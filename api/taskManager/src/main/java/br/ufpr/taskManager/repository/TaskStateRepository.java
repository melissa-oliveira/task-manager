package br.ufpr.taskManager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ufpr.taskManager.entity.TaskState;

public interface TaskStateRepository extends JpaRepository<TaskState, Integer>{

}
