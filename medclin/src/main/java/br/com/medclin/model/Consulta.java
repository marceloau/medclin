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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@SequenceGenerator(name = "CONSULTA_SEQ", sequenceName = "CONSULTA_SEQ", allocationSize = 1)
public class Consulta implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
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
	
	@Transient
	private transient Date dataUltimaConsulta;

	public Date getDataUltimaConsulta() {
		return dataUltimaConsulta;
	}

	public void setDataUltimaConsulta(Date dataUltimaConsulta) {
		this.dataUltimaConsulta = dataUltimaConsulta;
	}

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
}
