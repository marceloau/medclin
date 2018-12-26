package br.com.medclin.facade;

import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import br.com.medclin.business.interfaces.ISolicitacaoMedicamentoBusiness;
import br.com.medclin.model.SolicitacaoMedicamento;

@Configuration
public class SolicitacaoMedicamentoFacade {

	@Autowired
	private ISolicitacaoMedicamentoBusiness solicitacaoMedicamentoBusiness;

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

	public Page<SolicitacaoMedicamento> listarSolicitacaoMedicamentoCodigoPaciente(final PageRequest pageable, final BigInteger codigoPaciente) {
		return solicitacaoMedicamentoBusiness.listarSolicitacaoMedicamentoCodigoPaciente(pageable, codigoPaciente);
	}
	
	public Page<SolicitacaoMedicamento> listarSolicitacaoMedicamento(final PageRequest pageable) {
		return solicitacaoMedicamentoBusiness.listarSolicitacaoMedicamento(pageable);
	}

}
