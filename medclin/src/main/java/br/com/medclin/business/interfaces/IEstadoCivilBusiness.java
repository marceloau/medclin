package br.com.medclin.business.interfaces;

import br.com.medclin.model.EstadoCivil;

public interface IEstadoCivilBusiness {

	public Iterable<EstadoCivil> listarEstadoCivil();

	public EstadoCivil buscarEstadoCivilPorCodigo(final Byte codigoEstadoCivil);

}
