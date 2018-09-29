package br.com.medclin.model;

import java.io.Serializable;
import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class EspecialidadeMedicoPK implements Serializable {

	private static final long SerialVersionUID = 1L;

	@Column(name = "codigo_pessoa", nullable = false, updatable = false, precision = 22, scale = 0)
	private BigInteger codigoPessoa;

	@Column(name = "codigo_especialidade_medico")
	private Short codigoEspecialidadeMedico;

	public BigInteger getCodigoPessoa() {
		return codigoPessoa;
	}

	public void setCodigoPessoa(BigInteger codigoPessoa) {
		this.codigoPessoa = codigoPessoa;
	}

	public Short getCodigoEspecialidadeMedico() {
		return codigoEspecialidadeMedico;
	}

	public void setCodigoEspecialidadeMedico(Short codigoEspecialidadeMedico) {
		this.codigoEspecialidadeMedico = codigoEspecialidadeMedico;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigoEspecialidadeMedico == null) ? 0 : codigoEspecialidadeMedico.hashCode());
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
		EspecialidadeMedicoPK other = (EspecialidadeMedicoPK) obj;
		if (codigoEspecialidadeMedico == null) {
			if (other.codigoEspecialidadeMedico != null)
				return false;
		} else if (!codigoEspecialidadeMedico.equals(other.codigoEspecialidadeMedico))
			return false;
		if (codigoPessoa == null) {
			if (other.codigoPessoa != null)
				return false;
		} else if (!codigoPessoa.equals(other.codigoPessoa))
			return false;
		return true;
	}

}
