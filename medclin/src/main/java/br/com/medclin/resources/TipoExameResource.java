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

import br.com.medclin.facade.TipoExameFacade;
import br.com.medclin.model.TipoExame;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/medclin/tipo-exame")
public class TipoExameResource {

	@Autowired
	private TipoExameFacade tipoExameFacade;

	@PutMapping
	public TipoExame atualizarTipoContato(@RequestBody @Valid final TipoExame tipoExame) {
		return tipoExameFacade.atualizarTipoExame(tipoExame);
	}

	@GetMapping("/{page}/{size}/{nomeTipoExame}")
	public Page<TipoExame> buscarTipoExamePorNome(@PathVariable final Integer page,
			@PathVariable final Integer size, @PathVariable final String nomeTipoExame) {
		return tipoExameFacade.buscarTipoExamePorNome(PageRequest.of(page.intValue(), size.intValue()),
				nomeTipoExame);
	}

	@GetMapping("/{codigoTipoExame}")
	public TipoExame buscarTipoExamePorCodigo(@PathVariable final Short codigoTipoExame) {
		return tipoExameFacade.buscarTipoExamePorCodigo(codigoTipoExame);
	}

	@PostMapping
	public TipoExame criarTipoExame(@RequestBody @Valid final TipoExame tipoExame) {
		return tipoExameFacade.criarTipoExame(tipoExame);
	}

	@DeleteMapping("/{codigoTipoExame}")
	public void deletarTipoExame(@PathVariable final Short codigoTipoExame) {
		tipoExameFacade.deletarTipoExame(codigoTipoExame);
	}

	@GetMapping("/{page}/{size}")
	public @ResponseBody Page<TipoExame> listarTipoExame(@PathVariable final Integer page,
			@PathVariable final Integer size) {
		return tipoExameFacade.listarTipoExame(PageRequest.of(page.intValue(), size.intValue()));
	}
}
