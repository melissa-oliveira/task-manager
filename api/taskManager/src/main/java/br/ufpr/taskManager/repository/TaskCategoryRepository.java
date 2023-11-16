package br.ufpr.taskManager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ufpr.taskManager.entity.TaskCategory;

public interface TaskCategoryRepository extends JpaRepository<TaskCategory, Integer>{

}
