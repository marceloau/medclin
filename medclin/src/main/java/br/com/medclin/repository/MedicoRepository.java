/*
 * 
 */
package br.com.medclin.repository;

import java.math.BigInteger;
import java.util.Date;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import br.com.medclin.model.Medico;

public interface MedicoRepository extends JpaRepository<Medico, BigInteger>, PagingAndSortingRepository<Medico, BigInteger> {

	@Query(value = "SELECT m FROM Medico m WHERE m.codigoPessoa = :codigoMedico")
	Medico buscarMedicoPorCodigo(@Param("codigoMedico") final BigInteger codigoMedico);

	@Query(value = "SELECT m FROM Medico m WHERE m.nomePessoa LIKE %:nomeMedico%")
	Page<Medico> buscarMedicoPorNome(@Param("nomeMedico") final String nomeMedico, final Pageable page);

	@Query(value = "SELECT m.dataCriacao FROM Medico m WHERE m.codigoPessoa = :codigoMedico")
	Date buscarDataCriacaoPorCodigo(@Param("codigoMedico") final BigInteger codigoMedico);

}