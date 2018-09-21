package br.com.medclin.business.interfaces;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import br.com.medclin.model.Paciente;

public interface IPacienteBusiness {

	public Paciente atualizarPaciente(final Paciente paciente);

	public Page<Paciente> buscarPacientePorNome(final PageRequest pageable, final String nomePaciente);

	public Paciente buscarPacientePorCodigo(final Long codigoPaciente);

	public Paciente criarPaciente(final Paciente paciente);

	public void deletarPaciente(final Long codigoPaciente);

	public Page<Paciente> listarPaciente(final PageRequest pageable);

}
