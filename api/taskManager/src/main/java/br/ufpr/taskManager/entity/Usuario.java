package br.ufpr.taskManager.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
@Table (name="tb_usuario")
public class Usuario implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "senha", nullable = false)
    private String senha;

    @OneToMany(mappedBy = "responsavel")
    private List<Tarefa> listaTarefas;

    public Usuario() {
      
    }
    
	public Usuario(int id, String nome, String email, String senha, List<Tarefa> listaTarefas) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.listaTarefas = listaTarefas;
	}
	
    public void adicionarTarefa(Tarefa tarefa) {
        listaTarefas.add(tarefa);
    }

    public void removerTarefa(Tarefa tarefa) {
        listaTarefas.remove(tarefa);
    }

    public List<Tarefa> listarTarefas() {
        return listaTarefas;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public List<Tarefa> getListaTarefas() {
		return listaTarefas;
	}

	public void setListaTarefas(List<Tarefa> listaTarefas) {
		this.listaTarefas = listaTarefas;
	}
}
