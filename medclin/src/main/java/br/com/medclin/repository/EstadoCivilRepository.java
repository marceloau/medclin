/*
 * 
 */
package br.com.medclin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.medclin.model.EstadoCivil;

public interface EstadoCivilRepository extends JpaRepository<EstadoCivil, Byte> {
}
