package br.ufpr.taskManager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufpr.taskManager.entity.Tarefa;
import br.ufpr.taskManager.repository.TarefaRepository;
import br.ufpr.taskManager.service.interfaces.ITarefaService;

@Service
public class TarefaService implements ITarefaService {

    @Autowired
    private TarefaRepository tarefaRepository;

    public List<Tarefa> findAll() {
        return tarefaRepository.findAll();
    }

    public Tarefa findById(Integer id) {
        return tarefaRepository.findById(id).orElse(null);
    }

    public Tarefa create(Tarefa entity) {
        return tarefaRepository.save(entity);
    }

    public Tarefa update(Tarefa entity) {
        Tarefa tarefaExistente = tarefaRepository.findById(entity.getId()).orElse(null);

        if (tarefaExistente != null) {
        	tarefaExistente.setTitulo(entity.getTitulo());
            tarefaExistente.setDescricao(entity.getDescricao());
            tarefaExistente.setDataVencimento(entity.getDataVencimento());
            tarefaExistente.setConcluida(entity.isConcluida());
            tarefaExistente.setResponsavel(entity.getResponsavel());
            tarefaExistente.setPrioridade(entity.getPrioridade());
            tarefaExistente.setEstado(entity.getEstado());
            tarefaExistente.setCategoria(entity.getCategoria());

            Tarefa tarefaAtualizada = tarefaRepository.save(tarefaExistente);
            return tarefaAtualizada;
        } else {
            return null;
        }
    }

    public void delete(Integer id) {
        tarefaRepository.deleteById(id);
    }
}
