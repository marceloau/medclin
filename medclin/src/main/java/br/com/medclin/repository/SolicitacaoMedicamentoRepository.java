/*
 * 
 */
package br.com.medclin.repository;

import java.math.BigInteger;

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
}
