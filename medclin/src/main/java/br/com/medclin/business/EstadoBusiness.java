package br.com.medclin.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import br.com.medclin.business.interfaces.IEstadoBusiness;
import br.com.medclin.model.Estado;
import br.com.medclin.repository.EstadoRepository;

@Configuration
public class EstadoBusiness implements IEstadoBusiness {

	@Autowired
	private EstadoRepository estadoRep;

	@Override
	public Iterable<Estado> listarEstado() {
		return estadoRep.findAll();
	}

}
