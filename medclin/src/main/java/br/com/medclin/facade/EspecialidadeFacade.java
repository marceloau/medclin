package br.com.medclin.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import br.com.medclin.business.interfaces.IEspecialidadeBusiness;
import br.com.medclin.model.Especialidade;

@Configuration
public class EspecialidadeFacade {

	@Autowired
	private IEspecialidadeBusiness especialidadeBusiness;

	public Especialidade atualizarEspecialidade(final Especialidade especialidade) {
		return especialidadeBusiness.atualizarEspecialidade(especialidade);
	}

	public Page<Especialidade> buscarEspecialidadePorNome(final PageRequest pageable, final String nomeEspecialidade) {
		return especialidadeBusiness.buscarEspecialidadePorNome(pageable, nomeEspecialidade);
	}

	public Iterable<Especialidade> buscarEspecialidadePorCodigo(final Short codigoEspecialidade) {
		return especialidadeBusiness.buscarEspecialidadePorCodigo(codigoEspecialidade);
	}

	public Especialidade criarEspecialidade(final Especialidade especialidade) {
		return especialidadeBusiness.criarEspecialidade(especialidade);
	}

	public void deletarEspecialidade(final Short codigoEspecialidade) {
		especialidadeBusiness.deletarEspecialidade(codigoEspecialidade);
	}

	public Page<Especialidade> listarEspecialidade(final PageRequest pageable) {
		return especialidadeBusiness.listarEspecialidade(pageable);
	}

}
