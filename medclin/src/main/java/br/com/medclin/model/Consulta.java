package br.com.medclin.model;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@SequenceGenerator(name = "CONSULTA_SEQ", sequenceName = "CONSULTA_SEQ", allocationSize = 1)
public class Consulta implements Serializable {

	private static final long SerialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CONSULTA_SEQ")
	@Column(name = "codigo_consulta", nullable = false, updatable = false, precision = 22, scale = 0)
	private BigInteger codigoConsulta;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codigo_medico", referencedColumnName = "codigo_pessoa", insertable = true, updatable = false)
	private Medico medico;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codigo_paciente", referencedColumnName = "codigo_pessoa", insertable = true, updatable = false)
	private Paciente paciente;
	private Integer codigoStatusConsulta;
	private String flagConfirmada;
	private String flagPrimeiraConsulta;
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss zzzz", timezone = "GMT-03:00")
	private Date dataAtendimento;
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss zzzz", timezone = "GMT-03:00")
	private Date dataConsulta;
	private Integer ordemChegada;
	@Column(length=2147483647) 
	private String historicoClinico;
	private String flagAtivo;
	private String usuarioUltimaAlteracao;
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataUltimaAlteracao;
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataCriacao;
	@OneToMany(mappedBy = "consulta")
	@OrderColumn(name = "codigo_solicitacao_exame", insertable = true, updatable = true)
	private List<SolicitacaoExame> listaSolicitacaoExame;
	@OneToMany(mappedBy = "consulta")
	@OrderColumn(name = "codigo_solicitacao_medicamento", insertable = true, updatable = true)
	private List<SolicitacaoMedicamento> listaSolicitacaoMedicamento;

	public BigInteger getCodigoConsulta() {
		return codigoConsulta;
	}

