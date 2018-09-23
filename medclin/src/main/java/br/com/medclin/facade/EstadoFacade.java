package br.com.medclin.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import br.com.medclin.business.interfaces.IEstadoBusiness;
import br.com.medclin.model.Estado;

@Configuration
public class EstadoFacade {

	@Autowired
	private IEstadoBusiness estadoBusiness;

	public Iterable<Estado> listarEstado() {
		return estadoBusiness.listarEstado();
	}

	public Estado buscarEstadoPorCodigo(final Byte codigoEstado) {
		return estadoBusiness.buscarEstadoPorCodigo(codigoEstado);
	}
}
