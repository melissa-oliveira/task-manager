package br.ufpr.taskManager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufpr.taskManager.entity.CategoriaTarefa;
import br.ufpr.taskManager.repository.CategoriaTarefaRepository;
import br.ufpr.taskManager.service.interfaces.ICategoriaTarefaService;

@Service
public class CategoriaTarefaService implements ICategoriaTarefaService {

    @Autowired
    private CategoriaTarefaRepository categoriaTarefaRepository;

    public List<CategoriaTarefa> findAll() {
        return categoriaTarefaRepository.findAll();
    }

    public CategoriaTarefa findById(Integer id) {
        return categoriaTarefaRepository.findById(id).orElse(null);
    }

    public CategoriaTarefa create(CategoriaTarefa entity) {
        return categoriaTarefaRepository.save(entity);
    }

    public CategoriaTarefa update(CategoriaTarefa entity) {
        CategoriaTarefa categoriaExistente = categoriaTarefaRepository.findById(entity.getId()).orElse(null);

        if (categoriaExistente != null) {
            categoriaExistente.setNome(entity.getNome());
            categoriaExistente.setDescricao(entity.getDescricao());

            CategoriaTarefa categoriaAtualizada = categoriaTarefaRepository.save(categoriaExistente);
            return categoriaAtualizada;
        } else {
            return null;
        }
    }

    public void delete(Integer id) {
        categoriaTarefaRepository.deleteById(id);
    }
}
