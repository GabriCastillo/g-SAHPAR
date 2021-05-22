package es.SAHPAR.SAHPAR.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Admin extends Usuario{
	@Id
    @GeneratedValue
    private int id;
	public void añadirUsuario() {}
	public void editarUsuario() {}
	public void eliminarUsuario(Usuario user) {}
	public void buscarUsuario() {}
}
