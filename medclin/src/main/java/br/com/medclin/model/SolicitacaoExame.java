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
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class SolicitacaoExame implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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
	
	@XmlTransient
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

}
