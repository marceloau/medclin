package br.com.medclin.business;

import java.io.File;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.JAXBException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import br.com.medclin.business.interfaces.IImpressaoBusiness;
import br.com.medclin.common.CloneUtil;
import br.com.medclin.common.Util;
import br.com.medclin.model.Consulta;
import br.com.medclin.model.Exame;
import br.com.medclin.model.FormularioImpressao;
import br.com.medclin.model.Medicamento;
import br.com.medclin.model.Paciente;
import br.com.medclin.model.SolicitacaoExame;
import br.com.medclin.model.SolicitacaoMedicamento;
import br.com.medclin.model.ebo.ConsultaImpressaoEBO;
import br.com.medclin.model.ebo.ImpressaoEBO;
import br.com.medclin.model.ebo.MedicamentoImpressaoEBO;
import br.com.medclin.repository.ConsultaRepository;
import br.com.medclin.repository.FormularioImpressaoRepository;
import br.com.medclin.repository.MedicamentoRepository;
import br.com.medclin.repository.PacienteRepository;
import br.com.medclin.repository.SolicitacaoExameRepository;
import br.com.medclin.repository.SolicitacaoMedicamentoRepository;

@Configuration
public class ImpressaoBusiness implements IImpressaoBusiness {
	
	private Logger logger = LoggerFactory.getLogger(ImpressaoBusiness.class);
	
	@Autowired
	private MedicamentoRepository medicamentoRepository;
	
	@Autowired
	private PacienteRepository pacienteRepository;
	
	@Autowired
	private SolicitacaoExameRepository solicitacaoExameRepository;
	
	@Autowired
	private SolicitacaoMedicamentoRepository solicitacaoMedicamentoRepository;
	
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
		
//		final ConsultaImpressaoEBO consultaEBO = new ConsultaImpressaoEBO();
//		consultaEBO.setConsulta(new ArrayList<Consulta>());
//		consultaEBO.getConsulta().add(consulta);
		
		documento.addConsulta(consulta);
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
				.gerarArquivo(nomeArquivo, formularioImpressao.getCaminhoFormulario(), metadados, "pdf");
	    
		s3Business.uploadImpressao(out);
		return out.getName();
	}
	
	@Override
	public String historicoClinico(final BigInteger codigoPaciente) {
		
		final List<Medicamento> medicamentos = this.buscarMedicamentos(codigoPaciente);
		final List<Consulta> consultas = this.buscarConsultas(codigoPaciente);
		final List<Exame> exames = this.buscarExames(codigoPaciente);
		final Paciente paciente = pacienteRepository.findById(codigoPaciente).get();
		final ImpressaoEBO documento = new ImpressaoEBO();

		final MedicamentoImpressaoEBO medicamentoEBO = new MedicamentoImpressaoEBO();
		medicamentoEBO.setMedicamento(medicamentos);
		
//		final ConsultaImpressaoEBO consultaEBO = new ConsultaImpressaoEBO();
//		consultaEBO.setConsulta(consultas);
		
		documento.setConsulta(consultas);
		documento.setExame(exames);
		documento.setMedicamento(medicamentoEBO);
		
		final String nomeArquivo = paciente.getNomePessoa() + '-' + new Date().getTime();
		
		final FormularioImpressao formularioImpressao = formularioImpressaoRepository.buscarPorCodigo(2);
		
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
				.gerarArquivo(nomeArquivo, formularioImpressao.getCaminhoFormulario(), metadados, "pdf");
	    
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
	
	private List<Exame> buscarExames(final BigInteger codigoPaciente) {
		final List<SolicitacaoExame> listaSolicitacaoExame = solicitacaoExameRepository.buscarSoliciExamePorCodigoPaciente(codigoPaciente);
		final List<Exame> retorno = new ArrayList<Exame>();
		for(final SolicitacaoExame solicitacaoExame : listaSolicitacaoExame) {
			if(solicitacaoExame != null) {
				retorno.add(cloneUtil.cloneExame(solicitacaoExame.getExame()));
			}
		}
		return retorno;
	}
	
	private List<Medicamento> buscarMedicamentos(final BigInteger codigoPaciente) {
		final List<SolicitacaoMedicamento> listaSolicitacoesMedicamentos = solicitacaoMedicamentoRepository.buscarSoliciMedPorCodigoPaciente(codigoPaciente);
		final List<Medicamento> retorno = new ArrayList<Medicamento>();
		for(final SolicitacaoMedicamento solicitacaoMedicamento : listaSolicitacoesMedicamentos) {
			if(solicitacaoMedicamento != null) {
				retorno.add(cloneUtil.cloneMedicamento(solicitacaoMedicamento.getMedicamento()));
			}
		}
		return retorno;
	}
	
	private List<Consulta> buscarConsultas(final BigInteger codigoPaciente) {
		
		final List<Consulta> retorno = consultaRepository.buscarConsultaPorCodigoPaciente(codigoPaciente);
			
		return retorno;
	}
}
