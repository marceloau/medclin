package br.com.medclin.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class AgendaMedico implements Serializable {

	private static final long SerialVersionUID = 1L;

	@EmbeddedId
	private AgendaMedicoPK agendaMedicoPK;

	@Temporal(TemporalType.DATE)
	private Date dataAtendimento;

	@Temporal(TemporalType.TIME)
	private Date horaInicioAtendimento;

	@Temporal(TemporalType.TIME)
	private Date horaFinalAtendimento;

	private String observacao;

	private String flagAtivo;

	private String usuarioUltimaAlteracao;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dataUltimaAlteracao;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dataCriacao;

	@ManyToOne
	@JoinColumn(name = "codigo_pessoa", referencedColumnName = "codigo_pessoa", insertable = false, updatable = false)
	private Medico medico;

	public AgendaMedicoPK getAgendaMedicoPK() {
		return agendaMedicoPK;
	}

	public void setAgendaMedicoPK(AgendaMedicoPK agendaMedicoPK) {
		this.agendaMedicoPK = agendaMedicoPK;
	}

	public Date getDataAtendimento() {
		return dataAtendimento;
	}

	public void setDataAtendimento(Date dataAtendimento) {
		this.dataAtendimento = dataAtendimento;
	}

	public Date getHoraInicioAtendimento() {
		return horaInicioAtendimento;
	}

	public void setHoraInicioAtendimento(Date horaInicioAtendimento) {
		this.horaInicioAtendimento = horaInicioAtendimento;
	}

	public Date getHoraFinalAtendimento() {
		return horaFinalAtendimento;
	}

	public void setHoraFinalAtendimento(Date horaFinalAtendimento) {
		this.horaFinalAtendimento = horaFinalAtendimento;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
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

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((agendaMedicoPK == null) ? 0 : agendaMedicoPK.hashCode());
		result = prime * result + ((dataAtendimento == null) ? 0 : dataAtendimento.hashCode());
		result = prime * result + ((dataCriacao == null) ? 0 : dataCriacao.hashCode());
		result = prime * result + ((dataUltimaAlteracao == null) ? 0 : dataUltimaAlteracao.hashCode());
		result = prime * result + ((flagAtivo == null) ? 0 : flagAtivo.hashCode());
		result = prime * result + ((horaFinalAtendimento == null) ? 0 : horaFinalAtendimento.hashCode());
		result = prime * result + ((horaInicioAtendimento == null) ? 0 : horaInicioAtendimento.hashCode());
		result = prime * result + ((medico == null) ? 0 : medico.hashCode());
		result = prime * result + ((observacao == null) ? 0 : observacao.hashCode());
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
		AgendaMedico other = (AgendaMedico) obj;
		if (agendaMedicoPK == null) {
			if (other.agendaMedicoPK != null)
				return false;
		} else if (!agendaMedicoPK.equals(other.agendaMedicoPK))
			return false;
		if (dataAtendimento == null) {
			if (other.dataAtendimento != null)
				return false;
		} else if (!dataAtendimento.equals(other.dataAtendimento))
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
		if (horaFinalAtendimento == null) {
			if (other.horaFinalAtendimento != null)
				return false;
		} else if (!horaFinalAtendimento.equals(other.horaFinalAtendimento))
			return false;
		if (horaInicioAtendimento == null) {
			if (other.horaInicioAtendimento != null)
				return false;
		} else if (!horaInicioAtendimento.equals(other.horaInicioAtendimento))
			return false;
		if (medico == null) {
			if (other.medico != null)
				return false;
		} else if (!medico.equals(other.medico))
			return false;
		if (observacao == null) {
			if (other.observacao != null)
				return false;
		} else if (!observacao.equals(other.observacao))
			return false;
		if (usuarioUltimaAlteracao == null) {
			if (other.usuarioUltimaAlteracao != null)
				return false;
		} else if (!usuarioUltimaAlteracao.equals(other.usuarioUltimaAlteracao))
			return false;
		return true;
	}

}
