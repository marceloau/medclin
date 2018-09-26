/*
 * 
 */
package br.com.medclin.resources;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.medclin.facade.ParametroConfiguracaoFacade;
import br.com.medclin.model.ParametroConfiguracao;

/**
 * The Class ParametroConfiguracaoResource.
 * 
 * @author henrique araujo
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/parametro-configuracao")
public class ParametroConfiguracaoResource {

	/** The parametro configuracao facade. */
	@Autowired
	private ParametroConfiguracaoFacade parametroConfiguracaoFacade;

	/**
	 * Atualiza parametro.
	 *
	 * @param parametroConfiguracao the parametro configuracao
	 * @return the parametro configuracao
	 */
	@PutMapping
	public ParametroConfiguracao atualizaParametro(
			@RequestBody @Valid final ParametroConfiguracao parametroConfiguracao) {
		return parametroConfiguracaoFacade.atualizaParametro(parametroConfiguracao);
	}

	/**
	 * Busca parametro configuracao.
	 *
	 * @param page          the page
	 * @param size          the size
	 * @param nomeParametro the nome parametro
	 * @return the parametro configuracao
	 */
	@GetMapping("/{page}/{size}/{nomeParametro}")
	public Iterable<ParametroConfiguracao> buscaParametroConfiguracaoPorNome(@PathVariable final Integer page,
			@PathVariable final Integer size, @PathVariable final String nomeParametro) {
		return parametroConfiguracaoFacade.buscaParametroConfiguracaoPorNome(page, size, nomeParametro);
	}

	/**
	 * Criar parametro.
	 *
	 * @param parametroConfiguracao the parametro configuracao
	 * @return the parametro configuracao
	 */
	@PostMapping
	public ParametroConfiguracao criarParametro(@RequestBody @Valid final ParametroConfiguracao parametroConfiguracao) {
		return parametroConfiguracaoFacade.criarParametro(parametroConfiguracao);
	}

	/**
	 * Deleta parametro.
	 *
	 * @param parametroConfiguracao the parametro configuracao
	 * @return the parametro configuracao
	 */
	@DeleteMapping
	public ParametroConfiguracao deletaParametro(@RequestBody final ParametroConfiguracao parametroConfiguracao) {
		return parametroConfiguracaoFacade.deletaParametro(parametroConfiguracao);
	}

	/**
	 * Lista parametro configuracao.
	 *
	 * @return the iterable
	 */
	@GetMapping(produces = "application/json")
	public @ResponseBody Iterable<ParametroConfiguracao> listarParametroConfiguracao() {
		return parametroConfiguracaoFacade.listarParametroConfiguracao();
	}

}
