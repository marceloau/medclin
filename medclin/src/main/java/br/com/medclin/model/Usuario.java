package br.com.medclin.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@PrimaryKeyJoinColumn(name = "codigo_pessoa")
public class Usuario extends Pessoa{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(unique=true)
	private String email;
	
	@Column(unique=true)
	private String login;
	
	@JsonIgnore
	private String senha;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
	
}
