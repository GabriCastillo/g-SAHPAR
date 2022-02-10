
package es.uma.ingsoftware.SAHPAR;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.ui.Model;

import es.uma.ingsoftware.SAHPAR.controller.AdminController;
import es.uma.ingsoftware.SAHPAR.controller.DoctorController;
import es.uma.ingsoftware.SAHPAR.controller.EnfermeroController;
import es.uma.ingsoftware.SAHPAR.controller.LoginController;
import es.uma.ingsoftware.SAHPAR.model.Paciente;
import es.uma.ingsoftware.SAHPAR.model.Usuario;
import es.uma.ingsoftware.SAHPAR.repository.PacienteRepository;
import es.uma.ingsoftware.SAHPAR.repository.UsuarioRepository;
import es.uma.ingsoftware.SAHPAR.service.PacienteService;
import javassist.bytecode.Descriptor.Iterator;

@SpringBootTest
class SahparApplicationTests {
	
	@Autowired
	private PacienteRepository pacRepository;
	
	@Autowired
	private UsuarioRepository usuRepository;
	
	@Autowired
	private LoginController logController;
	
	@Autowired
	private EnfermeroController enfController;

	@Test
	public void comprobarPaciente() {
		Paciente pa = new Paciente();
		pa.setLimiteAmarillo(40);
		pa.setLimiteRojo(20);
		assertEquals(pa.comprobarPaciente(40),"amarillo");
	}
	/*@Test
	public void cambiarEstado() {
		Paciente pa = new Paciente();
		String est = pa.getEstado();
		pa.setLimiteAmarillo(100);
		pa.setLimiteRojo(80);
		pa.cambiarEstado();
		assertNotEquals(pa.getEstado(),est);
	}*/
	
	@Test
	public void añadirPaciente() {
		Paciente pa= new Paciente();
		pa.setSeguridadSocial("1234");
		pacRepository.save(pa);
		
		List<Paciente> pacientes= pacRepository.findAll();
		assertTrue(pacientes.contains(pa));
	}
	@Test
	public void borrarPaciente() {
		Paciente pa= new Paciente();
		pa.setSeguridadSocial("1234");
		pacRepository.save(pa);
		pacRepository.delete(pa);
		List<Paciente> pacientes= pacRepository.findAll();
		assertFalse(pacientes.contains(pa));
	}
	@Test
	@Transactional
	public void editarPaciente() {
		Paciente pa= new Paciente();
		pa.setSeguridadSocial("1234");
		String dir="ETSII";
		pa.setDireccion(dir);
		pacRepository.save(pa);
		assertTrue(pacRepository.existsById(pa.getSeguridadSocial()));
		pa.setDireccion("Magisterio");
		pacRepository.save(pa);
		assertNotEquals(dir,pacRepository.getById(pa.getSeguridadSocial()).getDireccion());
	}
	
	@Test
	public void añadirUsuario() {
		Usuario user= new Usuario();
		user.setDni("65728409a");
		usuRepository.save(user);
		
		assertTrue(usuRepository.existsById(user.getDni()));
	}
	@Test
	public void borrarUsuario() {
		Usuario user= new Usuario();
		user.setDni("65728409a");
		usuRepository.save(user);
		usuRepository.delete(user);
		assertFalse(usuRepository.existsById(user.getDni()));
	}
	@Test
	@Transactional
	public void editarUsuario() {
		Usuario user= new Usuario();
		user.setDni("65728409a");
		usuRepository.save(user);
		user.setType("enfermero");
		usuRepository.save(user);
		user.setType("doctor");
		usuRepository.save(user);
		assertNotEquals("enfermero",usuRepository.getById(user.getDni()).getType());
	}
	@Test
	@Transactional
	public void contraseñaCorrecta() {
		Usuario user= new Usuario();
		user.setDni("65728409a");
		user.setPassw("12345");
		usuRepository.save(user);
		assertEquals("12345",usuRepository.getById(user.getDni()).getPassw());
	}
	@Test
	@Transactional
	public void loginEnfermeroCorrecto() {
		Usuario user= new Usuario();
		user.setDni("65728409a");
		user.setPassw("12345");
		user.setType("enfermero");
		usuRepository.save(user);
		String url=logController.validUsuario(user);
		assertEquals("redirect:/enfermero",url);
	}
	@Test
	@Transactional
	public void loginAdminCorrecto() {
		Usuario user= new Usuario();
		user.setDni("65728409a");
		user.setPassw("12345");
		user.setType("admin");
		usuRepository.save(user);
		String url=logController.validUsuario(user);
		assertEquals("redirect:/admin",url);
	}
	@Test
	@Transactional
	public void loginDoctorCorrecto() {
		Usuario user= new Usuario();
		user.setDni("65728409a");
		user.setPassw("12345");
		user.setType("doctor");
		usuRepository.save(user);
		String url=logController.validUsuario(user);
		assertEquals("redirect:/doctor",url);
	}
	@Test
	@Transactional
	public void loginIncorrecto() {
		Usuario user= new Usuario();
		user.setDni("65728409a");
		user.setPassw("12345");
		user.setType("enfermero");
		usuRepository.save(user);
		Usuario user2= new Usuario();
		user2.setDni("65728409a");
		user2.setPassw("12");
		String url=logController.validUsuario(user2);
		assertEquals("login/error",url);
	}
//	@Test
//	public void comprobarOrden() {
//		Model model = null ;
//		List<Paciente> pacientes;
//		Paciente pa = new Paciente();
//		Paciente pa2 = new Paciente();
//		Paciente pa3 = new Paciente();
//		pa.setSeguridadSocial("1");
//		pa.setEstado("rojo");
//		pa.setNombre("nomb1");
//		pa2.setSeguridadSocial("2");
//		pa2.setEstado("verde");
//		pa2.setNombre("nomb2");
//		pa3.setSeguridadSocial("3");
//		pa3.setEstado("negro");
//		pa3.setNombre("nomb3");
//		pacRepository.save(pa);
//		pacRepository.save(pa2);
//		pacRepository.save(pa3);
//		
//		
//		pacientes=pacService.getAll();
//		System.out.println(pacientes);
//		enfController.listadoPacientes(model);
//		pacientes=pacService.getAll();
//		System.out.println(pacientes);
//		assertTrue(pacientes.isEmpty());
//		assertTrue("negro".equalsIgnoreCase(pacientes.get(0).getEstado()));
//		//assertEquals("rojo",pacientes.get(1).getEstado());
//		//assertEquals("verde",pacientes.get(2).getEstado());
//		
//	}
	
}
