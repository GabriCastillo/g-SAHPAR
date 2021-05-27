package es.SAHPAR.SAHPAR.model;

import javax.persistence.Entity;

@Entity
public class Enfermero extends Usuario {

	public Enfermero(String username, String passw, String foto, String dni, String nombre, String apellidos) {
		super(username, passw, foto, dni, nombre, apellidos);
		// TODO Auto-generated constructor stub
	}

}
