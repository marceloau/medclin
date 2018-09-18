package br.com.medclin.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.medclin.facade.EstadoFacade;
import br.com.medclin.model.Estado;

@RestController
@RequestMapping(value = "/medclin/estado")
public class EstadoResource {

	@Autowired
	private EstadoFacade estadoFacade;

	@GetMapping(produces = "application/json")
	public @ResponseBody Iterable<Estado> listarEstado() {
		return estadoFacade.listarEstado();
	}
}
