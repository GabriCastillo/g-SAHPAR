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
public class DoctorController {
	@Autowired
	PacienteService pacienteService;

	@RequestMapping("/doctor")
	public String doctorPage() {
		return "doctor/index";
	}

	@RequestMapping("/doctor/add")
	public String addPaciente(Model model) {
		model.addAttribute("paciente", new Paciente());
		return "doctor/add";
	}

	@PostMapping("/doctor/save")
	public String savePaciente(Paciente p) {
		pacienteService.save(p);
		return "redirect:/doctor";
	}

	@RequestMapping("/doctor/edit/{seguridadSocial}")
	public String editPaciente(@PathVariable("seguridadSocial") String seguridadSocial, Model model) {
		model.addAttribute("paciente", pacienteService.getById(seguridadSocial));
		return "doctor/add";
	}

	@RequestMapping("/doctor/lista")
	public String listadoPacientes(Model model) {
		List<Paciente> pacientes = pacienteService.getAll();
		for (Paciente pac : pacientes) {
			pac.cambiarEstado();
		}
		Collections.sort(pacientes);
		model.addAttribute("listaPacientes", pacientes);

		return "doctor/lista";
	}

	@RequestMapping("/doctor/view/{seguridadSocial}")
	public String viewPaciente(@PathVariable("seguridadSocial") String seguridadSocial, Model model) {
		model.addAttribute("paciente", pacienteService.getById(seguridadSocial));
		return "doctor/view";
	}

	@RequestMapping("/doctor/delete/{seguridadSocial}")
	public String deletePaciente(@PathVariable("seguridadSocial") String seguridadSocial) {
		pacienteService.delete(seguridadSocial);
		return "volver";
	}

	@RequestMapping("/doctor/buscar")
	public String buscar(Model model) {
		model.addAttribute("paciente", new Paciente());
		return "doctor/buscar";
	}

	@RequestMapping("/doctor/buscarN")
	public String buscarN(Model model) {
		model.addAttribute("paciente", new Paciente());
		return "doctor/buscarN";
	}

	@RequestMapping("/doctor/buscaarN")
	public String buscarNombre(@RequestParam String nombre, Model model,
			@ModelAttribute("paciente") Paciente paciente) {
		model.addAttribute("pacientePorNombre", pacienteService.buscarPorNombre(nombre));
		return "doctor/buscarN";
	}

	@RequestMapping("/doctor/buscarA")
	public String buscarA(Model model) {
		model.addAttribute("paciente", new Paciente());
		return "doctor/buscarA";
	}

	@RequestMapping("/doctor/buscaarA")
	public String buscarApellidos(@RequestParam String apellidos, Model model,
			@ModelAttribute("paciente") Paciente paciente) {
		model.addAttribute("pacientePorApellidos", pacienteService.buscarPorApellidos(apellidos));
		return "doctor/buscarA";
	}

	@RequestMapping("/doctor/buscarSS")
	public String buscarSS(Model model) {
		model.addAttribute("paciente", new Paciente());
		return "doctor/buscarSS";

	}

	@RequestMapping("/doctor/buscaarSS")
	public String buscarSegSocial(@RequestParam String seguridadSocial, Model model,
			@ModelAttribute("paciente") Paciente paciente) {
		model.addAttribute("pacientePorseguridadSocial", pacienteService.getById(seguridadSocial));
		return "doctor/buscarSS";
	}

}
