package br.com.medclin.common;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Configuration;

import br.com.medclin.model.ContatoPessoa;
import br.com.medclin.model.ContatoPessoaPK;
import br.com.medclin.model.Estado;
import br.com.medclin.model.EstadoCivil;
import br.com.medclin.model.Paciente;
import br.com.medclin.model.TipoContato;
import br.com.medclin.model.TipoLogradouro;

@Configuration
public class CloneUtil {

	public Paciente clonePaciente(final Paciente paciente) {
		Paciente pacienteClone = null;
		if (paciente != null) {
			pacienteClone = new Paciente();

			pacienteClone.setCodigoPessoa(paciente.getCodigoPessoa());
			pacienteClone.setContatos(cloneListaContatoPessoa(paciente.getContatos()));
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
			ArrayList<Object> listaNula = new ArrayList<>();
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

}
