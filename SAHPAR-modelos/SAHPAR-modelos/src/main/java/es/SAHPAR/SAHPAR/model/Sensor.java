package es.SAHPAR.SAHPAR.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Sensor {
	@Id
	@GeneratedValue
	private Integer id;
	private double frecuencia;
	private String habitacion;
	@OneToOne (mappedBy ="sensor")
	Paciente ps;
	public Sensor() {

	}
	public double getFrecuencia() {
		return frecuencia;
	}
	public String getHabitacion() {
		return habitacion;
	}
	public void setHabitacion(String habitacion) {
		this.habitacion = habitacion;
	}
	
	
}
