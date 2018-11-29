package br.com.medclin.model;

import java.io.Serializable;
import java.math.BigInteger;

import javax.persistence.Column;

public class SolicitacaoMedicamentoPK implements Serializable {

	private static final long SerialVersionUID = 1L;

	@Column(name = "codigo_consulta", nullable = false, updatable = false, precision = 22, scale = 0)
	private BigInteger codigoConsulta;

	@Column(name = "codigo_solicitacao_medicamento")
	private Short codigoSolicitacaoMedicamento;

	public BigInteger getCodigoConsulta() {
		return codigoConsulta;
	}

	public void setCodigoConsulta(BigInteger codigoConsulta) {
		this.codigoConsulta = codigoConsulta;
	}

	public Short getCodigoSolicitacaoMedicamento() {
		return codigoSolicitacaoMedicamento;
	}

	public void setCodigoSolicitacaoMedicamento(Short codigoSolicitacaoMedicamento) {
		this.codigoSolicitacaoMedicamento = codigoSolicitacaoMedicamento;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigoConsulta == null) ? 0 : codigoConsulta.hashCode());
		result = prime * result
				+ ((codigoSolicitacaoMedicamento == null) ? 0 : codigoSolicitacaoMedicamento.hashCode());
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
		SolicitacaoMedicamentoPK other = (SolicitacaoMedicamentoPK) obj;
		if (codigoConsulta == null) {
			if (other.codigoConsulta != null)
				return false;
		} else if (!codigoConsulta.equals(other.codigoConsulta))
			return false;
		if (codigoSolicitacaoMedicamento == null) {
			if (other.codigoSolicitacaoMedicamento != null)
				return false;
		} else if (!codigoSolicitacaoMedicamento.equals(other.codigoSolicitacaoMedicamento))
			return false;
		return true;
	}

}
