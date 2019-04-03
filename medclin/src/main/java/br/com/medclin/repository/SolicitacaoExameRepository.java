/*
 * 
 */
package br.com.medclin.repository;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import br.com.medclin.model.SolicitacaoExame;
import br.com.medclin.model.SolicitacaoExamePK;

public interface SolicitacaoExameRepository
		extends JpaRepository<SolicitacaoExame, SolicitacaoExamePK>, PagingAndSortingRepository<SolicitacaoExame, SolicitacaoExamePK> {
	
	@Query(value = "SELECT solicitacaoExame FROM SolicitacaoExame solicitacaoExame WHERE solicitacaoExame.consulta.paciente.codigoPessoa = :codigoPaciente")
	Page<SolicitacaoExame> listarSolicitacaoExameCodigoPaciente(@Param("codigoPaciente") final BigInteger codigoPaciente,
			final Pageable page);
	
	@Query(value = "SELECT COUNT (solicitacaoExame) FROM SolicitacaoExame solicitacaoExame WHERE solicitacaoExame.consulta.codigoConsulta = :codigoConsulta")
	Short buscarMaxSolicitacaoExameConsulta(@Param("codigoConsulta") final BigInteger codigoConsulta);
	
	@Query(value = "SELECT COUNT (solicitacaoExame) FROM SolicitacaoExame solicitacaoExame WHERE solicitacaoExame.consulta.codigoConsulta = :codigoConsulta AND solicitacaoExame.exame.codigoExame = :codigoExame ")
	Integer countSoliciExamePorConsulExame(@Param("codigoConsulta") final BigInteger codigoConsulta, @Param("codigoExame") final Short codigoExame);
	
	@Query(value = "SELECT solicitacaoExame FROM SolicitacaoExame solicitacaoExame WHERE solicitacaoExame.consulta.codigoConsulta = :codigoConsulta AND solicitacaoExame.exame.codigoExame = :codigoExame ")
	SolicitacaoExame buscarSoliciExamePorConsulExame(@Param("codigoConsulta") final BigInteger codigoConsulta, @Param("codigoExame") final Short codigoExame);
	
	@Query(value = "SELECT solicitacaoExame FROM SolicitacaoExame solicitacaoExame WHERE solicitacaoExame.consulta.paciente.codigoPessoa = :codigoPessoa ")
	List<SolicitacaoExame> buscarSoliciExamePorCodigoPaciente(@Param("codigoPessoa") final BigInteger codigoPessoa);
}
