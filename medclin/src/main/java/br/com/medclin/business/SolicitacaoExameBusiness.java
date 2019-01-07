/*
 * 
 */
package br.com.medclin.business;

import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import br.com.medclin.business.interfaces.ISolicitacaoExameBusiness;
import br.com.medclin.common.AuditoriaUtil;
import br.com.medclin.common.CloneUtil;
import br.com.medclin.model.SolicitacaoExame;
import br.com.medclin.repository.SolicitacaoExameRepository;

@Configuration
public class SolicitacaoExameBusiness implements ISolicitacaoExameBusiness {

	@Autowired
	private SolicitacaoExameRepository solicitacaoExameRep;
	
	@Autowired
	private CloneUtil cloneUtil;

	@Autowired
	private AuditoriaUtil auditoriaUtil;

	@Override
	public Page<SolicitacaoExame> listarSolicitacaoExameCodigoPaciente(final PageRequest pageable, final BigInteger codigoPaciente) {
		return cloneUtil.cloneListaSolicitacaoExame(solicitacaoExameRep.listarSolicitacaoExameCodigoPaciente(codigoPaciente, pageable));
	}

	@Override
	public Page<SolicitacaoExame> listarSolicitacaoExame(final PageRequest pageable) {
		return cloneUtil.cloneListaSolicitacaoExame(solicitacaoExameRep.findAll(pageable));
	}

	@Override
	public SolicitacaoExame salvar(final SolicitacaoExame solicitacaoExame) {
		SolicitacaoExame retorno = null;
		auditoriaUtil.setDadosAuditoriaAtualizacao(solicitacaoExame, "MOCK_MATRICULA - " + Math.random());
		if(validaExistenciaSolicitacaoExameConsulta(solicitacaoExame.getSolicitacaoExamePK().getCodigoConsulta(), 
				solicitacaoExame.getExame().getCodigoExame())) {
			
			retorno = solicitacaoExameRep.buscarSoliciExamePorConsulExame(solicitacaoExame.getSolicitacaoExamePK().getCodigoConsulta(), 
				solicitacaoExame.getExame().getCodigoExame());
			
		} else {
			solicitacaoExame.getSolicitacaoExamePK().setCodigoSolicitacaoExame(
					gerarNumeroSolicitacaoExame(solicitacaoExame.getSolicitacaoExamePK().getCodigoConsulta()));
			retorno = solicitacaoExameRep.save(solicitacaoExame);
		}
		return cloneUtil.cloneSolicitacaoExame(retorno);
	}
	
	public Short gerarNumeroSolicitacaoExame(final BigInteger codigoConsulta) {
		final Integer retorno = solicitacaoExameRep.buscarMaxSolicitacaoExameConsulta(codigoConsulta) + 1;
		return retorno.shortValue();
	}
	
	// Verifica se o exame já foi solicitado nessa mesma consulta
	public Boolean validaExistenciaSolicitacaoExameConsulta(final BigInteger codigoConsulta, final Short codigoExame) {
		Boolean retorno = Boolean.FALSE;
		final Integer quantSolicitacoes = solicitacaoExameRep.countSoliciExamePorConsulExame(codigoConsulta, codigoExame);
		if (quantSolicitacoes > 0) {
			retorno = Boolean.TRUE;
		}
		return retorno;
	}

}
