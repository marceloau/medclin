/*
 * 
 */
package br.com.medclin.resources;

import java.math.BigInteger;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.medclin.facade.ConsultaFacade;
import br.com.medclin.model.Consulta;

@RestController
@RequestMapping(value = "/medclin/consulta")
public class ConsultaResource {

	@Autowired
	private ConsultaFacade consultaFacade;

	@PutMapping
	public Consulta atualizarConsulta(@RequestBody @Valid final Consulta consulta) {
		return consultaFacade.atualizarConsulta(consulta);
	}

	@GetMapping("/{codigoConsulta}")
	public Consulta buscarConsultaPorCodigo(@PathVariable final BigInteger codigoConsulta) {
		return consultaFacade.buscarConsultaPorCodigo(codigoConsulta);
	}
	
	@GetMapping("/confirmar/{codigoConsulta}")
	public Consulta confirmarConsulta(@PathVariable final BigInteger codigoConsulta) {
		return consultaFacade.confirmarConsulta(codigoConsulta);
	}
	
	@GetMapping("/iniciar-atendimento/{codigoConsulta}")
	public Consulta iniciarAtendimento(@PathVariable final BigInteger codigoConsulta) {
		return consultaFacade.iniciarAtendimento(codigoConsulta);
	}
	
	@GetMapping("/ordem-chegada/{codigoConsulta}/{numeroOrdemChegada}")
	public Consulta atualizarOrdemChegada(@PathVariable final BigInteger codigoConsulta, @PathVariable final Integer numeroOrdemChegada) {
		return consultaFacade.atualizarOrdemChegada(codigoConsulta, numeroOrdemChegada);
	}
	
	@GetMapping("/buscarConsulta/{page}/{size}")
	public Page<Consulta> buscarConsulta(@PathVariable final Integer page, @PathVariable final Integer size,
			@RequestParam(required = false) String nomePaciente, @RequestParam(required = false) String dataConsulta, 
			@RequestParam(required = false) String mesConsulta,
			@RequestParam(required = false) String codigoPaciente,
			@RequestParam(required = false) Integer codigoStatusConsulta) {
		return consultaFacade.buscarConsulta(PageRequest.of(page.intValue(), size.intValue()), nomePaciente, dataConsulta, mesConsulta, codigoPaciente, codigoStatusConsulta);
	}

	@PostMapping
	public Consulta criarConsulta(@RequestBody @Valid final Consulta consulta) {
		return consultaFacade.criarConsulta(consulta);
	}

	@DeleteMapping("/{codigoConsulta}")
	public void deletarConsulta(@PathVariable final BigInteger codigoConsulta) {
		consultaFacade.deletarConsulta(codigoConsulta);
	}

	@GetMapping("/{page}/{size}")
	public @ResponseBody Page<Consulta> listarConsulta(@PathVariable final Integer page,
			@PathVariable final Integer size) {
		return consultaFacade.listarConsulta(PageRequest.of(page.intValue(), size.intValue()));
	}
	
	@GetMapping("/listarConsultasAtendimento/{page}/{size}")
	public Page<Consulta> listarConsultasAtendimento(@PathVariable final Integer page, @PathVariable final Integer size,
			@RequestParam(required = true) String dataConsulta, @RequestParam(required = false) String flagConfirmada) {
		return consultaFacade.listarConsultasAtendimento(PageRequest.of(page.intValue(), size.intValue()), dataConsulta, flagConfirmada);
	}
	
	@GetMapping("/total-consultas")
	public BigInteger totalConsultas() {
		return consultaFacade.totalConsultas();
	}
}
