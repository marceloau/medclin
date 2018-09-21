package br.com.medclin.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;

@Entity
public class ContatoPessoa implements Serializable {

	private static final long SerialVersionUID = 1L;

	@EmbeddedId
	private ContatoPessoaPK contatoPessoaPK;

	@NotBlank(message = "O texto contato é obrigatório.")
	private String textoContato;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codigo_tipo_contato")
	private TipoContato tipoContato;

	@ManyToOne
	@JoinColumn(name = "codigo_pessoa", referencedColumnName = "codigo_pessoa", insertable = false, updatable = false)
	private Pessoa pessoa;

	private String flagAtivo;

	private String usuarioUltimaAlteracao;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dataUltimaAlteracao;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dataCriacao;

	public ContatoPessoaPK getContatoPessoaPK() {
		return contatoPessoaPK;
	}

	public void setContatoPessoaPK(ContatoPessoaPK contatoPessoaPK) {
		this.contatoPessoaPK = contatoPessoaPK;
	}

	public String getTextoContato() {
		return textoContato;
	}

	public void setTextoContato(String textoContato) {
		this.textoContato = textoContato;
	}

	public TipoContato getTipoContato() {
		return tipoContato;
	}

	public void setTipoContato(TipoContato tipoContato) {
		this.tipoContato = tipoContato;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
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
		result = prime * result + ((contatoPessoaPK == null) ? 0 : contatoPessoaPK.hashCode());
		result = prime * result + ((dataCriacao == null) ? 0 : dataCriacao.hashCode());
		result = prime * result + ((dataUltimaAlteracao == null) ? 0 : dataUltimaAlteracao.hashCode());
		result = prime * result + ((flagAtivo == null) ? 0 : flagAtivo.hashCode());
		result = prime * result + ((pessoa == null) ? 0 : pessoa.hashCode());
		result = prime * result + ((textoContato == null) ? 0 : textoContato.hashCode());
		result = prime * result + ((tipoContato == null) ? 0 : tipoContato.hashCode());
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
		ContatoPessoa other = (ContatoPessoa) obj;
		if (contatoPessoaPK == null) {
			if (other.contatoPessoaPK != null)
				return false;
		} else if (!contatoPessoaPK.equals(other.contatoPessoaPK))
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
		if (pessoa == null) {
			if (other.pessoa != null)
				return false;
		} else if (!pessoa.equals(other.pessoa))
			return false;
		if (textoContato == null) {
			if (other.textoContato != null)
				return false;
		} else if (!textoContato.equals(other.textoContato))
			return false;
		if (tipoContato == null) {
			if (other.tipoContato != null)
				return false;
		} else if (!tipoContato.equals(other.tipoContato))
			return false;
		if (usuarioUltimaAlteracao == null) {
			if (other.usuarioUltimaAlteracao != null)
				return false;
		} else if (!usuarioUltimaAlteracao.equals(other.usuarioUltimaAlteracao))
			return false;
		return true;
	}

}
