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

import br.com.medclin.model.TipoContato;

public interface TipoContatoRepository
		extends JpaRepository<TipoContato, Short>, PagingAndSortingRepository<TipoContato, Short> {

	@Query(value = "SELECT tC FROM TipoContato tC WHERE tC.codigoTipoContato = :codigoTipoContato")
	Iterable<TipoContato> buscarTipoContatoPorCodigo(@Param("codigoTipoContato") final Short codigoTipoContato);

	@Query(value = "SELECT tC FROM TipoContato tC WHERE tC.nomeTipoContato LIKE %:nomeTipoContato%")
	Page<TipoContato> buscarTipoContatoPorNome(@Param("nomeTipoContato") final String nomeTipoContato,
			final Pageable page);
}
