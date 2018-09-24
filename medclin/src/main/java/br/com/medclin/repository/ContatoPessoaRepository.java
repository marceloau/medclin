/*
 * 
 */
package br.com.medclin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.medclin.model.ContatoPessoa;
import br.com.medclin.model.ContatoPessoaPK;

public interface ContatoPessoaRepository extends JpaRepository<ContatoPessoa, ContatoPessoaPK> {

}