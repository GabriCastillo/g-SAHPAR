package es.uma.ingsoftware.SAHPAR.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import es.uma.ingsoftware.SAHPAR.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, String> {

	List<Usuario> findByNombre(String nombre);

	List<Usuario> findByApellidos(String apellidos);

}
