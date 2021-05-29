package prIngSoftware.sahparFabri.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import prIngSoftware.sahparFabri.model.Usuario;

public interface LoginRepository extends JpaRepository<Usuario, String>{
	
}
