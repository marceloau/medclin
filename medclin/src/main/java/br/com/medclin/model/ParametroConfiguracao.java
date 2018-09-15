/*
 * 
 */
package br.com.medclin.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;

/**
 * The Class ParametroConfiguracao.
 * 
 * @author henrique araujo
 */
@Entity
public class ParametroConfiguracao {

	/** The codigo parametro. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigoParametro;

	/** The nome parametro. */
	@NotBlank
	private String nomeParametro;

	/** The nome resumido parametro. */
	@NotBlank
	private String nomeResumidoParametro;

	/** The texto conteudo parametro. */
	@NotBlank
	private String textoConteudoParametro;

	/** The texto descricao parametro. */
	@NotBlank
	private String textoDescricaoParametro;

	@NotBlank
	private String usuarioUltimaAlteracao;

	@NotBlank
	private String flagAtivo;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dataUltimaAlteracao;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dataCriacao;

	public Long getCodigoParametro() {
		return codigoParametro;
	}

	public void setCodigoParametro(Long codigoParametro) {
		this.codigoParametro = codigoParametro;
	}

	public String getNomeParametro() {
		return nomeParametro;
	}

	public void setNomeParametro(String nomeParametro) {
		this.nomeParametro = nomeParametro;
	}

	public String getNomeResumidoParametro() {
		return nomeResumidoParametro;
	}

	public void setNomeResumidoParametro(String nomeResumidoParametro) {
		this.nomeResumidoParametro = nomeResumidoParametro;
	}

	public String getTextoConteudoParametro() {
		return textoConteudoParametro;
	}

	public void setTextoConteudoParametro(String textoConteudoParametro) {
		this.textoConteudoParametro = textoConteudoParametro;
	}

	public String getTextoDescricaoParametro() {
		return textoDescricaoParametro;
	}

	public void setTextoDescricaoParametro(String textoDescricaoParametro) {
		this.textoDescricaoParametro = textoDescricaoParametro;
	}

	public String getUsuarioUltimaAlteracao() {
		return usuarioUltimaAlteracao;
	}

	public void setUsuarioUltimaAlteracao(String usuarioUltimaAlteracao) {
		this.usuarioUltimaAlteracao = usuarioUltimaAlteracao;
	}

	public String getFlagAtivo() {
		return flagAtivo;
	}

	public void setFlagAtivo(String flagAtivo) {
		this.flagAtivo = flagAtivo;
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
		result = prime * result + ((codigoParametro == null) ? 0 : codigoParametro.hashCode());
		result = prime * result + ((dataCriacao == null) ? 0 : dataCriacao.hashCode());
		result = prime * result + ((dataUltimaAlteracao == null) ? 0 : dataUltimaAlteracao.hashCode());
		result = prime * result + ((flagAtivo == null) ? 0 : flagAtivo.hashCode());
		result = prime * result + ((nomeParametro == null) ? 0 : nomeParametro.hashCode());
		result = prime * result + ((nomeResumidoParametro == null) ? 0 : nomeResumidoParametro.hashCode());
		result = prime * result + ((textoConteudoParametro == null) ? 0 : textoConteudoParametro.hashCode());
		result = prime * result + ((textoDescricaoParametro == null) ? 0 : textoDescricaoParametro.hashCode());
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
		ParametroConfiguracao other = (ParametroConfiguracao) obj;
		if (codigoParametro == null) {
			if (other.codigoParametro != null)
				return false;
		} else if (!codigoParametro.equals(other.codigoParametro))
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
		if (nomeParametro == null) {
			if (other.nomeParametro != null)
				return false;
		} else if (!nomeParametro.equals(other.nomeParametro))
			return false;
		if (nomeResumidoParametro == null) {
			if (other.nomeResumidoParametro != null)
				return false;
		} else if (!nomeResumidoParametro.equals(other.nomeResumidoParametro))
			return false;
		if (textoConteudoParametro == null) {
			if (other.textoConteudoParametro != null)
				return false;
		} else if (!textoConteudoParametro.equals(other.textoConteudoParametro))
			return false;
		if (textoDescricaoParametro == null) {
			if (other.textoDescricaoParametro != null)
				return false;
		} else if (!textoDescricaoParametro.equals(other.textoDescricaoParametro))
			return false;
		if (usuarioUltimaAlteracao == null) {
			if (other.usuarioUltimaAlteracao != null)
				return false;
		} else if (!usuarioUltimaAlteracao.equals(other.usuarioUltimaAlteracao))
			return false;
		return true;
	}

}
