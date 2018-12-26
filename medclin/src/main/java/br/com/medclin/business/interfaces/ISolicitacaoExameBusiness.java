package br.com.medclin.business.interfaces;

import java.math.BigInteger;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import br.com.medclin.model.SolicitacaoExame;

public interface ISolicitacaoExameBusiness {

	public Page<SolicitacaoExame> listarSolicitacaoExameCodigoPaciente(final PageRequest pageable, final BigInteger codigoPaciente);

	public Page<SolicitacaoExame> listarSolicitacaoExame(final PageRequest pageable);

}
