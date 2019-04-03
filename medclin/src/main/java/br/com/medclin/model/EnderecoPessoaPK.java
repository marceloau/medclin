package br.com.medclin.model;

import java.io.Serializable;
import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class EnderecoPessoaPK implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "codigo_pessoa", nullable = false, updatable = false, precision = 22, scale = 0)
	private BigInteger codigoPessoa;

	@Column(name = "codigo_endereco_pessoa")
	private Integer codigoEnderecoPessoa;

	public BigInteger getCodigoPessoa() {
		return codigoPessoa;
	}

	public void setCodigoPessoa(BigInteger codigoPessoa) {
		this.codigoPessoa = codigoPessoa;
	}

	public Integer getCodigoEnderecoPessoa() {
		return codigoEnderecoPessoa;
	}

	public void setCodigoEnderecoPessoa(Integer codigoEnderecoPessoa) {
		this.codigoEnderecoPessoa = codigoEnderecoPessoa;
	}

}
