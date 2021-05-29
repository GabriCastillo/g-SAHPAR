package prIngSoftware.sahparFabri.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;


@Entity
public class Paciente {
	@Id
	@GeneratedValue
	private Integer id;
	private String dni;
	private String nombre;
	private String apellidos;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(iso=ISO.DATE)
	private Date nacimiento;
	private String direccion;
	private String seguridad_social;
	private double limite_rojo;
	private double limite_amarillo;
	private String tlfContc;
	
	@OneToOne
    private Sensor sensor;
	
//	@ManyToOne
//    private Usuario usuario;
	
	public Paciente() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Date getNacimiento() {
		return nacimiento;
	}

	public void setNacimiento(Date nacimiento) {
		this.nacimiento = nacimiento;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getSeguridad_social() {
		return seguridad_social;
	}

	public void setSeguridad_social(String seguridad_social) {
		this.seguridad_social = seguridad_social;
	}

	public double getLimite_rojo() {
		return limite_rojo;
	}

	public void setLimite_rojo(double limite_rojo) {
		this.limite_rojo = limite_rojo;
	}

	public double getLimite_amarillo() {
		return limite_amarillo;
	}

	public void setLimite_amarillo(double limite_amarillo) {
		this.limite_amarillo = limite_amarillo;
	}

	public String getTlfContc() {
		return tlfContc;
	}

	public void setTlfContc(String tlfContc) {
		this.tlfContc = tlfContc;
	}

	@Override
	public int hashCode() {
		return dni.toLowerCase().hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Paciente) {
			Paciente pac = (Paciente) obj;
			if (dni.equalsIgnoreCase(pac.dni)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public String toString() {
		return nombre + " " + apellidos;
	}

}
