package br.com.medclin.business.interfaces;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import br.com.medclin.model.Exame;

public interface IExameBusiness {

	public Exame atualizarExame(final Exame exame);

	public Page<Exame> buscarExamePorNome(final PageRequest pageable, final String nomeExame);

	public Exame buscarExamePorCodigo(final Short codigoExame);

	public Exame criarExame(final Exame exame);

	public void deletarExame(final Short codigoExame);

	public Page<Exame> listarExame(final PageRequest pageable);

}
