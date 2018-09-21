package br.com.medclin.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ContatoPessoaPK implements Serializable {

	private static final long SerialVersionUID = 1L;

	@Column(name = "codigo_pessoa")
	private Long codigoPessoa;

	@Column(name = "codigo_contato_pessoa")
	private Integer codigoContatoPessoa;

	public Long getCodigoPessoa() {
		return codigoPessoa;
	}

	public void setCodigoPessoa(Long codigoPessoa) {
		this.codigoPessoa = codigoPessoa;
	}

	public Integer getCodigoContatoPessoa() {
		return codigoContatoPessoa;
	}

	public void setCodigoContatoPessoa(Integer codigoContatoPessoa) {
		this.codigoContatoPessoa = codigoContatoPessoa;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigoContatoPessoa == null) ? 0 : codigoContatoPessoa.hashCode());
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
		ContatoPessoaPK other = (ContatoPessoaPK) obj;
		if (codigoContatoPessoa == null) {
			if (other.codigoContatoPessoa != null)
				return false;
		} else if (!codigoContatoPessoa.equals(other.codigoContatoPessoa))
			return false;
		if (codigoPessoa == null) {
			if (other.codigoPessoa != null)
				return false;
		} else if (!codigoPessoa.equals(other.codigoPessoa))
			return false;
		return true;
	}

}
