package prIngSoftware.sahparFabri.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import prIngSoftware.sahparFabri.model.Paciente;
import prIngSoftware.sahparFabri.repository.PacienteRepository;

@Service
public class PacienteService {
	
	@Autowired
	PacienteRepository pacienteRepository;
	
	public List<Paciente> getAll(){
		return pacienteRepository.findAll();
	}

	public void save(Paciente p) {
		pacienteRepository.saveAndFlush(p);		
	}

	public void delete(Integer id) {
		pacienteRepository.deleteById(id);		
	}

	public Paciente getById(Integer id) {
		return pacienteRepository.getById(id);
	}
}
