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

	/** The usuario ultima alteracao. */
	@NotBlank
	private String usuarioUltimaAlteracao;

	/** The data ultima alteracao. */
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataUltimaAlteracao;

	/**
	 * Gets the codigo parametro.
	 *
	 * @return the codigo parametro
	 */
	public Long getCodigoParametro() {
		return codigoParametro;
	}

	/**
	 * Sets the codigo parametro.
	 *
	 * @param codigoParametro the new codigo parametro
	 */
	public void setCodigoParametro(Long codigoParametro) {
		this.codigoParametro = codigoParametro;
	}

	/**
	 * Gets the nome parametro.
	 *
	 * @return the nome parametro
	 */
	public String getNomeParametro() {
		return nomeParametro;
	}

	/**
	 * Sets the nome parametro.
	 *
	 * @param nomeParametro the new nome parametro
	 */
	public void setNomeParametro(String nomeParametro) {
		this.nomeParametro = nomeParametro;
	}

	/**
	 * Gets the nome resumido parametro.
	 *
	 * @return the nome resumido parametro
	 */
	public String getNomeResumidoParametro() {
		return nomeResumidoParametro;
	}

	/**
	 * Sets the nome resumido parametro.
	 *
	 * @param nomeResumidoParametro the new nome resumido parametro
	 */
	public void setNomeResumidoParametro(String nomeResumidoParametro) {
		this.nomeResumidoParametro = nomeResumidoParametro;
	}

	/**
	 * Gets the texto conteudo parametro.
	 *
	 * @return the texto conteudo parametro
	 */
	public String getTextoConteudoParametro() {
		return textoConteudoParametro;
	}

	/**
	 * Sets the texto conteudo parametro.
	 *
	 * @param textoConteudoParametro the new texto conteudo parametro
	 */
	public void setTextoConteudoParametro(String textoConteudoParametro) {
		this.textoConteudoParametro = textoConteudoParametro;
	}

	/**
	 * Gets the texto descricao parametro.
	 *
	 * @return the texto descricao parametro
	 */
	public String getTextoDescricaoParametro() {
		return textoDescricaoParametro;
	}

	/**
	 * Sets the texto descricao parametro.
	 *
	 * @param textoDescricaoParametro the new texto descricao parametro
	 */
	public void setTextoDescricaoParametro(String textoDescricaoParametro) {
		this.textoDescricaoParametro = textoDescricaoParametro;
	}

	/**
	 * Gets the usuario ultima alteracao.
	 *
	 * @return the usuario ultima alteracao
	 */
	public String getUsuarioUltimaAlteracao() {
		return usuarioUltimaAlteracao;
	}

	/**
	 * Sets the usuario ultima alteracao.
	 *
	 * @param usuarioUltimaAlteracao the new usuario ultima alteracao
	 */
	public void setUsuarioUltimaAlteracao(String usuarioUltimaAlteracao) {
		this.usuarioUltimaAlteracao = usuarioUltimaAlteracao;
	}

	/**
	 * Gets the data ultima alteracao.
	 *
	 * @return the data ultima alteracao
	 */
	public Date getDataUltimaAlteracao() {
		return dataUltimaAlteracao;
	}

	/**
	 * Sets the data ultima alteracao.
	 *
	 * @param dataUltimaAlteracao the new data ultima alteracao
	 */
	public void setDataUltimaAlteracao(Date dataUltimaAlteracao) {
		this.dataUltimaAlteracao = dataUltimaAlteracao;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigoParametro == null) ? 0 : codigoParametro.hashCode());
		result = prime * result + ((dataUltimaAlteracao == null) ? 0 : dataUltimaAlteracao.hashCode());
		result = prime * result + ((nomeParametro == null) ? 0 : nomeParametro.hashCode());
		result = prime * result + ((nomeResumidoParametro == null) ? 0 : nomeResumidoParametro.hashCode());
		result = prime * result + ((textoConteudoParametro == null) ? 0 : textoConteudoParametro.hashCode());
		result = prime * result + ((textoDescricaoParametro == null) ? 0 : textoDescricaoParametro.hashCode());
		result = prime * result + ((usuarioUltimaAlteracao == null) ? 0 : usuarioUltimaAlteracao.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
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
		if (dataUltimaAlteracao == null) {
			if (other.dataUltimaAlteracao != null)
				return false;
		} else if (!dataUltimaAlteracao.equals(other.dataUltimaAlteracao))
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
