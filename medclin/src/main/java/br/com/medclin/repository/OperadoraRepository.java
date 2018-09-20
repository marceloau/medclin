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

import br.com.medclin.model.Operadora;

public interface OperadoraRepository
		extends JpaRepository<Operadora, Short>, PagingAndSortingRepository<Operadora, Short> {

	@Query(value = "SELECT o FROM Operadora o WHERE o.codigoOperadora = :codigoOperadora")
	Operadora buscarOperadoraPorCodigo(@Param("codigoOperadora") final Short codigoOperadora);

	@Query(value = "SELECT o FROM Operadora o WHERE o.codigoOficial = :codigoOficial")
	Page<Operadora> buscarOperadoraPorCodigoOficial(@Param("codigoOficial") final Integer codigoOficial);

	@Query(value = "SELECT o FROM Operadora o WHERE o.nomeOperadora LIKE %:nomeOperadora%")
	Page<Operadora> buscarOperadoraPorNome(@Param("nomeOperadora") final String nomeOperadora, final Pageable page);

	@Query(value = "SELECT o.dataCriacao FROM Operadora o WHERE o.codigoOperadora = :codigoOperadora")
	Date buscarDataCriacaoPorCodigo(@Param("codigoOperadora") final Short codigoOperadora);
}
