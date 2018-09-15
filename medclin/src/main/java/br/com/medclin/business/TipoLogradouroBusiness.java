package br.com.medclin.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import br.com.medclin.business.interfaces.ITipoLogradouroBusiness;
import br.com.medclin.model.TipoLogradouro;
import br.com.medclin.repository.TipoLogradouroRepository;

@Configuration
public class TipoLogradouroBusiness implements ITipoLogradouroBusiness {

	@Autowired
	private TipoLogradouroRepository TipoLogradouroRep;

	@Override
	public Iterable<TipoLogradouro> listarTipoLogradouro() {
		return TipoLogradouroRep.findAll();
	}

}
