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

import br.ufpr.taskManager.entity.TaskCategory;
import br.ufpr.taskManager.entity.User;
import br.ufpr.taskManager.service.TaskCategoryService;

@CrossOrigin
@RestController
public class TaskCategoryController {

    @Autowired
    private TaskCategoryService taskCategoryService;

    @PostMapping("/taskCategory")
    public TaskCategory insert(@RequestBody TaskCategory taskCategory) {
        return taskCategoryService.create(taskCategory);
    }

    @GetMapping("/taskCategory")
    public List<TaskCategory> findAll() {
        return taskCategoryService.findAll();
    }
    
    @PostMapping("/taskCategory/user")
    public List<TaskCategory> findByUser(@RequestBody User user) {
        return taskCategoryService.findByUser(user);
    }

    @GetMapping("/taskCategory/{id}")
    public TaskCategory findById(@PathVariable("id") Integer id) {
        return taskCategoryService.findById(id);
    }

    @PutMapping("/taskCategory")
    public TaskCategory update(@RequestBody TaskCategory taskCategory) {
        return taskCategoryService.update(taskCategory);
    }

    @DeleteMapping("/taskCategory/{id}")
    public void deleteById(@PathVariable("id") Integer id) {
        taskCategoryService.delete(id);
    }
}
