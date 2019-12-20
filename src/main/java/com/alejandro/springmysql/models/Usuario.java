package com.alejandro.springmysql.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "usuarios")
public class Usuario implements Serializable{
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotEmpty
	private String nombre;
	@NotEmpty
	@Email
	private String email;
	
	public Usuario(Long id, String nombre, String email) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.email = email;
	}
	public Usuario() {
		super();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	private static final long serialVersionUID = 1L;
	
	
	

}
