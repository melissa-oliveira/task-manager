package br.ufpr.taskManager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ufpr.taskManager.entity.EstadoTarefa;

public interface EstadoTarefaRepository extends JpaRepository<EstadoTarefa, Integer>{

}
