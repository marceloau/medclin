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

import br.com.medclin.model.Paciente;

public interface PacienteRepository
		extends JpaRepository<Paciente, BigInteger>, PagingAndSortingRepository<Paciente, BigInteger> {

	@Query(value = "SELECT p FROM Paciente p WHERE p.codigoPessoa = :codigoPaciente")
	Paciente buscarPacientePorCodigo(@Param("codigoPaciente") final BigInteger codigoPaciente);

	@Query(value = " SELECT p1 FROM Paciente p1"
			+ "	WHERE p1 IN("
			+ " SELECT DISTINCT(p.codigoPessoa) FROM Paciente p "
			+ " LEFT JOIN p.listaPlanoSaudePaciente lPS"
			+ "	LEFT JOIN lPS.tipoPlanoSaude tP"
			+ "	LEFT JOIN p.contatos c"
			+ " WHERE p.nomePessoa LIKE %:nomePaciente%"
			+ " OR p.nomeMae LIKE %:nomeMae%"
			+ " OR p.numeroRg LIKE :numeroRg"
			+ " OR p.numeroCpf LIKE :numeroCpf"
			+ " OR p.numeroCartaoSUS LIKE :numeroCartaoSUS"
			+ " OR tP.codigoTipoPlano LIKE :codigoTipoPlano"
			+ " OR c.textoContato LIKE %:textoContato%)"
			+ "	ORDER BY p1.codigoPessoa ASC")
	Page<Paciente> buscarPaciente(final Pageable page, @Param("nomePaciente") final String nomePaciente,
			@Param("nomeMae") final String nomeMae, @Param("numeroRg") final String numeroRg,
			@Param("numeroCpf") final String numeroCpf, @Param("numeroCartaoSUS") final String numeroCartaoSUS,
			@Param("codigoTipoPlano") final Short codigoTipoPlano, @Param("textoContato") final String textoContato);

	@Query(value = "SELECT p.dataCriacao FROM Paciente p WHERE p.codigoPessoa = :codigoPaciente")
	Date buscarDataCriacaoPorCodigo(@Param("codigoPaciente") final BigInteger codigoPaciente);

}