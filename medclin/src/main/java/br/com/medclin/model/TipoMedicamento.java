package br.com.medclin.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;

@Entity
@SequenceGenerator(name = "TIPO_MEDICAMENTO_SEQ", sequenceName = "TIPO_MEDICAMENTO_SEQ", allocationSize = 1)
public class TipoMedicamento implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TIPO_MEDICAMENTO_SEQ")
	@Column(name = "codigo_tipo_medicamento")
	private Short codigoTipoMedicamento;

	@NotBlank
	private String nomeTipoMedicamento;

	private String descricaoTipoMedicamento;

	private String flagAtivo;

	private String usuarioUltimaAlteracao;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dataUltimaAlteracao;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dataCriacao;

	public Short getCodigoTipoMedicamento() {
		return codigoTipoMedicamento;
	}

	public void setCodigoTipoMedicamento(Short codigoTipoMedicamento) {
		this.codigoTipoMedicamento = codigoTipoMedicamento;
	}

	public String getNomeTipoMedicamento() {
		return nomeTipoMedicamento;
	}

	public void setNomeTipoMedicamento(String nomeTipoMedicamento) {
		this.nomeTipoMedicamento = nomeTipoMedicamento;
	}

	public String getDescricaoTipoMedicamento() {
		return descricaoTipoMedicamento;
	}

	public void setDescricaoTipoMedicamento(String descricaoTipoMedicamento) {
		this.descricaoTipoMedicamento = descricaoTipoMedicamento;
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
		result = prime * result + ((codigoTipoMedicamento == null) ? 0 : codigoTipoMedicamento.hashCode());
		result = prime * result + ((dataCriacao == null) ? 0 : dataCriacao.hashCode());
		result = prime * result + ((dataUltimaAlteracao == null) ? 0 : dataUltimaAlteracao.hashCode());
		result = prime * result + ((descricaoTipoMedicamento == null) ? 0 : descricaoTipoMedicamento.hashCode());
		result = prime * result + ((flagAtivo == null) ? 0 : flagAtivo.hashCode());
		result = prime * result + ((nomeTipoMedicamento == null) ? 0 : nomeTipoMedicamento.hashCode());
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
		TipoMedicamento other = (TipoMedicamento) obj;
		if (codigoTipoMedicamento == null) {
			if (other.codigoTipoMedicamento != null)
				return false;
		} else if (!codigoTipoMedicamento.equals(other.codigoTipoMedicamento))
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
		if (descricaoTipoMedicamento == null) {
			if (other.descricaoTipoMedicamento != null)
				return false;
		} else if (!descricaoTipoMedicamento.equals(other.descricaoTipoMedicamento))
			return false;
		if (flagAtivo == null) {
			if (other.flagAtivo != null)
				return false;
		} else if (!flagAtivo.equals(other.flagAtivo))
			return false;
		if (nomeTipoMedicamento == null) {
			if (other.nomeTipoMedicamento != null)
				return false;
		} else if (!nomeTipoMedicamento.equals(other.nomeTipoMedicamento))
			return false;
		if (usuarioUltimaAlteracao == null) {
			if (other.usuarioUltimaAlteracao != null)
				return false;
		} else if (!usuarioUltimaAlteracao.equals(other.usuarioUltimaAlteracao))
			return false;
		return true;
	}

}
