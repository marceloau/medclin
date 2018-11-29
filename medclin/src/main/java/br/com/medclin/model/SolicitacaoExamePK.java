package br.com.medclin.model;

import java.io.Serializable;
import java.math.BigInteger;

import javax.persistence.Column;

public class SolicitacaoExamePK implements Serializable {

	private static final long SerialVersionUID = 1L;

	@Column(name = "codigo_consulta", nullable = false, updatable = false, precision = 22, scale = 0)
	private BigInteger codigoConsulta;

	@Column(name = "codigo_solicitacao_exame")
	private Short codigoSolicitacaoExame;


	public BigInteger getCodigoConsulta() {
		return codigoConsulta;
	}

	public void setCodigoConsulta(BigInteger codigoConsulta) {
		this.codigoConsulta = codigoConsulta;
	}

	public Short getCodigoSolicitacaoExame() {
		return codigoSolicitacaoExame;
	}

	public void setCodigoSolicitacaoExame(Short codigoSolicitacaoExame) {
		this.codigoSolicitacaoExame = codigoSolicitacaoExame;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigoConsulta == null) ? 0 : codigoConsulta.hashCode());
		result = prime * result + ((codigoSolicitacaoExame == null) ? 0 : codigoSolicitacaoExame.hashCode());
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
		SolicitacaoExamePK other = (SolicitacaoExamePK) obj;
		if (codigoConsulta == null) {
			if (other.codigoConsulta != null)
				return false;
		} else if (!codigoConsulta.equals(other.codigoConsulta))
			return false;
		if (codigoSolicitacaoExame == null) {
			if (other.codigoSolicitacaoExame != null)
				return false;
		} else if (!codigoSolicitacaoExame.equals(other.codigoSolicitacaoExame))
			return false;
		return true;
	}

}
