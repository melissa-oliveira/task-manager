package br.ufpr.taskManager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.ufpr.taskManager.entity.Tarefa;
import br.ufpr.taskManager.service.TarefaService;

@CrossOrigin
@RestController
public class TarefaController {

    @Autowired
    private TarefaService tarefaService;

    @PostMapping("/tarefa")
    public Tarefa inserir(@RequestBody Tarefa tarefa) {
        return tarefaService.create(tarefa);
    }

    @GetMapping("/tarefa")
    public List<Tarefa> buscar() {
        return tarefaService.findAll();
    }

    @GetMapping("/tarefa/{id}")
    public Tarefa buscarPorId(@PathVariable("id") Integer id) {
        return tarefaService.findById(id);
    }

    @PutMapping("/tarefa")
    public Tarefa atualizar(@RequestBody Tarefa tarefa) {
        return tarefaService.update(tarefa);
    }

    @DeleteMapping("/tarefa/{id}")
    public void deletarPorId(@PathVariable("id") Integer id) {
        tarefaService.delete(id);
    }
}
