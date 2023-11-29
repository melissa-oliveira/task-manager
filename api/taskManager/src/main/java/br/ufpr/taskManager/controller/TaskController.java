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

import br.ufpr.taskManager.entity.Task;
import br.ufpr.taskManager.entity.User;
import br.ufpr.taskManager.service.TaskService;

@CrossOrigin
@RestController
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping("/task")
    public Task insert(@RequestBody Task task) {
        return taskService.create(task);
    }

    @GetMapping("/task")
    public List<Task> findAll() {
        return taskService.findAll();
    }

    @PostMapping("/task/user")
    public List<Task> findByUser(@RequestBody User user) {
        return taskService.findByUser(user);
    }

    @GetMapping("/task/{id}")
    public Task findById(@PathVariable("id") Integer id) {
        return taskService.findById(id);
    }

    @PutMapping("/task")
    public Task update(@RequestBody Task task) {
        return taskService.update(task);
    }

    @DeleteMapping("/task/{id}")
    public void deleteById(@PathVariable("id") Integer id) {
        taskService.delete(id);
    }
}
