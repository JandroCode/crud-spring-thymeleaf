package com.alejandro.springmysql.controllers;

import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.alejandro.springmysql.models.Usuario;
import com.alejandro.springmysql.service.IUsuarioService;

@Controller
@SessionAttributes("usuario")
public class UsuarioController {
	
	@Autowired
	@Qualifier("usuarioservice")
	private IUsuarioService usuarioservice;
	
	@GetMapping("/")
	public String listar(Model model){
		model.addAttribute("title", "listado de usuarios");
		model.addAttribute("usuarios", usuarioservice.listar());
		model.addAttribute("usuario", new Usuario());
		return "listar";
	}
	
	//Formulario para agregar usuarios
	@GetMapping("/usersform")
	public String usersform(Map<String, Object>model) {
		Usuario usuario = new Usuario();
		model.put("usuario", usuario);
		model.put("title", "Agregar");
		return "usersform";
	}
	//Método para guardar usuarios
	@PostMapping("/save")
	public String save(@Valid Usuario usuario,BindingResult result, SessionStatus status, Model model, RedirectAttributes flash) {
		if(result.hasErrors()) {
			model.addAttribute("title", "Guardar");
			return "usersform";
		}
		usuarioservice.save(usuario);
		status.setComplete();
		flash.addFlashAttribute("success", "Usuario creado con éxito");
		return "redirect:/";
	}
	
	//Método para eliminar usuarios
	@GetMapping("/delete/{id}")
	public String detele(@PathVariable(value = "id")Long id, RedirectAttributes flash) {
		if(id>0) {
			usuarioservice.delete(id);
			flash.addFlashAttribute("success","Usuario eliminado con éxito");
		}
		return "redirect:/";
	}
	//Formulario para editar usuarios
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable(value = "id")Long id, Map<String,Object>model) {
		Optional<Usuario> usuario = null;
		if(id>0) {
			usuario = usuarioservice.findUserById(id);
			
			
		}else {
			return "redirect:/";
		}
		
		model.put("usuario", usuario);
		model.put("title","Editar");
		
		
		return "usersform";
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
