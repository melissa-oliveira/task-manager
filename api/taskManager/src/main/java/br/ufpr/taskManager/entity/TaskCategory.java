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

@Entity
@Table (name="tb_task_category")
public class TaskCategory implements Serializable {
	@Id   
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(name="id")
    private int id;
	
	@Column(name="name")
    private String name;
	
	@Column(name="description")
    private String description;
	
	@Column(name="color")
    private String color;
	
    @ManyToOne
    @JoinColumn(name = "responsible_id")
    private User responsible;

	
	public TaskCategory() {

	}
    
	public TaskCategory(int id, String name, String description, String color, User responsible) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.color = color;
		this.responsible = responsible;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public User getResponsible() {
		return responsible;
	}

	public void setResponsible(User responsible) {
		this.responsible = responsible;
	}
}
