package br.com.medclin.model.ebo;

public class PacienteEBO {

	private String nomePaciente;
	private String nomeMae;
	private String numeroRg;
	private String numeroCpf;
	private String numeroCartaoSUS;
	private Short codigoTipoPlano;
	private String textoContato;

	public String getNomePaciente() {
		return nomePaciente;
	}

	public void setNomePaciente(String nomePaciente) {
		this.nomePaciente = nomePaciente;
	}

	public String getNomeMae() {
		return nomeMae;
	}

	public void setNomeMae(String nomeMae) {
		this.nomeMae = nomeMae;
	}

	public String getNumeroRg() {
		return numeroRg;
	}

	public void setNumeroRg(String numeroRg) {
		this.numeroRg = numeroRg;
	}

	public String getNumeroCpf() {
		return numeroCpf;
	}

	public void setNumeroCpf(String numeroCpf) {
		this.numeroCpf = numeroCpf;
	}

	public String getNumeroCartaoSUS() {
		return numeroCartaoSUS;
	}

	public void setNumeroCartaoSUS(String numeroCartaoSUS) {
		this.numeroCartaoSUS = numeroCartaoSUS;
	}

	public Short getCodigoTipoPlano() {
		return codigoTipoPlano;
	}

	public void setCodigoTipoPlano(Short codigoTipoPlano) {
		this.codigoTipoPlano = codigoTipoPlano;
	}

	public String getTextoContato() {
		return textoContato;
	}

	public void setTextoContato(String textoContato) {
		this.textoContato = textoContato;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigoTipoPlano == null) ? 0 : codigoTipoPlano.hashCode());
		result = prime * result + ((nomeMae == null) ? 0 : nomeMae.hashCode());
		result = prime * result + ((nomePaciente == null) ? 0 : nomePaciente.hashCode());
		result = prime * result + ((numeroCartaoSUS == null) ? 0 : numeroCartaoSUS.hashCode());
		result = prime * result + ((numeroCpf == null) ? 0 : numeroCpf.hashCode());
		result = prime * result + ((numeroRg == null) ? 0 : numeroRg.hashCode());
		result = prime * result + ((textoContato == null) ? 0 : textoContato.hashCode());
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
		PacienteEBO other = (PacienteEBO) obj;
		if (codigoTipoPlano == null) {
			if (other.codigoTipoPlano != null)
				return false;
		} else if (!codigoTipoPlano.equals(other.codigoTipoPlano))
			return false;
		if (nomeMae == null) {
			if (other.nomeMae != null)
				return false;
		} else if (!nomeMae.equals(other.nomeMae))
			return false;
		if (nomePaciente == null) {
			if (other.nomePaciente != null)
				return false;
		} else if (!nomePaciente.equals(other.nomePaciente))
			return false;
		if (numeroCartaoSUS == null) {
			if (other.numeroCartaoSUS != null)
				return false;
		} else if (!numeroCartaoSUS.equals(other.numeroCartaoSUS))
			return false;
		if (numeroCpf == null) {
			if (other.numeroCpf != null)
				return false;
		} else if (!numeroCpf.equals(other.numeroCpf))
			return false;
		if (numeroRg == null) {
			if (other.numeroRg != null)
				return false;
		} else if (!numeroRg.equals(other.numeroRg))
			return false;
		if (textoContato == null) {
			if (other.textoContato != null)
				return false;
		} else if (!textoContato.equals(other.textoContato))
			return false;
		return true;
	}

}
