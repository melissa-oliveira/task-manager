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

import br.ufpr.taskManager.entity.TaskState;
import br.ufpr.taskManager.service.TaskStateService;

@CrossOrigin
@RestController
public class TaskStateController {

    @Autowired
    private TaskStateService taskStateService;

    @PostMapping("/taskState")
    public TaskState insert(@RequestBody TaskState taskState) {
        return taskStateService.create(taskState);
    }

    @GetMapping("/taskState")
    public List<TaskState> findAll() {
        return taskStateService.findAll();
    }

    @GetMapping("/taskState/{id}")
    public TaskState findById(@PathVariable("id") Integer id) {
        return taskStateService.findById(id);
    }

    @PutMapping("/taskState")
    public TaskState update(@RequestBody TaskState taskState) {
        return taskStateService.update(taskState);
    }

    @DeleteMapping("/taskState/{id}")
    public void deleteById(@PathVariable("id") Integer id) {
        taskStateService.delete(id);
    }
}
