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
import br.com.medclin.model.Consulta;
import br.com.medclin.model.ContatoPessoa;
import br.com.medclin.model.ContatoPessoaPK;
import br.com.medclin.model.EnderecoPessoa;
import br.com.medclin.model.EnderecoPessoaPK;
import br.com.medclin.model.Especialidade;
import br.com.medclin.model.EspecialidadeMedico;
import br.com.medclin.model.EspecialidadeMedicoPK;
import br.com.medclin.model.Estado;
import br.com.medclin.model.EstadoCivil;
import br.com.medclin.model.Exame;
import br.com.medclin.model.Medicamento;
import br.com.medclin.model.Medico;
import br.com.medclin.model.Operadora;
import br.com.medclin.model.Paciente;
import br.com.medclin.model.Pessoa;
import br.com.medclin.model.PlanoSaudePaciente;
import br.com.medclin.model.PlanoSaudePacientePK;
import br.com.medclin.model.SolicitacaoExame;
import br.com.medclin.model.SolicitacaoExamePK;
import br.com.medclin.model.SolicitacaoMedicamento;
import br.com.medclin.model.SolicitacaoMedicamentoPK;
import br.com.medclin.model.TipoContato;
import br.com.medclin.model.TipoExame;
import br.com.medclin.model.TipoLogradouro;
import br.com.medclin.model.TipoMedicamento;
import br.com.medclin.model.TipoPlanoSaude;
import br.com.medclin.model.UsoMedicamento;
import br.com.medclin.model.Usuario;

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
			if (enderecoPessoa.getEnderecoPessoaPK() != null) {
				enderecoPessoaPKClone
						.setCodigoEnderecoPessoa(enderecoPessoa.getEnderecoPessoaPK().getCodigoEnderecoPessoa());
				enderecoPessoaPKClone.setCodigoPessoa(enderecoPessoa.getEnderecoPessoaPK().getCodigoPessoa());
			}
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

	public Consulta cloneConsulta(final Consulta consulta) {
		Consulta consultaClone = null;
		if (AssertUtil.isNotNull(consulta)) {
			consultaClone = new Consulta();
			consultaClone.setCodigoConsulta(consulta.getCodigoConsulta());
			consultaClone.setCodigoStatusConsulta(consulta.getCodigoStatusConsulta());
			consultaClone.setDataAtendimento(consulta.getDataAtendimento());
			consultaClone.setDataConsulta(consulta.getDataConsulta());
			consultaClone.setFlagConfirmada(consulta.getFlagConfirmada());
			consultaClone.setFlagPrimeiraConsulta(consulta.getFlagPrimeiraConsulta());
			consultaClone.setDataCriacao(consulta.getDataCriacao());
			consultaClone.setDataUltimaAlteracao(consulta.getDataUltimaAlteracao());
			consultaClone.setFlagAtivo(consulta.getFlagAtivo());
			consultaClone.setUsuarioUltimaAlteracao(consulta.getUsuarioUltimaAlteracao());
			consultaClone.setMedico(cloneMedico(consulta.getMedico()));
			consultaClone.setPaciente(clonePaciente(consulta.getPaciente()));
			consultaClone.setOrdemChegada(consulta.getOrdemChegada());
			consultaClone.setHistoricoClinico(consulta.getHistoricoClinico());
			consultaClone.setListaSolicitacaoExame(cloneListaSolicExame(consulta.getListaSolicitacaoExame()));
			consultaClone.setListaSolicitacaoMedicamento(
					cloneListaSolicitacaoMedicamento(consulta.getListaSolicitacaoMedicamento()));
			consultaClone.setDataUltimaConsulta(consulta.getDataUltimaConsulta());
		}

		return consultaClone;
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
		listaMedicoClone = new ArrayList<>();
		if (AssertUtil.isNotNull(listaMedico) && AssertUtil.isNotEmptyList(listaMedico.getContent())) {
			for (Medico medico : listaMedico.getContent()) {
				listaMedicoClone.add(cloneMedico(medico));
			}
		}
		listaRetorno = new PageImpl<>(listaMedicoClone, listaMedico.getPageable(), listaMedico.getTotalElements());

		return listaRetorno;
	}

	public Page<Consulta> cloneListaConsulta(final Page<Consulta> listaConsulta) {
		List<Consulta> listaConsultaClone = null;
		PageImpl<Consulta> listaRetorno = null;
		listaConsultaClone = new ArrayList<>();
		if (AssertUtil.isNotNull(listaConsulta) && AssertUtil.isNotEmptyList(listaConsulta.getContent())) {
			for (Consulta consulta : listaConsulta.getContent()) {
				listaConsultaClone.add(cloneConsulta(consulta));
			}
		}
		listaRetorno = new PageImpl<>(listaConsultaClone, listaConsulta.getPageable(),
				listaConsulta.getTotalElements());

		return listaRetorno;
	}

	public Page<Paciente> cloneListaPaciente(final Page<Paciente> listaPaciente) {
		List<Paciente> listaPacienteClone = null;
		PageImpl<Paciente> listaRetorno = null;
		listaPacienteClone = new ArrayList<>();
		if (AssertUtil.isNotNull(listaPaciente) && AssertUtil.isNotEmptyList(listaPaciente.getContent())) {
			for (Paciente paciente : listaPaciente.getContent()) {
				listaPacienteClone.add(clonePaciente(paciente));
			}
		}
		listaRetorno = new PageImpl<>(listaPacienteClone, listaPaciente.getPageable(),
				listaPaciente.getTotalElements());

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
	
	public Page<Usuario> cloneListaUsuario(final Page<Usuario> listaUsuario) {
		List<Usuario> listaUsuarioClone = null;
		PageImpl<Usuario> listaRetorno = null;
		if (AssertUtil.isNotNull(listaUsuario) && AssertUtil.isNotEmptyList(listaUsuario.getContent())) {

			listaUsuarioClone = new ArrayList<>();
			for (Usuario usuario : listaUsuario.getContent()) {
				listaUsuarioClone.add(cloneUsuario(usuario));
			}
			listaRetorno = new PageImpl<>(listaUsuarioClone, listaUsuario.getPageable(), listaUsuario.getTotalElements());
		}

		return listaRetorno;
	}
	
	public Usuario cloneUsuario(final Usuario usuario) {
		Usuario usuarioClone = null;
		if (AssertUtil.isNotNull(usuario)) {
			usuarioClone = new Usuario();
			final Pessoa pessoaClone = new Pessoa();

			pessoaClone.setCodigoPessoa(usuario.getPessoa().getCodigoPessoa());
			pessoaClone.setContatos(cloneListaContatoPessoa(usuario.getPessoa().getContatos()));
			pessoaClone.setDataCriacao(usuario.getPessoa().getDataCriacao());
			pessoaClone.setDataNascimento(usuario.getPessoa().getDataNascimento());
			pessoaClone.setDataUltimaAlteracao(usuario.getPessoa().getDataUltimaAlteracao());
			pessoaClone.setEnderecos(cloneListaEnderecoPessoa(usuario.getPessoa().getEnderecos()));
			pessoaClone.setEstadoCivil(cloneEstadoCivil(usuario.getPessoa().getEstadoCivil()));
			pessoaClone.setFlagAtivo(usuario.getPessoa().getFlagAtivo());
			pessoaClone.setInformacaoAdicional(usuario.getPessoa().getInformacaoAdicional());
			pessoaClone.setNacionalidade(usuario.getPessoa().getNacionalidade());
			pessoaClone.setNaturalidade(usuario.getPessoa().getNaturalidade());
			pessoaClone.setNomePessoa(usuario.getPessoa().getNomePessoa());
			pessoaClone.setNumeroCpf(usuario.getPessoa().getNumeroCpf());
			pessoaClone.setNumeroRg(usuario.getPessoa().getNumeroRg());
			pessoaClone.setOrgamEmissor(usuario.getPessoa().getOrgamEmissor());
			pessoaClone.setSexo(usuario.getPessoa().getSexo());
			pessoaClone.setUsuarioUltimaAlteracao(usuario.getPessoa().getUsuarioUltimaAlteracao());
			usuarioClone.setLogin(usuario.getLogin());
			usuarioClone.setEmail(usuario.getEmail());
			usuarioClone.setSenha(usuario.getSenha());
			usuarioClone.setUsuarioUltimaAlteracao(usuario.getUsuarioUltimaAlteracao());
			usuarioClone.setDataCriacao(usuario.getDataCriacao());
			usuarioClone.setDataUltimaAlteracao(usuario.getPessoa().getDataUltimaAlteracao());
			usuarioClone.setFlagAtivo(usuario.getPessoa().getFlagAtivo());
			usuarioClone.setPessoa(pessoaClone);

		}

		return usuarioClone;
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
			planoSaudePacienteClone.setNumeroCartao(planoSaudePaciente.getNumeroCartao());
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

	public TipoExame cloneTipoExame(final TipoExame tipoExame) {
		TipoExame tipoExameClone = null;
		if (AssertUtil.isNotNull(tipoExame)) {
			tipoExameClone = new TipoExame();
			tipoExameClone.setCodigoTipoExame(tipoExame.getCodigoTipoExame());
			tipoExameClone.setDataCriacao(tipoExame.getDataCriacao());
			tipoExameClone.setDataUltimaAlteracao(tipoExame.getDataUltimaAlteracao());
			tipoExameClone.setDescricaoTipoExame(tipoExame.getDescricaoTipoExame());
			tipoExameClone.setFlagAtivo(tipoExame.getFlagAtivo());
			tipoExameClone.setNomeTipoExame(tipoExame.getNomeTipoExame());
			tipoExameClone.setUsuarioUltimaAlteracao(tipoExame.getUsuarioUltimaAlteracao());

		}

		return tipoExameClone;
	}

	public Exame cloneExame(final Exame exame) {
		Exame exameClone = null;
		if (AssertUtil.isNotNull(exame)) {
			exameClone = new Exame();
			exameClone.setCodigoExame(exame.getCodigoExame());
			exameClone.setDataCriacao(exame.getDataCriacao());
			exameClone.setTipoExame(cloneTipoExame(exame.getTipoExame()));
			exameClone.setDataUltimaAlteracao(exame.getDataUltimaAlteracao());
			exameClone.setDescricaoExame(exame.getDescricaoExame());
			exameClone.setFlagAtivo(exame.getFlagAtivo());
			exameClone.setNomeExame(exame.getNomeExame());
			exameClone.setUsuarioUltimaAlteracao(exame.getUsuarioUltimaAlteracao());

		}

		return exameClone;
	}

	public Page<Exame> cloneListaExame(final Page<Exame> listaExame) {
		List<Exame> listaExameClone = null;
		PageImpl<Exame> listaRetorno = null;

		listaExameClone = new ArrayList<>();
		for (Exame exame : listaExame.getContent()) {
			listaExameClone.add(cloneExame(exame));
		}
		listaRetorno = new PageImpl<>(listaExameClone, listaExame.getPageable(), listaExame.getTotalElements());

		return listaRetorno;
	}
	
	public Page<SolicitacaoExame> cloneListaSolicitacaoExame(final Page<SolicitacaoExame> listaSolicitacaoExame) {
		List<SolicitacaoExame> listaSolicitacaoExameClone = null;
		PageImpl<SolicitacaoExame> listaRetorno = null;

		listaSolicitacaoExameClone = new ArrayList<>();
		for (SolicitacaoExame solicitacaoExame : listaSolicitacaoExame.getContent()) {
			listaSolicitacaoExameClone.add(cloneSolicitacaoExame(solicitacaoExame));
		}
		listaRetorno = new PageImpl<>(listaSolicitacaoExameClone, listaSolicitacaoExame.getPageable(), listaSolicitacaoExame.getTotalElements());

		return listaRetorno;
	}
	
	public Page<SolicitacaoMedicamento> cloneListaSolicitacaoMedicamento(final Page<SolicitacaoMedicamento> listaSolicitacaoMedicamento) {
		List<SolicitacaoMedicamento> listaSolicitacaoMedicamentoClone = null;
		PageImpl<SolicitacaoMedicamento> listaRetorno = null;

		listaSolicitacaoMedicamentoClone = new ArrayList<>();
		for (SolicitacaoMedicamento solicitacaoMedicamento : listaSolicitacaoMedicamento.getContent()) {
			listaSolicitacaoMedicamentoClone.add(cloneSolicitacaoMedicamento(solicitacaoMedicamento));
		}
		listaRetorno = new PageImpl<>(listaSolicitacaoMedicamentoClone, listaSolicitacaoMedicamento.getPageable(), listaSolicitacaoMedicamento.getTotalElements());

		return listaRetorno;
	}

	public SolicitacaoExame cloneSolicitacaoExame(final SolicitacaoExame solicitacaoExame) {
		SolicitacaoExame solicitacaoExameClone = null;
		if (AssertUtil.isNotNull(solicitacaoExame)) {
			solicitacaoExameClone = new SolicitacaoExame();
			SolicitacaoExamePK cloneSolicitacaoExamePK = new SolicitacaoExamePK();
			cloneSolicitacaoExamePK.setCodigoConsulta(solicitacaoExame.getSolicitacaoExamePK().getCodigoConsulta());
			cloneSolicitacaoExamePK
					.setCodigoSolicitacaoExame(solicitacaoExame.getSolicitacaoExamePK().getCodigoSolicitacaoExame());
			solicitacaoExameClone.setSolicitacaoExamePK(cloneSolicitacaoExamePK);
			solicitacaoExameClone.setDataCriacao(solicitacaoExame.getDataCriacao());
			solicitacaoExameClone.setDataSolicitacaoExame(solicitacaoExame.getDataSolicitacaoExame());
			solicitacaoExameClone.setDataUltimaAlteracao(solicitacaoExame.getDataUltimaAlteracao());
			solicitacaoExameClone.setFlagAtivo(solicitacaoExame.getFlagAtivo());
			solicitacaoExameClone.setExame(cloneExame(solicitacaoExame.getExame()));
			solicitacaoExameClone.setUsuarioUltimaAlteracao(solicitacaoExame.getUsuarioUltimaAlteracao());
		}

		return solicitacaoExameClone;
	}

	public List<SolicitacaoExame> cloneListaSolicExame(final List<SolicitacaoExame> listaSolicitacaoExame) {
		List<SolicitacaoExame> listaSolicitacaoExameClone = null;
		if (AssertUtil.isNotEmptyList(listaSolicitacaoExame)) {
			listaNula.add(null);
			listaSolicitacaoExame.removeAll(listaNula);

			listaSolicitacaoExameClone = new ArrayList<>();
			for (SolicitacaoExame especialidadeMedico : listaSolicitacaoExame) {
				listaSolicitacaoExameClone.add(cloneSolicitacaoExame(especialidadeMedico));
			}
		}
		return listaSolicitacaoExameClone;
	}

	public Medicamento cloneMedicamento(final Medicamento medicamento) {
		Medicamento medicamentoClone = null;
		if (AssertUtil.isNotNull(medicamento)) {
			medicamentoClone = new Medicamento();
			medicamentoClone.setCodigoMedicamento(medicamento.getCodigoMedicamento());
			medicamentoClone.setDataCriacao(medicamento.getDataCriacao());
			medicamentoClone.setTipoMedicamento(cloneTipoMedicamento(medicamento.getTipoMedicamento()));
			medicamentoClone.setUsoMedicamento(cloneUsoMedicamento(medicamento.getUsoMedicamento()));
			medicamentoClone.setDataUltimaAlteracao(medicamento.getDataUltimaAlteracao());
			medicamentoClone.setDescricaoMedicamento(medicamento.getDescricaoMedicamento());
			medicamentoClone.setFlagAtivo(medicamento.getFlagAtivo());
			medicamentoClone.setNomeMedicamento(medicamento.getNomeMedicamento());
			medicamentoClone.setComposicao(medicamento.getComposicao());
			medicamentoClone.setPosologia(medicamento.getPosologia());
			medicamentoClone.setUsuarioUltimaAlteracao(medicamento.getUsuarioUltimaAlteracao());

		}

		return medicamentoClone;
	}

	public Page<Medicamento> cloneListaMedicamento(final Page<Medicamento> listaMedicamento) {
		List<Medicamento> listaMedicamentoClone = null;
		PageImpl<Medicamento> listaRetorno = null;

		listaMedicamentoClone = new ArrayList<>();
		for (Medicamento medicamento : listaMedicamento.getContent()) {
			listaMedicamentoClone.add(cloneMedicamento(medicamento));
		}
		listaRetorno = new PageImpl<>(listaMedicamentoClone, listaMedicamento.getPageable(),
				listaMedicamento.getTotalElements());

		return listaRetorno;
	}

	public TipoMedicamento cloneTipoMedicamento(final TipoMedicamento tipoMedicamento) {
		TipoMedicamento tipoMedicamentoClone = null;
		if (AssertUtil.isNotNull(tipoMedicamento)) {
			tipoMedicamentoClone = new TipoMedicamento();
			tipoMedicamentoClone.setCodigoTipoMedicamento(tipoMedicamento.getCodigoTipoMedicamento());
			tipoMedicamentoClone.setDataCriacao(tipoMedicamento.getDataCriacao());
			tipoMedicamentoClone.setDataUltimaAlteracao(tipoMedicamento.getDataUltimaAlteracao());
			tipoMedicamentoClone.setDescricaoTipoMedicamento(tipoMedicamento.getDescricaoTipoMedicamento());
			tipoMedicamentoClone.setFlagAtivo(tipoMedicamento.getFlagAtivo());
			tipoMedicamentoClone.setNomeTipoMedicamento(tipoMedicamento.getNomeTipoMedicamento());
			tipoMedicamentoClone.setUsuarioUltimaAlteracao(tipoMedicamento.getUsuarioUltimaAlteracao());

		}

		return tipoMedicamentoClone;
	}

	public UsoMedicamento cloneUsoMedicamento(final UsoMedicamento usoMedicamento) {
		UsoMedicamento usoMedicamentoClone = null;
		if (AssertUtil.isNotNull(usoMedicamento)) {
			usoMedicamentoClone = new UsoMedicamento();
			usoMedicamentoClone.setCodigoUsoMedicamento(usoMedicamento.getCodigoUsoMedicamento());
			usoMedicamentoClone.setDataCriacao(usoMedicamento.getDataCriacao());
			usoMedicamentoClone.setDataUltimaAlteracao(usoMedicamento.getDataUltimaAlteracao());
			usoMedicamentoClone.setFlagAtivo(usoMedicamento.getFlagAtivo());
			usoMedicamentoClone.setNomeUsoMedicamento(usoMedicamento.getNomeUsoMedicamento());
			usoMedicamentoClone.setDescricaoUsoMedicamento(usoMedicamento.getDescricaoUsoMedicamento());
			usoMedicamentoClone.setUsuarioUltimaAlteracao(usoMedicamento.getUsuarioUltimaAlteracao());

		}
		return usoMedicamentoClone;
	}

	public SolicitacaoMedicamento cloneSolicitacaoMedicamento(final SolicitacaoMedicamento solicitacaoMedicamento) {
		SolicitacaoMedicamento solicitacaoMedicamentoClone = null;
		if (AssertUtil.isNotNull(solicitacaoMedicamento)) {
			solicitacaoMedicamentoClone = new SolicitacaoMedicamento();
			SolicitacaoMedicamentoPK cloneSolicitacaoMedicamentoPK = new SolicitacaoMedicamentoPK();
			cloneSolicitacaoMedicamentoPK
					.setCodigoConsulta(solicitacaoMedicamento.getSolicitacaoMedicamentoPK().getCodigoConsulta());
			cloneSolicitacaoMedicamentoPK.setCodigoSolicitacaoMedicamento(
					solicitacaoMedicamento.getSolicitacaoMedicamentoPK().getCodigoSolicitacaoMedicamento());
			solicitacaoMedicamentoClone.setSolicitacaoMedicamentoPK(cloneSolicitacaoMedicamentoPK);
			solicitacaoMedicamentoClone.setDataCriacao(solicitacaoMedicamento.getDataCriacao());
			solicitacaoMedicamentoClone
					.setDataSolicitacaoMedicamento(solicitacaoMedicamento.getDataSolicitacaoMedicamento());
			solicitacaoMedicamentoClone.setDataUltimaAlteracao(solicitacaoMedicamento.getDataUltimaAlteracao());
			solicitacaoMedicamentoClone.setFlagAtivo(solicitacaoMedicamento.getFlagAtivo());
			solicitacaoMedicamentoClone.setMedicamento(cloneMedicamento(solicitacaoMedicamento.getMedicamento()));
			solicitacaoMedicamentoClone.setUsuarioUltimaAlteracao(solicitacaoMedicamento.getUsuarioUltimaAlteracao());
		}

		return solicitacaoMedicamentoClone;
	}

	public List<SolicitacaoMedicamento> cloneListaSolicitacaoMedicamento(
			final List<SolicitacaoMedicamento> listaSolicitacaoMedicamento) {
		List<SolicitacaoMedicamento> listaSolicitacaoMedicamentoClone = null;
		if (AssertUtil.isNotEmptyList(listaSolicitacaoMedicamento)) {
			listaNula.add(null);
			listaSolicitacaoMedicamento.removeAll(listaNula);

			listaSolicitacaoMedicamentoClone = new ArrayList<>();
			for (SolicitacaoMedicamento especialidadeMedico : listaSolicitacaoMedicamento) {
				listaSolicitacaoMedicamentoClone.add(cloneSolicitacaoMedicamento(especialidadeMedico));
			}
		}
		return listaSolicitacaoMedicamentoClone;
	}
}
