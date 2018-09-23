package br.com.medclin.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import br.com.medclin.business.interfaces.IEstadoCivilBusiness;
import br.com.medclin.common.CloneUtil;
import br.com.medclin.model.EstadoCivil;
import br.com.medclin.repository.EstadoCivilRepository;

@Configuration
public class EstadoCivilBusiness implements IEstadoCivilBusiness {

	@Autowired
	private EstadoCivilRepository estadoCivilRep;
	
	@Autowired
	private CloneUtil cloneUtil;

	@Override
	public Iterable<EstadoCivil> listarEstadoCivil() {
		return estadoCivilRep.findAll();
	}

	@Override
	public EstadoCivil buscarEstadoCivilPorCodigo(final Byte codigoEstadoCivil) {
		return cloneUtil.cloneEstadoCivil(estadoCivilRep.getOne(codigoEstadoCivil));
	}
}
