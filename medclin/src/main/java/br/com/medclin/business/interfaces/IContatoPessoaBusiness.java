package br.com.medclin.business.interfaces;

import java.math.BigInteger;
import java.util.List;

import br.com.medclin.model.ContatoPessoa;

public interface IContatoPessoaBusiness {

	public void criarListaContatoPessoa(final List<ContatoPessoa> listaContatoPessoa, final BigInteger codigoPessoa);

	public void atualizarListaContatoPessoa(final List<ContatoPessoa> listaContatoPessoa, final BigInteger codigoPessoa);

}
