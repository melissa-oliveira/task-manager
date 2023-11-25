package br.ufpr.taskManager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufpr.taskManager.entity.TaskCategory;
import br.ufpr.taskManager.repository.TaskCategoryRepository;

@Service
public class TaskCategoryService {

    @Autowired
    private TaskCategoryRepository taskCategoryRepository;

    public List<TaskCategory> findAll() {
        return taskCategoryRepository.findAll();
    }

    public TaskCategory findById(Integer id) {
        return taskCategoryRepository.findById(id).orElse(null);
    }

    public TaskCategory create(TaskCategory entity) {
        return taskCategoryRepository.save(entity);
    }

    public TaskCategory update(TaskCategory entity) {
        TaskCategory existingCategory = taskCategoryRepository.findById(entity.getId()).orElse(null);

        if (existingCategory != null) {
            existingCategory.setName(entity.getName());
            existingCategory.setDescription(entity.getDescription());
            existingCategory.setColor(entity.getColor());

            TaskCategory updatedCategory = taskCategoryRepository.save(existingCategory);
            return updatedCategory;
        } else {
            return null;
        }
    }

    public void delete(Integer id) {
        taskCategoryRepository.deleteById(id);
    }
}
