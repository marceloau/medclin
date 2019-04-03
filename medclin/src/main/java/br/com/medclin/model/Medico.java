package br.com.medclin.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "codigo_pessoa")
public class Medico extends Pessoa  implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String numeroCRM;

	@OneToMany(mappedBy = "medico")
	@OrderColumn(name = "codigo_especialidade_medico", insertable = false, updatable = false)
	private List<EspecialidadeMedico> listaEspecialidadeMedico;

	@OneToMany(mappedBy = "medico")
	@OrderColumn(name = "codigo_agenda_medico", insertable = false, updatable = false)
	private List<AgendaMedico> listaAgendaMedico;

	public String getNumeroCRM() {
		return numeroCRM;
	}

	public void setNumeroCRM(String numeroCRM) {
		this.numeroCRM = numeroCRM;
	}

	public List<EspecialidadeMedico> getListaEspecialidadeMedico() {
		return listaEspecialidadeMedico;
	}

	public void setListaEspecialidadeMedico(List<EspecialidadeMedico> listaEspecialidadeMedico) {
		this.listaEspecialidadeMedico = listaEspecialidadeMedico;
	}

	public List<AgendaMedico> getListaAgendaMedico() {
		return listaAgendaMedico;
	}

	public void setListaAgendaMedico(List<AgendaMedico> listaAgendaMedico) {
		this.listaAgendaMedico = listaAgendaMedico;
	}

}
