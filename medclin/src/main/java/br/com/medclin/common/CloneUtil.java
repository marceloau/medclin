package br.com.medclin.common;

import org.springframework.context.annotation.Configuration;

import br.com.medclin.model.EstadoCivil;
import br.com.medclin.model.Paciente;

@Configuration
public class CloneUtil {

	public Paciente clonePaciente(final Paciente paciente) {
		Paciente pacienteClone = null;
		if (paciente != null) {
			pacienteClone = new Paciente();

			pacienteClone.setCodigoPessoa(paciente.getCodigoPessoa());
			pacienteClone.setContatos(null);
			pacienteClone.setDataCriacao(paciente.getDataCriacao());
			pacienteClone.setDataNascimento(paciente.getDataNascimento());
			pacienteClone.setDataUltimaAlteracao(paciente.getDataUltimaAlteracao());
			pacienteClone.setEnderecos(null);
			pacienteClone.setEstadoCivil(cloneEstadoCivil(paciente.getEstadoCivil()));
			pacienteClone.setFlagAtivo(paciente.getFlagAtivo());
			pacienteClone.setInformacaoAdcional(paciente.getInformacaoAdcional());
			pacienteClone.setListaPlanoSaudePaciente(null);
			pacienteClone.setNacionalidade(paciente.getNacionalidade());
			pacienteClone.setNaturalidade(paciente.getNaturalidade());
			pacienteClone.setNomeMae(paciente.getNomeMae());
			pacienteClone.setNomePai(paciente.getNomePai());
			pacienteClone.setNomePessoa(paciente.getNomePessoa());
			pacienteClone.setNomeProfissao(paciente.getNomeProfissao());
			pacienteClone.setNumeroCartaoSus(paciente.getNumeroCartaoSus());
			pacienteClone.setNumeroCpf(paciente.getNumeroCpf());
			pacienteClone.setNumeroRg(paciente.getNumeroRg());
			pacienteClone.setOrgamEmissor(paciente.getOrgamEmissor());
			pacienteClone.setSexo(paciente.getSexo());
			pacienteClone.setUsuarioUltimaAlteracao(paciente.getUsuarioUltimaAlteracao());

		}

		return pacienteClone;
	}

	public EstadoCivil cloneEstadoCivil(final EstadoCivil estadoCivil) {
		EstadoCivil estadoCivilClone = null;
		if (estadoCivil != null) {
			estadoCivilClone = new EstadoCivil();

			estadoCivilClone.setCodigoEstadoCivil(estadoCivil.getCodigoEstadoCivil());
			estadoCivilClone.setDataCriacao(estadoCivil.getDataCriacao());
			estadoCivilClone.setDataUltimaAlteracao(estadoCivil.getDataUltimaAlteracao());
			estadoCivilClone.setFlagAtivo(estadoCivil.getFlagAtivo());
			estadoCivilClone.setNomeEstadoCivil(estadoCivil.getNomeEstadoCivil());
			estadoCivilClone.setUsuarioUltimaAlteracao(estadoCivil.getUsuarioUltimaAlteracao());
		}

		return estadoCivilClone;
	}
}
