package br.ufpr.taskManager.repository;

import br.ufpr.taskManager.entity.User;

import org.springframework.data.jpa.repository.*;

import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	 public User findByEmail(String email);
}
