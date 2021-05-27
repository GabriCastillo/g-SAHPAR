package prIngSoftware.sahparFabri.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import prIngSoftware.sahparFabri.model.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente, Integer>{
	
}
