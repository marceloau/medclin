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
public class TipoContato implements Serializable {

	private static final long SerialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codigo_tipo_contato")
	private Short codigoTipoContato;

	@NotBlank
	private String nomeTipoContato;

	private String descricaoTipoContato;

	private String flagAtivo;

	private String usuarioUltimaAlteracao;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dataUltimaAlteracao;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dataCriacao;

	public Short getCodigoTipoContato() {
		return codigoTipoContato;
	}

	public void setCodigoTipoContato(Short codigoTipoContato) {
		this.codigoTipoContato = codigoTipoContato;
	}

	public String getNomeTipoContato() {
		return nomeTipoContato;
	}

	public void setNomeTipoContato(String nomeTipoContato) {
		this.nomeTipoContato = nomeTipoContato;
	}

	public String getDescricaoTipoContato() {
		return descricaoTipoContato;
	}

	public void setDescricaoTipoContato(String descricaoTipoContato) {
		this.descricaoTipoContato = descricaoTipoContato;
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
		result = prime * result + ((codigoTipoContato == null) ? 0 : codigoTipoContato.hashCode());
		result = prime * result + ((dataCriacao == null) ? 0 : dataCriacao.hashCode());
		result = prime * result + ((dataUltimaAlteracao == null) ? 0 : dataUltimaAlteracao.hashCode());
		result = prime * result + ((descricaoTipoContato == null) ? 0 : descricaoTipoContato.hashCode());
		result = prime * result + ((flagAtivo == null) ? 0 : flagAtivo.hashCode());
		result = prime * result + ((nomeTipoContato == null) ? 0 : nomeTipoContato.hashCode());
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
		TipoContato other = (TipoContato) obj;
		if (codigoTipoContato == null) {
			if (other.codigoTipoContato != null)
				return false;
		} else if (!codigoTipoContato.equals(other.codigoTipoContato))
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
		if (descricaoTipoContato == null) {
			if (other.descricaoTipoContato != null)
				return false;
		} else if (!descricaoTipoContato.equals(other.descricaoTipoContato))
			return false;
		if (flagAtivo == null) {
			if (other.flagAtivo != null)
				return false;
		} else if (!flagAtivo.equals(other.flagAtivo))
			return false;
		if (nomeTipoContato == null) {
			if (other.nomeTipoContato != null)
				return false;
		} else if (!nomeTipoContato.equals(other.nomeTipoContato))
			return false;
		if (usuarioUltimaAlteracao == null) {
			if (other.usuarioUltimaAlteracao != null)
				return false;
		} else if (!usuarioUltimaAlteracao.equals(other.usuarioUltimaAlteracao))
			return false;
		return true;
	}

}
