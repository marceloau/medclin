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

import br.com.medclin.facade.TipoPlanoSaudeFacade;
import br.com.medclin.model.TipoPlanoSaude;

@RestController
@RequestMapping(value = "/medclin/tipo-plano-saude")
public class TipoPlanoSaudeResource {

	@Autowired
	private TipoPlanoSaudeFacade tipoPlanoSaudeFacade;

	@PutMapping
	public TipoPlanoSaude atualizarTipoPlanoSaude(@RequestBody @Valid final TipoPlanoSaude tipoPlanoSaude) {
		return tipoPlanoSaudeFacade.atualizarTipoPlanoSaude(tipoPlanoSaude);
	}

	@GetMapping("/{page}/{size}/{nomeTipoPlanoSaude}")
	public Page<TipoPlanoSaude> buscarTipoPlanoSaudePorNome(@PathVariable final Integer page,
			@PathVariable final Integer size, @PathVariable final String nomeTipoPlanoSaude) {
		return tipoPlanoSaudeFacade.buscarTipoPlanoSaudePorNome(PageRequest.of(page.intValue(), size.intValue()),
				nomeTipoPlanoSaude);
	}

	@GetMapping("/{codigoTipoPlanoSaude}")
	public Iterable<TipoPlanoSaude> buscarTipoPlanoSaudePorCodigo(@PathVariable final Short codigoTipoPlanoSaude) {
		return tipoPlanoSaudeFacade.buscarTipoPlanoSaudePorCodigo(codigoTipoPlanoSaude);
	}

	@PostMapping
	public TipoPlanoSaude criarTipoPlanoSaude(@RequestBody @Valid final TipoPlanoSaude tipoPlanoSaude) {
		return tipoPlanoSaudeFacade.criarTipoPlanoSaude(tipoPlanoSaude);
	}

	@DeleteMapping("/{codigoTipoPlanoSaude}")
	public void deletarTipoPlanoSaude(@PathVariable final Short codigoTipoPlanoSaude) {
		tipoPlanoSaudeFacade.deletarTipoPlanoSaude(codigoTipoPlanoSaude);
	}

	@GetMapping("/{page}/{size}")
	public @ResponseBody Page<TipoPlanoSaude> listarTipoPlanoSaude(@PathVariable final Integer page,
			@PathVariable final Integer size) {
		return tipoPlanoSaudeFacade.listarTipoPlanoSaude(PageRequest.of(page.intValue(), size.intValue()));
	}
}
