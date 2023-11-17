package br.ufpr.taskManager.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import java.util.Date;

@Entity
@Table (name="tb_task")
public class Task implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "due_date")
    private Date dueDate;

    @Column(name = "completed")
    private boolean completed;

    @ManyToOne
    @JoinColumn(name = "responsible_id")
    private User responsible;

    @Column(name = "priority")
    private int priority;

    @ManyToOne
    @JoinColumn(name = "state_id")
    private TaskState state;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private TaskCategory category;
    
    public Task() {
    	
    }

    public Task(int id, String title, String description, Date dueDate, User responsible, int priority, TaskState state, TaskCategory category) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.completed = false;
        this.responsible = responsible;
        this.priority = priority;
        this.state = state;
        this.category = category;
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public boolean isCompleted() {
		return completed;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}

	public User getResponsible() {
		return responsible;
	}

	public void setResponsible(User responsible) {
		this.responsible = responsible;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public TaskState getState() {
		return state;
	}

	public void setState(TaskState state) {
		this.state = state;
	}

	public TaskCategory getCategory() {
		return category;
	}

	public void setCategory(TaskCategory category) {
		this.category = category;
	}

}
