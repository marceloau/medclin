package br.com.medclin.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.validation.constraints.NotNull;

@Entity
@PrimaryKeyJoinColumn(name = "codigo_pessoa")
public class Paciente extends Pessoa {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String numeroCartaoSUS;

	private String nomeProfissao;

	private String nomePai;

	@NotNull(message = "Nome da mãe não informada!")
	private String nomeMae;

	@OneToMany(mappedBy = "paciente")
	@OrderColumn(name = "codigo_plano_saude_paciente", insertable = false, updatable = false)
	private List<PlanoSaudePaciente> listaPlanoSaudePaciente;

	public String getNumeroCartaoSUS() {
		return numeroCartaoSUS;
	}

	public void setNumeroCartaoSUS(String numeroCartaoSUS) {
		this.numeroCartaoSUS = numeroCartaoSUS;
	}

	public String getNomeProfissao() {
		return nomeProfissao;
	}

	public void setNomeProfissao(String nomeProfissao) {
		this.nomeProfissao = nomeProfissao;
	}

	public String getNomePai() {
		return nomePai;
	}

	public void setNomePai(String nomePai) {
		this.nomePai = nomePai;
	}

	public String getNomeMae() {
		return nomeMae;
	}

	public void setNomeMae(String nomeMae) {
		this.nomeMae = nomeMae;
	}

	public List<PlanoSaudePaciente> getListaPlanoSaudePaciente() {
		return listaPlanoSaudePaciente;
	}

	public void setListaPlanoSaudePaciente(List<PlanoSaudePaciente> listaPlanoSaudePaciente) {
		this.listaPlanoSaudePaciente = listaPlanoSaudePaciente;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((listaPlanoSaudePaciente == null) ? 0 : listaPlanoSaudePaciente.hashCode());
		result = prime * result + ((nomeMae == null) ? 0 : nomeMae.hashCode());
		result = prime * result + ((nomePai == null) ? 0 : nomePai.hashCode());
		result = prime * result + ((nomeProfissao == null) ? 0 : nomeProfissao.hashCode());
		result = prime * result + ((numeroCartaoSUS == null) ? 0 : numeroCartaoSUS.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Paciente other = (Paciente) obj;
		if (listaPlanoSaudePaciente == null) {
			if (other.listaPlanoSaudePaciente != null)
				return false;
		} else if (!listaPlanoSaudePaciente.equals(other.listaPlanoSaudePaciente))
			return false;
		if (nomeMae == null) {
			if (other.nomeMae != null)
				return false;
		} else if (!nomeMae.equals(other.nomeMae))
			return false;
		if (nomePai == null) {
			if (other.nomePai != null)
				return false;
		} else if (!nomePai.equals(other.nomePai))
			return false;
		if (nomeProfissao == null) {
			if (other.nomeProfissao != null)
				return false;
		} else if (!nomeProfissao.equals(other.nomeProfissao))
			return false;
		if (numeroCartaoSUS == null) {
			if (other.numeroCartaoSUS != null)
				return false;
		} else if (!numeroCartaoSUS.equals(other.numeroCartaoSUS))
			return false;
		return true;
	}

}
