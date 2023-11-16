package br.ufpr.taskManager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufpr.taskManager.entity.EstadoTarefa;
import br.ufpr.taskManager.repository.EstadoTarefaRepository;
import br.ufpr.taskManager.service.interfaces.IEstadoTarefaService;

@Service
public class EstadoTarefaService implements IEstadoTarefaService {

    @Autowired
    private EstadoTarefaRepository estadoTarefaRepository;

    public List<EstadoTarefa> findAll() {
        return estadoTarefaRepository.findAll();
    }

    public EstadoTarefa findById(Integer id) {
        return estadoTarefaRepository.findById(id).orElse(null);
    }

    public EstadoTarefa create(EstadoTarefa entity) {
        return estadoTarefaRepository.save(entity);
    }

    public EstadoTarefa update(EstadoTarefa entity) {
        EstadoTarefa estadoExistente = estadoTarefaRepository.findById(entity.getId()).orElse(null);

        if (estadoExistente != null) {
        	estadoExistente.setNome(entity.getNome());
            estadoExistente.setDescricao(entity.getDescricao());

            EstadoTarefa estadoAtualizado = estadoTarefaRepository.save(estadoExistente);
            return estadoAtualizado;
        } else {
            return null;
        }
    }

    public void delete(Integer id) {
        estadoTarefaRepository.deleteById(id);
    }
}
