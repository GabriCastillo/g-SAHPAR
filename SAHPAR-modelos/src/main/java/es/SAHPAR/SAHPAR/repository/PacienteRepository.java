package es.SAHPAR.SAHPAR.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import es.SAHPAR.SAHPAR.model.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente,String>{

}
