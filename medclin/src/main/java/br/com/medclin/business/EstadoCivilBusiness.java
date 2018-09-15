package br.com.medclin.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import br.com.medclin.business.interfaces.IEstadoCivilBusiness;
import br.com.medclin.model.EstadoCivil;
import br.com.medclin.repository.EstadoCivilRepository;

@Configuration
public class EstadoCivilBusiness implements IEstadoCivilBusiness {

	@Autowired
	private EstadoCivilRepository estadoCivilRep;

	@Override
	public Iterable<EstadoCivil> listarEstadoCivil() {
		return estadoCivilRep.findAll();
	}
}
