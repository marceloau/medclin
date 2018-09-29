package br.com.medclin.business.interfaces;

import java.math.BigInteger;
import java.util.List;

import br.com.medclin.model.EspecialidadeMedico;

public interface IEspecialidadeMedicoBusiness {

	public void criarListaEspecialidadeMedico(final List<EspecialidadeMedico> listaEspecialidadeMedico,
			final BigInteger codigoPessoa);

	public void atualizarListaEspecialidadeMedico(final List<EspecialidadeMedico> listaEspecialidadeMedico);

}
