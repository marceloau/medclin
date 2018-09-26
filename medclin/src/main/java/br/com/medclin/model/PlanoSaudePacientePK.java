package br.com.medclin.model;

import java.io.Serializable;
import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class PlanoSaudePacientePK implements Serializable {

	private static final long SerialVersionUID = 1L;

	@Column(name = "codigo_pessoa")
	private BigInteger codigoPessoa;

	@Column(name = "codigo_plano_saude_paciente")
	private Long codigoPlanoSaudePaciente;

	public BigInteger getCodigoPessoa() {
		return codigoPessoa;
	}

	public void setCodigoPessoa(BigInteger codigoPessoa) {
		this.codigoPessoa = codigoPessoa;
	}

	public Long getCodigoPlanoSaudePaciente() {
		return codigoPlanoSaudePaciente;
	}

	public void setCodigoPlanoSaudePaciente(Long codigoPlanoSaudePaciente) {
		this.codigoPlanoSaudePaciente = codigoPlanoSaudePaciente;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigoPessoa == null) ? 0 : codigoPessoa.hashCode());
		result = prime * result + ((codigoPlanoSaudePaciente == null) ? 0 : codigoPlanoSaudePaciente.hashCode());
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
		PlanoSaudePacientePK other = (PlanoSaudePacientePK) obj;
		if (codigoPessoa == null) {
			if (other.codigoPessoa != null)
				return false;
		} else if (!codigoPessoa.equals(other.codigoPessoa))
			return false;
		if (codigoPlanoSaudePaciente == null) {
			if (other.codigoPlanoSaudePaciente != null)
				return false;
		} else if (!codigoPlanoSaudePaciente.equals(other.codigoPlanoSaudePaciente))
			return false;
		return true;
	}

}
