package br.com.medclin.facade;

import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import br.com.medclin.business.interfaces.IMedicoBusiness;
import br.com.medclin.model.Medico;

@Configuration
public class MedicoFacade {

	@Autowired
	private IMedicoBusiness medicoBusiness;

	public Medico atualizarMedico(final Medico medico) {
		return medicoBusiness.atualizarMedico(medico);
	}

	public Page<Medico> buscarMedicoPorNome(final PageRequest pageable, final String nomeMedico) {
		return medicoBusiness.buscarMedicoPorNome(pageable, nomeMedico);
	}

	public Medico buscarMedicoPorCodigo(final BigInteger codigoMedico) {
		return medicoBusiness.buscarMedicoPorCodigo(codigoMedico);
	}

	public Medico criarMedico(final Medico medico) {
		return medicoBusiness.criarMedico(medico);
	}

	public void deletarMedico(final BigInteger codigoMedico) {
		medicoBusiness.deletarMedico(codigoMedico);
	}

	public Page<Medico> listarMedico(final PageRequest pageable) {
		return medicoBusiness.listarMedico(pageable);
	}

}
