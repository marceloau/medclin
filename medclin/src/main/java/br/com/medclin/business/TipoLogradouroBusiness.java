package br.com.medclin.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import br.com.medclin.business.interfaces.ITipoLogradouroBusiness;
import br.com.medclin.common.CloneUtil;
import br.com.medclin.model.TipoLogradouro;
import br.com.medclin.repository.TipoLogradouroRepository;

@Configuration
public class TipoLogradouroBusiness implements ITipoLogradouroBusiness {

	@Autowired
	private TipoLogradouroRepository tipoLogradouroRep;

	@Autowired
	private CloneUtil cloneUtil;

	@Override
	public Iterable<TipoLogradouro> listarTipoLogradouro() {
		return tipoLogradouroRep.findAll();
	}

	@Override
	public TipoLogradouro buscarTipoLogradouroPorCodigo(final Byte codigoTipoLogradouro) {
		return cloneUtil.clonetipoLogradouro(tipoLogradouroRep.getOne(codigoTipoLogradouro));
	}

}
