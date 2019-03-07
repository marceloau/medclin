/*
 * 
 */
package br.com.medclin.resources;

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

import br.com.medclin.facade.MedicamentoFacade;
import br.com.medclin.model.Medicamento;

@RestController
@RequestMapping(value = "/medclin/medicamento")
public class MedicamentoResource {

	@Autowired
	private MedicamentoFacade medicamentoFacade;

	@PutMapping
	public Medicamento atualizarTipoContato(@RequestBody @Valid final Medicamento medicamento) {
		return medicamentoFacade.atualizarMedicamento(medicamento);
	}

	@GetMapping("/{page}/{size}/{nomeMedicamento}")
	public Page<Medicamento> buscarMedicamentoPorNome(@PathVariable final Integer page,
			@PathVariable final Integer size, @PathVariable final String nomeMedicamento) {
		return medicamentoFacade.buscarMedicamentoPorNome(PageRequest.of(page.intValue(), size.intValue()),
				nomeMedicamento);
	}

	@GetMapping("/{codigoMedicamento}")
	public Medicamento buscarMedicamentoPorCodigo(@PathVariable final Short codigoMedicamento) {
		return medicamentoFacade.buscarMedicamentoPorCodigo(codigoMedicamento);
	}

	@PostMapping
	public Medicamento criarMedicamento(@RequestBody @Valid final Medicamento medicamento) {
		return medicamentoFacade.criarMedicamento(medicamento);
	}

	@DeleteMapping("/{codigoMedicamento}")
	public void deletarMedicamento(@PathVariable final Short codigoMedicamento) {
		medicamentoFacade.deletarMedicamento(codigoMedicamento);
	}

	@GetMapping("/{page}/{size}")
	public @ResponseBody Page<Medicamento> listarMedicamento(@PathVariable final Integer page,
			@PathVariable final Integer size) {
		return medicamentoFacade.listarMedicamento(PageRequest.of(page.intValue(), size.intValue()));
	}
}
