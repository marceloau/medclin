package br.com.medclin.business.interfaces;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import br.com.medclin.model.Medicamento;

public interface IMedicamentoBusiness {

	public Medicamento atualizarMedicamento(final Medicamento medicamento);

	public Page<Medicamento> buscarMedicamentoPorNome(final PageRequest pageable, final String nomeMedicamento);

	public Medicamento buscarMedicamentoPorCodigo(final Short codigoMedicamento);

	public Medicamento criarMedicamento(final Medicamento medicamento);

	public void deletarMedicamento(final Short codigoMedicamento);

	public Page<Medicamento> listarMedicamento(final PageRequest pageable);

}
