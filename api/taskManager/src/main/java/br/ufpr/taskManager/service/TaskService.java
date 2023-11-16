package br.ufpr.taskManager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufpr.taskManager.entity.Task;
import br.ufpr.taskManager.repository.TaskRepository;
import br.ufpr.taskManager.service.interfaces.ITaskService;

@Service
public class TaskService implements ITaskService {

    @Autowired
    private TaskRepository taskRepository;

    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    public Task findById(Integer id) {
        return taskRepository.findById(id).orElse(null);
    }

    public Task create(Task entity) {
        return taskRepository.save(entity);
    }

    public Task update(Task entity) {
        Task existingTask = taskRepository.findById(entity.getId()).orElse(null);

        if (existingTask != null) {
            existingTask.setTitle(entity.getTitle());
            existingTask.setDescription(entity.getDescription());
            existingTask.setDueDate(entity.getDueDate());
            existingTask.setCompleted(entity.isCompleted());
            existingTask.setResponsible(entity.getResponsible());
            existingTask.setPriority(entity.getPriority());
            existingTask.setState(entity.getState());
            existingTask.setCategory(entity.getCategory());
       
            Task updatedTask = taskRepository.save(existingTask);
            return updatedTask;
        } else {
            return null;
        }
    }

    public void delete(Integer id) {
        taskRepository.deleteById(id);
    }
}
