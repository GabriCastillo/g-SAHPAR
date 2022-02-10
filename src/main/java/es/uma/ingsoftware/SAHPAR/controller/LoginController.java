package es.uma.ingsoftware.SAHPAR.controller;

//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import es.uma.ingsoftware.SAHPAR.model.Enfermero;
import es.uma.ingsoftware.SAHPAR.model.Usuario;
import es.uma.ingsoftware.SAHPAR.service.UsuarioService;

@Controller
public class LoginController {
	@Autowired
	UsuarioService usuarioService;
	
//	@RequestMapping("/login")
//	public String listadousuarios(Model model) {
//		List<Usuario> usuarios = usuarioService.getAll();
//		model.addAttribute("listaUsuarios", usuarios);
//		
//		return "login/index";
//	}
//	
//	@RequestMapping("/login/register")
//	public String addUsuario(Model model) {
//		model.addAttribute("usuario", new Enfermero());
//		return "login/register";
//	}
	
//	@PostMapping("/login/save")
//	public String saveUsuario(Usuario u) {
//		usuarioService.save(u);
//		if (u.getType().equalsIgnoreCase("admin")) {
//			return "redirect:/login";
//		} else if (u.getType().equalsIgnoreCase("doctor")) {
//				return "redirect:/doctor";
//			} else {
//				return "redirect:/enfermero";
//		}
//	}
	
	@RequestMapping("/login/sesion")
	public String validUsuario(Model model) {
		model.addAttribute("usuario", new Enfermero());
		return "login/sesion";
	}
	
	@PostMapping("/login/valid")
	public String validUsuario(Usuario u) {
		if (u.getDni() == null) {
			return "login/error";
		}
		if(usuarioService.exits(u)) {
			String tipo = usuarioService.getById(u.getDni()).getType();
			if (tipo.equalsIgnoreCase("admin")) {
				return "redirect:/admin";
			} else if (tipo.equalsIgnoreCase("doctor")) {
				return "redirect:/doctor";
			} else if (tipo.equalsIgnoreCase("enfermero")){
				return "redirect:/enfermero";
			} else {
				return "login/error";
			}
		}
		return "login/error";
	}
	
//	@RequestMapping("/login/view/{dni}")
//	public String viewPaciente(@PathVariable("dni") String dni, Model model) {
//		model.addAttribute("usuario", usuarioService.getById(dni));
//		return "login/view";
//	}
//	
//	@RequestMapping("/login/delete/{dni}")
//	public String deleteUsuario(@PathVariable("dni") String dni) {
//		usuarioService.delete(dni);
//		return "redirect:/login";
//	}
}
