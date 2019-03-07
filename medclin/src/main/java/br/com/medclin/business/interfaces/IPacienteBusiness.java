package br.com.medclin.business.interfaces;

import java.math.BigInteger;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import br.com.medclin.model.Paciente;

public interface IPacienteBusiness {

	public Paciente atualizarPaciente(final Paciente paciente);

	public Page<Paciente> buscarPaciente(final PageRequest pageable, final String nomePaciente, final String nomeMae,
			final String numeroRg, final String numeroCpf, final String numeroCartaoSUS, final Short codigoTipoPlano,
			final String textoContato);

	public Paciente buscarPacientePorCodigo(final BigInteger codigoPaciente);

	public Paciente criarPaciente(final Paciente paciente);

	public void deletarPaciente(final BigInteger codigoPaciente);

	public Page<Paciente> listarPaciente(final PageRequest pageable);
	
	public BigInteger totalPacientes();

}
