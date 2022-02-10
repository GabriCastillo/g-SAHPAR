package es.uma.ingsoftware.SAHPAR.model;

import java.util.List;

import javax.persistence.*;


@Entity
public class Usuario {

	@Id
	private String dni;
	private String passw;
	private String type;
	private String nombre;
	private String apellidos;
	
	@ManyToMany (mappedBy = "usuario")
	List<Paciente> paciente;

	public Usuario() {

	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getPassw() {
		return passw;
	}

	public void setPassw(String passw) {
		this.passw = passw;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	@Override
	public int hashCode() {
		return dni.toLowerCase().hashCode() + passw.toLowerCase().hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Usuario) {
			Usuario usu = (Usuario) obj;
			if (dni.equalsIgnoreCase(usu.dni) && passw.equalsIgnoreCase(usu.passw)) {
				return true;
			}
		}
		return false;
	}

	@Override
    public String toString() {
        return "Usuario{" + dni +"-" + nombre + "-" + apellidos + "}";
    }

}
