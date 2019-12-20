package com.alejandro.springmysql.service;

import java.util.List;
import java.util.Optional;

import com.alejandro.springmysql.models.Usuario;

public interface IUsuarioService {
	public List<Usuario> listar();
	public void save(Usuario usuario);
	public void delete(Long id);
	public Optional<Usuario> findUserById(Long id);
	
}
