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
public class SolicitacaoMedicamento implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private SolicitacaoMedicamentoPK solicitacaoMedicamentoPK;

	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss zzzz", timezone = "GMT-03:00")
	private Date dataSolicitacaoMedicamento;

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
	@JoinColumn(name = "codigo_medicamento", referencedColumnName = "codigo_medicamento", insertable = true, updatable = true)
	private Medicamento medicamento;

	public SolicitacaoMedicamentoPK getSolicitacaoMedicamentoPK() {
		return solicitacaoMedicamentoPK;
	}

	public void setSolicitacaoMedicamentoPK(SolicitacaoMedicamentoPK solicitacaoMedicamentoPK) {
		this.solicitacaoMedicamentoPK = solicitacaoMedicamentoPK;
	}

	public Date getDataSolicitacaoMedicamento() {
		return dataSolicitacaoMedicamento;
	}

	public void setDataSolicitacaoMedicamento(Date dataSolicitacaoMedicamento) {
		this.dataSolicitacaoMedicamento = dataSolicitacaoMedicamento;
	}

	public String getFlagAtivo() {
		return flagAtivo;
	}

	public void setFlagAtivo(String flagAtivo) {
		this.flagAtivo = flagAtivo;
	}

	public String string() {
		return usuarioUltimaAlteracao;
	}

	public void setUsuarioUltimaAlteracao(String usuarioUltimaAlteracao) {
		this.usuarioUltimaAlteracao = usuarioUltimaAlteracao;
	}

	public String getUsuarioUltimaAlteracao() {
		return usuarioUltimaAlteracao;
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

	public Medicamento getMedicamento() {
		return medicamento;
	}

	public void setMedicamento(Medicamento medicamento) {
		this.medicamento = medicamento;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((consulta == null) ? 0 : consulta.hashCode());
		result = prime * result + ((dataCriacao == null) ? 0 : dataCriacao.hashCode());
		result = prime * result + ((dataSolicitacaoMedicamento == null) ? 0 : dataSolicitacaoMedicamento.hashCode());
		result = prime * result + ((dataUltimaAlteracao == null) ? 0 : dataUltimaAlteracao.hashCode());
		result = prime * result + ((medicamento == null) ? 0 : medicamento.hashCode());
		result = prime * result + ((flagAtivo == null) ? 0 : flagAtivo.hashCode());
		result = prime * result + ((solicitacaoMedicamentoPK == null) ? 0 : solicitacaoMedicamentoPK.hashCode());
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
		SolicitacaoMedicamento other = (SolicitacaoMedicamento) obj;
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
		if (dataSolicitacaoMedicamento == null) {
			if (other.dataSolicitacaoMedicamento != null)
				return false;
		} else if (!dataSolicitacaoMedicamento.equals(other.dataSolicitacaoMedicamento))
			return false;
		if (dataUltimaAlteracao == null) {
			if (other.dataUltimaAlteracao != null)
				return false;
		} else if (!dataUltimaAlteracao.equals(other.dataUltimaAlteracao))
			return false;
		if (medicamento == null) {
			if (other.medicamento != null)
				return false;
		} else if (!medicamento.equals(other.medicamento))
			return false;
		if (flagAtivo == null) {
			if (other.flagAtivo != null)
				return false;
		} else if (!flagAtivo.equals(other.flagAtivo))
			return false;
		if (solicitacaoMedicamentoPK == null) {
			if (other.solicitacaoMedicamentoPK != null)
				return false;
		} else if (!solicitacaoMedicamentoPK.equals(other.solicitacaoMedicamentoPK))
			return false;
		if (usuarioUltimaAlteracao == null) {
			if (other.usuarioUltimaAlteracao != null)
				return false;
		} else if (!usuarioUltimaAlteracao.equals(other.usuarioUltimaAlteracao))
			return false;
		return true;
	}

}
