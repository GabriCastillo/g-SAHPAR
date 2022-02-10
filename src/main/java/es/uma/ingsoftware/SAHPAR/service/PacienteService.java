package es.uma.ingsoftware.SAHPAR.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import es.uma.ingsoftware.SAHPAR.model.Paciente;
import es.uma.ingsoftware.SAHPAR.repository.PacienteRepository;

@Service
public class PacienteService {
	@Autowired
	PacienteRepository pacienteRepository;
	
	public List<Paciente> getAll() {
		return pacienteRepository.findAll();
	}
	
	public void save(Paciente p) {
		 pacienteRepository.saveAndFlush(p);
	}
	
	@SuppressWarnings("deprecation")
	public Paciente getById(String seguridadSocial) {
		return pacienteRepository.getOne(seguridadSocial);
	}
	
	public void delete(String seguridadSocial) {
		pacienteRepository.deleteById(seguridadSocial);
	}
	
	public List<Paciente> buscarPorNombre(String nombre) {
		return pacienteRepository.findByNombre(nombre);
		}
	public List<Paciente> buscarPorApellidos(String apellidos){
		return pacienteRepository.findByApellidos(apellidos);
	}
	
}
