package es.SAHPAR.SAHPAR.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity
public abstract class Usuario {
	@Id
	private String username;
	private String passw;
	private String foto;
	private String dni;
	private String nombre;
	private String apellidos;
	private String tipo;
	
	@OneToOne (mappedBy = "user")
	Roles roles;
	
	@ManyToMany (mappedBy = "usuario")
	List<Paciente> paciente;
	
	
	public Usuario(String username,String passw,String foto,String dni,String nombre,String apellidos,String tipo) {
		this.username=username;
		this.passw=passw;
		this.foto=foto;
		this.dni=dni;
		this.nombre=nombre;
		this.apellidos=apellidos;
		this.tipo=tipo;
	}
	public void editarFoto(String foto) {
		this.foto=foto;
	}
	public void avisarMedico() {}
	public void añadirPaciente(Paciente paciente) {}
	public void buscarPaciente() {}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassw() {
		return passw;
	}
	public void setPassw(String passw) {
		this.passw = passw;
	}
	public String getFoto() {
		return foto;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
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
	public String getTipo() {
		return tipo;
	}
	
}
