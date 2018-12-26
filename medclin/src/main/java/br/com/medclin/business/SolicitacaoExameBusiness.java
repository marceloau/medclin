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
import br.com.medclin.common.CloneUtil;
import br.com.medclin.model.SolicitacaoExame;
import br.com.medclin.repository.SolicitacaoExameRepository;

@Configuration
public class SolicitacaoExameBusiness implements ISolicitacaoExameBusiness {

	@Autowired
	private SolicitacaoExameRepository solicitacaoExameRep;
	
	@Autowired
	private CloneUtil cloneUtil;

	@Override
	public Page<SolicitacaoExame> listarSolicitacaoExameCodigoPaciente(final PageRequest pageable, final BigInteger codigoPaciente) {
		return cloneUtil.cloneListaSolicitacaoExame(solicitacaoExameRep.listarSolicitacaoExameCodigoPaciente(codigoPaciente, pageable));
	}

	@Override
	public Page<SolicitacaoExame> listarSolicitacaoExame(PageRequest pageable) {
		return cloneUtil.cloneListaSolicitacaoExame(solicitacaoExameRep.findAll(pageable));
	}

}
