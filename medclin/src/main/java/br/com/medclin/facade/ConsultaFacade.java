package br.com.medclin.facade;

import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import br.com.medclin.business.interfaces.IConsultaBusiness;
import br.com.medclin.model.Consulta;

@Configuration
public class ConsultaFacade {

	@Autowired
	private IConsultaBusiness consultaBusiness;

	public Consulta atualizarConsulta(final Consulta consulta) {
		return consultaBusiness.atualizarConsulta(consulta);
	}

	public Consulta buscarConsultaPorCodigo(final BigInteger codigoConsulta) {
		return consultaBusiness.buscarConsultaPorCodigo(codigoConsulta);
	}
	
	public Consulta confirmarConsulta(final BigInteger codigoConsulta) {
		return consultaBusiness.confirmarConsulta(codigoConsulta);
	}
	
	public Consulta atualizarOrdemChegada(final BigInteger codigoConsulta, final Integer numeroOrdemChegada) {
		return consultaBusiness.atualizarOrdemChegada(codigoConsulta, numeroOrdemChegada);
	}
	
	public Page<Consulta> buscarConsulta(final PageRequest pageable, final String nomePaciente, final String dataConsulta,
			final String mesConsulta, final String codigoPaciente, final Integer codigoStatusConsulta) {
		return consultaBusiness.buscarConsulta(pageable, nomePaciente, dataConsulta, mesConsulta, codigoPaciente, codigoStatusConsulta);
	}

	public Consulta criarConsulta(final Consulta consulta) {
		return consultaBusiness.criarConsulta(consulta);
	}

	public void deletarConsulta(final BigInteger codigoConsulta) {
		consultaBusiness.deletarConsulta(codigoConsulta);
	}

	public Page<Consulta> listarConsulta(final PageRequest pageable) {
		return consultaBusiness.listarConsulta(pageable);
	}
	
	public Page<Consulta> listarConsultasAtendimento(final PageRequest pageable, final String dataConsulta) {
		return consultaBusiness.listarConsultasAtendimento(pageable, dataConsulta);
	}
	
	public BigInteger totalConsultas() {
		return consultaBusiness.totalConsultas();
	}

}
