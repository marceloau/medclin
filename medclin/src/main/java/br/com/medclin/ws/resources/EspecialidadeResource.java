/*
 * 
 */
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
import br.com.medclin.model.Especialidade;

@RestController
@RequestMapping(value = "/medclin/especialidade")
public class EspecialidadeResource {

	@Autowired
	private EspecialidadeFacade especialidadeFacade;

	@PutMapping
	public Especialidade atualizarEspecialidade(@RequestBody @Valid final Especialidade especialidade) {
		return especialidadeFacade.atualizarEspecialidade(especialidade);
	}

	@GetMapping("/{page}/{size}/{nomeEspecialidade}")
	public Page<Especialidade> buscarEspecialidadePorNome(@PathVariable final Integer page,
			@PathVariable final Integer size, @PathVariable final String nomeEspecialidade) {
		return especialidadeFacade.buscarEspecialidadePorNome(PageRequest.of(page.intValue(), size.intValue()),
				nomeEspecialidade);
	}

	@GetMapping("/{codigoEspecialidade}")
	public Iterable<Especialidade> buscarEspecialidadePorCodigo(@PathVariable final Long codigoEspecialidade) {
		return especialidadeFacade.buscarEspecialidadePorCodigo(codigoEspecialidade);
	}

	@PostMapping
	public Especialidade criarEspecialidade(@RequestBody @Valid final Especialidade especialidade) {
		return especialidadeFacade.criarEspecialidade(especialidade);
	}

	@DeleteMapping("/{codigoEspecialidade}")
	public void deletarEspecialidade(@PathVariable final Long codigoEspecialidade) {
		especialidadeFacade.deletarEspecialidade(codigoEspecialidade);
	}

	@GetMapping("/{page}/{size}")
	public @ResponseBody Page<Especialidade> listarEspecialidade(@PathVariable final Integer page,
			@PathVariable final Integer size) {
		return especialidadeFacade.listarEspecialidade(PageRequest.of(page.intValue(), size.intValue()));
	}
}
