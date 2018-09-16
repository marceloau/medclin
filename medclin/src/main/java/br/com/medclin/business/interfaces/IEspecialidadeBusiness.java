package br.com.medclin.business.interfaces;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import br.com.medclin.model.Especialidade;

public interface IEspecialidadeBusiness {

	public Especialidade atualizarEspecialidade(final Especialidade especialidade);

	public Page<Especialidade> buscarEspecialidadePorNome(final PageRequest pageable, final String nomeEspecialidade);

	public Iterable<Especialidade> buscarEspecialidadePorCodigo(final Short codigoEspecialidade);

	public Especialidade criarEspecialidade(final Especialidade especialidade);

	public void deletarEspecialidade(final Short codigoEspecialidade);

	public Page<Especialidade> listarEspecialidade(final PageRequest pageable);

}
