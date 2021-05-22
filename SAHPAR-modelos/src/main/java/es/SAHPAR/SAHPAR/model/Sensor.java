package es.SAHPAR.SAHPAR.model;

public class Sensor {
	private double frecuencia;
	private String habitacion;
	private int id;
	public Sensor(int id) {
		this.id=id;
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
