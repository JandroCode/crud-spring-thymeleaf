package com.alejandro.springmysql.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alejandro.springmysql.models.Usuario;

@Repository("usuariorepository")
public interface IUsuarioRepository extends JpaRepository<Usuario, Long> {
	

	

}
