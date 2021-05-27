package es.SAHPAR.SAHPAR.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;


@Entity
public class Paciente {
	@Id
	private String nombre;
	@Id
	private String apellidos;
	private String direccion;
	private String seguridad_social;
	private String datos_sanitarios;
	private String color;
	private double limite_rojo;
	private double limite_amarillo;
	private String tlfContc;
	@OneToOne
	Sensor sensor;
	@ManyToMany
	List<Usuario> usuario;
	public Paciente(String nombre,String apellidos,String direccion,String seguridad_social,
			String datos_sanitarios,double limite_rojo,double limite_amarillo,String tlfContc) {
		this.nombre=nombre;
		this.apellidos=apellidos;
		this.direccion=direccion;
		this.seguridad_social=seguridad_social;
		this.datos_sanitarios=datos_sanitarios;
		this.limite_amarillo=limite_amarillo;
		this.limite_rojo=limite_rojo;
		this.tlfContc=tlfContc;
		this.color="Verde";
		while(true) {
			comprobarPaciente();
		}
	}
	public void comprobarPaciente() {
		double frec = sensor.getFrecuencia();
		if(frec>=limite_rojo) {
			color="Rojo";
		}else if(frec>=limite_amarillo&&frec<limite_rojo) {
			color="Amarillo";
		}else {
			color="Verde";
		}
	}
	public void color(String color) {}
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
	public Sensor getSensor() {
		return sensor;
	}
	public void setSensor(Sensor sensor) {
		this.sensor = sensor;
	}
	
}
