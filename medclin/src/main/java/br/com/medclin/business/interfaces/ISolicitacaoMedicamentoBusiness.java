package br.com.medclin.business.interfaces;

import java.math.BigInteger;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import br.com.medclin.model.SolicitacaoMedicamento;

public interface ISolicitacaoMedicamentoBusiness {

	public Page<SolicitacaoMedicamento> listarSolicitacaoMedicamentoCodigoPaciente(final PageRequest pageable, final BigInteger codigoPaciente);

	public Page<SolicitacaoMedicamento> listarSolicitacaoMedicamento(final PageRequest pageable);
	
	public SolicitacaoMedicamento salvar(final SolicitacaoMedicamento solicitacaoMedicamento);

}
