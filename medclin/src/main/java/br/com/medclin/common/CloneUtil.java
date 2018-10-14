/*
 * 
 */
package br.com.medclin.common;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import br.com.medclin.model.AgendaMedico;
import br.com.medclin.model.AgendaMedicoPK;
import br.com.medclin.model.ContatoPessoa;
import br.com.medclin.model.ContatoPessoaPK;
import br.com.medclin.model.EnderecoPessoa;
import br.com.medclin.model.EnderecoPessoaPK;
import br.com.medclin.model.Especialidade;
import br.com.medclin.model.EspecialidadeMedico;
import br.com.medclin.model.EspecialidadeMedicoPK;
import br.com.medclin.model.Estado;
import br.com.medclin.model.EstadoCivil;
import br.com.medclin.model.Medico;
import br.com.medclin.model.Operadora;
import br.com.medclin.model.Paciente;
import br.com.medclin.model.PlanoSaudePaciente;
import br.com.medclin.model.PlanoSaudePacientePK;
import br.com.medclin.model.TipoContato;
import br.com.medclin.model.TipoLogradouro;
import br.com.medclin.model.TipoPlanoSaude;

@Configuration
public class CloneUtil {

	private final ArrayList<Object> listaNula = new ArrayList<>();

	public AgendaMedico cloneAgendaMedico(final AgendaMedico agendaMedico) {
		AgendaMedico agendaMedicoClone = null;
		AgendaMedicoPK agendaMedicoPK = null;
		if (AssertUtil.isNotNull(agendaMedico)) {
			agendaMedicoClone = new AgendaMedico();
			agendaMedicoPK = new AgendaMedicoPK();
			agendaMedicoPK.setCodigoAgendaMedico(agendaMedico.getAgendaMedicoPK().getCodigoAgendaMedico());
			agendaMedicoPK.setCodigoPessoa(agendaMedico.getAgendaMedicoPK().getCodigoPessoa());
			agendaMedicoClone.setAgendaMedicoPK(agendaMedicoPK);
			agendaMedicoClone.setDiaSemana(agendaMedico.getDiaSemana());
			agendaMedicoClone.setHoraInicioAtendimento(agendaMedico.getHoraInicioAtendimento());
			agendaMedicoClone.setHoraFinalAtendimento(agendaMedico.getHoraFinalAtendimento());
			agendaMedicoClone.setObservacao(agendaMedico.getObservacao());
			agendaMedicoClone.setDataCriacao(agendaMedico.getDataCriacao());
			agendaMedicoClone.setDataUltimaAlteracao(agendaMedico.getDataUltimaAlteracao());
			agendaMedicoClone.setFlagAtivo(agendaMedico.getFlagAtivo());
			agendaMedicoClone.setUsuarioUltimaAlteracao(agendaMedico.getUsuarioUltimaAlteracao());
		}

		return agendaMedicoClone;
	}

	public ContatoPessoa cloneContatoPessoa(final ContatoPessoa contatoPessoa) {
		ContatoPessoa contatoPessoaClone = null;
		ContatoPessoaPK contatoPessoaPKClone = null;
		if (AssertUtil.isNotNull(contatoPessoa)) {
			contatoPessoaClone = new ContatoPessoa();
			contatoPessoaPKClone = new ContatoPessoaPK();
			contatoPessoaPKClone.setCodigoContatoPessoa(contatoPessoa.getContatoPessoaPK().getCodigoContatoPessoa());
			contatoPessoaPKClone.setCodigoPessoa(contatoPessoa.getContatoPessoaPK().getCodigoPessoa());
			contatoPessoaClone.setContatoPessoaPK(contatoPessoaPKClone);
			contatoPessoaClone.setDataCriacao(contatoPessoa.getDataCriacao());
			contatoPessoaClone.setDataUltimaAlteracao(contatoPessoa.getDataUltimaAlteracao());
			contatoPessoaClone.setFlagAtivo(contatoPessoa.getFlagAtivo());
			contatoPessoaClone.setTextoContato(contatoPessoa.getTextoContato());
			contatoPessoaClone.setTipoContato(cloneTipoContato(contatoPessoa.getTipoContato()));
			contatoPessoaClone.setUsuarioUltimaAlteracao(contatoPessoa.getUsuarioUltimaAlteracao());
		}

		return contatoPessoaClone;
	}

