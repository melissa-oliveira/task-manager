package br.ufpr.taskManager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.ufpr.taskManager.entity.Usuario;
import br.ufpr.taskManager.service.UsuarioService;

@CrossOrigin
@RestController
public class UsuarioController {
	@Autowired
	private UsuarioService usuarioService;
	
	@PostMapping("/usuario")
	public Usuario inserir(@RequestBody Usuario usuario) {
		usuario.setSenha(usuarioService.hashSHA256(usuario.getSenha()));
		usuarioService.create(usuario);	
		return usuarioService.findByEmail(usuario.getEmail());
	}
	 
	@GetMapping("/usuario")
	 public List<Usuario> buscar() {
		return usuarioService.findAll();		
	}
	
	@GetMapping("/usuario/{id}")
	public Usuario buscarPorId(@PathVariable("id") Integer id) {		
		return usuarioService.findById(id);	  
	}
	
	@GetMapping("/usuario/email/{email}")
	public Usuario buscarPorEmail(@PathVariable("email") String email) {		
		return usuarioService.findByEmail(email);	  
	}
	
	@PutMapping("/usuario")
	public Usuario atualizar(@RequestBody Usuario usuario) { 
	    return usuarioService.update(usuario);	       
	}
	
	@DeleteMapping("/usuario/{id}")
	public void deletarPorId(@PathVariable("id") Integer id) {		
		usuarioService.delete(id);		  
	}

}