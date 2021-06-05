package es.SAHPAR.SAHPAR.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Sensor extends Thread{
	@Id
	@GeneratedValue
	private Integer id;
	private double frecuencia;
	private String habitacion;
	private boolean activado;
	@OneToOne (mappedBy ="sensor")
	Paciente ps;
	public void run(){
		activado=true;
		int prob;
		while(activado) {
			prob=(int) (Math.random()*101);
			if(prob<=20&&prob>0) {
				frecuencia=Math.random()*(40);
			}else if(prob<=50&&prob>20){
				frecuencia=Math.random()*(59-40+1)+40;
			}else{
				frecuencia=Math.random()*(100-60+1)+60;
			}
			ps.comprobarPaciente();
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public boolean isActivado() {
		return activado;
	}
	public void setActivado(boolean activado) {
		this.activado = activado;
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
