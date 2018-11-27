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

import br.com.medclin.model.Medicamento;

public interface MedicamentoRepository
		extends JpaRepository<Medicamento, Short>, PagingAndSortingRepository<Medicamento, Short> {

	@Query(value = "SELECT medicamento FROM Medicamento medicamento WHERE medicamento.codigoMedicamento = :codigoMedicamento")
	Medicamento buscarMedicamentoPorCodigo(@Param("codigoMedicamento") final Short codigoMedicamento);

	@Query(value = "SELECT medicamento FROM Medicamento medicamento WHERE medicamento.nomeMedicamento LIKE %:nomeMedicamento%")
	Page<Medicamento> buscarMedicamentoPorNome(@Param("nomeMedicamento") final String nomeMedicamento,
			final Pageable page);

	@Query(value = "SELECT medicamento.dataCriacao FROM Medicamento medicamento WHERE medicamento.codigoMedicamento = :codigoMedicamento")
	Date buscarDataCriacaoPorCodigo(@Param("codigoMedicamento") final Short codigoMedicamento);
}
