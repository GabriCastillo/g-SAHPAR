package es.SAHPAR.SAHPAR.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.SAHPAR.SAHPAR.model.Usuario;
import es.SAHPAR.SAHPAR.repository.UsuarioRepository;

@Service
public class UsuarioService {
	@Autowired
	UsuarioRepository usuarioRepository;
	public List<Usuario> getAll(){
		return usuarioRepository.findAll();
	}
}
