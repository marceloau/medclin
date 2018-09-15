/*
 * 
 */
package br.com.medclin.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.medclin.model.ParametroConfiguracao;

/**
 * The Interface ParametroConfiguracaoRepository.
 * 
 * @author henrique araujo
 */
public interface ParametroConfiguracaoRepository extends JpaRepository<ParametroConfiguracao, Long> {

	/**
	 * Buscar parametro por nome.
	 *
	 * @param nomeParametro the nome parametro
	 * @param page          the page
	 * @return the list
	 */
	@Query(value = "SELECT pC FROM ParametroConfiguracao pC WHERE pC.nomeParametro LIKE %:nomeParametro%")
	List<ParametroConfiguracao> buscarParametroPorNome(@Param("nomeParametro") final String nomeParametro,
			final Pageable page);

	/**
	 * Quantidade total parametro.
	 *
	 * @return the long
	 */
	@Query(value = "SELECT COUNT(pC.codigoParametro) FROM ParametroConfiguracao pC")
	Long quantidadeTotalParametro();

}
