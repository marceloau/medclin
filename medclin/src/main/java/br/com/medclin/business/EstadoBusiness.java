package br.com.medclin.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import br.com.medclin.business.interfaces.IEstadoBusiness;
import br.com.medclin.common.CloneUtil;
import br.com.medclin.model.Estado;
import br.com.medclin.repository.EstadoRepository;

@Configuration
public class EstadoBusiness implements IEstadoBusiness {

	@Autowired
	private EstadoRepository estadoRep;
	
	@Autowired
	private CloneUtil cloneUtil;

	@Override
	public Iterable<Estado> listarEstado() {
		return estadoRep.findAll();
	}

	@Override
	public Estado buscarEstadoPorCodigo(final Byte codigoEstado) {
		return cloneUtil.cloneEstado(estadoRep.getOne(codigoEstado));
	}

}
