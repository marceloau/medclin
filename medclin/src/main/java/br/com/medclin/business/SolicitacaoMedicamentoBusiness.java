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
import br.com.medclin.common.CloneUtil;
import br.com.medclin.model.SolicitacaoMedicamento;
import br.com.medclin.repository.SolicitacaoMedicamentoRepository;

@Configuration
public class SolicitacaoMedicamentoBusiness implements ISolicitacaoMedicamentoBusiness {

	@Autowired
	private SolicitacaoMedicamentoRepository solicitacaoMedicamentoRep;
	
	@Autowired
	private CloneUtil cloneUtil;

	@Override
	public Page<SolicitacaoMedicamento> listarSolicitacaoMedicamentoCodigoPaciente(final PageRequest pageable, final BigInteger codigoPaciente) {
		return cloneUtil.cloneListaSolicitacaoMedicamento(solicitacaoMedicamentoRep.listarSolicitacaoMedicamentoCodigoPaciente(codigoPaciente, pageable));
	}

	@Override
	public Page<SolicitacaoMedicamento> listarSolicitacaoMedicamento(PageRequest pageable) {
		return cloneUtil.cloneListaSolicitacaoMedicamento(solicitacaoMedicamentoRep.findAll(pageable));
	}

}
