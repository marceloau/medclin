package br.com.medclin.business.interfaces;

import br.com.medclin.model.TipoLogradouro;

public interface ITipoLogradouroBusiness {

	public Iterable<TipoLogradouro> listarTipoLogradouro();

	public TipoLogradouro buscarTipoLogradouroPorCodigo(final Byte codigoTipoLogradouro);

}
