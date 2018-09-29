package br.com.medclin.business.interfaces;

import java.math.BigInteger;
import java.util.List;

import br.com.medclin.model.PlanoSaudePaciente;

public interface IPlanoSaudePacienteBusiness {

	public void criarListaPlanoSaudePaciente(final List<PlanoSaudePaciente> listaPlanoSaudePaciente,
			final BigInteger codigoPessoa);

	public void atualizarListaPlanoSaudePaciente(final List<PlanoSaudePaciente> listaPlanoSaudePaciente);

}
