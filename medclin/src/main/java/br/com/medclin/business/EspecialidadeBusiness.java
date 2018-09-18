/*
 * 
 */
package br.com.medclin.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import br.com.medclin.business.interfaces.IEspecialidadeBusiness;
import br.com.medclin.common.AuditoriaUtil;
import br.com.medclin.model.Especialidade;
import br.com.medclin.repository.EspecialidadeRepository;

@Configuration
public class EspecialidadeBusiness implements IEspecialidadeBusiness {

	@Autowired
	private EspecialidadeRepository especialidadeRep;

	@Autowired
	private AuditoriaUtil auditoriaUtil;

	@Override
	public Especialidade atualizarEspecialidade(final Especialidade especialidade) {
		auditoriaUtil.setDadosAuditoriaAtualizacao(especialidade, "MOCK_MATRICULA - " + Math.random());
		return especialidadeRep.saveAndFlush(especialidade);
	}

	@Override
	public Especialidade buscarEspecialidadePorCodigo(final Short codigoEspecialidade) {
		return especialidadeRep.buscarEspecialidadePorCodigo(codigoEspecialidade);
	}

	@Override
	public Page<Especialidade> buscarEspecialidadePorNome(final PageRequest pageable, final String nomeEspecialidade) {
		return especialidadeRep.buscarEspecialidadePorNome(nomeEspecialidade, pageable);
	}

	@Override
	public Especialidade criarEspecialidade(final Especialidade especialidade) {
		auditoriaUtil.setDadosAuditoriaCriacao(especialidade, "MOCK_MATRICULA - " + Math.random());
		return especialidadeRep.save(especialidade);
	}

	@Override
	public void deletarEspecialidade(final Short codigoEspecialidade) {
		especialidadeRep.deleteById(codigoEspecialidade);
	}

	@Override
	public Page<Especialidade> listarEspecialidade(final PageRequest pageable) {
		return especialidadeRep.findAll(pageable);
	}

}
