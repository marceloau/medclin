package br.com.medclin.model;

import java.io.Serializable;
import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class AgendaMedicoPK implements Serializable {

	private static final long SerialVersionUID = 1L;

	@Column(name = "codigo_pessoa", nullable = false, updatable = false, precision = 22, scale = 0)
	private BigInteger codigoPessoa;

	@Column(name = "codigo_agenda_medico")
	private Short codigoAgendaMedico;

	public BigInteger getCodigoPessoa() {
		return codigoPessoa;
	}

	public void setCodigoPessoa(BigInteger codigoPessoa) {
		this.codigoPessoa = codigoPessoa;
	}

	public Short getCodigoAgendaMedico() {
		return codigoAgendaMedico;
	}

	public void setCodigoAgendaMedico(Short codigoAgendaMedico) {
		this.codigoAgendaMedico = codigoAgendaMedico;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigoAgendaMedico == null) ? 0 : codigoAgendaMedico.hashCode());
		result = prime * result + ((codigoPessoa == null) ? 0 : codigoPessoa.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AgendaMedicoPK other = (AgendaMedicoPK) obj;
		if (codigoAgendaMedico == null) {
			if (other.codigoAgendaMedico != null)
				return false;
		} else if (!codigoAgendaMedico.equals(other.codigoAgendaMedico))
			return false;
		if (codigoPessoa == null) {
			if (other.codigoPessoa != null)
				return false;
		} else if (!codigoPessoa.equals(other.codigoPessoa))
			return false;
		return true;
	}

}