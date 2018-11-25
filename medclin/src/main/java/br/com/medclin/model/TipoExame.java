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
@SequenceGenerator(name = "TIPO_EXAME_SEQ", sequenceName = "TIPO_EXAME_SEQ", allocationSize = 1)
public class TipoExame implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TIPO_EXAME_SEQ")
	@Column(name = "codigo_tipo_exame")
	private Short codigoTipoExame;

	@NotBlank
	private String nomeTipoExame;

	private String descricaoTipoExame;

	private String flagAtivo;

	private String usuarioUltimaAlteracao;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dataUltimaAlteracao;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dataCriacao;

	public Short getCodigoTipoExame() {
		return codigoTipoExame;
	}

	public void setCodigoTipoExame(Short codigoTipoExame) {
		this.codigoTipoExame = codigoTipoExame;
	}

	public String getNomeTipoExame() {
		return nomeTipoExame;
	}

	public void setNomeTipoExame(String nomeTipoExame) {
		this.nomeTipoExame = nomeTipoExame;
	}

	public String getDescricaoTipoExame() {
		return descricaoTipoExame;
	}

	public void setDescricaoTipoExame(String descricaoTipoExame) {
		this.descricaoTipoExame = descricaoTipoExame;
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
		result = prime * result + ((codigoTipoExame == null) ? 0 : codigoTipoExame.hashCode());
		result = prime * result + ((dataCriacao == null) ? 0 : dataCriacao.hashCode());
		result = prime * result + ((dataUltimaAlteracao == null) ? 0 : dataUltimaAlteracao.hashCode());
		result = prime * result + ((descricaoTipoExame == null) ? 0 : descricaoTipoExame.hashCode());
		result = prime * result + ((flagAtivo == null) ? 0 : flagAtivo.hashCode());
		result = prime * result + ((nomeTipoExame == null) ? 0 : nomeTipoExame.hashCode());
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
		TipoExame other = (TipoExame) obj;
		if (codigoTipoExame == null) {
			if (other.codigoTipoExame != null)
				return false;
		} else if (!codigoTipoExame.equals(other.codigoTipoExame))
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
		if (descricaoTipoExame == null) {
			if (other.descricaoTipoExame != null)
				return false;
		} else if (!descricaoTipoExame.equals(other.descricaoTipoExame))
			return false;
		if (flagAtivo == null) {
			if (other.flagAtivo != null)
				return false;
		} else if (!flagAtivo.equals(other.flagAtivo))
			return false;
		if (nomeTipoExame == null) {
			if (other.nomeTipoExame != null)
				return false;
		} else if (!nomeTipoExame.equals(other.nomeTipoExame))
			return false;
		if (usuarioUltimaAlteracao == null) {
			if (other.usuarioUltimaAlteracao != null)
				return false;
		} else if (!usuarioUltimaAlteracao.equals(other.usuarioUltimaAlteracao))
			return false;
		return true;
	}

}
