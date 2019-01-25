/*
 * 
 */
package br.com.medclin.repository;

import java.math.BigInteger;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import br.com.medclin.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, BigInteger>, PagingAndSortingRepository<Usuario, BigInteger> {
	
	@Query(value = "SELECT usuario FROM Usuario usuario WHERE usuario.codigoUsuario = :codigoUsuario")
	Usuario buscarUsuarioPorCodigoPessoa(@Param("codigoUsuario") final BigInteger codigoUsuario);

	@Query(value = "SELECT usuario FROM Usuario usuario WHERE usuario.email LIKE %:nome%")
	Page<Usuario> buscarUsuarioPorNome(@Param("nome") final String nome,
			final Pageable page);
	
	@Query(value = "SELECT usuario FROM Usuario usuario WHERE usuario.email LIKE %:email%")
	Usuario buscarUsuarioPorEmail(@Param("email") final String email);

	@Query(value = "SELECT usuario FROM Usuario usuario WHERE usuario.login LIKE :login")
	Usuario buscarUsuarioPorLogin(@Param("login") final String login);
	
}