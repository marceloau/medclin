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

import br.com.medclin.facade.TipoMedicamentoFacade;
import br.com.medclin.model.TipoMedicamento;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/medclin/tipo-medicamento")
public class TipoMedicamentoResource {

	@Autowired
	private TipoMedicamentoFacade tipoMedicamentoFacade;

	@PutMapping
	public TipoMedicamento atualizarTipoContato(@RequestBody @Valid final TipoMedicamento tipoMedicamento) {
		return tipoMedicamentoFacade.atualizarTipoMedicamento(tipoMedicamento);
	}

	@GetMapping("/{page}/{size}/{nomeTipoMedicamento}")
	public Page<TipoMedicamento> buscarTipoMedicamentoPorNome(@PathVariable final Integer page,
			@PathVariable final Integer size, @PathVariable final String nomeTipoMedicamento) {
		return tipoMedicamentoFacade.buscarTipoMedicamentoPorNome(PageRequest.of(page.intValue(), size.intValue()),
				nomeTipoMedicamento);
	}

	@GetMapping("/{codigoTipoMedicamento}")
	public TipoMedicamento buscarTipoMedicamentoPorCodigo(@PathVariable final Short codigoTipoMedicamento) {
		return tipoMedicamentoFacade.buscarTipoMedicamentoPorCodigo(codigoTipoMedicamento);
	}

	@PostMapping
	public TipoMedicamento criarTipoMedicamento(@RequestBody @Valid final TipoMedicamento tipoMedicamento) {
		return tipoMedicamentoFacade.criarTipoMedicamento(tipoMedicamento);
	}

	@DeleteMapping("/{codigoTipoMedicamento}")
	public void deletarTipoMedicamento(@PathVariable final Short codigoTipoMedicamento) {
		tipoMedicamentoFacade.deletarTipoMedicamento(codigoTipoMedicamento);
	}

	@GetMapping("/{page}/{size}")
	public @ResponseBody Page<TipoMedicamento> listarTipoMedicamento(@PathVariable final Integer page,
			@PathVariable final Integer size) {
		return tipoMedicamentoFacade.listarTipoMedicamento(PageRequest.of(page.intValue(), size.intValue()));
	}
}
