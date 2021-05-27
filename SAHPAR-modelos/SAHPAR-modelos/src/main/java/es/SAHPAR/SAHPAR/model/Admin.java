package es.SAHPAR.SAHPAR.model;

import javax.persistence.Entity;

@Entity
public class Admin extends Usuario{
	public Admin(String username, String passw, String foto, String dni, String nombre, String apellidos) {
		super(username, passw, foto, dni, nombre, apellidos);
		// TODO Auto-generated constructor stub
	}
	public void añadirUsuario() {}
	public void editarUsuario() {}
	public void eliminarUsuario(Usuario user) {}
	public void buscarUsuario() {}
}
