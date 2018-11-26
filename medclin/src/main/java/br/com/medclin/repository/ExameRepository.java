/*
 * 
 */
package br.com.medclin.repository;

import java.util.Date;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import br.com.medclin.model.Exame;

public interface ExameRepository
		extends JpaRepository<Exame, Short>, PagingAndSortingRepository<Exame, Short> {

	@Query(value = "SELECT exame FROM Exame exame WHERE exame.codigoExame = :codigoExame")
	Exame buscarExamePorCodigo(@Param("codigoExame") final Short codigoExame);

	@Query(value = "SELECT exame FROM Exame exame WHERE exame.nomeExame LIKE %:nomeExame%")
	Page<Exame> buscarExamePorNome(@Param("nomeExame") final String nomeExame,
			final Pageable page);
	
	@Query(value = "SELECT exame.dataCriacao FROM Exame exame WHERE exame.codigoExame = :codigoExame")
	Date buscarDataCriacaoPorCodigo(@Param("codigoExame") final Short codigoExame);
}
