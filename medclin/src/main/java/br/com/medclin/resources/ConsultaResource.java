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

import br.com.medclin.facade.ConsultaFacade;
import br.com.medclin.model.Consulta;

@CrossOrigin(origins = "*")
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
}
