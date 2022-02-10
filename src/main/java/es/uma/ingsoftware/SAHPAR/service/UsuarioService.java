package es.uma.ingsoftware.SAHPAR.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import es.uma.ingsoftware.SAHPAR.model.Usuario;
import es.uma.ingsoftware.SAHPAR.repository.UsuarioRepository;

@Service
public class UsuarioService  {
	@Autowired
	UsuarioRepository usuarioRepository;
	
	public List<Usuario> getAll() {
		return usuarioRepository.findAll();
	}
	
	public void save(Usuario u) {
		 usuarioRepository.saveAndFlush(u);
	}
	
	// @SuppressWarnings("deprecation")
	public Usuario getById(String dni) {
		return usuarioRepository.getById(dni);
	}
	public void delete(String dni) {
		usuarioRepository.deleteById(dni);
	}
	
	public void findByName(String nombre) {
		usuarioRepository.findById(nombre);
		}
	
	public List<Usuario> buscarPorNombre(String nombre) {
		return usuarioRepository.findByNombre(nombre);
		}
	
	public List<Usuario> buscarPorApellidos(String apellidos){
		return usuarioRepository.findByApellidos(apellidos);
	}
	
	public boolean exits(Usuario usu) {
		if (usuarioRepository.existsById(usu.getDni())) {
			Usuario usu2 = usuarioRepository.getById(usu.getDni());
			if (usu.getPassw().equalsIgnoreCase(usu2.getPassw())) {
				return true;
			}
		}
		return false;
	}
}



