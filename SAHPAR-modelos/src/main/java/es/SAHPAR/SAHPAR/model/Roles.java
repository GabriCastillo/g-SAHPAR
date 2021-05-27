package es.SAHPAR.SAHPAR.model;

import javax.persistence.OneToMany;

public class Roles {
	@OneToMany
	Usuario user;
	
	private String rol;
	public Roles() {
		this.rol=user.getTipo();
	}
	public String getRol() {
		return rol;
	}
	//Enfermero, Doctor y Admin
}
