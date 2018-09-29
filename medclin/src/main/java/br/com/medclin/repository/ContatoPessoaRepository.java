/*
 * 
 */
package br.com.medclin.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.medclin.model.ContatoPessoa;
import br.com.medclin.model.ContatoPessoaPK;

public interface ContatoPessoaRepository extends JpaRepository<ContatoPessoa, ContatoPessoaPK> {

	@Query(value = "SELECT c.dataCriacao FROM ContatoPessoa c WHERE " + "c.contatoPessoaPK = :contatoPessoaPK ")
	Date buscarDataCriacaoPorCodigo(@Param("contatoPessoaPK") final ContatoPessoaPK contatoPessoaPK);

}