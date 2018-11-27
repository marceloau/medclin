package br.com.medclin.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;

@Entity
public class UsoMedicamento implements Serializable {

	private static final long SerialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codigo_uso_medicamento")
	private Integer codigoUsoMedicamento;

	@NotBlank
	private String nomeUsoMedicamento;

	private String descricaoUsoMedicamento;

	private String flagAtivo;

	private String usuarioUltimaAlteracao;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dataUltimaAlteracao;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dataCriacao;

	public Integer getCodigoUsoMedicamento() {
		return codigoUsoMedicamento;
	}

	public void setCodigoUsoMedicamento(Integer codigoUsoMedicamento) {
		this.codigoUsoMedicamento = codigoUsoMedicamento;
	}

	public String getNomeUsoMedicamento() {
		return nomeUsoMedicamento;
	}

	public void setNomeUsoMedicamento(String nomeUsoMedicamento) {
		this.nomeUsoMedicamento = nomeUsoMedicamento;
	}

	public String getDescricaoUsoMedicamento() {
		return descricaoUsoMedicamento;
	}

	public void setDescricaoUsoMedicamento(String descricaoUsoMedicamento) {
		this.descricaoUsoMedicamento = descricaoUsoMedicamento;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigoUsoMedicamento == null) ? 0 : codigoUsoMedicamento.hashCode());
		result = prime * result + ((dataCriacao == null) ? 0 : dataCriacao.hashCode());
		result = prime * result + ((dataUltimaAlteracao == null) ? 0 : dataUltimaAlteracao.hashCode());
		result = prime * result + ((descricaoUsoMedicamento == null) ? 0 : descricaoUsoMedicamento.hashCode());
		result = prime * result + ((flagAtivo == null) ? 0 : flagAtivo.hashCode());
		result = prime * result + ((nomeUsoMedicamento == null) ? 0 : nomeUsoMedicamento.hashCode());
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
		UsoMedicamento other = (UsoMedicamento) obj;
		if (codigoUsoMedicamento == null) {
			if (other.codigoUsoMedicamento != null)
				return false;
		} else if (!codigoUsoMedicamento.equals(other.codigoUsoMedicamento))
			return false;
		if (dataCriacao == null) {
			if (other.dataCriacao != null)
				return false;
		} else if (!dataCriacao.equals(other.dataCriacao))
			return false;
		if (dataUltimaAlteracao == null) {
			if (other.dataUltimaAlteracao != null)
				return false;
		} else if (!dataUltimaAlteracao.equals(other.dataUltimaAlteracao))
			return false;
		if (descricaoUsoMedicamento == null) {
			if (other.descricaoUsoMedicamento != null)
				return false;
		} else if (!descricaoUsoMedicamento.equals(other.descricaoUsoMedicamento))
			return false;
		if (flagAtivo == null) {
			if (other.flagAtivo != null)
				return false;
		} else if (!flagAtivo.equals(other.flagAtivo))
			return false;
		if (nomeUsoMedicamento == null) {
			if (other.nomeUsoMedicamento != null)
				return false;
		} else if (!nomeUsoMedicamento.equals(other.nomeUsoMedicamento))
			return false;
		if (usuarioUltimaAlteracao == null) {
			if (other.usuarioUltimaAlteracao != null)
				return false;
		} else if (!usuarioUltimaAlteracao.equals(other.usuarioUltimaAlteracao))
			return false;
		return true;
	}

}
