package es.uma.ingsoftware.SAHPAR.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import es.uma.ingsoftware.SAHPAR.model.Paciente;
import es.uma.ingsoftware.SAHPAR.service.PacienteService;

@Controller
public class EnfermeroController {
	@Autowired
	PacienteService pacienteService;

	@RequestMapping("/enfermero")
	public String enfermeroPage() {
		return "enfermero/index";
	}

	@RequestMapping("/enfermero/add")
	public String addPaciente(Model model) {
		model.addAttribute("paciente", new Paciente());
		return "enfermero/add";
	}

	@PostMapping("/enfermero/save")
	public String savePaciente(Paciente p) {
		pacienteService.save(p);
		return "redirect:/enfermero";
	}

	@RequestMapping("/enfermero/edit/{seguridadSocial}")
	public String editPaciente(@PathVariable("seguridadSocial") String seguridadSocial, Model model) {
		model.addAttribute("paciente", pacienteService.getById(seguridadSocial));
		return "enfermero/add";
	}

	@RequestMapping("/enfermero/lista")
	public String listadoPacientes(Model model) {
		List<Paciente> pacientes = pacienteService.getAll();
		for (Paciente pac : pacientes) {
			pac.cambiarEstado();
		}
		Collections.sort(pacientes);
		model.addAttribute("listaPacientes", pacientes);

		return "enfermero/lista";
	}

	@RequestMapping("/enfermero/view/{seguridadSocial}")
	public String viewPaciente(@PathVariable("seguridadSocial") String seguridadSocial, Model model) {
		model.addAttribute("paciente", pacienteService.getById(seguridadSocial));
		return "enfermero/view";
	}

	@RequestMapping("/enfermero/buscar")
	public String buscar(Model model) {
		model.addAttribute("paciente", new Paciente());
		return "enfermero/buscar";
	}

	@RequestMapping("/enfermero/buscarN")
	public String buscarN(Model model) {
		model.addAttribute("paciente", new Paciente());
		return "enfermero/buscarN";
	}

	@RequestMapping("/enfermero/buscaarN")
	public String buscarNombre(@RequestParam String nombre, Model model,
			@ModelAttribute("paciente") Paciente paciente) {
		model.addAttribute("pacientePorNombre", pacienteService.buscarPorNombre(nombre));
		return "enfermero/buscarN";
	}

	@RequestMapping("/enfermero/buscarA")
	public String buscarA(Model model) {
		model.addAttribute("paciente", new Paciente());
		return "enfermero/buscarA";
	}

	@RequestMapping("/enfermero/buscaarA")
	public String buscarApellidos(@RequestParam String apellidos, Model model,
			@ModelAttribute("paciente") Paciente paciente) {
		model.addAttribute("pacientePorApellidos", pacienteService.buscarPorApellidos(apellidos));
		return "enfermero/buscarA";
	}

	@RequestMapping("/enfermero/buscarSS")
	public String buscarSS(Model model) {
		model.addAttribute("paciente", new Paciente());
		return "enfermero/buscarSS";

	}

	@RequestMapping("/enfermero/buscaarSS")
	public String buscarSegSocial(@RequestParam String seguridadSocial, Model model,
			@ModelAttribute("paciente") Paciente paciente) {
		model.addAttribute("pacientePorseguridadSocial", pacienteService.getById(seguridadSocial));
		return "enfermero/buscarSS";
	}

}
