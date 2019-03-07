/*
 * 
 */
package br.com.medclin.repository;

import java.math.BigInteger;
import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import br.com.medclin.model.Consulta;

public interface ConsultaRepository
		extends JpaRepository<Consulta, BigInteger>, PagingAndSortingRepository<Consulta, BigInteger> {

	@Query(value = "SELECT c FROM Consulta c WHERE c.codigoConsulta = :codigoConsulta")
	Consulta buscarConsultaPorCodigo(@Param("codigoConsulta") final BigInteger codigoConsulta);
	
	boolean existsByDataConsultaAndOrdemChegada(final Date dataConsulta, final Integer ordemChegada);
	
	@Query(value = "SELECT c.dataCriacao FROM Consulta c WHERE c.codigoConsulta = :codigoConsulta")
	Date buscarDataCriacaoPorCodigo(@Param("codigoConsulta") final BigInteger codigoConsulta);
	
	@Query(value = "SELECT COUNT (c) FROM Consulta c")
	BigInteger totalConsultas();
}