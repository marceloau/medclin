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

import br.com.medclin.model.TipoExame;

public interface TipoExameRepository
		extends JpaRepository<TipoExame, Short>, PagingAndSortingRepository<TipoExame, Short> {

	@Query(value = "SELECT tE FROM TipoExame tE WHERE tE.codigoTipoExame = :codigoTipoExame")
	TipoExame buscarTipoExamePorCodigo(@Param("codigoTipoExame") final Short codigoTipoExame);

	@Query(value = "SELECT tE FROM TipoExame tE WHERE tE.nomeTipoExame LIKE %:nomeTipoExame%")
	Page<TipoExame> buscarTipoExamePorNome(@Param("nomeTipoExame") final String nomeTipoExame,
			final Pageable page);

	@Query(value = "SELECT tE.dataCriacao FROM TipoExame tE WHERE tE.codigoTipoExame = :codigoTipoExame")
	Date buscarDataCriacaoPorCodigo(@Param("codigoTipoExame") final Short codigoTipoExame);
}
