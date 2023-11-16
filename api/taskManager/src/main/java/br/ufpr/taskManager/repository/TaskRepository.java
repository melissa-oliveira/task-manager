package br.ufpr.taskManager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ufpr.taskManager.entity.Task;

public interface TaskRepository extends JpaRepository<Task, Integer>{

}
