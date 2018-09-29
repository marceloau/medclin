package br.com.medclin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.medclin.model.PlanoSaudePaciente;
import br.com.medclin.model.PlanoSaudePacientePK;

public interface PlanoSaudePacienteRepository extends JpaRepository<PlanoSaudePaciente, PlanoSaudePacientePK> {

}