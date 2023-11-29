package br.ufpr.taskManager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ufpr.taskManager.entity.Task;
import br.ufpr.taskManager.entity.User;

public interface TaskRepository extends JpaRepository<Task, Integer>{
	public List<Task> findByResponsible(User user);
}
