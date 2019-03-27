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
public class FormularioImpressao implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigoFormularioImpressao;

	@NotBlank
	private String nomeFormulario;
	
	@NotBlank
	private String nomeJasper;
	
	@Column(nullable = false, length = 100)
	private String descricaoFormulario;

	@NotBlank
	private String caminhoFormulario;

	private String flagAtivo;

	private String usuarioUltimaAlteracao;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dataUltimaAlteracao;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dataCriacao;

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

	public Integer getCodigoFormularioImpressao() {
		return codigoFormularioImpressao;
	}

	public void setCodigoFormularioImpressao(Integer codigoFormularioImpressao) {
		this.codigoFormularioImpressao = codigoFormularioImpressao;
	}

	public String getNomeFormulario() {
		return nomeFormulario;
	}

	public void setNomeFormulario(String nomeFormulario) {
		this.nomeFormulario = nomeFormulario;
	}

	public String getNomeJasper() {
		return nomeJasper;
	}

	public void setNomeJasper(String nomeJasper) {
		this.nomeJasper = nomeJasper;
	}

	public String getDescricaoFormulario() {
		return descricaoFormulario;
	}

	public void setDescricaoFormulario(String descricaoFormulario) {
		this.descricaoFormulario = descricaoFormulario;
	}

	public String getCaminhoFormulario() {
		return caminhoFormulario;
	}

	public void setCaminhoFormulario(String caminhoFormulario) {
		this.caminhoFormulario = caminhoFormulario;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((caminhoFormulario == null) ? 0 : caminhoFormulario.hashCode());
		result = prime * result + ((codigoFormularioImpressao == null) ? 0 : codigoFormularioImpressao.hashCode());
		result = prime * result + ((dataCriacao == null) ? 0 : dataCriacao.hashCode());
		result = prime * result + ((dataUltimaAlteracao == null) ? 0 : dataUltimaAlteracao.hashCode());
		result = prime * result + ((descricaoFormulario == null) ? 0 : descricaoFormulario.hashCode());
		result = prime * result + ((flagAtivo == null) ? 0 : flagAtivo.hashCode());
		result = prime * result + ((nomeFormulario == null) ? 0 : nomeFormulario.hashCode());
		result = prime * result + ((nomeJasper == null) ? 0 : nomeJasper.hashCode());
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
		FormularioImpressao other = (FormularioImpressao) obj;
		if (caminhoFormulario == null) {
			if (other.caminhoFormulario != null)
				return false;
		} else if (!caminhoFormulario.equals(other.caminhoFormulario))
			return false;
		if (codigoFormularioImpressao == null) {
			if (other.codigoFormularioImpressao != null)
				return false;
		} else if (!codigoFormularioImpressao.equals(other.codigoFormularioImpressao))
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
		if (descricaoFormulario == null) {
			if (other.descricaoFormulario != null)
				return false;
		} else if (!descricaoFormulario.equals(other.descricaoFormulario))
			return false;
		if (flagAtivo == null) {
			if (other.flagAtivo != null)
				return false;
		} else if (!flagAtivo.equals(other.flagAtivo))
			return false;
		if (nomeFormulario == null) {
			if (other.nomeFormulario != null)
				return false;
		} else if (!nomeFormulario.equals(other.nomeFormulario))
			return false;
		if (nomeJasper == null) {
			if (other.nomeJasper != null)
				return false;
		} else if (!nomeJasper.equals(other.nomeJasper))
			return false;
		if (usuarioUltimaAlteracao == null) {
			if (other.usuarioUltimaAlteracao != null)
				return false;
		} else if (!usuarioUltimaAlteracao.equals(other.usuarioUltimaAlteracao))
			return false;
		return true;
	}
}
