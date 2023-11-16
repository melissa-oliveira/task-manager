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

import br.ufpr.taskManager.entity.CategoriaTarefa;
import br.ufpr.taskManager.service.CategoriaTarefaService;

@CrossOrigin
@RestController
public class CategoriaTarefaController {

    @Autowired
    private CategoriaTarefaService categoriaTarefaService;

    @PostMapping("/categoriaTarefa")
    public CategoriaTarefa inserir(@RequestBody CategoriaTarefa categoriaTarefa) {
        return categoriaTarefaService.create(categoriaTarefa);
    }

    @GetMapping("/categoriaTarefa")
    public List<CategoriaTarefa> buscar() {
        return categoriaTarefaService.findAll();
    }

    @GetMapping("/categoriaTarefa/{id}")
    public CategoriaTarefa buscarPorId(@PathVariable("id") Integer id) {
        return categoriaTarefaService.findById(id);
    }

    @PutMapping("/categoriaTarefa")
    public CategoriaTarefa atualizar(@RequestBody CategoriaTarefa categoriaTarefa) {
        return categoriaTarefaService.update(categoriaTarefa);
    }

    @DeleteMapping("/categoriaTarefa/{id}")
    public void deletarPorId(@PathVariable("id") Integer id) {
        categoriaTarefaService.delete(id);
    }
}
