package es.uma.ingsoftware.SAHPAR.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collections;
import java.util.List;
import es.uma.ingsoftware.SAHPAR.model.*;
import es.uma.ingsoftware.SAHPAR.service.*;

@Controller
public class AdminController {
	@Autowired
	PacienteService pacienteService;

	@Autowired
	UsuarioService usuarioService;

	@RequestMapping("/admin")
	public String adminPage() {
		return "admin/index";
	}

	@RequestMapping("/admin/addU")
	public String addUsuario(Model model) {
		model.addAttribute("usuario", new Usuario());
		return "admin/addU";
	}

	@PostMapping("/admin/saveU")
	public String saveUsuario(Usuario u) {
		if (u.getPassw().equalsIgnoreCase("")) {
			return "login/error";
		} else {
			usuarioService.save(u);
			return "redirect:/admin";
		}
	}

	@RequestMapping("/admin/addP")
	public String addPaciente(Model model) {
		model.addAttribute("paciente", new Paciente());
		return "admin/addP";
	}

	@PostMapping("/admin/saveP")
	public String savePaciente(Paciente p) {
		pacienteService.save(p);
		return "redirect:/admin";
	}

	@RequestMapping("/admin/editU/{dni}")
	public String editUsuario(@PathVariable("dni") String dni, Model model) {
		model.addAttribute("usuario", usuarioService.getById(dni));

		return "admin/addU";
	}

	@RequestMapping("/admin/editP/{seguridadSocial}")
	public String editPaciente(@PathVariable("seguridadSocial") String seguridadSocial, Model model) {
		model.addAttribute("paciente", pacienteService.getById(seguridadSocial));
		return "admin/addP";
	}

	@RequestMapping("/admin/listaP")
	public String listadoPacientes(Model model) {
		List<Paciente> pacientes = pacienteService.getAll();
		for (Paciente pac : pacientes) {
			pac.cambiarEstado();
		}
		Collections.sort(pacientes);
		model.addAttribute("listaPacientes", pacientes);

		return "admin/listaP";
	}

	@RequestMapping("/admin/listaU")
	public String listadoUsuarios(Model model) {
		List<Usuario> usuario = usuarioService.getAll();
		model.addAttribute("listaUsuarios", usuario);

		return "admin/listaU";
	}

	@RequestMapping("/admin/deleteU/{dni}")
	public String deleteUsuario(@PathVariable("dni") String dni) {
		usuarioService.delete(dni);
		return "volver";
	}

	@RequestMapping("/admin/deleteP/{seguridadSocial}")
	public String deletePaciente(@PathVariable("seguridadSocial") String seguridadSocial) {
		pacienteService.delete(seguridadSocial);
		return "volver";
	}

	@RequestMapping("/admin/viewU/{dni}")
	public String viewUsuario(@PathVariable("dni") String dni, Model model) {
		model.addAttribute("usuario", usuarioService.getById(dni));
		return "admin/viewU";
	}

	@RequestMapping("/admin/viewP/{seguridadSocial}")
	public String viewPaciente(@PathVariable("seguridadSocial") String seguridadSocial, Model model) {
		model.addAttribute("paciente", pacienteService.getById(seguridadSocial));
		return "admin/viewP";
	}

	@RequestMapping("/admin/buscarP")
	public String buscarP(Model model) {
		model.addAttribute("paciente", new Paciente());
		return "admin/buscarP";
	}

	@RequestMapping("/admin/buscarPN")
	public String buscarPN(Model model) {
		model.addAttribute("paciente", new Paciente());
		return "admin/buscarPN";
	}

	@RequestMapping("/admin/buscaarPN")
	public String buscarPaNombre(@RequestParam String nombre, Model model,
			@ModelAttribute("paciente") Paciente paciente) {
		model.addAttribute("pacientePorNombre", pacienteService.buscarPorNombre(nombre));
		return "admin/buscarPN";
	}

	@RequestMapping("/admin/buscarPA")
	public String buscarPA(Model model) {
		model.addAttribute("paciente", new Paciente());
		return "admin/buscarPA";
	}

	@RequestMapping("/admin/buscaarPA")
	public String buscarPaApellidos(@RequestParam String apellidos, Model model,
			@ModelAttribute("paciente") Paciente paciente) {
		model.addAttribute("pacientePorApellidos", pacienteService.buscarPorApellidos(apellidos));
		return "admin/buscarPA";
	}

	@RequestMapping("/admin/buscarPSS")
	public String buscarPSS(Model model) {
		model.addAttribute("paciente", new Paciente());
		return "admin/buscarPSS";

	}

	@RequestMapping("/admin/buscaarPSS")
	public String buscarPaSegSocial(@RequestParam String seguridadSocial, Model model,
			@ModelAttribute("paciente") Paciente paciente) {
		model.addAttribute("pacientePorseguridadSocial", pacienteService.getById(seguridadSocial));
		return "admin/buscarPSS";
	}

	@RequestMapping("/admin/buscarU")
	public String buscarU(Model model) {
		model.addAttribute("usuario", new Usuario());
		return "admin/buscarU";
	}

	@RequestMapping("/admin/buscarUN")
	public String buscarUN(Model model) {
		model.addAttribute("usuario", new Usuario());
		return "admin/buscarUN";
	}

	@RequestMapping("/admin/buscaarUN")
	public String buscarUsNombre(@RequestParam String nombre, Model model, @ModelAttribute("usuario") Usuario usuario) {
		model.addAttribute("usuarioPorNombre", usuarioService.buscarPorNombre(nombre));
		return "admin/buscarUN";
	}

	@RequestMapping("/admin/buscarUA")
	public String buscarUA(Model model) {
		model.addAttribute("usuario", new Usuario());
		return "admin/buscarUA";
	}

	@RequestMapping("/admin/buscaarUA")
	public String buscarUsApellidos(@RequestParam String apellidos, Model model,
			@ModelAttribute("usuario") Usuario usuario) {
		model.addAttribute("usuarioPorApellidos", usuarioService.buscarPorApellidos(apellidos));
		return "admin/buscarUA";
	}

	@RequestMapping("/admin/buscarUDni")
	public String buscarUDni(Model model) {
		model.addAttribute("usuario", new Usuario());
		return "admin/buscarUDni";

	}

	@RequestMapping("/admin/buscaarUDni")
	public String buscarUsDni(@RequestParam String dni, Model model, @ModelAttribute("usuario") Usuario usuario) {
		model.addAttribute("usuarioPorDni", usuarioService.getById(dni));
		return "admin/buscarUDni";
	}

};
