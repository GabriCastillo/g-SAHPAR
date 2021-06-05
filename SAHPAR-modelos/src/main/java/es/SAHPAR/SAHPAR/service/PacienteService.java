package es.SAHPAR.SAHPAR.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.SAHPAR.SAHPAR.model.Paciente;
import es.SAHPAR.SAHPAR.repository.PacienteRepository;

@Service
public class PacienteService {
	@Autowired
	PacienteRepository pacienteRepository;
	
	public List<Paciente> getAll(){
		return pacienteRepository.findAll();
	}
}
