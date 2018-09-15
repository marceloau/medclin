package br.com.medclin.ws.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.medclin.facade.EstadoCivilFacade;
import br.com.medclin.model.EstadoCivil;

@RestController
@RequestMapping(value = "/medclin/estado-civil")
public class EstadoCivilResource {

	@Autowired
	private EstadoCivilFacade estadoCivilFacade;

	@GetMapping(produces = "application/json")
	public @ResponseBody Iterable<EstadoCivil> listarEstadoCivil() {
		return estadoCivilFacade.listarEstadoCivil();
	}
}