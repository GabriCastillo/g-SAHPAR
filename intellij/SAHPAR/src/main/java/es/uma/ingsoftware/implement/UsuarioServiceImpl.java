package es.uma.ingsoftware.implement;

import es.uma.ingsoftware.dao.IUsuarioDAO;
import es.uma.ingsoftware.entity.Usuario;
import es.uma.ingsoftware.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements IUsuarioService {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private IUsuarioDAO usuarioDAO;

    @Override
    public Usuario findByUsername(String username) {
        return usuarioDAO.findByUsername(username);
    }

    @Override
    public Usuario registrar(Usuario u) {
        u.setPassw(passwordEncoder.encode(u.getPassw()));
        return usuarioDAO.save(u);
    }
}
