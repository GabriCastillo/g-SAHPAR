package prIngSoftware.sahparFabri.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import prIngSoftware.sahparFabri.model.Doctor;
import prIngSoftware.sahparFabri.model.Usuario;
import prIngSoftware.sahparFabri.service.LoginService;

@Controller
public class LoginController {
	
	@Autowired
	LoginService loginService;
	
	@RequestMapping("/login")
	public String listadousuarios(Model model) {
		List<Usuario> usuarios = loginService.getAll();
		
		model.addAttribute("listaUsuarios", usuarios);
		
		return "login/index";
	}
	
	@RequestMapping("/login/register")
	public String addUsuario(Model model) {
		model.addAttribute("usuario", new Doctor());
		return "login/register";
	}
	
	@PostMapping("/login/save")
	public String saveUsuario(Usuario u) {
		loginService.save(u);
		return "redirect:/pacientes";
	}
	
	@RequestMapping("/login/sesion")
	public String validUsuario(Model model) {
		model.addAttribute("usuario", new Doctor());
		return "login/sesion";
	}
	
	@PostMapping("/login/valid")
	public String validUsuario(Usuario u) {
		if(loginService.exits(u)) {
			return "redirect:/pacientes";
		}
		return "login/error";
	}
	
//	@RequestMapping("/login/sesion{id}")
//	public String validUsuario(@PathVariable("id") Integer id, Model model) {		
//		model.addAttribute("usuario", loginService.getById(id));
//		return "login/register";
//	}
	
	
//	@RequestMapping("/login/save/{dni}")
//	public String editPaciente(@PathVariable("dni") String dni, Model model) {
//		try{
//			model.addAttribute("paciente", loginService.getById(dni));
//		} catch (Exception e) {
//			return "login/error";
//		}
//		return "pacientes/add";
//	}
	
	@RequestMapping("/login/delete/{dni}")
	public String deletePaciente(@PathVariable("dni") String dni) {
		loginService.delete(dni);
		return "redirect:/login";
	}
}
