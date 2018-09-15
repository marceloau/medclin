/*
 * 
 */
package br.com.medclin.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import br.com.medclin.business.interfaces.IParametroConfiguracaoBusiness;
import br.com.medclin.model.ParametroConfiguracao;

/**
 * The Class ParametroConfiguracaoFacade.
 * 
 * @author henrique araujo
 */
@Configuration
public class ParametroConfiguracaoFacade {

	/** The parametro configuracao business. */
	@Autowired
	private IParametroConfiguracaoBusiness parametroConfiguracaoBusiness;

	/**
	 * Atualiza parametro.
	 *
	 * @param parametroConfiguracao the parametro configuracao
	 * @return the parametro configuracao
	 */
	public ParametroConfiguracao atualizaParametro(final ParametroConfiguracao parametroConfiguracao) {
		return parametroConfiguracaoBusiness.atualizaParametro(parametroConfiguracao);
	}

	/**
	 * Busca parametro configuracao por nome.
	 *
	 * @param page          the page
	 * @param size          the size
	 * @param nomeParametro the nome parametro
	 * @return the iterable
	 */
	public Iterable<ParametroConfiguracao> buscaParametroConfiguracaoPorNome(final Integer page, final Integer size,
			final String nomeParametro) {
		return parametroConfiguracaoBusiness.buscaParametroConfiguracaoPorNome(page, size, nomeParametro);
	}

	/**
	 * Criar parametro.
	 *
	 * @param parametroConfiguracao the parametro configuracao
	 * @return the parametro configuracao
	 */
	public ParametroConfiguracao criarParametro(final ParametroConfiguracao parametroConfiguracao) {
		return parametroConfiguracaoBusiness.criarParametro(parametroConfiguracao);
	}

	/**
	 * Deleta parametro.
	 *
	 * @param parametroConfiguracao the parametro configuracao
	 * @return the parametro configuracao
	 */
	public ParametroConfiguracao deletaParametro(final ParametroConfiguracao parametroConfiguracao) {
		parametroConfiguracaoBusiness.deletaParametro(parametroConfiguracao);
		return parametroConfiguracao;
	}

	/**
	 * Listar parametro configuracao.
	 *
	 * @return the iterable
	 */
	public Iterable<ParametroConfiguracao> listarParametroConfiguracao() {
		return parametroConfiguracaoBusiness.listarParametroConfiguracao();
	}

}
