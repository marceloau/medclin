package br.com.medclin.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;

@Entity
public class Estado {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Byte codigoEstado;

	@NotBlank
	private String nomeCompletoEstado;

	@NotBlank
	private String nomeAbreviadoEstado;

	private String flagAtivo;

	private String usuarioUltimaAlteracao;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dataUltimaAlteracao;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dataCriacao;

	public Byte getCodigoEstado() {
		return codigoEstado;
	}

	public void setCodigoEstado(Byte codigoEstado) {
		this.codigoEstado = codigoEstado;
	}

	public String getNomeCompletoEstado() {
		return nomeCompletoEstado;
	}

	public void setNomeCompletoEstado(String nomeCompletoEstado) {
		this.nomeCompletoEstado = nomeCompletoEstado;
	}

	public String getNomeAbreviadoEstado() {
		return nomeAbreviadoEstado;
	}

	public void setNomeAbreviadoEstado(String nomeAbreviadoEstado) {
		this.nomeAbreviadoEstado = nomeAbreviadoEstado;
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
		result = prime * result + ((codigoEstado == null) ? 0 : codigoEstado.hashCode());
		result = prime * result + ((dataCriacao == null) ? 0 : dataCriacao.hashCode());
		result = prime * result + ((dataUltimaAlteracao == null) ? 0 : dataUltimaAlteracao.hashCode());
		result = prime * result + ((flagAtivo == null) ? 0 : flagAtivo.hashCode());
		result = prime * result + ((nomeAbreviadoEstado == null) ? 0 : nomeAbreviadoEstado.hashCode());
		result = prime * result + ((nomeCompletoEstado == null) ? 0 : nomeCompletoEstado.hashCode());
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
		Estado other = (Estado) obj;
		if (codigoEstado == null) {
			if (other.codigoEstado != null)
				return false;
		} else if (!codigoEstado.equals(other.codigoEstado))
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
		if (nomeAbreviadoEstado == null) {
			if (other.nomeAbreviadoEstado != null)
				return false;
		} else if (!nomeAbreviadoEstado.equals(other.nomeAbreviadoEstado))
			return false;
		if (nomeCompletoEstado == null) {
			if (other.nomeCompletoEstado != null)
				return false;
		} else if (!nomeCompletoEstado.equals(other.nomeCompletoEstado))
			return false;
		if (usuarioUltimaAlteracao == null) {
			if (other.usuarioUltimaAlteracao != null)
				return false;
		} else if (!usuarioUltimaAlteracao.equals(other.usuarioUltimaAlteracao))
			return false;
		return true;
	}

}
