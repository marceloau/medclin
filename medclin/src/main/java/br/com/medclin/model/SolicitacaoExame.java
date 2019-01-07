package br.com.medclin.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class SolicitacaoExame implements Serializable {

	private static final long SerialVersionUID = 1L;

	@EmbeddedId
	private SolicitacaoExamePK solicitacaoExamePK;

	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss zzzz", timezone = "GMT-03:00")
	private Date dataSolicitacaoExame;

	private String flagAtivo;

	private String usuarioUltimaAlteracao;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dataUltimaAlteracao;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dataCriacao;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codigo_consulta", referencedColumnName = "codigo_consulta", insertable = false, updatable = false)
	private Consulta consulta;

	@ManyToOne
	@JoinColumn(name = "codigo_exame", referencedColumnName = "codigo_exame", insertable = true, updatable = true)
	private Exame exame;

	public SolicitacaoExamePK getSolicitacaoExamePK() {
		return solicitacaoExamePK;
	}

	public void setSolicitacaoExamePK(SolicitacaoExamePK solicitacaoExamePK) {
		this.solicitacaoExamePK = solicitacaoExamePK;
	}

	public Date getDataSolicitacaoExame() {
		return dataSolicitacaoExame;
	}

	public void setDataSolicitacaoExame(Date dataSolicitacaoExame) {
		this.dataSolicitacaoExame = dataSolicitacaoExame;
	}

	public String getFlagAtivo() {
		return flagAtivo;
	}

	public void setFlagAtivo(String flagAtivo) {
		this.flagAtivo = flagAtivo;
	}

	public String getUsuarioUltimaAlteracao() {
		return usuarioUltimaAlteracao;
	}

	public void setUsuarioUltimaAlteracao(String usuarioUltimaAlteracao) {
		this.usuarioUltimaAlteracao = usuarioUltimaAlteracao;
	}

	public Date getDataUltimaAlteracao() {
		return dataUltimaAlteracao;
	}

	public void setDataUltimaAlteracao(Date dataUltimaAlteracao) {
		this.dataUltimaAlteracao = dataUltimaAlteracao;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public Consulta getConsulta() {
		return consulta;
	}

	public void setConsulta(Consulta consulta) {
		this.consulta = consulta;
	}

	public Exame getExame() {
		return exame;
	}

	public void setExame(Exame exame) {
		this.exame = exame;
	}

	public static long getSerialversionuid() {
		return SerialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((consulta == null) ? 0 : consulta.hashCode());
		result = prime * result + ((dataCriacao == null) ? 0 : dataCriacao.hashCode());
		result = prime * result + ((dataSolicitacaoExame == null) ? 0 : dataSolicitacaoExame.hashCode());
		result = prime * result + ((dataUltimaAlteracao == null) ? 0 : dataUltimaAlteracao.hashCode());
		result = prime * result + ((exame == null) ? 0 : exame.hashCode());
		result = prime * result + ((flagAtivo == null) ? 0 : flagAtivo.hashCode());
		result = prime * result + ((solicitacaoExamePK == null) ? 0 : solicitacaoExamePK.hashCode());
		result = prime * result + ((usuarioUltimaAlteracao == null) ? 0 : usuarioUltimaAlteracao.hashCode());
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
		SolicitacaoExame other = (SolicitacaoExame) obj;
		if (consulta == null) {
			if (other.consulta != null)
				return false;
		} else if (!consulta.equals(other.consulta))
			return false;
		if (dataCriacao == null) {
			if (other.dataCriacao != null)
				return false;
		} else if (!dataCriacao.equals(other.dataCriacao))
			return false;
		if (dataSolicitacaoExame == null) {
			if (other.dataSolicitacaoExame != null)
				return false;
		} else if (!dataSolicitacaoExame.equals(other.dataSolicitacaoExame))
			return false;
		if (dataUltimaAlteracao == null) {
			if (other.dataUltimaAlteracao != null)
				return false;
		} else if (!dataUltimaAlteracao.equals(other.dataUltimaAlteracao))
			return false;
		if (exame == null) {
			if (other.exame != null)
				return false;
		} else if (!exame.equals(other.exame))
			return false;
		if (flagAtivo == null) {
			if (other.flagAtivo != null)
				return false;
		} else if (!flagAtivo.equals(other.flagAtivo))
			return false;
		if (solicitacaoExamePK == null) {
			if (other.solicitacaoExamePK != null)
				return false;
		} else if (!solicitacaoExamePK.equals(other.solicitacaoExamePK))
			return false;
		if (usuarioUltimaAlteracao == null) {
			if (other.usuarioUltimaAlteracao != null)
				return false;
		} else if (!usuarioUltimaAlteracao.equals(other.usuarioUltimaAlteracao))
			return false;
		return true;
	}

}
