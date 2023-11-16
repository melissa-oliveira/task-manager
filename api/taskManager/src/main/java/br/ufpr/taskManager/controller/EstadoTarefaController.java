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

import br.ufpr.taskManager.entity.EstadoTarefa;
import br.ufpr.taskManager.service.EstadoTarefaService;

@CrossOrigin
@RestController
public class EstadoTarefaController {

    @Autowired
    private EstadoTarefaService estadoTarefaService;

    @PostMapping("/estadoTarefa")
    public EstadoTarefa inserir(@RequestBody EstadoTarefa estadoTarefa) {
        return estadoTarefaService.create(estadoTarefa);
    }

    @GetMapping("/estadoTarefa")
    public List<EstadoTarefa> buscar() {
        return estadoTarefaService.findAll();
    }

    @GetMapping("/estadoTarefa/{id}")
    public EstadoTarefa buscarPorId(@PathVariable("id") Integer id) {
        return estadoTarefaService.findById(id);
    }

    @PutMapping("/estadoTarefa")
    public EstadoTarefa atualizar(@RequestBody EstadoTarefa estadoTarefa) {
        return estadoTarefaService.update(estadoTarefa);
    }

    @DeleteMapping("/estadoTarefa/{id}")
    public void deletarPorId(@PathVariable("id") Integer id) {
        estadoTarefaService.delete(id);
    }
}
