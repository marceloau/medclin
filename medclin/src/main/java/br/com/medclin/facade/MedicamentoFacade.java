package br.com.medclin.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import br.com.medclin.business.interfaces.IMedicamentoBusiness;
import br.com.medclin.model.Medicamento;

@Configuration
public class MedicamentoFacade {

	@Autowired
	private IMedicamentoBusiness medicamentoBusiness;

	public Medicamento atualizarMedicamento(final Medicamento medicamento) {
		return medicamentoBusiness.atualizarMedicamento(medicamento);
	}

	public Page<Medicamento> buscarMedicamentoPorNome(final PageRequest pageable, final String nomeMedicamento) {
		return medicamentoBusiness.buscarMedicamentoPorNome(pageable, nomeMedicamento);
	}

	public Medicamento buscarMedicamentoPorCodigo(final Short codigoMedicamento) {
		return medicamentoBusiness.buscarMedicamentoPorCodigo(codigoMedicamento);
	}

	public Medicamento criarMedicamento(final Medicamento medicamento) {
		return medicamentoBusiness.criarMedicamento(medicamento);
	}

	public void deletarMedicamento(final Short codigoMedicamento) {
		medicamentoBusiness.deletarMedicamento(codigoMedicamento);
	}

	public Page<Medicamento> listarMedicamento(final PageRequest pageable) {
		return medicamentoBusiness.listarMedicamento(pageable);
	}

}
