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

import br.com.medclin.facade.MedicoFacade;
import br.com.medclin.model.Medico;

@RestController
@RequestMapping(value = "/medclin/medico")
public class MedicoResource {

	@Autowired
	private MedicoFacade medicoFacade;

	@PutMapping
	public Medico atualizarMedico(@RequestBody @Valid final Medico medico) {
		return medicoFacade.atualizarMedico(medico);
	}

	@GetMapping("/{page}/{size}/{nomeMedico}")
	public Page<Medico> buscarMedicoPorNome(@PathVariable final Integer page, @PathVariable final Integer size,
			@PathVariable final String nomeMedico) {
		return medicoFacade.buscarMedicoPorNome(PageRequest.of(page.intValue(), size.intValue()), nomeMedico);
	}

	@GetMapping("/{codigoMedico}")
	public Medico buscarMedicoPorCodigo(@PathVariable final Long codigoMedico) {
		return medicoFacade.buscarMedicoPorCodigo(codigoMedico);
	}

	@PostMapping
	public Medico criarMedico(@RequestBody @Valid final Medico medico) {
		return medicoFacade.criarMedico(medico);
	}

	@DeleteMapping("/{codigoMedico}")
	public void deletarMedico(@PathVariable final Long codigoMedico) {
		medicoFacade.deletarMedico(codigoMedico);
	}

	@GetMapping("/{page}/{size}")
	public @ResponseBody Page<Medico> listarMedico(@PathVariable final Integer page, @PathVariable final Integer size) {
		return medicoFacade.listarMedico(PageRequest.of(page.intValue(), size.intValue()));
	}
}
