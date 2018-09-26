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

import br.com.medclin.facade.OperadoraFacade;
import br.com.medclin.model.Operadora;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/medclin/operadora")
public class OperadoraResource {

	@Autowired
	private OperadoraFacade operadoraFacade;

	@PutMapping
	public Operadora atualizarOperadora(@RequestBody @Valid final Operadora operadora) {
		return operadoraFacade.atualizarOperadora(operadora);
	}

	@GetMapping("/{page}/{size}/{nomeOperadora}")
	public Page<Operadora> buscarOperadoraPorNome(@PathVariable final Integer page, @PathVariable final Integer size,
			@PathVariable final String nomeOperadora) {
		return operadoraFacade.buscarOperadoraPorNome(PageRequest.of(page.intValue(), size.intValue()), nomeOperadora);
	}

	@GetMapping("/{codigoOperadora}")
	public Operadora buscarOperadoraPorCodigo(@PathVariable final Short codigoOperadora) {
		return operadoraFacade.buscarOperadoraPorCodigo(codigoOperadora);
	}

	@GetMapping("/codigoOficial={codigoOficial}")
	public Operadora buscarOperadoraPorCodigoOficial(@PathVariable final Integer codigoOficial) {
		return operadoraFacade.buscarOperadoraPorCodigoOficial(codigoOficial);
	}

	@PostMapping
	public Operadora criarOperadora(@RequestBody @Valid final Operadora operadora) {
		return operadoraFacade.criarOperadora(operadora);
	}

	@DeleteMapping("/{codigoOperadora}")
	public void deletarOperadora(@PathVariable final Short codigoOperadora) {
		operadoraFacade.deletarOperadora(codigoOperadora);
	}

	@GetMapping("/{page}/{size}")
	public @ResponseBody Page<Operadora> listarOperadora(@PathVariable final Integer page,
			@PathVariable final Integer size) {
		return operadoraFacade.listarOperadora(PageRequest.of(page.intValue(), size.intValue()));
	}
}
