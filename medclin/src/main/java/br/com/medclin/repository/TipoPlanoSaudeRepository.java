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

import br.com.medclin.model.TipoPlanoSaude;

public interface TipoPlanoSaudeRepository
		extends JpaRepository<TipoPlanoSaude, Short>, PagingAndSortingRepository<TipoPlanoSaude, Short> {

	@Query(value = "SELECT tPS FROM TipoPlanoSaude tPS WHERE tPS.codigoTipoPlano = :codigoTipoPlano")
	TipoPlanoSaude buscarTipoPlanoSaudePorCodigo(@Param("codigoTipoPlano") final Short codigoTipoPlano);

	@Query(value = "SELECT tPS FROM TipoPlanoSaude tPS WHERE tPS.nomeTipoPlano LIKE %:nomeTipoPlano%")
	Page<TipoPlanoSaude> buscarTipoPlanoSaudePorNome(@Param("nomeTipoPlano") final String nomeTipoPlano,
			final Pageable page);
}
