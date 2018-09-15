package br.com.medclin.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import br.com.medclin.business.interfaces.IEspecialidadeBusiness;
import br.com.medclin.model.Especialidade;
import br.com.medclin.repository.EspecialidadeRepository;

@Configuration
public class EspecialidadeBusiness implements IEspecialidadeBusiness {

	@Autowired
	private EspecialidadeRepository especialidadeRep;

	@Override
	public Especialidade atualizarEspecialidade(final Especialidade especialidade) {
		return especialidadeRep.saveAndFlush(especialidade);
	}

	@Override
	public Page<Especialidade> buscarEspecialidadePorNome(final PageRequest pageable, final String nomeEspecialidade) {
		return especialidadeRep.buscarEspecialidadePorNome(nomeEspecialidade, pageable);
	}

	@Override
	public Iterable<Especialidade> buscarEspecialidadePorCodigo(final Long codigoEspecialidade) {
		return especialidadeRep.buscarEspecialidadePorCodigo(codigoEspecialidade);
	}

	@Override
	public Especialidade criarEspecialidade(final Especialidade especialidade) {
		return especialidadeRep.save(especialidade);
	}

	@Override
	public void deletarEspecialidade(final Long codigoEspecialidade) {
		especialidadeRep.deleteById(codigoEspecialidade);
	}

	@Override
	public Page<Especialidade> listarEspecialidade(final PageRequest pageable) {
		return especialidadeRep.findAll(pageable);
	}

}
