package es.uma.ingsoftware.SAHPAR.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import antlr.collections.List;

@Controller
public class AdminController {
	
		@RequestMapping("/admin")
		public String adminPage() {
			return "admin/index";
		}
	
		@RequestMapping("/admin/listadoUsuarios")
		public String listadoUsuarios() { //ENTRE PARÉNTESIS IRÍA: (Model model)
			/*List<Usuario> usuarios = new ArrayList<>(); -- CLASE USUARIO, ENFERMERO, DOCTOR Y ADMIN SON SUBCLASES
			AQUÍ SE PODRÍAN AÑADIR USUARIOS
			model.addAttribute("listaUsuarios", usuarios);
			*/
			return "admin/listaUsuarios";
		}
		
		@RequestMapping("/admin/addUsuario")
		public String addUsuario() {
			return "admin/add";
			}

		@RequestMapping("/admin/editUsuario/{id}")
		public String editUsuario() {
			return "admin/edit";
		}
		
		@RequestMapping("/admin/deleteUsuario/{id}")
		public String deleteUsuario() {
			return "redirect:/admin/listadoUsuarios";
		}

		@RequestMapping("/admin/listadoPacientes")
		public String listadoPacientes() {
			return "admin/listaPacientes";
		}
		@RequestMapping("/admin/addPaciente")
		public String addPaciente() {
			return "admin/addPac";
			}

		@RequestMapping("/admin/editPaciente/{id}")
		public String editPaciente() {
			return "admin/editPac";
		}
		
		@RequestMapping("/admin/deletePaciente/{id}")
		public String deletePaciente() {
			return "redirect:/admin/listadoPacientes";
		}




}
