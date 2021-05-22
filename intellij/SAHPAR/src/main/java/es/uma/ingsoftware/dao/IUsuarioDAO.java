package es.uma.ingsoftware.dao;

import es.uma.ingsoftware.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUsuarioDAO extends JpaRepository<Usuario,Long> {
    public Usuario findByUsername(String username);
}
