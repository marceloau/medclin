/*
 * 
 */
package br.com.medclin.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.medclin.model.AgendaMedico;
import br.com.medclin.model.AgendaMedicoPK;

public interface AgendaMedicoRepository extends JpaRepository<AgendaMedico, AgendaMedicoPK> {

	@Query(value = "SELECT a.dataCriacao FROM AgendaMedico a WHERE " + "a.agendaMedicoPK = :agendaMedicoPK ")
	Date buscarDataCriacaoPorCodigo(@Param("agendaMedicoPK") final AgendaMedicoPK agendaMedicoPK);

}