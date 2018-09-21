package br.com.medclin.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import br.com.medclin.business.interfaces.IPacienteBusiness;
import br.com.medclin.model.Paciente;

@Configuration
public class PacienteFacade {

	@Autowired
	private IPacienteBusiness pacienteBusiness;

	public Paciente atualizarPaciente(final Paciente paciente) {
		return pacienteBusiness.atualizarPaciente(paciente);
	}

	public Page<Paciente> buscarPacientePorNome(final PageRequest pageable, final String nomePaciente) {
		return pacienteBusiness.buscarPacientePorNome(pageable, nomePaciente);
	}

	public Paciente buscarPacientePorCodigo(final Long codigoPaciente) {
		return pacienteBusiness.buscarPacientePorCodigo(codigoPaciente);
	}

	public Paciente criarPaciente(final Paciente paciente) {
		return pacienteBusiness.criarPaciente(paciente);
	}

	public void deletarPaciente(final Long codigoPaciente) {
		pacienteBusiness.deletarPaciente(codigoPaciente);
	}

	public Page<Paciente> listarPaciente(final PageRequest pageable) {
		return pacienteBusiness.listarPaciente(pageable);
	}

}
