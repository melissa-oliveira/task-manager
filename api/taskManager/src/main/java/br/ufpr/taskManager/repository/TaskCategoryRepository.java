package br.ufpr.taskManager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ufpr.taskManager.entity.TaskCategory;
import br.ufpr.taskManager.entity.User;

public interface TaskCategoryRepository extends JpaRepository<TaskCategory, Integer>{
	public List<TaskCategory> findByResponsible(User user);
}
