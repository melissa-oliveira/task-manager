package br.ufpr.taskManager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufpr.taskManager.entity.TaskState;
import br.ufpr.taskManager.repository.TaskStateRepository;

@Service
public class TaskStateService {

    @Autowired
    private TaskStateRepository taskStateRepository;

    public List<TaskState> findAll() {
        return taskStateRepository.findAll();
    }

    public TaskState findById(Integer id) {
        return taskStateRepository.findById(id).orElse(null);
    }

    public TaskState create(TaskState entity) {
        return taskStateRepository.save(entity);
    }

    public TaskState update(TaskState entity) {
        TaskState existingState = taskStateRepository.findById(entity.getId()).orElse(null);

        if (existingState != null) {
            existingState.setName(entity.getName());
            existingState.setDescription(entity.getDescription());

            TaskState updatedState = taskStateRepository.save(existingState);
            return updatedState;
        } else {
            return null;
        }
    }

    public void delete(Integer id) {
        taskStateRepository.deleteById(id);
    }
}
