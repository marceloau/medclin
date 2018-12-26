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

import br.com.medclin.model.SolicitacaoExame;
import br.com.medclin.model.SolicitacaoExamePK;

public interface SolicitacaoExameRepository
		extends JpaRepository<SolicitacaoExame, SolicitacaoExamePK>, PagingAndSortingRepository<SolicitacaoExame, SolicitacaoExamePK> {
	
	@Query(value = "SELECT solicitacaoExame FROM SolicitacaoExame solicitacaoExame WHERE solicitacaoExame.consulta.paciente.codigoPessoa = :codigoPaciente")
	Page<SolicitacaoExame> listarSolicitacaoExameCodigoPaciente(@Param("codigoPaciente") final BigInteger codigoPaciente,
			final Pageable page);
}
