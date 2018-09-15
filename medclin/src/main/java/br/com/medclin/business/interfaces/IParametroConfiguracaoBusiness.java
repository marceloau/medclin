/*
 * 
 */
package br.com.medclin.business.interfaces;

import br.com.medclin.model.ParametroConfiguracao;

/**
 * Interface do business de parametro de configuracao.
 * 
 * @author henrique araujo
 */
public interface IParametroConfiguracaoBusiness {

	/**
	 * Atualiza parametro.
	 *
	 * @param parametroConfiguracao the parametro configuracao
	 * @return the parametro configuracao
	 */
	public ParametroConfiguracao atualizaParametro(final ParametroConfiguracao parametroConfiguracao);

	/**
	 * Busca parametro configuracao por nome.
	 *
	 * @param page          the page
	 * @param size          the size
	 * @param nomeParametro the nome parametro
	 * @return the iterable
	 */
	public Iterable<ParametroConfiguracao> buscaParametroConfiguracaoPorNome(final Integer page, final Integer size,
			final String nomeParametro);

	/**
	 * Criar parametro.
	 *
	 * @param parametroConfiguracao the parametro configuracao
	 * @return the parametro configuracao
	 */
	public ParametroConfiguracao criarParametro(final ParametroConfiguracao parametroConfiguracao);

	/**
	 * Deleta parametro.
	 *
	 * @param parametroConfiguracao the parametro configuracao
	 * @return the parametro configuracao
	 */
	public ParametroConfiguracao deletaParametro(final ParametroConfiguracao parametroConfiguracao);

	/**
	 * Listar parametro configuracao.
	 *
	 * @return the iterable
	 */
	public Iterable<ParametroConfiguracao> listarParametroConfiguracao();

}
