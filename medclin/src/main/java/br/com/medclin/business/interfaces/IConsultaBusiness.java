package br.com.medclin.business.interfaces;

import java.math.BigInteger;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import br.com.medclin.model.Consulta;

public interface IConsultaBusiness {

	public Consulta atualizarConsulta(final Consulta consulta);

	public Consulta buscarConsultaPorCodigo(final BigInteger codigoConsulta);
	
	public Page<Consulta> buscarConsultaPorNomePaciente(final PageRequest pageable, final String nomePaciente);

	public Consulta criarConsulta(final Consulta consulta);

	public void deletarConsulta(final BigInteger codigoConsulta);

	public Page<Consulta> listarConsulta(final PageRequest pageable);

}
