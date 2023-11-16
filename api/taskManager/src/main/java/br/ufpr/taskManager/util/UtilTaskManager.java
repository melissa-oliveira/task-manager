package br.ufpr.taskManager.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.ufpr.taskManager.entity.TaskCategory;
import br.ufpr.taskManager.entity.TaskState;
import br.ufpr.taskManager.entity.Task;
import br.ufpr.taskManager.entity.User;

public class UtilTaskManager {
    private List<Task> taskList;

    public List<Task> getTaskList() {
        return taskList;
    }

    public void setTaskList(List<Task> taskList) {
        this.taskList = taskList;
    }

    public UtilTaskManager(List<Task> taskList) {
        this.taskList = taskList;
    }

    public void createTask(int id, String title, String description, Date dueDate, User responsible, int priority, TaskState state, TaskCategory category) {
        Task newTask = new Task(id, title, description, dueDate, responsible, priority, state, category);
        taskList.add(newTask);
    }

    public void assignTaskToUser(Task task, User user) {
        if (taskList.contains(task)) {
            task.setResponsible(user);
            user.addTask(task);
        } else {
            System.out.println("Task not found in the task list.");
        }
    }

    public void removeTask(Task task) {
        if (taskList.contains(task)) {
            taskList.remove(task);
            task.getResponsible().removeTask(task);
        } else {
            System.out.println("Task not found in the task list.");
        }
    }

    public List<Task> listTasks() {
        return taskList;
    }

    public List<Task> listCompletedTasks() {
        List<Task> completedTasks = new ArrayList<>();
        for (Task task : taskList) {
            if (task.isCompleted()) {
                completedTasks.add(task);
            }
        }
        return completedTasks;
    }

    public List<Task> listOverdueTasks() {
        List<Task> overdueTasks = new ArrayList<>();
        Date currentDate = new Date();
        for (Task task : taskList) {
            if (!task.isCompleted() && task.getDueDate().before(currentDate)) {
                overdueTasks.add(task);
            }
        }
        return overdueTasks;
    }
}
