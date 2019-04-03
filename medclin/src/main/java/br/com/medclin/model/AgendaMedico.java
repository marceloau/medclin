package br.com.medclin.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class AgendaMedico implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private AgendaMedicoPK agendaMedicoPK;

	private Integer diaSemana;

	@Temporal(TemporalType.TIME)
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss zzzz", timezone="GMT-03:00")
	private Date horaInicioAtendimento;

	@Temporal(TemporalType.TIME)
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss zzzz", timezone="GMT-03:00")
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

	public Integer getDiaSemana() {
		return diaSemana;
	}

	public void setDiaSemana(Integer diaSemana) {
		this.diaSemana = diaSemana;
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

	@XmlTransient
	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

}
