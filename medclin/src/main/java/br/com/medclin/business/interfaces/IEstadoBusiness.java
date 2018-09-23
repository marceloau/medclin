package br.com.medclin.business.interfaces;

import br.com.medclin.model.Estado;

public interface IEstadoBusiness {

	public Iterable<Estado> listarEstado();

	public Estado buscarEstadoPorCodigo(final Byte codigoEstado);

}
