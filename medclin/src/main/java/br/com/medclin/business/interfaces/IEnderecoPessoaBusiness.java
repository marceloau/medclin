package br.com.medclin.business.interfaces;

import java.math.BigInteger;
import java.util.List;

import br.com.medclin.model.EnderecoPessoa;

public interface IEnderecoPessoaBusiness {

	public void criarListaEnderecoPessoa(final List<EnderecoPessoa> listaEnderecoPessoa, final BigInteger codigoPessoa);

	public void atualizarListaEnderecoPessoa(final List<EnderecoPessoa> listaEnderecoPessoa, final BigInteger codigoPessoa);

}
