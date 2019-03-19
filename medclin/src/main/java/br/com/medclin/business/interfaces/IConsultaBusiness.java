package br.com.medclin.business.interfaces;

import java.math.BigInteger;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import br.com.medclin.model.Consulta;

public interface IConsultaBusiness {

	public Consulta atualizarConsulta(final Consulta consulta);

	public Consulta buscarConsultaPorCodigo(final BigInteger codigoConsulta);
	
	public Consulta confirmarConsulta(final BigInteger codigoConsulta);
	
	public Consulta iniciarAtendimento(final BigInteger codigoConsulta);
	
	public Consulta atualizarOrdemChegada(final BigInteger codigoConsulta, final Integer numeroOrdemChegada);
	
	public Page<Consulta> buscarConsulta(final PageRequest pageable, final String nomePaciente, final String dataConsulta, final String mesConsulta, final String codigoPaciente,
			final Integer codigoStatusConsulta);
	
	public Consulta criarConsulta(final Consulta consulta);

	public void deletarConsulta(final BigInteger codigoConsulta);
	
	public BigInteger totalConsultas();

	public Page<Consulta> listarConsulta(final PageRequest pageable);
	
	public Page<Consulta> listarConsultasAtendimento(final PageRequest pageable, final String dataConsulta, final String flagConfirmada);

}
