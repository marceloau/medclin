/*
 * 
 */
package br.com.medclin.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import br.com.medclin.model.Especialidade;

public interface EspecialidadeRepository
		extends JpaRepository<Especialidade, Short>, PagingAndSortingRepository<Especialidade, Short> {

	@Query(value = "SELECT e FROM Especialidade e WHERE e.codigoEspecialidade = :codigoEspecialidade")
	Iterable<Especialidade> buscarEspecialidadePorCodigo(@Param("codigoEspecialidade") final Short codigoEspecialidade);

	@Query(value = "SELECT e FROM Especialidade e WHERE e.nomeEspecialidade LIKE %:nomeEspecialidade%")
	Page<Especialidade> buscarEspecialidadePorNome(@Param("nomeEspecialidade") final String nomeEspecialidade,
			final Pageable page);
}
