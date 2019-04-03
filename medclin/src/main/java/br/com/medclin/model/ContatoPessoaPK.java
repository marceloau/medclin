package br.com.medclin.model;

import java.io.Serializable;
import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ContatoPessoaPK implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "codigo_pessoa", nullable = false, updatable = false, precision = 22, scale = 0)
	private BigInteger codigoPessoa;

	@Column(name = "codigo_contato_pessoa")
	private Integer codigoContatoPessoa;

	public BigInteger getCodigoPessoa() {
		return codigoPessoa;
	}

	public void setCodigoPessoa(BigInteger codigoPessoa) {
		this.codigoPessoa = codigoPessoa;
	}

	public Integer getCodigoContatoPessoa() {
		return codigoContatoPessoa;
	}

	public void setCodigoContatoPessoa(Integer codigoContatoPessoa) {
		this.codigoContatoPessoa = codigoContatoPessoa;
	}

}
