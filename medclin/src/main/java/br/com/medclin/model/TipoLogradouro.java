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
public class TipoLogradouro implements Serializable {

	private static final long SerialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codigo_tipo_logradouro")
	private Byte codigoTipoLogradouro;

	@NotBlank
	private String nomeTipoLogradouro;

	private String flagAtivo;

	private String usuarioUltimaAlteracao;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dataUltimaAlteracao;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dataCriacao;

	public Byte getCodigoTipoLogradouro() {
		return codigoTipoLogradouro;
	}

	public void setCodigoTipoLogradouro(Byte codigoTipoLogradouro) {
		this.codigoTipoLogradouro = codigoTipoLogradouro;
	}

	public String getNomeTipoLogradouro() {
		return nomeTipoLogradouro;
	}

	public void setNomeTipoLogradouro(String nomeTipoLogradouro) {
		this.nomeTipoLogradouro = nomeTipoLogradouro;
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
		result = prime * result + ((codigoTipoLogradouro == null) ? 0 : codigoTipoLogradouro.hashCode());
		result = prime * result + ((dataCriacao == null) ? 0 : dataCriacao.hashCode());
		result = prime * result + ((dataUltimaAlteracao == null) ? 0 : dataUltimaAlteracao.hashCode());
		result = prime * result + ((flagAtivo == null) ? 0 : flagAtivo.hashCode());
		result = prime * result + ((nomeTipoLogradouro == null) ? 0 : nomeTipoLogradouro.hashCode());
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
		TipoLogradouro other = (TipoLogradouro) obj;
		if (codigoTipoLogradouro == null) {
			if (other.codigoTipoLogradouro != null)
				return false;
		} else if (!codigoTipoLogradouro.equals(other.codigoTipoLogradouro))
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
		if (flagAtivo == null) {
			if (other.flagAtivo != null)
				return false;
		} else if (!flagAtivo.equals(other.flagAtivo))
			return false;
		if (nomeTipoLogradouro == null) {
			if (other.nomeTipoLogradouro != null)
				return false;
		} else if (!nomeTipoLogradouro.equals(other.nomeTipoLogradouro))
			return false;
		if (usuarioUltimaAlteracao == null) {
			if (other.usuarioUltimaAlteracao != null)
				return false;
		} else if (!usuarioUltimaAlteracao.equals(other.usuarioUltimaAlteracao))
			return false;
		return true;
	}

}
