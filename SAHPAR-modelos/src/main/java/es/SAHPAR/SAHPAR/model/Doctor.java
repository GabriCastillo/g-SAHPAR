package es.SAHPAR.SAHPAR.model;

import javax.persistence.Entity;

@Entity
public class Doctor extends Usuario{
	public Doctor(String username, String passw, String foto, String dni, String nombre, String apellidos) {
		super(username, passw, foto, dni, nombre, apellidos,"Doctor");
		// TODO Auto-generated constructor stub
	}

	public void eliminarPaciente(Paciente paciente) {
		
	}
}
