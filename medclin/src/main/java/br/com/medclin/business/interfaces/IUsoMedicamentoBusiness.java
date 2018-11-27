package br.com.medclin.business.interfaces;

import br.com.medclin.model.UsoMedicamento;

public interface IUsoMedicamentoBusiness {

	public Iterable<UsoMedicamento> listarUsoMedicamento();

	public UsoMedicamento buscarUsoMedicamentoPorCodigo(final Integer codigoUsoMedicamento);

}
