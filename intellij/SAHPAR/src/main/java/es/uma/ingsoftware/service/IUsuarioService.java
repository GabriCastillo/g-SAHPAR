package es.uma.ingsoftware.service;

import es.uma.ingsoftware.entity.Usuario;

public interface IUsuarioService {

    public Usuario findByUsername(String username);
    public Usuario registrar(Usuario u);

}
