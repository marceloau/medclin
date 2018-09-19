package br.com.medclin.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Endereco {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codigo_endereco")
	private Integer codigoEndereco;

	private String nomeBairro;

	private Integer numeroCep;

	private String nomeCidade;

	private String nomeLogradouro;

	private Integer numeroLogradouro;

	private String complemento;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(foreignKey = @ForeignKey(name = "codigo_tipo_logradouro"), name = "codigo_tipo_logradouro", nullable = false)
	private TipoLogradouro tipoLogradouro;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(foreignKey = @ForeignKey(name = "codigo_estado"), name = "codigo_estado", nullable = false)
	private Estado estado;

	private String flagAtivo;

	private String usuarioUltimaAlteracao;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dataUltimaAlteracao;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dataCriacao;

	public Integer getCodigoEndereco() {
		return codigoEndereco;
	}

	public void setCodigoEndereco(Integer codigoEndereco) {
		this.codigoEndereco = codigoEndereco;
	}

	public String getNomeBairro() {
		return nomeBairro;
	}

	public void setNomeBairro(String nomeBairro) {
		this.nomeBairro = nomeBairro;
	}

	public Integer getNumeroCep() {
		return numeroCep;
	}

	public void setNumeroCep(Integer numeroCep) {
		this.numeroCep = numeroCep;
	}

	public String getNomeCidade() {
		return nomeCidade;
	}

	public void setNomeCidade(String nomeCidade) {
		this.nomeCidade = nomeCidade;
	}

	public String getNomeLogradouro() {
		return nomeLogradouro;
	}

	public void setNomeLogradouro(String nomeLogradouro) {
		this.nomeLogradouro = nomeLogradouro;
	}

	public Integer getNumeroLogradouro() {
		return numeroLogradouro;
	}

	public void setNumeroLogradouro(Integer numeroLogradouro) {
		this.numeroLogradouro = numeroLogradouro;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public TipoLogradouro getTipoLogradouro() {
		return tipoLogradouro;
	}

	public void setTipoLogradouro(TipoLogradouro tipoLogradouro) {
		this.tipoLogradouro = tipoLogradouro;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
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
		result = prime * result + ((codigoEndereco == null) ? 0 : codigoEndereco.hashCode());
		result = prime * result + ((complemento == null) ? 0 : complemento.hashCode());
		result = prime * result + ((dataCriacao == null) ? 0 : dataCriacao.hashCode());
		result = prime * result + ((dataUltimaAlteracao == null) ? 0 : dataUltimaAlteracao.hashCode());
		result = prime * result + ((estado == null) ? 0 : estado.hashCode());
		result = prime * result + ((flagAtivo == null) ? 0 : flagAtivo.hashCode());
		result = prime * result + ((nomeBairro == null) ? 0 : nomeBairro.hashCode());
		result = prime * result + ((nomeCidade == null) ? 0 : nomeCidade.hashCode());
		result = prime * result + ((nomeLogradouro == null) ? 0 : nomeLogradouro.hashCode());
		result = prime * result + ((numeroCep == null) ? 0 : numeroCep.hashCode());
		result = prime * result + ((numeroLogradouro == null) ? 0 : numeroLogradouro.hashCode());
		result = prime * result + ((tipoLogradouro == null) ? 0 : tipoLogradouro.hashCode());
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
		Endereco other = (Endereco) obj;
		if (codigoEndereco == null) {
			if (other.codigoEndereco != null)
				return false;
		} else if (!codigoEndereco.equals(other.codigoEndereco))
			return false;
		if (complemento == null) {
			if (other.complemento != null)
				return false;
		} else if (!complemento.equals(other.complemento))
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
		if (estado == null) {
			if (other.estado != null)
				return false;
		} else if (!estado.equals(other.estado))
			return false;
		if (flagAtivo == null) {
			if (other.flagAtivo != null)
				return false;
		} else if (!flagAtivo.equals(other.flagAtivo))
			return false;
		if (nomeBairro == null) {
			if (other.nomeBairro != null)
				return false;
		} else if (!nomeBairro.equals(other.nomeBairro))
			return false;
		if (nomeCidade == null) {
			if (other.nomeCidade != null)
				return false;
		} else if (!nomeCidade.equals(other.nomeCidade))
			return false;
		if (nomeLogradouro == null) {
			if (other.nomeLogradouro != null)
				return false;
		} else if (!nomeLogradouro.equals(other.nomeLogradouro))
			return false;
		if (numeroCep == null) {
			if (other.numeroCep != null)
				return false;
		} else if (!numeroCep.equals(other.numeroCep))
			return false;
		if (numeroLogradouro == null) {
			if (other.numeroLogradouro != null)
				return false;
		} else if (!numeroLogradouro.equals(other.numeroLogradouro))
			return false;
		if (tipoLogradouro == null) {
			if (other.tipoLogradouro != null)
				return false;
		} else if (!tipoLogradouro.equals(other.tipoLogradouro))
			return false;
		if (usuarioUltimaAlteracao == null) {
			if (other.usuarioUltimaAlteracao != null)
				return false;
		} else if (!usuarioUltimaAlteracao.equals(other.usuarioUltimaAlteracao))
			return false;
		return true;
	}

}
