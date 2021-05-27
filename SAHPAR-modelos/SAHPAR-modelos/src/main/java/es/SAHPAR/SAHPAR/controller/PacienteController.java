package es.SAHPAR.SAHPAR.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PacienteController {
	
	@RequestMapping("/pacientes")
	public String listadoPacientes() {
		return "pacientes/index";
	}
}
