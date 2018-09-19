/*
 * 
 */
package br.com.medclin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import br.com.medclin.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long>, PagingAndSortingRepository<Pessoa, Long> {

}