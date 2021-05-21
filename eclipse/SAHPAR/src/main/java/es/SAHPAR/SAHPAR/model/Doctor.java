package es.SAHPAR.SAHPAR.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Doctor extends Usuario{
	@Id
    @GeneratedValue
    private int id;



	public void eliminarPaciente(Paciente paciente) {
		
	}
}
