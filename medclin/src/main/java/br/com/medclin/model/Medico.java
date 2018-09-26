package br.com.medclin.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "codigo_pessoa")
public class Medico extends Pessoa {

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((listaAgendaMedico == null) ? 0 : listaAgendaMedico.hashCode());
		result = prime * result + ((listaEspecialidadeMedico == null) ? 0 : listaEspecialidadeMedico.hashCode());
		result = prime * result + ((numeroCRM == null) ? 0 : numeroCRM.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Medico other = (Medico) obj;
		if (listaAgendaMedico == null) {
			if (other.listaAgendaMedico != null)
				return false;
		} else if (!listaAgendaMedico.equals(other.listaAgendaMedico))
			return false;
		if (listaEspecialidadeMedico == null) {
			if (other.listaEspecialidadeMedico != null)
				return false;
		} else if (!listaEspecialidadeMedico.equals(other.listaEspecialidadeMedico))
			return false;
		if (numeroCRM == null) {
			if (other.numeroCRM != null)
				return false;
		} else if (!numeroCRM.equals(other.numeroCRM))
			return false;
		return true;
	}

}
