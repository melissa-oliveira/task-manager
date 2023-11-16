package br.ufpr.taskManager.repository;

import br.ufpr.taskManager.entity.Usuario;

import org.springframework.data.jpa.repository.*;

import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
	 public Usuario findByEmail(String email);
}