	public void setCodigoConsulta(BigInteger codigoConsulta) {
		this.codigoConsulta = codigoConsulta;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Integer getCodigoStatusConsulta() {
		return codigoStatusConsulta;
	}

	public void setCodigoStatusConsulta(Integer codigoStatusConsulta) {
		this.codigoStatusConsulta = codigoStatusConsulta;
	}

	public String getFlagConfirmada() {
		return flagConfirmada;
	}

	public void setFlagConfirmada(String flagConfirmada) {
		this.flagConfirmada = flagConfirmada;
	}

	public String getFlagPrimeiraConsulta() {
		return flagPrimeiraConsulta;
	}

	public void setFlagPrimeiraConsulta(String flagPrimeiraConsulta) {
		this.flagPrimeiraConsulta = flagPrimeiraConsulta;
	}

	public Date getDataAtendimento() {
		return dataAtendimento;
	}

	public void setDataAtendimento(Date dataAtendimento) {
		this.dataAtendimento = dataAtendimento;
	}

	public Date getDataConsulta() {
		return dataConsulta;
	}

	public void setDataConsulta(Date dataConsulta) {
		this.dataConsulta = dataConsulta;
	}

	public Integer getOrdemChegada() {
		return ordemChegada;
	}

	public void setOrdemChegada(Integer ordemChegada) {
		this.ordemChegada = ordemChegada;
	}

	public String getHistoricoClinico() {
		return historicoClinico;
	}

	public void setHistoricoClinico(String historicoClinico) {
		this.historicoClinico = historicoClinico;
	}

	public List<SolicitacaoExame> getListaSolicitacaoExame() {
		return listaSolicitacaoExame;
	}

	public void setListaSolicitacaoExame(List<SolicitacaoExame> listaSolicitacaoExame) {
		this.listaSolicitacaoExame = listaSolicitacaoExame;
	}

	public List<SolicitacaoMedicamento> getListaSolicitacaoMedicamento() {
		return listaSolicitacaoMedicamento;
	}

	public void setListaSolicitacaoMedicamento(List<SolicitacaoMedicamento> listaSolicitacaoMedicamento) {
		this.listaSolicitacaoMedicamento = listaSolicitacaoMedicamento;
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
		result = prime * result + ((codigoConsulta == null) ? 0 : codigoConsulta.hashCode());
		result = prime * result + ((codigoStatusConsulta == null) ? 0 : codigoStatusConsulta.hashCode());
		result = prime * result + ((dataAtendimento == null) ? 0 : dataAtendimento.hashCode());
		result = prime * result + ((dataConsulta == null) ? 0 : dataConsulta.hashCode());
		result = prime * result + ((dataCriacao == null) ? 0 : dataCriacao.hashCode());
		result = prime * result + ((dataUltimaAlteracao == null) ? 0 : dataUltimaAlteracao.hashCode());
		result = prime * result + ((flagAtivo == null) ? 0 : flagAtivo.hashCode());
		result = prime * result + ((flagConfirmada == null) ? 0 : flagConfirmada.hashCode());
		result = prime * result + ((flagPrimeiraConsulta == null) ? 0 : flagPrimeiraConsulta.hashCode());
		result = prime * result + ((historicoClinico == null) ? 0 : historicoClinico.hashCode());
		result = prime * result + ((listaSolicitacaoExame == null) ? 0 : listaSolicitacaoExame.hashCode());
		result = prime * result + ((listaSolicitacaoMedicamento == null) ? 0 : listaSolicitacaoMedicamento.hashCode());
		result = prime * result + ((medico == null) ? 0 : medico.hashCode());
		result = prime * result + ((ordemChegada == null) ? 0 : ordemChegada.hashCode());
		result = prime * result + ((paciente == null) ? 0 : paciente.hashCode());
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
		Consulta other = (Consulta) obj;
		if (codigoConsulta == null) {
			if (other.codigoConsulta != null)
				return false;
		} else if (!codigoConsulta.equals(other.codigoConsulta))
			return false;
		if (codigoStatusConsulta == null) {
			if (other.codigoStatusConsulta != null)
				return false;
		} else if (!codigoStatusConsulta.equals(other.codigoStatusConsulta))
			return false;
		if (dataAtendimento == null) {
			if (other.dataAtendimento != null)
				return false;
		} else if (!dataAtendimento.equals(other.dataAtendimento))
			return false;
		if (dataConsulta == null) {
			if (other.dataConsulta != null)
				return false;
		} else if (!dataConsulta.equals(other.dataConsulta))
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
		if (flagConfirmada == null) {
			if (other.flagConfirmada != null)
				return false;
		} else if (!flagConfirmada.equals(other.flagConfirmada))
			return false;
		if (flagPrimeiraConsulta == null) {
			if (other.flagPrimeiraConsulta != null)
				return false;
		} else if (!flagPrimeiraConsulta.equals(other.flagPrimeiraConsulta))
			return false;
		if (historicoClinico == null) {
			if (other.historicoClinico != null)
				return false;
		} else if (!historicoClinico.equals(other.historicoClinico))
			return false;
		if (listaSolicitacaoExame == null) {
			if (other.listaSolicitacaoExame != null)
				return false;
		} else if (!listaSolicitacaoExame.equals(other.listaSolicitacaoExame))
			return false;
		if (listaSolicitacaoMedicamento == null) {
			if (other.listaSolicitacaoMedicamento != null)
				return false;
		} else if (!listaSolicitacaoMedicamento.equals(other.listaSolicitacaoMedicamento))
			return false;
		if (medico == null) {
			if (other.medico != null)
				return false;
		} else if (!medico.equals(other.medico))
			return false;
		if (ordemChegada == null) {
			if (other.ordemChegada != null)
				return false;
		} else if (!ordemChegada.equals(other.ordemChegada))
			return false;
		if (paciente == null) {
			if (other.paciente != null)
				return false;
		} else if (!paciente.equals(other.paciente))
			return false;
		if (usuarioUltimaAlteracao == null) {
			if (other.usuarioUltimaAlteracao != null)
				return false;
		} else if (!usuarioUltimaAlteracao.equals(other.usuarioUltimaAlteracao))
			return false;
		return true;
	}

}
