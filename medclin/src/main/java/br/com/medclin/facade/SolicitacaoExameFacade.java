package br.com.medclin.facade;

import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import br.com.medclin.business.interfaces.ISolicitacaoExameBusiness;
import br.com.medclin.model.SolicitacaoExame;

@Configuration
public class SolicitacaoExameFacade {

	@Autowired
	private ISolicitacaoExameBusiness solicitacaoExameBusiness;

//	public Exame atualizarExame(final Exame exame) {
//		return exameBusiness.atualizarExame(exame);
//	}
//
//	public Page<Exame> buscarExamePorNome(final PageRequest pageable, final String nomeExame) {
//		return exameBusiness.buscarExamePorNome(pageable, nomeExame);
//	}

//	public Exame buscarSolicitacaoExamePorCodigo(final Short codigoExame) {
//		return exameBusiness.buscarSolicitacaoExamePorCodigo(codigoExame);
//	}

//	public Exame criarExame(final Exame exame) {
//		return exameBusiness.criarExame(exame);
//	}
//
//	public void deletarExame(final Short codigoExame) {
//		exameBusiness.deletarExame(codigoExame);
//	}

	public Page<SolicitacaoExame> listarSolicitacaoExameCodigoPaciente(final PageRequest pageable, final BigInteger codigoPaciente) {
		return solicitacaoExameBusiness.listarSolicitacaoExameCodigoPaciente(pageable, codigoPaciente);
	}
	
	public Page<SolicitacaoExame> listarSolicitacaoExame(final PageRequest pageable) {
		return solicitacaoExameBusiness.listarSolicitacaoExame(pageable);
	}

}
