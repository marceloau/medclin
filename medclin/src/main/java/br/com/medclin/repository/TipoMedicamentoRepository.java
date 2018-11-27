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

import br.com.medclin.model.TipoMedicamento;

public interface TipoMedicamentoRepository
		extends JpaRepository<TipoMedicamento, Short>, PagingAndSortingRepository<TipoMedicamento, Short> {

	@Query(value = "SELECT tE FROM TipoMedicamento tE WHERE tE.codigoTipoMedicamento = :codigoTipoMedicamento")
	TipoMedicamento buscarTipoMedicamentoPorCodigo(@Param("codigoTipoMedicamento") final Short codigoTipoMedicamento);

	@Query(value = "SELECT tE FROM TipoMedicamento tE WHERE tE.nomeTipoMedicamento LIKE %:nomeTipoMedicamento%")
	Page<TipoMedicamento> buscarTipoMedicamentoPorNome(@Param("nomeTipoMedicamento") final String nomeTipoMedicamento,
			final Pageable page);

	@Query(value = "SELECT tE.dataCriacao FROM TipoMedicamento tE WHERE tE.codigoTipoMedicamento = :codigoTipoMedicamento")
	Date buscarDataCriacaoPorCodigo(@Param("codigoTipoMedicamento") final Short codigoTipoMedicamento);
}
