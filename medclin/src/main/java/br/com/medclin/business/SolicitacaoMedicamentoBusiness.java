/*
 * 
 */
package br.com.medclin.business;

import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import br.com.medclin.business.interfaces.ISolicitacaoMedicamentoBusiness;
import br.com.medclin.common.AuditoriaUtil;
import br.com.medclin.common.CloneUtil;
import br.com.medclin.model.SolicitacaoExame;
import br.com.medclin.model.SolicitacaoMedicamento;
import br.com.medclin.repository.SolicitacaoMedicamentoRepository;

@Configuration
public class SolicitacaoMedicamentoBusiness implements ISolicitacaoMedicamentoBusiness {

	@Autowired
	private SolicitacaoMedicamentoRepository solicitacaoMedicamentoRep;
	
	@Autowired
	private CloneUtil cloneUtil;
	
	@Autowired
	private AuditoriaUtil auditoriaUtil;

	@Override
	public Page<SolicitacaoMedicamento> listarSolicitacaoMedicamentoCodigoPaciente(final PageRequest pageable, final BigInteger codigoPaciente) {
		return cloneUtil.cloneListaSolicitacaoMedicamento(solicitacaoMedicamentoRep.listarSolicitacaoMedicamentoCodigoPaciente(codigoPaciente, pageable));
	}

	@Override
	public Page<SolicitacaoMedicamento> listarSolicitacaoMedicamento(final PageRequest pageable) {
		return cloneUtil.cloneListaSolicitacaoMedicamento(solicitacaoMedicamentoRep.findAll(pageable));
	}

	@Override
	public SolicitacaoMedicamento salvar(final SolicitacaoMedicamento solicitacaoMedicamento) {
		SolicitacaoMedicamento retorno = null;
		auditoriaUtil.setDadosAuditoriaAtualizacao(solicitacaoMedicamento, "MOCK_MATRICULA - " + Math.random());
		
		if(validaExistenciaSolicitacaoMediConsulta(solicitacaoMedicamento.getSolicitacaoMedicamentoPK().getCodigoConsulta(), 
				solicitacaoMedicamento.getMedicamento().getCodigoMedicamento())) {
			
			retorno = solicitacaoMedicamentoRep.buscarSoliciMedPorConsulMedicamento(solicitacaoMedicamento.getSolicitacaoMedicamentoPK().getCodigoConsulta(), 
					solicitacaoMedicamento.getMedicamento().getCodigoMedicamento());
			
		} else {
			solicitacaoMedicamento.getSolicitacaoMedicamentoPK().setCodigoSolicitacaoMedicamento(
					gerarNumeroSolicitacaoMedicamento(solicitacaoMedicamento.getSolicitacaoMedicamentoPK().getCodigoConsulta()));
			retorno = solicitacaoMedicamentoRep.save(solicitacaoMedicamento);
		}
		
		return cloneUtil.cloneSolicitacaoMedicamento(retorno);
	}
	
	public Short gerarNumeroSolicitacaoMedicamento(final BigInteger codigoConsulta) {
		final Integer retorno = solicitacaoMedicamentoRep.buscarMaxSolicitacaoMedicamentoConsulta(codigoConsulta) + 1;
		return retorno.shortValue();
	}
	
	// Verifica se o medicamento já foi prescrito nessa mesma consulta
	public Boolean validaExistenciaSolicitacaoMediConsulta(final BigInteger codigoConsulta, final Short codigoMedicamento) {
		Boolean retorno = Boolean.FALSE;
		final Integer quantSolicitacoes = solicitacaoMedicamentoRep.countSoliciMedPorConsulMed(codigoConsulta, codigoMedicamento);
		if (quantSolicitacoes > 0) {
			retorno = Boolean.TRUE;
		}
		return retorno;
	}

}
