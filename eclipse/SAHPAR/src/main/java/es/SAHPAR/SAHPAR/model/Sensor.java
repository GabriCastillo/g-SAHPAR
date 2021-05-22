package es.SAHPAR.SAHPAR.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Sensor {
	@Id
    @GeneratedValue
    private int id;
	private double frecuencia;
	private String habitacion;

	@OneToOne(mappedBy = "Sensor")
	private Paciente paciente;
	
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
