package br.com.medclin.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import br.com.medclin.business.interfaces.ITipoLogradouroBusiness;
import br.com.medclin.model.TipoLogradouro;

@Configuration
public class TipoLogradouroFacade {

	@Autowired
	private ITipoLogradouroBusiness tipoLogradouroBusiness;

	public Iterable<TipoLogradouro> listarTipoLogradouro() {
		return tipoLogradouroBusiness.listarTipoLogradouro();
	}

	public TipoLogradouro buscarTipoLogradouroPorCodigo(final Byte codigoTipoLogradouro) {
		return tipoLogradouroBusiness.buscarTipoLogradouroPorCodigo(codigoTipoLogradouro);
	}

}
