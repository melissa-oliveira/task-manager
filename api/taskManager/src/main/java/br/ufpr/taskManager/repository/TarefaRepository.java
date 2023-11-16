package br.ufpr.taskManager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ufpr.taskManager.entity.Tarefa;

public interface TarefaRepository extends JpaRepository<Tarefa, Integer>{

}
