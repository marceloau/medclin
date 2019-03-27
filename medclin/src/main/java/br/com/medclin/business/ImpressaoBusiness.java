package br.com.medclin.business;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.JAXBException;

import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.FileItemStream;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import br.com.medclin.business.interfaces.IImpressaoBusiness;
import br.com.medclin.common.CloneUtil;
import br.com.medclin.common.Util;
import br.com.medclin.model.Consulta;
import br.com.medclin.model.FormularioImpressao;
import br.com.medclin.model.Medicamento;
import br.com.medclin.model.ebo.ImpressaoEBO;
import br.com.medclin.model.ebo.MedicamentoImpressaoEBO;
import br.com.medclin.repository.ConsultaRepository;
import br.com.medclin.repository.FormularioImpressaoRepository;
import br.com.medclin.repository.MedicamentoRepository;

@Configuration
public class ImpressaoBusiness implements IImpressaoBusiness {
	
	private Logger logger = LoggerFactory.getLogger(ImpressaoBusiness.class);
	
	@Autowired
	private MedicamentoRepository medicamentoRepository;
	
	@Autowired
	private ConsultaRepository consultaRepository;
	
	@Autowired
	private GeradorImpressaoBusiness geradorImpressaoBusiness;
	
	@Autowired
	private S3Business s3Business;
	
	@Autowired
	private FormularioImpressaoRepository formularioImpressaoRepository;
	
	@Autowired
	private CloneUtil cloneUtil;

//	@Override
//	public ByteArrayOutputStream medicamento(final String listaMedicamento, final BigInteger codigoConsulta) {
//		
//		final List<Medicamento> medicamentos = this.buscarMedicamentos(listaMedicamento);
//		final Consulta consulta = cloneUtil.cloneConsulta(this.consultaRepository.buscarConsultaPorCodigo(codigoConsulta));
//		final ImpressaoEBO documento = new ImpressaoEBO();
//		
//		final MedicamentoImpressaoEBO medicamentoEBO = new MedicamentoImpressaoEBO();
//		medicamentoEBO.setMedicamento(medicamentos);
//		
//		documento.setConsulta(consulta);
//		documento.setMedicamento(medicamentoEBO);
//		
//		final String nomeArquivo = consulta.getPaciente().getNomePessoa() + '-' + consulta.getCodigoConsulta() + '-' + new Date().getTime();
//		
//		final FormularioImpressao formularioImpressao = formularioImpressaoRepository.buscarPorCodigo(1);
//		
//		String metadados = "";
//		try {
//			metadados = Util.gerarXMLs(ImpressaoEBO.class, documento);
//		} catch (JAXBException e) {
//			logger.error("Erro ao gerar xml: " + e.getMessage());
//			e.printStackTrace();
//		}
//		metadados = Util.removeXmlStringNamespaceAndPreamble(metadados);
//		metadados = Util.inserirParametrosFormulario(metadados);
//		
//		final File out = geradorImpressaoBusiness
//				.gerarArquivo(nomeArquivo, formularioImpressao.getCaminhoFormulario(), metadados, "pdf", documento);
//	    
//		s3Business.uploadImpressao(out);
//		final ByteArrayOutputStream retorno = s3Business.downloadFile(out.getName());
//		return retorno;
//	}
	
	@Override
	public String medicamento(final String listaMedicamento, final BigInteger codigoConsulta) {
		
		final List<Medicamento> medicamentos = this.buscarMedicamentos(listaMedicamento);
		final Consulta consulta = cloneUtil.cloneConsulta(this.consultaRepository.buscarConsultaPorCodigo(codigoConsulta));
		final ImpressaoEBO documento = new ImpressaoEBO();
		
		final MedicamentoImpressaoEBO medicamentoEBO = new MedicamentoImpressaoEBO();
		medicamentoEBO.setMedicamento(medicamentos);
		
		documento.setConsulta(consulta);
		documento.setMedicamento(medicamentoEBO);
		
		final String nomeArquivo = consulta.getPaciente().getNomePessoa() + '-' + consulta.getCodigoConsulta() + '-' + new Date().getTime();
		
		final FormularioImpressao formularioImpressao = formularioImpressaoRepository.buscarPorCodigo(1);
		
		String metadados = "";
		try {
			metadados = Util.gerarXMLs(ImpressaoEBO.class, documento);
		} catch (JAXBException e) {
			logger.error("Erro ao gerar xml: " + e.getMessage());
			e.printStackTrace();
		}
		metadados = Util.removeXmlStringNamespaceAndPreamble(metadados);
		metadados = Util.inserirParametrosFormulario(metadados);
		
		final File out = geradorImpressaoBusiness
				.gerarArquivo(nomeArquivo, formularioImpressao.getCaminhoFormulario(), metadados, "pdf", documento);
	    
		s3Business.uploadImpressao(out);
		return out.getName();
	}
	
	private List<Medicamento> buscarMedicamentos(final String codigosMedicamentos) {
		
		final String[] listaCodigoMedicamentos = codigosMedicamentos.split(",");
		final List<Medicamento> listaMedicamentos = new ArrayList<Medicamento>();
		for(final String index : listaCodigoMedicamentos) {
			final Medicamento medicamento = medicamentoRepository.buscarMedicamentoPorCodigo(Short.valueOf(index));
			
			if(medicamento != null) {
				listaMedicamentos.add(cloneUtil.cloneMedicamento(medicamento));
			}
		}
		
		return listaMedicamentos;
	}
}
