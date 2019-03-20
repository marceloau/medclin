package br.com.medclin.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;

@Entity
@SequenceGenerator(name = "MEDICAMENTO_SEQ", sequenceName = "MEDICAMENTO_SEQ", allocationSize = 1)
public class Medicamento implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MEDICAMENTO_SEQ")
	@Column(name = "codigo_medicamento")
	private Short codigoMedicamento;

	@NotBlank
	private String nomeMedicamento;

	private String descricaoMedicamento;

	private String posologia;

	private String composicao;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codigo_tipo_medicamento")
	private TipoMedicamento tipoMedicamento;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codigo_uso_medicamento")
	private UsoMedicamento usoMedicamento;

	private String flagEspecial;
	
	private String flagAtivo;

	private String usuarioUltimaAlteracao;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dataUltimaAlteracao;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dataCriacao;

	public Short getCodigoMedicamento() {
		return codigoMedicamento;
	}

	public void setCodigoMedicamento(Short codigoMedicamento) {
		this.codigoMedicamento = codigoMedicamento;
	}

	public String getNomeMedicamento() {
		return nomeMedicamento;
	}

	public void setNomeMedicamento(String nomeMedicamento) {
		this.nomeMedicamento = nomeMedicamento;
	}

	public String getDescricaoMedicamento() {
		return descricaoMedicamento;
	}

	public void setDescricaoMedicamento(String descricaoMedicamento) {
		this.descricaoMedicamento = descricaoMedicamento;
	}

	public String getPosologia() {
		return posologia;
	}

	public void setPosologia(String posologia) {
		this.posologia = posologia;
	}

	public String getComposicao() {
		return composicao;
	}

	public void setComposicao(String composicao) {
		this.composicao = composicao;
	}

	public TipoMedicamento getTipoMedicamento() {
		return tipoMedicamento;
	}

	public void setTipoMedicamento(TipoMedicamento tipoMedicamento) {
		this.tipoMedicamento = tipoMedicamento;
	}

	public UsoMedicamento getUsoMedicamento() {
		return usoMedicamento;
	}

	public void setUsoMedicamento(UsoMedicamento usoMedicamento) {
		this.usoMedicamento = usoMedicamento;
	}

	public String getFlagAtivo() {
		return flagAtivo;
	}

	public void setFlagAtivo(String flagAtivo) {
		this.flagAtivo = flagAtivo;
	}
	
	public String getFlagEspecial() {
		return flagEspecial;
	}

	public void setFlagEspecial(String flagEspecial) {
		this.flagEspecial = flagEspecial;
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
		result = prime * result + ((codigoMedicamento == null) ? 0 : codigoMedicamento.hashCode());
		result = prime * result + ((composicao == null) ? 0 : composicao.hashCode());
		result = prime * result + ((dataCriacao == null) ? 0 : dataCriacao.hashCode());
		result = prime * result + ((dataUltimaAlteracao == null) ? 0 : dataUltimaAlteracao.hashCode());
		result = prime * result + ((descricaoMedicamento == null) ? 0 : descricaoMedicamento.hashCode());
		result = prime * result + ((flagAtivo == null) ? 0 : flagAtivo.hashCode());
		result = prime * result + ((nomeMedicamento == null) ? 0 : nomeMedicamento.hashCode());
		result = prime * result + ((posologia == null) ? 0 : posologia.hashCode());
		result = prime * result + ((tipoMedicamento == null) ? 0 : tipoMedicamento.hashCode());
		result = prime * result + ((usoMedicamento == null) ? 0 : usoMedicamento.hashCode());
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
		Medicamento other = (Medicamento) obj;
		if (codigoMedicamento == null) {
			if (other.codigoMedicamento != null)
				return false;
		} else if (!codigoMedicamento.equals(other.codigoMedicamento))
			return false;
		if (composicao == null) {
			if (other.composicao != null)
				return false;
		} else if (!composicao.equals(other.composicao))
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
		if (descricaoMedicamento == null) {
			if (other.descricaoMedicamento != null)
				return false;
		} else if (!descricaoMedicamento.equals(other.descricaoMedicamento))
			return false;
		if (flagAtivo == null) {
			if (other.flagAtivo != null)
				return false;
		} else if (!flagAtivo.equals(other.flagAtivo))
			return false;
		if (nomeMedicamento == null) {
			if (other.nomeMedicamento != null)
				return false;
		} else if (!nomeMedicamento.equals(other.nomeMedicamento))
			return false;
		if (posologia == null) {
			if (other.posologia != null)
				return false;
		} else if (!posologia.equals(other.posologia))
			return false;
		if (tipoMedicamento == null) {
			if (other.tipoMedicamento != null)
				return false;
		} else if (!tipoMedicamento.equals(other.tipoMedicamento))
			return false;
		if (usoMedicamento == null) {
			if (other.usoMedicamento != null)
				return false;
		} else if (!usoMedicamento.equals(other.usoMedicamento))
			return false;
		if (usuarioUltimaAlteracao == null) {
			if (other.usuarioUltimaAlteracao != null)
				return false;
		} else if (!usuarioUltimaAlteracao.equals(other.usuarioUltimaAlteracao))
			return false;
		return true;
	}
}
