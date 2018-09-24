package br.com.medclin.common;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Page;

import br.com.medclin.model.ContatoPessoa;
import br.com.medclin.model.ContatoPessoaPK;
import br.com.medclin.model.EnderecoPessoa;
import br.com.medclin.model.EnderecoPessoaPK;
import br.com.medclin.model.Estado;
import br.com.medclin.model.EstadoCivil;
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

	public Paciente clonePaciente(final Paciente paciente) {
		Paciente pacienteClone = null;
		if (paciente != null) {
			pacienteClone = new Paciente();

			pacienteClone.setCodigoPessoa(paciente.getCodigoPessoa());
			pacienteClone.setContatos(cloneListaContatoPessoa(paciente.getContatos()));
			pacienteClone.setDataCriacao(paciente.getDataCriacao());
			pacienteClone.setDataNascimento(paciente.getDataNascimento());
			pacienteClone.setDataUltimaAlteracao(paciente.getDataUltimaAlteracao());
			pacienteClone.setEnderecos(cloneListaEnderecoPessoa(paciente.getEnderecos()));
			pacienteClone.setEstadoCivil(cloneEstadoCivil(paciente.getEstadoCivil()));
			pacienteClone.setFlagAtivo(paciente.getFlagAtivo());
			pacienteClone.setInformacaoAdcional(paciente.getInformacaoAdcional());
			pacienteClone
					.setListaPlanoSaudePaciente(cloneListaPlanoSaudePaciente(paciente.getListaPlanoSaudePaciente()));
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

	public ContatoPessoa cloneContatoPessoa(final ContatoPessoa contatoPessoa) {
		ContatoPessoa contatoPessoaClone = null;
		ContatoPessoaPK contatoPessoaPKClone = null;
		if (contatoPessoa != null) {
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

	public TipoContato cloneTipoContato(final TipoContato tipoContato) {
		TipoContato tipoContatoClone = null;
		if (tipoContato != null) {
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

	public List<ContatoPessoa> cloneListaContatoPessoa(final List<ContatoPessoa> listaContatoPessoa) {
		List<ContatoPessoa> listaContatoPessoaClone = null;
		if (listaContatoPessoa != null && !listaContatoPessoa.isEmpty()) {
			listaNula.add(null);
			listaContatoPessoa.removeAll(listaNula);// remove objetos nulos retornados pela consulta.

			listaContatoPessoaClone = new ArrayList<>();
			for (ContatoPessoa contatoPessoa : listaContatoPessoa) {
				listaContatoPessoaClone.add(cloneContatoPessoa(contatoPessoa));
			}
		}
		return listaContatoPessoaClone;
	}

	public Estado cloneEstado(final Estado estado) {
		Estado estadoClone = null;
		if (estado != null) {
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

	public TipoLogradouro clonetipoLogradouro(final TipoLogradouro tipoLogradouro) {
		TipoLogradouro tipoLogradouroClone = null;
		if (tipoLogradouro != null) {
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

	public List<EnderecoPessoa> cloneListaEnderecoPessoa(final List<EnderecoPessoa> listaEnderecoPessoa) {
		List<EnderecoPessoa> listaEnderecoPessoaClone = null;
		if (AssertUtil.isNotEmptyList(listaEnderecoPessoa)) {
			listaNula.add(null);
			listaEnderecoPessoa.removeAll(listaNula);// remove objetos nulos retornados pela consulta.

			listaEnderecoPessoaClone = new ArrayList<>();
			for (EnderecoPessoa enderecoPessoa : listaEnderecoPessoa) {
				listaEnderecoPessoaClone.add(cloneEnderecoPessoa(enderecoPessoa));
			}
		}
		return listaEnderecoPessoaClone;
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

	public List<PlanoSaudePaciente> cloneListaPlanoSaudePaciente(
			final List<PlanoSaudePaciente> listaPlanoSaudePaciente) {
		List<PlanoSaudePaciente> listaPlanoSaudePacienteClone = null;
		if (AssertUtil.isNotEmptyList(listaPlanoSaudePaciente)) {
			listaNula.add(null);
			listaPlanoSaudePaciente.removeAll(listaNula);// remove objetos nulos retornados pela consulta.

			listaPlanoSaudePacienteClone = new ArrayList<>();
			for (PlanoSaudePaciente planoSaudePaciente : listaPlanoSaudePaciente) {
				listaPlanoSaudePacienteClone.add(clonePlanoSaudePaciente(planoSaudePaciente));
			}
		}
		return listaPlanoSaudePacienteClone;
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
