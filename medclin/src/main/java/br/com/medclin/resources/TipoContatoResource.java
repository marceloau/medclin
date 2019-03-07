/*
 * 
 */
package br.com.medclin.resources;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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

import br.com.medclin.facade.TipoContatoFacade;
import br.com.medclin.model.TipoContato;

@RestController
@RequestMapping(value = "/medclin/tipo-contato")
public class TipoContatoResource {

	@Autowired
	private TipoContatoFacade tipoContatoFacade;

	@PutMapping
	public TipoContato atualizarTipoContato(@RequestBody @Valid final TipoContato TipoContato) {
		return tipoContatoFacade.atualizarTipoContato(TipoContato);
	}

	@GetMapping("/{page}/{size}/{nomeTipoContato}")
	public Page<TipoContato> buscarTipoContatoPorNome(@PathVariable final Integer page,
			@PathVariable final Integer size, @PathVariable final String nomeTipoContato) {
		return tipoContatoFacade.buscarTipoContatoPorNome(PageRequest.of(page.intValue(), size.intValue()),
				nomeTipoContato);
	}

	@GetMapping("/{codigoTipoContato}")
	public TipoContato buscarTipoContatoPorCodigo(@PathVariable final Short codigoTipoContato) {
		return tipoContatoFacade.buscarTipoContatoPorCodigo(codigoTipoContato);
	}

	@PostMapping
	public TipoContato criarTipoContato(@RequestBody @Valid final TipoContato TipoContato) {
		return tipoContatoFacade.criarTipoContato(TipoContato);
	}

	@DeleteMapping("/{codigoTipoContato}")
	public void deletarTipoContato(@PathVariable final Short codigoTipoContato) {
		tipoContatoFacade.deletarTipoContato(codigoTipoContato);
	}

	@GetMapping("/{page}/{size}")
	public @ResponseBody Page<TipoContato> listarTipoContato(@PathVariable final Integer page,
			@PathVariable final Integer size) {
		return tipoContatoFacade.listarTipoContato(PageRequest.of(page.intValue(), size.intValue()));
	}
}
