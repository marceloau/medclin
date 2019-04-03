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

import br.com.medclin.model.SolicitacaoMedicamento;
import br.com.medclin.model.SolicitacaoMedicamentoPK;

public interface SolicitacaoMedicamentoRepository
		extends JpaRepository<SolicitacaoMedicamento, SolicitacaoMedicamentoPK>, PagingAndSortingRepository<SolicitacaoMedicamento, SolicitacaoMedicamentoPK> {

	@Query(value = "SELECT solicitacaoMedicamento FROM SolicitacaoMedicamento solicitacaoMedicamento WHERE solicitacaoMedicamento.consulta.paciente.codigoPessoa = :codigoPaciente")
	Page<SolicitacaoMedicamento> listarSolicitacaoMedicamentoCodigoPaciente(@Param("codigoPaciente") final BigInteger codigoPaciente,
			final Pageable page);
	
	@Query(value = "SELECT COUNT (solicitacaoMedicamento) FROM SolicitacaoMedicamento solicitacaoMedicamento WHERE solicitacaoMedicamento.consulta.codigoConsulta = :codigoConsulta")
	Short buscarMaxSolicitacaoMedicamentoConsulta(@Param("codigoConsulta") final BigInteger codigoConsulta);
	
	@Query(value = "SELECT COUNT (solicitacaoMedicamento) FROM SolicitacaoMedicamento solicitacaoMedicamento "
			+ "WHERE solicitacaoMedicamento.consulta.codigoConsulta = :codigoConsulta AND solicitacaoMedicamento.medicamento.codigoMedicamento = :codigoMedicamento")
	Integer countSoliciMedPorConsulMed(@Param("codigoConsulta") final BigInteger codigoConsulta, @Param("codigoMedicamento") final Short codigoMedicamento);
	
	@Query(value = "SELECT solicitacaoMedicamento FROM SolicitacaoMedicamento solicitacaoMedicamento "
			+ "WHERE solicitacaoMedicamento.consulta.codigoConsulta = :codigoConsulta AND solicitacaoMedicamento.medicamento.codigoMedicamento = :codigoMedicamento")
	SolicitacaoMedicamento buscarSoliciMedPorConsulMedicamento(@Param("codigoConsulta") final BigInteger codigoConsulta, @Param("codigoMedicamento") final Short codigoMedicamento);
	
	@Query(value = "SELECT solicitacaoMedicamento FROM SolicitacaoMedicamento solicitacaoMedicamento "
			+ "WHERE solicitacaoMedicamento.consulta.paciente.codigoPessoa = :codigoPessoa ")
	List<SolicitacaoMedicamento> buscarSoliciMedPorCodigoPaciente(@Param("codigoPessoa") final BigInteger codigoPessoa);
}
