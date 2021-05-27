package prIngSoftware.sahparFabri.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import prIngSoftware.sahparFabri.model.Paciente;
import prIngSoftware.sahparFabri.service.PacienteService;

@Controller
public class PacienteController {
	
	@Autowired
	PacienteService pacienteService;
	
	@RequestMapping("/pacientes")
	public String listadoPacientes(Model model) {
		List<Paciente> pacientes = pacienteService.getAll();
		
		model.addAttribute("listaPacientes", pacientes);
		
		return "pacientes/index";
	}
	
	@RequestMapping("/pacientes/add")
	public String addPaciente(Model model) {
		model.addAttribute("paciente", new Paciente());
		return "pacientes/add";
	}
	
	@PostMapping("/pacientes/save")
	public String savePaciente(Paciente p) {
		pacienteService.save(p);
		return "redirect:/pacientes";
	}
	
	@RequestMapping("/pacientes/edit/{id}")
	public String editPaciente(@PathVariable("id") Integer id, Model model) {
		model.addAttribute("paciente", pacienteService.getById(id));
		return "pacientes/add";
	}
	
	@RequestMapping("/pacientes/view/{id}")
	public String viewPaciente(@PathVariable("id") Integer id, Model model) {
		model.addAttribute("paciente", pacienteService.getById(id));
		return "pacientes/view";
	}
	
	@RequestMapping("/pacientes/delete/{id}")
	public String deletePaciente(@PathVariable("id") Integer id) {
		pacienteService.delete(id);
		return "redirect:/pacientes";
	}
}
