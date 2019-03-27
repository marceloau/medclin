/*
 * 
 */
package br.com.medclin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.medclin.model.FormularioImpressao;

public interface FormularioImpressaoRepository extends JpaRepository<FormularioImpressao, Integer> {

	@Query(value = "SELECT formulario FROM FormularioImpressao formulario WHERE " + "formulario.codigoFormularioImpressao = :codigoFormularioImpressao ")
	FormularioImpressao buscarPorCodigo(@Param("codigoFormularioImpressao") final Integer codigoFormularioImpressao);
	
//	@Query(value = "SELECT formulario FROM FormularioImpressao formulario WHERE " + "formulario.nomeJasper like :nomeJasper ")
//	FormularioImpressao buscarPorNomeJasper(@Param("nomejasper") final String nomejasper);

}