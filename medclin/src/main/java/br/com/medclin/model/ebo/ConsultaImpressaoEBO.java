package br.com.medclin.model.ebo;

import java.io.Serializable;
import java.util.List;

import br.com.medclin.model.Consulta;

public class ConsultaImpressaoEBO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Consulta> consulta;

	public List<Consulta> getConsulta() {
		return consulta;
	}

	public void setConsulta(List<Consulta> consulta) {
		this.consulta = consulta;
	}

}