	public EnderecoPessoa cloneEnderecoPessoa(final EnderecoPessoa enderecoPessoa) {
		EnderecoPessoa enderecoPessoaClone = null;
		EnderecoPessoaPK enderecoPessoaPKClone = null;
		if (AssertUtil.isNotNull(enderecoPessoa)) {
			enderecoPessoaClone = new EnderecoPessoa();
			enderecoPessoaPKClone = new EnderecoPessoaPK();
			enderecoPessoaPKClone
					.setCodigoEnderecoPessoa(enderecoPessoa.getEnderecoPessoaPK().getCodigoEnderecoPessoa());
			enderecoPessoaPKClone.setCodigoPessoa(enderecoPessoa.getEnderecoPessoaPK().getCodigoPessoa());
			enderecoPessoaClone.setComplemento(enderecoPessoa.getComplemento());
			enderecoPessoaClone.setDataCriacao(enderecoPessoa.getDataCriacao());
			enderecoPessoaClone.setDataUltimaAlteracao(enderecoPessoa.getDataUltimaAlteracao());
			enderecoPessoaClone.setEnderecoPessoaPK(enderecoPessoaPKClone);
			enderecoPessoaClone.setEstado(cloneEstado(enderecoPessoa.getEstado()));
			enderecoPessoaClone.setFlagAtivo(enderecoPessoa.getFlagAtivo());
			enderecoPessoaClone.setNomeBairro(enderecoPessoa.getNomeBairro());
			enderecoPessoaClone.setNomeCidade(enderecoPessoa.getNomeCidade());
			enderecoPessoaClone.setNomeLogradouro(enderecoPessoa.getNomeLogradouro());
			enderecoPessoaClone.setNumeroCep(enderecoPessoa.getNumeroCep());
			enderecoPessoaClone.setNumeroLogradouro(enderecoPessoa.getNumeroLogradouro());
			enderecoPessoaClone.setTipoLogradouro(clonetipoLogradouro(enderecoPessoa.getTipoLogradouro()));
			enderecoPessoaClone.setUsuarioUltimaAlteracao(enderecoPessoa.getUsuarioUltimaAlteracao());
		}
		return enderecoPessoaClone;
	}

	public Especialidade cloneEspecialidade(final Especialidade especialidade) {
		Especialidade especialidadeClone = null;
		if (AssertUtil.isNotNull(especialidade)) {
			especialidadeClone = new Especialidade();
			especialidadeClone.setCodigoEspecialidade(especialidade.getCodigoEspecialidade());
			especialidadeClone.setDataCriacao(especialidade.getDataCriacao());
			especialidadeClone.setDataUltimaAlteracao(especialidade.getDataUltimaAlteracao());
			especialidadeClone.setDescricaoEspecialidade(especialidade.getDescricaoEspecialidade());
			especialidadeClone.setFlagAtivo(especialidade.getFlagAtivo());
			especialidadeClone.setNomeEspecialidade(especialidade.getNomeEspecialidade());
			especialidadeClone.setUsuarioUltimaAlteracao(especialidade.getUsuarioUltimaAlteracao());
		}

		return especialidadeClone;
	}

	public EspecialidadeMedico cloneEspecialidadeMedico(final EspecialidadeMedico especialidadeMedico) {
		EspecialidadeMedico especialidadeMedicoClone = null;
		EspecialidadeMedicoPK especialidadeMedicoPK = null;
		if (AssertUtil.isNotNull(especialidadeMedico)) {
			especialidadeMedicoClone = new EspecialidadeMedico();
			especialidadeMedicoPK = new EspecialidadeMedicoPK();
			especialidadeMedicoPK.setCodigoEspecialidadeMedico(
					especialidadeMedico.getEspecialidadeMedicoPK().getCodigoEspecialidadeMedico());
			especialidadeMedicoPK.setCodigoPessoa(especialidadeMedico.getEspecialidadeMedicoPK().getCodigoPessoa());
			especialidadeMedicoClone.setEspecialidadeMedicoPK(especialidadeMedicoPK);
			especialidadeMedicoClone.setDataInicioAtuacao(especialidadeMedico.getDataInicioAtuacao());
			especialidadeMedicoClone.setDataCriacao(especialidadeMedico.getDataCriacao());
			especialidadeMedicoClone.setDataUltimaAlteracao(especialidadeMedico.getDataUltimaAlteracao());
			especialidadeMedicoClone.setFlagAtivo(especialidadeMedico.getFlagAtivo());
			especialidadeMedicoClone.setUsuarioUltimaAlteracao(especialidadeMedico.getUsuarioUltimaAlteracao());
			especialidadeMedicoClone.setEspecialidade(cloneEspecialidade(especialidadeMedico.getEspecialidade()));
		}

		return especialidadeMedicoClone;
	}

