package com.alejandro.springmysql.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alejandro.springmysql.models.Usuario;
import com.alejandro.springmysql.repository.IUsuarioRepository;

@Service("usuarioservice")
public class UsuarioServiceImpl implements IUsuarioService {
	
	@Autowired
	@Qualifier("usuariorepository")
	private IUsuarioRepository usuariorepository;
	
	@Override
	@Transactional(readOnly = true)
	public List<Usuario> listar() {
		return usuariorepository.findAll();
	}

	@Override
	@Transactional
	public void save(Usuario usuario) {
		usuariorepository.save(usuario);
	}


	@Override
	@Transactional
	public void delete(Long id) {
		usuariorepository.deleteById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Usuario> findUserById(Long id) {
		return usuariorepository.findById(id);
	}

	
	

	
}
