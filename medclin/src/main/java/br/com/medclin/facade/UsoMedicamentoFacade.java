package br.com.medclin.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import br.com.medclin.business.interfaces.IUsoMedicamentoBusiness;
import br.com.medclin.model.UsoMedicamento;

@Configuration
public class UsoMedicamentoFacade {

	@Autowired
	private IUsoMedicamentoBusiness usoMedicamentoBusiness;

	public Iterable<UsoMedicamento> listarUsoMedicamento() {
		return usoMedicamentoBusiness.listarUsoMedicamento();
	}

	public UsoMedicamento buscarUsoMedicamentoPorCodigo(final Integer codigoUsoMedicamento) {
		return usoMedicamentoBusiness.buscarUsoMedicamentoPorCodigo(codigoUsoMedicamento);
	}
}
