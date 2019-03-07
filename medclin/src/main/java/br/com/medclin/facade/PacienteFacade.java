package br.com.medclin.facade;

import java.math.BigInteger;

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

	public Page<Paciente> buscarPaciente(final PageRequest pageable, final String nomePaciente, final String nomeMae,
			final String numeroRg, final String numeroCpf, final String numeroCartaoSUS, final Short codigoTipoPlano,
			final String textoContato) {
		return pacienteBusiness.buscarPaciente(pageable, nomePaciente, nomeMae, numeroRg, numeroCpf, numeroCartaoSUS,
				codigoTipoPlano, textoContato);
	}

	public Paciente buscarPacientePorCodigo(final BigInteger codigoPaciente) {
		return pacienteBusiness.buscarPacientePorCodigo(codigoPaciente);
	}

	public Paciente criarPaciente(final Paciente paciente) {
		return pacienteBusiness.criarPaciente(paciente);
	}

	public void deletarPaciente(final BigInteger codigoPaciente) {
		pacienteBusiness.deletarPaciente(codigoPaciente);
	}

	public Page<Paciente> listarPaciente(final PageRequest pageable) {
		return pacienteBusiness.listarPaciente(pageable);
	}
	
	public BigInteger totalPacientes() {
		return pacienteBusiness.totalPacientes();
	}

}
