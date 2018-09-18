package br.com.medclin.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.medclin.facade.TipoLogradouroFacade;
import br.com.medclin.model.TipoLogradouro;

@RestController
@RequestMapping(value = "/medclin/tipo-logradouro")
public class TipoLogradouroResource {

	@Autowired
	private TipoLogradouroFacade tipoLogradouroFacade;

	@GetMapping(produces = "application/json")
	public @ResponseBody Iterable<TipoLogradouro> listarTipoLogradouro() {
		return tipoLogradouroFacade.listarTipoLogradouro();
	}
}
