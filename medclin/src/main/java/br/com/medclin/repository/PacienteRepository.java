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

import br.com.medclin.model.Paciente;

public interface PacienteRepository
		extends JpaRepository<Paciente, Long>, PagingAndSortingRepository<Paciente, Long> {

	@Query(value = "SELECT p FROM Paciente p WHERE p.codigoPessoa = :codigoPaciente")
	Paciente buscarPacientePorCodigo(@Param("codigoPaciente") final Long codigoPaciente);

	@Query(value = "SELECT p FROM Paciente p WHERE p.nomePessoa LIKE %:nomePaciente%")
	Page<Paciente> buscarPacientePorNome(@Param("nomePaciente") final String nomePaciente,
			final Pageable page);

	@Query(value = "SELECT p.dataCriacao FROM Paciente p WHERE p.codigoPessoa = :codigoPaciente")
	Date buscarDataCriacaoPorCodigo(@Param("codigoPaciente") final Long codigoPaciente);

}