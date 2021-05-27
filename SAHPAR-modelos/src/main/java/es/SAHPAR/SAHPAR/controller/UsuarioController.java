package es.SAHPAR.SAHPAR.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UsuarioController {

	@RequestMapping("/paciente/add")
	public String addPaciente() {
		return "personas/add";
	}
	
	@RequestMapping("/usuario/add")
	public String addUsuario() {
		return "personas/add";
	}
	
	@RequestMapping("/usuario/edit/{username}")
	public String editUsuario() {
		return "usuario/edit";
	}
	@RequestMapping("/paciente/edit/{nombre,apellidos}")
	public String editPaciente() {
		return "usuario/edit";
	}
	
	@RequestMapping("/usuario/delete/{username}")
	public String deleteUsuario() {
		return "usuario/edit";
	}
	@RequestMapping("/paciente/delete/{username}")
	public String deletePaciente() {
		return "usuario/edit";
	}
	
	
}