	public Estado cloneEstado(final Estado estado) {
		Estado estadoClone = null;
		if (AssertUtil.isNotNull(estado)) {
			estadoClone = new Estado();
			estadoClone.setCodigoEstado(estado.getCodigoEstado());
			estadoClone.setDataCriacao(estado.getDataCriacao());
			estadoClone.setDataUltimaAlteracao(estado.getDataUltimaAlteracao());
			estadoClone.setFlagAtivo(estado.getFlagAtivo());
			estadoClone.setNomeEstado(estado.getNomeEstado());
			estadoClone.setSiglaEstado(estado.getSiglaEstado());
			estadoClone.setUsuarioUltimaAlteracao(estado.getUsuarioUltimaAlteracao());

		}
		return estadoClone;
	}

	public EstadoCivil cloneEstadoCivil(final EstadoCivil estadoCivil) {
		EstadoCivil estadoCivilClone = null;
		if (AssertUtil.isNotNull(estadoCivil)) {
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

	public List<AgendaMedico> cloneListaAgendaMedico(final List<AgendaMedico> listaAgendaMedico) {
		List<AgendaMedico> listaAgendaMedicoClone = null;
		if (AssertUtil.isNotEmptyList(listaAgendaMedico)) {
			listaNula.add(null);
			listaAgendaMedico.removeAll(listaNula);

			listaAgendaMedicoClone = new ArrayList<>();
			for (AgendaMedico agendaMedico : listaAgendaMedico) {
				listaAgendaMedicoClone.add(cloneAgendaMedico(agendaMedico));
			}
		}
		return listaAgendaMedicoClone;
	}

	public List<ContatoPessoa> cloneListaContatoPessoa(final List<ContatoPessoa> listaContatoPessoa) {
		List<ContatoPessoa> listaContatoPessoaClone = null;
		if (AssertUtil.isNotEmptyList(listaContatoPessoa)) {
			listaNula.add(null);
			listaContatoPessoa.removeAll(listaNula);

			listaContatoPessoaClone = new ArrayList<>();
			for (ContatoPessoa contatoPessoa : listaContatoPessoa) {
				listaContatoPessoaClone.add(cloneContatoPessoa(contatoPessoa));
			}
		}
		return listaContatoPessoaClone;
	}

	public List<EnderecoPessoa> cloneListaEnderecoPessoa(final List<EnderecoPessoa> listaEnderecoPessoa) {
		List<EnderecoPessoa> listaEnderecoPessoaClone = null;
		if (AssertUtil.isNotEmptyList(listaEnderecoPessoa)) {
			listaNula.add(null);
			listaEnderecoPessoa.removeAll(listaNula);

			listaEnderecoPessoaClone = new ArrayList<>();
			for (EnderecoPessoa enderecoPessoa : listaEnderecoPessoa) {
				listaEnderecoPessoaClone.add(cloneEnderecoPessoa(enderecoPessoa));
			}
		}
		return listaEnderecoPessoaClone;
	}

	public List<EspecialidadeMedico> cloneListaEspecialidadeMedico(
			final List<EspecialidadeMedico> listaEspecialidadeMedico) {
		List<EspecialidadeMedico> listaEspecialidadeMedicoClone = null;
		if (AssertUtil.isNotEmptyList(listaEspecialidadeMedico)) {
			listaNula.add(null);
			listaEspecialidadeMedico.removeAll(listaNula);

			listaEspecialidadeMedicoClone = new ArrayList<>();
			for (EspecialidadeMedico especialidadeMedico : listaEspecialidadeMedico) {
				listaEspecialidadeMedicoClone.add(cloneEspecialidadeMedico(especialidadeMedico));
			}
		}
		return listaEspecialidadeMedicoClone;
	}

	public Page<Medico> cloneListaMedico(final Page<Medico> listaMedico) {
		List<Medico> listaMedicoClone = null;
		PageImpl<Medico> listaRetorno = null;
		if (AssertUtil.isNotNull(listaMedico) && AssertUtil.isNotEmptyList(listaMedico.getContent())) {

			listaMedicoClone = new ArrayList<>();
			for (Medico medico : listaMedico.getContent()) {
				listaMedicoClone.add(cloneMedico(medico));
			}
			listaRetorno = new PageImpl<>(listaMedicoClone, listaMedico.getPageable(), listaMedico.getTotalElements());
		}

		return listaRetorno;
	}

	public Page<Paciente> cloneListaPaciente(final Page<Paciente> listaPaciente) {
		List<Paciente> listaPacienteClone = null;
		PageImpl<Paciente> listaRetorno = null;
		if (AssertUtil.isNotNull(listaPaciente) && AssertUtil.isNotEmptyList(listaPaciente.getContent())) {

			listaPacienteClone = new ArrayList<>();
			for (Paciente paciente : listaPaciente.getContent()) {
				listaPacienteClone.add(clonePaciente(paciente));
			}
			listaRetorno = new PageImpl<>(listaPacienteClone, listaPaciente.getPageable(),
					listaPaciente.getTotalElements());
		}

		return listaRetorno;
	}

	public List<PlanoSaudePaciente> cloneListaPlanoSaudePaciente(
			final List<PlanoSaudePaciente> listaPlanoSaudePaciente) {
		List<PlanoSaudePaciente> listaPlanoSaudePacienteClone = null;
		if (AssertUtil.isNotEmptyList(listaPlanoSaudePaciente)) {
			listaNula.add(null);
			listaPlanoSaudePaciente.removeAll(listaNula);

			listaPlanoSaudePacienteClone = new ArrayList<>();
			for (PlanoSaudePaciente planoSaudePaciente : listaPlanoSaudePaciente) {
				listaPlanoSaudePacienteClone.add(clonePlanoSaudePaciente(planoSaudePaciente));
			}
		}
		return listaPlanoSaudePacienteClone;
	}

	public Medico cloneMedico(final Medico medico) {
		Medico medicoClone = null;
		if (AssertUtil.isNotNull(medico)) {
			medicoClone = new Medico();

			medicoClone.setCodigoPessoa(medico.getCodigoPessoa());
			medicoClone.setContatos(cloneListaContatoPessoa(medico.getContatos()));
			medicoClone.setDataCriacao(medico.getDataCriacao());
			medicoClone.setDataNascimento(medico.getDataNascimento());
			medicoClone.setDataUltimaAlteracao(medico.getDataUltimaAlteracao());
			medicoClone.setEnderecos(cloneListaEnderecoPessoa(medico.getEnderecos()));
			medicoClone.setEstadoCivil(cloneEstadoCivil(medico.getEstadoCivil()));
			medicoClone.setFlagAtivo(medico.getFlagAtivo());
			medicoClone.setInformacaoAdicional(medico.getInformacaoAdicional());
			medicoClone.setNacionalidade(medico.getNacionalidade());
			medicoClone.setNaturalidade(medico.getNaturalidade());
			medicoClone.setNomePessoa(medico.getNomePessoa());
			medicoClone.setNumeroCpf(medico.getNumeroCpf());
			medicoClone.setNumeroRg(medico.getNumeroRg());
			medicoClone.setOrgamEmissor(medico.getOrgamEmissor());
			medicoClone.setSexo(medico.getSexo());
			medicoClone.setUsuarioUltimaAlteracao(medico.getUsuarioUltimaAlteracao());
			medicoClone.setListaAgendaMedico(cloneListaAgendaMedico(medico.getListaAgendaMedico()));
			medicoClone
					.setListaEspecialidadeMedico(cloneListaEspecialidadeMedico(medico.getListaEspecialidadeMedico()));
			medicoClone.setNumeroCRM(medico.getNumeroCRM());

		}

		return medicoClone;
	}

	public Operadora cloneOperadora(final Operadora operadora) {
		Operadora operadoraClone = null;
		if (AssertUtil.isNotNull(operadora)) {
			operadoraClone = new Operadora();
			operadoraClone.setCodigoOficial(operadora.getCodigoOficial());
			operadoraClone.setCodigoOperadora(operadora.getCodigoOperadora());
			operadoraClone.setDataCriacao(operadora.getDataCriacao());
			operadoraClone.setDataUltimaAlteracao(operadora.getDataUltimaAlteracao());
			operadoraClone.setDescricaoOperadora(operadora.getDescricaoOperadora());
			operadoraClone.setFlagAtivo(operadora.getFlagAtivo());
			operadoraClone.setNomeOperadora(operadora.getNomeOperadora());
			operadoraClone.setUsuarioUltimaAlteracao(operadora.getUsuarioUltimaAlteracao());
		}

		return operadoraClone;
	}

	public Paciente clonePaciente(final Paciente paciente) {
		Paciente pacienteClone = null;
		if (AssertUtil.isNotNull(paciente)) {
			pacienteClone = new Paciente();

			pacienteClone.setCodigoPessoa(paciente.getCodigoPessoa());
			pacienteClone.setContatos(cloneListaContatoPessoa(paciente.getContatos()));
			pacienteClone.setDataCriacao(paciente.getDataCriacao());
			pacienteClone.setDataNascimento(paciente.getDataNascimento());
			pacienteClone.setDataUltimaAlteracao(paciente.getDataUltimaAlteracao());
			pacienteClone.setEnderecos(cloneListaEnderecoPessoa(paciente.getEnderecos()));
			pacienteClone.setEstadoCivil(cloneEstadoCivil(paciente.getEstadoCivil()));
			pacienteClone.setFlagAtivo(paciente.getFlagAtivo());
			pacienteClone.setInformacaoAdicional(paciente.getInformacaoAdicional());
			pacienteClone
					.setListaPlanoSaudePaciente(cloneListaPlanoSaudePaciente(paciente.getListaPlanoSaudePaciente()));
			pacienteClone.setNacionalidade(paciente.getNacionalidade());
			pacienteClone.setNaturalidade(paciente.getNaturalidade());
			pacienteClone.setNomeMae(paciente.getNomeMae());
			pacienteClone.setNomePai(paciente.getNomePai());
			pacienteClone.setNomePessoa(paciente.getNomePessoa());
			pacienteClone.setNomeProfissao(paciente.getNomeProfissao());
			pacienteClone.setNumeroCartaoSUS(paciente.getNumeroCartaoSUS());
			pacienteClone.setNumeroCpf(paciente.getNumeroCpf());
			pacienteClone.setNumeroRg(paciente.getNumeroRg());
			pacienteClone.setOrgamEmissor(paciente.getOrgamEmissor());
			pacienteClone.setSexo(paciente.getSexo());
			pacienteClone.setUsuarioUltimaAlteracao(paciente.getUsuarioUltimaAlteracao());

		}

		return pacienteClone;
	}

	public PlanoSaudePaciente clonePlanoSaudePaciente(final PlanoSaudePaciente planoSaudePaciente) {
		PlanoSaudePaciente planoSaudePacienteClone = null;
		PlanoSaudePacientePK planoSaudePacientePKClone = null;
		if (AssertUtil.isNotNull(planoSaudePaciente)) {
			planoSaudePacienteClone = new PlanoSaudePaciente();
			planoSaudePacientePKClone = new PlanoSaudePacientePK();

			planoSaudePacientePKClone.setCodigoPessoa(planoSaudePaciente.getPlanoSaudePacientePK().getCodigoPessoa());
			planoSaudePacientePKClone.setCodigoPlanoSaudePaciente(
					planoSaudePaciente.getPlanoSaudePacientePK().getCodigoPlanoSaudePaciente());
			planoSaudePacienteClone.setPlanoSaudePacientePK(planoSaudePacientePKClone);
			planoSaudePacienteClone.setDataCriacao(planoSaudePaciente.getDataCriacao());
			planoSaudePacienteClone.setDataUltimaAlteracao(planoSaudePaciente.getDataUltimaAlteracao());
			planoSaudePacienteClone.setFlagAtivo(planoSaudePaciente.getFlagAtivo());
			planoSaudePacienteClone.setNomeTitular(planoSaudePaciente.getNomeTitular());
			planoSaudePacienteClone.setUsuarioUltimaAlteracao(planoSaudePaciente.getUsuarioUltimaAlteracao());
			planoSaudePacienteClone.setValidadeCartao(planoSaudePaciente.getValidadeCartao());
			planoSaudePacienteClone.setOperadora(cloneOperadora(planoSaudePaciente.getOperadora()));
			planoSaudePacienteClone.setTipoPlanoSaude(cloneTipoPlanoSaude(planoSaudePaciente.getTipoPlanoSaude()));
		}
		return planoSaudePacienteClone;
	}

	public TipoContato cloneTipoContato(final TipoContato tipoContato) {
		TipoContato tipoContatoClone = null;
		if (AssertUtil.isNotNull(tipoContato)) {
			tipoContatoClone = new TipoContato();
			tipoContatoClone.setCodigoTipoContato(tipoContato.getCodigoTipoContato());
			tipoContatoClone.setDataCriacao(tipoContato.getDataCriacao());
			tipoContatoClone.setDataUltimaAlteracao(tipoContato.getDataUltimaAlteracao());
			tipoContatoClone.setDescricaoTipoContato(tipoContato.getDescricaoTipoContato());
			tipoContatoClone.setFlagAtivo(tipoContato.getFlagAtivo());
			tipoContatoClone.setNomeTipoContato(tipoContato.getNomeTipoContato());
			tipoContatoClone.setUsuarioUltimaAlteracao(tipoContato.getUsuarioUltimaAlteracao());

		}

		return tipoContatoClone;
	}

	public TipoLogradouro clonetipoLogradouro(final TipoLogradouro tipoLogradouro) {
		TipoLogradouro tipoLogradouroClone = null;
		if (AssertUtil.isNotNull(tipoLogradouro)) {
			tipoLogradouroClone = new TipoLogradouro();
			tipoLogradouroClone.setCodigoTipoLogradouro(tipoLogradouro.getCodigoTipoLogradouro());
			tipoLogradouroClone.setDataCriacao(tipoLogradouro.getDataCriacao());
			tipoLogradouroClone.setDataUltimaAlteracao(tipoLogradouro.getDataUltimaAlteracao());
			tipoLogradouroClone.setFlagAtivo(tipoLogradouro.getFlagAtivo());
			tipoLogradouroClone.setNomeTipoLogradouro(tipoLogradouro.getNomeTipoLogradouro());
			tipoLogradouroClone.setUsuarioUltimaAlteracao(tipoLogradouro.getUsuarioUltimaAlteracao());

		}
		return tipoLogradouroClone;
	}

	public TipoPlanoSaude cloneTipoPlanoSaude(final TipoPlanoSaude tipoPlanoSaude) {
		TipoPlanoSaude tipoPlanoSaudeClone = null;
		if (AssertUtil.isNotNull(tipoPlanoSaude)) {
			tipoPlanoSaudeClone = new TipoPlanoSaude();
			tipoPlanoSaudeClone.setCodigoTipoPlano(tipoPlanoSaude.getCodigoTipoPlano());
			tipoPlanoSaudeClone.setDataCriacao(tipoPlanoSaude.getDataCriacao());
			tipoPlanoSaudeClone.setDataUltimaAlteracao(tipoPlanoSaude.getDataUltimaAlteracao());
			tipoPlanoSaudeClone.setDescricaoTipoPlano(tipoPlanoSaude.getDescricaoTipoPlano());
			tipoPlanoSaudeClone.setFlagAtivo(tipoPlanoSaude.getFlagAtivo());
			tipoPlanoSaudeClone.setNomeTipoPlano(tipoPlanoSaude.getNomeTipoPlano());
			tipoPlanoSaudeClone.setUsuarioUltimaAlteracao(tipoPlanoSaude.getUsuarioUltimaAlteracao());
		}

		return tipoPlanoSaudeClone;
	}

}
