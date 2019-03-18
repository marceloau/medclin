package br.com.medclin.model;

import java.math.BigInteger;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import br.com.medclin.common.PerfilEnum;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@SequenceGenerator(name = "USUARIO_SEQ", sequenceName = "USUARIO_SEQ", allocationSize = 1)
public class Usuario implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public Usuario() {}
	
	public Usuario(BigInteger codigoUsuario, String email, String login, String senha, Pessoa pessoa, Set<PerfilEnum> perfis) {
		super();
		this.codigoUsuario = codigoUsuario;
		this.email = email;
		this.login = login;
		this.pessoa = pessoa;
		this.senha = senha;
		this.perfis = perfis.stream().map(perfilRetorno -> perfilRetorno.getCodigo()).collect(Collectors.toSet());
	}
	
	public Usuario(Usuario usuario) {
		this.codigoUsuario = usuario.getCodigoUsuario();
		this.email = usuario.getEmail();
		this.login = usuario.getLogin();
		this.pessoa = usuario.getPessoa();
		this.senha = usuario.getSenha();
		this.perfis = usuario.getPerfis().stream().map(perfilRetorno -> perfilRetorno.getCodigo()).collect(Collectors.toSet());
		this.flagAtivo = usuario.getFlagAtivo();
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USUARIO_SEQ")
	@Column(name = "codigo_usuario", nullable = false, updatable = false, precision = 22, scale = 0)
	private BigInteger codigoUsuario;
	
	@Column(unique=true, nullable = false)
	private String email;
	
	@Column(unique=true, nullable = false)
	private String login;
	
	@Column(nullable = false)
	private String senha;
	
	@OneToOne
	@JoinColumn(name = "codigo_pessoa", referencedColumnName = "codigo_pessoa", insertable = true, updatable = true)
	private Pessoa pessoa;
	
	@ElementCollection(fetch=FetchType.EAGER)
	@CollectionTable(name="GrupoAcesso")
	private Set<Integer> perfis = new HashSet<>();
	
	private String flagAtivo;

	private String usuarioUltimaAlteracao;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dataUltimaAlteracao;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dataCriacao;

	public BigInteger getCodigoUsuario() {
		return codigoUsuario;
	}

	public void setCodigoUsuario(BigInteger codigoUsuario) {
		this.codigoUsuario = codigoUsuario;
	}

	public Set<PerfilEnum> getPerfis() {
		return perfis.stream().map(perfilRetorno -> PerfilEnum.toEnum(perfilRetorno)).collect(Collectors.toSet());
	}

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

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
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
	
	public boolean hasRole(PerfilEnum perfil) {
		return this.perfis.contains(perfil.getCodigo());
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
	}

	@Override
	public String getPassword() {
		return senha;
	}

	@Override
	public String getUsername() {
		return login;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
	
}
