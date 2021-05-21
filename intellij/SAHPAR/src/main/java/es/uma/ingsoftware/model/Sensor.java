package es.uma.ingsoftware.model;

import javax.persistence.Entity;

@Entity
public class Sensor {
	private double frecuencia;
	private String habitacion;
	private int id;
	public double getFrecuencia() {
		return frecuencia;
	}
	public void setFrecuencia(double frecuencia) {
		this.frecuencia = frecuencia;
	}
	public String getHabitacion() {
		return habitacion;
	}
	public void setHabitacion(String habitacion) {
		this.habitacion = habitacion;
	}
	
	
}
