package es.SAHPAR.SAHPAR.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import es.SAHPAR.SAHPAR.model.Usuario;
import es.SAHPAR.SAHPAR.service.UsuarioService;

@Controller
public class UsuarioController {
	@Autowired
	UsuarioService usuarioService;

	@RequestMapping("/usuario")
	public String listadoUsuarios() {
		List<Usuario> usuarios= usuarioService.getAll();
		return "usuario/index";
	}
	@RequestMapping("/paciente/add")
	public String addPaciente() {
		return "personas/add";
	}
	
	@RequestMapping("/usuario/add")
	public String addUsuario() {
		return "usuarios/add";
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
