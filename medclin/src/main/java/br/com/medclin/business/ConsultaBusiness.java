/*
 * 
 */
package br.com.medclin.business;

import java.math.BigInteger;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import br.com.medclin.business.interfaces.IConsultaBusiness;
import br.com.medclin.business.interfaces.ISolicitacaoExameBusiness;
import br.com.medclin.business.interfaces.ISolicitacaoMedicamentoBusiness;
import br.com.medclin.common.AssertUtil;
import br.com.medclin.common.AuditoriaUtil;
import br.com.medclin.common.CloneUtil;
import br.com.medclin.dao.ConsultaDAO;
import br.com.medclin.model.Consulta;
import br.com.medclin.model.SolicitacaoExame;
import br.com.medclin.model.SolicitacaoMedicamento;
import br.com.medclin.repository.ConsultaRepository;

@Configuration
public class ConsultaBusiness implements IConsultaBusiness {

	@Autowired
	private ConsultaRepository consultaRep;
	
	@Autowired
	private ISolicitacaoExameBusiness solicitacaoExameBusiness;
	
	@Autowired
	private ISolicitacaoMedicamentoBusiness solicitacaoMedicamentoBusiness;
	
	@Autowired
	private ConsultaDAO consultaDAO;

	@Autowired
	private CloneUtil cloneUtil;

	@Autowired
	private AuditoriaUtil auditoriaUtil;

	@Override
	public Consulta atualizarConsulta(final Consulta consulta) {
		auditoriaUtil.setDadosAuditoriaAtualizacao(consulta, "MOCK_MATRICULA - " + Math.random());
		
		// Criando lista de solicitacação de exame.
		if(AssertUtil.isNotEmptyList(consulta.getListaSolicitacaoExame())) {
			final List<SolicitacaoExame> listaSolicitacaoExame = new ArrayList<SolicitacaoExame>();
			for(final SolicitacaoExame solicitacaoExame : consulta.getListaSolicitacaoExame()) {
				listaSolicitacaoExame.add(solicitacaoExameBusiness.salvar(solicitacaoExame));
			}
			consulta.setListaSolicitacaoExame(listaSolicitacaoExame);
		}
		
		// Criando lista de solicitacação de medicamento.
		if(AssertUtil.isNotEmptyList(consulta.getListaSolicitacaoMedicamento())) {
			final List<SolicitacaoMedicamento> listaSolicitacaoMedicamento = new ArrayList<SolicitacaoMedicamento>();
			for(final SolicitacaoMedicamento solicitacaoMedicamento : consulta.getListaSolicitacaoMedicamento()) {
				listaSolicitacaoMedicamento.add(solicitacaoMedicamentoBusiness.salvar(solicitacaoMedicamento));
			}
			consulta.setListaSolicitacaoMedicamento(listaSolicitacaoMedicamento);
		}
		return cloneUtil.cloneConsulta(consultaRep.saveAndFlush(consulta));
	}

	@Override
	public Consulta buscarConsultaPorCodigo(final BigInteger codigoConsulta) {
		return cloneUtil.cloneConsulta(consultaRep.buscarConsultaPorCodigo(codigoConsulta));
	}
	
	@Override
	public Page<Consulta> buscarConsulta(final PageRequest pageable, final String nomePaciente, final String dataConsulta, final String mesConsulta, final String codigoPaciente) {
				
		final DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date dataConsultaFormatada = null;
		if(dataConsulta != null) {
			try {
				dataConsultaFormatada = df.parse(dataConsulta);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		Date mesConsultaFormatada = null;
		if(mesConsulta != null) {
			try {
				mesConsultaFormatada = df.parse(mesConsulta);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		BigInteger codPaciente = null;
		if (AssertUtil.isNotNullAndEmpty(codigoPaciente)) {
			codPaciente = BigInteger.valueOf(Long.valueOf(codigoPaciente));
		}
		return cloneUtil.cloneListaConsulta(consultaDAO.buscarConsulta(pageable, nomePaciente, dataConsultaFormatada, mesConsultaFormatada, codPaciente));
	}

	@Override
	public Consulta criarConsulta(final Consulta consulta) {
		auditoriaUtil.setDadosAuditoriaCriacao(consulta, "MOCK_MATRICULA - " + Math.random());
		return cloneUtil.cloneConsulta(consultaRep.save(consulta));
	}

	@Override
	public void deletarConsulta(final BigInteger codigoConsulta) {
		consultaRep.deleteById(codigoConsulta);
	}

	@Override
	public Page<Consulta> listarConsulta(final PageRequest pageable) {
		return cloneUtil.cloneListaConsulta(consultaRep.findAll(pageable));
	}

}
