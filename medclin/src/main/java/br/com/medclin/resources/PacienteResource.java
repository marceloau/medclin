/*
 * 
 */
package br.com.medclin.resources;

import java.math.BigInteger;

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

import br.com.medclin.facade.PacienteFacade;
import br.com.medclin.model.Paciente;
import br.com.medclin.model.ebo.PacienteEBO;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/medclin/paciente")
public class PacienteResource {

	@Autowired
	private PacienteFacade pacienteFacade;

	@PutMapping
	public Paciente atualizarPaciente(@RequestBody @Valid final Paciente Paciente) {
		return pacienteFacade.atualizarPaciente(Paciente);
	}

	@PostMapping("/buscarPaciente/{page}/{size}")
	public Page<Paciente> buscarPaciente(@PathVariable final Integer page, @PathVariable final Integer size,
			@RequestBody @Valid final PacienteEBO pacienteEBO) {
		return pacienteFacade.buscarPaciente(PageRequest.of(page.intValue(), size.intValue()),
				pacienteEBO.getNomePaciente(), pacienteEBO.getNomeMae(), pacienteEBO.getNumeroRg(),
				pacienteEBO.getNumeroCpf(), pacienteEBO.getNumeroCartaoSUS(), pacienteEBO.getCodigoTipoPlano(),
				pacienteEBO.getTextoContato());

	}

	@GetMapping("/{codigoPaciente}")
	public Paciente buscarPacientePorCodigo(@PathVariable final BigInteger codigoPaciente) {
		return pacienteFacade.buscarPacientePorCodigo(codigoPaciente);
	}

	@PostMapping
	public Paciente criarPaciente(@RequestBody @Valid final Paciente Paciente) {
		return pacienteFacade.criarPaciente(Paciente);
	}

	@DeleteMapping("/{codigoPaciente}")
	public void deletarPaciente(@PathVariable final BigInteger codigoPaciente) {
		pacienteFacade.deletarPaciente(codigoPaciente);
	}

	@GetMapping("/{page}/{size}")
	public @ResponseBody Page<Paciente> listarPaciente(@PathVariable final Integer page,
			@PathVariable final Integer size) {
		return pacienteFacade.listarPaciente(PageRequest.of(page.intValue(), size.intValue()));
	}
}
