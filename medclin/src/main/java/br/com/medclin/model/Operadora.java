package br.com.medclin.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Operadora {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Short codigoOperadora;

	@NotBlank
	private String nomeOperadora;

	private String descricaoOperadora;

	@NotNull
	@Min(value = 1, message = "Atenção, informe o valor do codigo Oficial")
	private Integer codigoOficial;

	private String flagAtivo;

	private String usuarioUltimaAlteracao;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dataUltimaAlteracao;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dataCriacao;

	public Short getCodigoOperadora() {
		return codigoOperadora;
	}

	public void setCodigoOperadora(Short codigoOperadora) {
		this.codigoOperadora = codigoOperadora;
	}

	public String getNomeOperadora() {
		return nomeOperadora;
	}

	public void setNomeOperadora(String nomeOperadora) {
		this.nomeOperadora = nomeOperadora;
	}

	public String getDescricaoOperadora() {
		return descricaoOperadora;
	}

	public void setDescricaoOperadora(String descricaoOperadora) {
		this.descricaoOperadora = descricaoOperadora;
	}

	public Integer getCodigoOficial() {
		return codigoOficial;
	}

	public void setCodigoOficial(Integer codigoOficial) {
		this.codigoOficial = codigoOficial;
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
		result = prime * result + ((codigoOficial == null) ? 0 : codigoOficial.hashCode());
		result = prime * result + ((codigoOperadora == null) ? 0 : codigoOperadora.hashCode());
		result = prime * result + ((dataCriacao == null) ? 0 : dataCriacao.hashCode());
		result = prime * result + ((dataUltimaAlteracao == null) ? 0 : dataUltimaAlteracao.hashCode());
		result = prime * result + ((descricaoOperadora == null) ? 0 : descricaoOperadora.hashCode());
		result = prime * result + ((flagAtivo == null) ? 0 : flagAtivo.hashCode());
		result = prime * result + ((nomeOperadora == null) ? 0 : nomeOperadora.hashCode());
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
		Operadora other = (Operadora) obj;
		if (codigoOficial == null) {
			if (other.codigoOficial != null)
				return false;
		} else if (!codigoOficial.equals(other.codigoOficial))
			return false;
		if (codigoOperadora == null) {
			if (other.codigoOperadora != null)
				return false;
		} else if (!codigoOperadora.equals(other.codigoOperadora))
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
		if (descricaoOperadora == null) {
			if (other.descricaoOperadora != null)
				return false;
		} else if (!descricaoOperadora.equals(other.descricaoOperadora))
			return false;
		if (flagAtivo == null) {
			if (other.flagAtivo != null)
				return false;
		} else if (!flagAtivo.equals(other.flagAtivo))
			return false;
		if (nomeOperadora == null) {
			if (other.nomeOperadora != null)
				return false;
		} else if (!nomeOperadora.equals(other.nomeOperadora))
			return false;
		if (usuarioUltimaAlteracao == null) {
			if (other.usuarioUltimaAlteracao != null)
				return false;
		} else if (!usuarioUltimaAlteracao.equals(other.usuarioUltimaAlteracao))
			return false;
		return true;
	}

}
