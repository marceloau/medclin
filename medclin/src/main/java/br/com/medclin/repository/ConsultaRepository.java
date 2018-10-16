/*
 * 
 */
package br.com.medclin.repository;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import br.com.medclin.model.Consulta;

public interface ConsultaRepository
		extends JpaRepository<Consulta, BigInteger>, PagingAndSortingRepository<Consulta, BigInteger> {
}