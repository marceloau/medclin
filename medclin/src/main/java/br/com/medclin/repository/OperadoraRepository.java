/*
 * 
 */
package br.com.medclin.repository;

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
	Iterable<Operadora> buscarOperadoraPorCodigoOficial(@Param("codigoOficial") final Integer codigoOficial);

	@Query(value = "SELECT o FROM Operadora o WHERE o.nomeOperadora LIKE %:nomeOperadora%")
	Page<Operadora> buscarOperadoraPorNome(@Param("nomeOperadora") final String nomeOperadora,
			final Pageable page);
}
