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

import br.com.medclin.model.Exame;
import br.com.medclin.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, BigInteger>, PagingAndSortingRepository<Usuario, BigInteger> {
	
	@Query(value = "SELECT usuario FROM Usuario usuario WHERE usuario.codigoPessoa = :codigoPessoa")
	Exame buscarUsuarioPorCodigo(@Param("codigoPessoa") final Short codigoPessoa);

	@Query(value = "SELECT usuario FROM Usuario usuario WHERE usuario.nome LIKE %:nome%")
	Page<Exame> buscarUsuarioPorNome(@Param("nome") final String nome,
			final Pageable page);
	
	@Query(value = "SELECT usuario FROM Usuario usuario WHERE usuario.email LIKE %:email%")
	Exame buscarUsuarioPorEmail(@Param("email") final String email,
			final Pageable page);

	@Query(value = "SELECT usuario FROM Usuario usuario WHERE usuario.login LIKE :login")
	Exame buscarUsuarioPorLogin(@Param("login") final String login);
	
}