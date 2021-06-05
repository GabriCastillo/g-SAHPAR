package es.SAHPAR.SAHPAR.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import es.SAHPAR.SAHPAR.model.Paciente;
import es.SAHPAR.SAHPAR.service.PacienteService;

@Controller
public class PacienteController {
	@Autowired
	PacienteService pacienteService;
	@RequestMapping("/pacientes")
	public String listadoPacientes() {
		List<Paciente> pacientes= pacienteService.getAll();
		
		//model.addAttribute("listaPacientes",pacientes); comprobar porque no va
		return "pacientes/index";
	}
}
