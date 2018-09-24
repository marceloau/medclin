/*
 * 
 */
package br.com.medclin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.medclin.model.EnderecoPessoa;
import br.com.medclin.model.EnderecoPessoaPK;

public interface EnderecoPessoaRepository extends JpaRepository<EnderecoPessoa, EnderecoPessoaPK> {

}