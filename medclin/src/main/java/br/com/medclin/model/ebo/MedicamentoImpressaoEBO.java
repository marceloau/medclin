package br.com.medclin.model.ebo;

import java.io.Serializable;
import java.util.List;

import br.com.medclin.model.Medicamento;

public class MedicamentoImpressaoEBO implements Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<Medicamento> medicamento;

	public List<Medicamento> getMedicamento() {
		return medicamento;
	}

	public void setMedicamento(List<Medicamento> medicamento) {
		this.medicamento = medicamento;
	}
	
}
