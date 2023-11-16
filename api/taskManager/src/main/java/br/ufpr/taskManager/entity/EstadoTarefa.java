package br.ufpr.taskManager.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Table (name="tb_estado_tarefa")
public class EstadoTarefa implements Serializable {
	@Id   
	@GeneratedValue   
	@Column(name="id")
	private int id;
	
	@Column(name="nome")
    private String nome;
	
	@Column(name="descricao")
    private String descricao;
	
	public EstadoTarefa() {
		
	}
    
	public EstadoTarefa(int id, String nome, String descricao) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
