/*
 * 
 */
package br.com.medclin.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import br.com.medclin.business.interfaces.IPacienteBusiness;
import br.com.medclin.common.AuditoriaUtil;
import br.com.medclin.model.Paciente;
import br.com.medclin.repository.PacienteRepository;

@Configuration
public class PacienteBusiness implements IPacienteBusiness {

	@Autowired
	private PacienteRepository pacienteRep;

	@Autowired
	private AuditoriaUtil auditoriaUtil;

	@Override
	public Paciente atualizarPaciente(final Paciente paciente) {
		auditoriaUtil.setDadosAuditoriaAtualizacao(paciente, "MOCK_MATRICULA - " + Math.random());
		return pacienteRep.saveAndFlush(paciente);
	}

	@Override
	public Paciente buscarPacientePorCodigo(final Long codigoPaciente) {
		return pacienteRep.buscarPacientePorCodigo(codigoPaciente);
	}

	@Override
	public Page<Paciente> buscarPacientePorNome(final PageRequest pageable, final String nomePaciente) {
		return pacienteRep.buscarPacientePorNome(nomePaciente, pageable);
	}

	@Override
	public Paciente criarPaciente(final Paciente paciente) {
		auditoriaUtil.setDadosAuditoriaCriacao(paciente, "MOCK_MATRICULA - " + Math.random());
		return pacienteRep.save(paciente);
	}

	@Override
	public void deletarPaciente(final Long codigoPaciente) {
		pacienteRep.deleteById(codigoPaciente);
	}

	@Override
	public Page<Paciente> listarPaciente(final PageRequest pageable) {
		return pacienteRep.findAll(pageable);
	}

}
