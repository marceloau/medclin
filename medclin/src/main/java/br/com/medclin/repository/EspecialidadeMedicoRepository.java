/*
 * 
 */
package br.com.medclin.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.medclin.model.EspecialidadeMedico;
import br.com.medclin.model.EspecialidadeMedicoPK;

public interface EspecialidadeMedicoRepository extends JpaRepository<EspecialidadeMedico, EspecialidadeMedicoPK> {

	@Query(value = "SELECT e.dataCriacao FROM EspecialidadeMedico e WHERE "
			+ "e.especialidadeMedicoPK = :especialidadeMedicoPK ")
	Date buscarDataCriacaoPorCodigo(@Param("especialidadeMedicoPK") final EspecialidadeMedicoPK especialidadeMedicoPK);

}