package es.uma.ingsoftware.SAHPAR.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import es.uma.ingsoftware.SAHPAR.model.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente, String> {

	List<Paciente> findByNombre(String nombre);

	List<Paciente> findByApellidos(String apellidos);
}
