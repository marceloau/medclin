package br.com.medclin.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.medclin.facade.UsoMedicamentoFacade;
import br.com.medclin.model.UsoMedicamento;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/medclin/uso-medicamento")
public class UsoMedicamentoResource {

	@Autowired
	private UsoMedicamentoFacade usoMedicamentoFacade;

	@GetMapping(produces = "application/json")
	public @ResponseBody Iterable<UsoMedicamento> listarUsoMedicamento() {
		return usoMedicamentoFacade.listarUsoMedicamento();
	}

	@GetMapping("/{codigoUsoMedicamento}")
	public UsoMedicamento buscarUsoMedicamentoPorCodigo(@PathVariable final Integer codigoUsoMedicamento) {
		return usoMedicamentoFacade.buscarUsoMedicamentoPorCodigo(codigoUsoMedicamento);
	}
}
