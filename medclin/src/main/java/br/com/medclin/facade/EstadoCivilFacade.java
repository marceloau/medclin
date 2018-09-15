package br.com.medclin.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import br.com.medclin.business.interfaces.IEstadoCivilBusiness;
import br.com.medclin.model.EstadoCivil;

@Configuration
public class EstadoCivilFacade {

	@Autowired
	private IEstadoCivilBusiness estadoCivilBusiness;

	public Iterable<EstadoCivil> listarEstadoCivil() {
		return estadoCivilBusiness.listarEstadoCivil();
	}

}
