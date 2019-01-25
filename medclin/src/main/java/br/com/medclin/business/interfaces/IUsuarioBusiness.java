/*
 * 
 */
package br.com.medclin.business.interfaces;

import java.math.BigInteger;

import org.springframework.data.domain.Page;

import br.com.medclin.model.Usuario;

/**
 * Interface do business de parametro de configuracao.
 * 
 * @author henrique araujo
 */
public interface IUsuarioBusiness {

	/**
	 * Busca usuario por nome.
	 *
	 * @param page          the page
	 * @param size          the size
	 * @param nomeParametro the nome parametro
	 * @return the iterable
	 */
	public Page<Usuario> buscaUsuarioPorNome(final Integer page, final Integer size,
			final String nomeParametro);
	
	/**
	 * Busca usuario por nome.
	 *
	 * @param email
	 * @return Usuario
	 */
	public Usuario buscaUsuarioPorEmail(final String email);
	
	/**
	 * Busca usuario por login.
	 *
	 * @param login
	 * @return Usuario
	 */
	public Usuario buscaUsuarioPorLogin(final String login);
	
	/**
	 * Busca usuario por Codigo.
	 *
	 * @param login BigInteger
	 * @return Usuario Usuario
	 */
	public Usuario buscaUsuarioPorCodigo(final BigInteger codigo);

	/**
	 * Listar usuario.
	 *
	 * @return the iterable
	 */
	public Page<Usuario> listarUsuario();

}
