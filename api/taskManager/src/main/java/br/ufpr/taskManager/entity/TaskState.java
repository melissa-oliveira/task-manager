package br.ufpr.taskManager.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Table (name="tb_task_state")
public class TaskState implements Serializable {
	@Id   
	@GeneratedValue(strategy = GenerationType.IDENTITY)   
	@Column(name="id")
	private int id;
	
	@Column(name="name")
    private String name;
	
	@Column(name="description")
    private String description;
	
	public TaskState() {
		
	}
    
	public TaskState(int id, String name, String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
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

}
