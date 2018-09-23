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
public class TipoPlanoSaude implements Serializable {

	private static final long SerialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codigo_tipo_plano")
	private Short codigoTipoPlano;

	@NotBlank(message = "O nome do tipo plano é obrigatório.")
	private String nomeTipoPlano;

	private String descricaoTipoPlano;

	private String flagAtivo;

	private String usuarioUltimaAlteracao;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dataUltimaAlteracao;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dataCriacao;

	public Short getCodigoTipoPlano() {
		return codigoTipoPlano;
	}

	public void setCodigoTipoPlano(Short codigoTipoPlano) {
		this.codigoTipoPlano = codigoTipoPlano;
	}

	public String getNomeTipoPlano() {
		return nomeTipoPlano;
	}

	public void setNomeTipoPlano(String nomeTipoPlano) {
		this.nomeTipoPlano = nomeTipoPlano;
	}

	public String getDescricaoTipoPlano() {
		return descricaoTipoPlano;
	}

	public void setDescricaoTipoPlano(String descricaoTipoPlano) {
		this.descricaoTipoPlano = descricaoTipoPlano;
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
		result = prime * result + ((codigoTipoPlano == null) ? 0 : codigoTipoPlano.hashCode());
		result = prime * result + ((dataCriacao == null) ? 0 : dataCriacao.hashCode());
		result = prime * result + ((dataUltimaAlteracao == null) ? 0 : dataUltimaAlteracao.hashCode());
		result = prime * result + ((descricaoTipoPlano == null) ? 0 : descricaoTipoPlano.hashCode());
		result = prime * result + ((flagAtivo == null) ? 0 : flagAtivo.hashCode());
		result = prime * result + ((nomeTipoPlano == null) ? 0 : nomeTipoPlano.hashCode());
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
		TipoPlanoSaude other = (TipoPlanoSaude) obj;
		if (codigoTipoPlano == null) {
			if (other.codigoTipoPlano != null)
				return false;
		} else if (!codigoTipoPlano.equals(other.codigoTipoPlano))
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
		if (descricaoTipoPlano == null) {
			if (other.descricaoTipoPlano != null)
				return false;
		} else if (!descricaoTipoPlano.equals(other.descricaoTipoPlano))
			return false;
		if (flagAtivo == null) {
			if (other.flagAtivo != null)
				return false;
		} else if (!flagAtivo.equals(other.flagAtivo))
			return false;
		if (nomeTipoPlano == null) {
			if (other.nomeTipoPlano != null)
				return false;
		} else if (!nomeTipoPlano.equals(other.nomeTipoPlano))
			return false;
		if (usuarioUltimaAlteracao == null) {
			if (other.usuarioUltimaAlteracao != null)
				return false;
		} else if (!usuarioUltimaAlteracao.equals(other.usuarioUltimaAlteracao))
			return false;
		return true;
	}

}
