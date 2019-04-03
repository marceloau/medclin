package br.com.medclin.model;

import java.io.Serializable;
import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class AgendaMedicoPK implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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
}