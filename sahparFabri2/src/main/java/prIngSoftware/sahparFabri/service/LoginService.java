package prIngSoftware.sahparFabri.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import prIngSoftware.sahparFabri.model.Usuario;
import prIngSoftware.sahparFabri.repository.LoginRepository;

@Service
public class LoginService {
	
	@Autowired
	LoginRepository loginRepository;
	
	public List<Usuario> getAll(){
		return loginRepository.findAll();
	}
	
	public void save(Usuario u) {
		loginRepository.saveAndFlush(u);		
	}

	public void delete(String dni) {
		loginRepository.deleteById(dni);
	}

	public Usuario getById(String dni) {
		return loginRepository.getById(dni);
	}
	
	public boolean exits(Usuario usu) {
		if (loginRepository.existsById(usu.getDni())) {
			Usuario usu2 = loginRepository.getById(usu.getDni());
			if (usu.getPassw().equalsIgnoreCase(usu2.getPassw())) {
				return true;
			}
		}
		return false;
	}
}
