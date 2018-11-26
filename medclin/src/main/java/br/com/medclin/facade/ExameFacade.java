package br.com.medclin.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import br.com.medclin.business.interfaces.IExameBusiness;
import br.com.medclin.model.Exame;

@Configuration
public class ExameFacade {

	@Autowired
	private IExameBusiness exameBusiness;

	public Exame atualizarExame(final Exame exame) {
		return exameBusiness.atualizarExame(exame);
	}

	public Page<Exame> buscarExamePorNome(final PageRequest pageable, final String nomeExame) {
		return exameBusiness.buscarExamePorNome(pageable, nomeExame);
	}

	public Exame buscarExamePorCodigo(final Short codigoExame) {
		return exameBusiness.buscarExamePorCodigo(codigoExame);
	}

	public Exame criarExame(final Exame exame) {
		return exameBusiness.criarExame(exame);
	}

	public void deletarExame(final Short codigoExame) {
		exameBusiness.deletarExame(codigoExame);
	}

	public Page<Exame> listarExame(final PageRequest pageable) {
		return exameBusiness.listarExame(pageable);
	}

}
