package br.com.medclin.ws.resources;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.medclin.facade.EspecialidadeFacade;
import br.com.medclin.facade.ParametroConfiguracaoFacade;
import br.com.medclin.model.Especialidade;
import br.com.medclin.model.ParametroConfiguracao;

@RestController
@RequestMapping(value = "/especialidade")
public class EspecialidadeResource {

	@Autowired
	private EspecialidadeFacade especialidadeFacade;


	@PutMapping
	public Especialidade atualizarEspecialidade(
			@RequestBody @Valid final Especialidade especialidade) {
		return especialidadeFacade.atualizarEspecialidade(especialidade);
	}


	@GetMapping("/{page}/{size}/{nomeEspecialidade}")
	public Page<Especialidade> buscarEspecialidadePorNome(@PathVariable final Integer page,
			@PathVariable final Integer size, @PathVariable final String nomeEspecialidade) {
		return especialidadeFacade.buscarEspecialidadePorNome(pageable, nomeEspecialidade);
	}
	
	@GetMapping("/{page}/{size}/{nomeParametro}")
	public Iterable<ParametroConfiguracao> buscaParametroConfiguracaoPorNome(@PathVariable final Integer page,
			@PathVariable final Integer size, @PathVariable final String nomeParametro) {
		return parametroConfiguracaoFacade.buscaParametroConfiguracaoPorNome(page, size, nomeParametro);
	}


	@PostMapping
	public ParametroConfiguracao criarParametro(@RequestBody @Valid final ParametroConfiguracao parametroConfiguracao) {
		return parametroConfiguracaoFacade.criarParametro(parametroConfiguracao);
	}


	@DeleteMapping
	public ParametroConfiguracao deletaParametro(@RequestBody final ParametroConfiguracao parametroConfiguracao) {
		return parametroConfiguracaoFacade.deletaParametro(parametroConfiguracao);
	}


	@GetMapping(produces = "application/json")
	public @ResponseBody Iterable<ParametroConfiguracao> listarParametroConfiguracao() {
		return parametroConfiguracaoFacade.listarParametroConfiguracao();
	}
}
