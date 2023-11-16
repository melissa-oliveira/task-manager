package br.ufpr.taskManager.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import java.util.Date;

@Entity
@Table (name="tb_tarefa")
public class Tarefa implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "titulo")
    private String titulo;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "dataVencimento")
    private Date dataVencimento;

    @Column(name = "concluida")
    private boolean concluida;

    @ManyToOne
    @JoinColumn(name = "responsavel_id")
    private Usuario responsavel;

    @Column(name = "prioridade")
    private int prioridade;

    @ManyToOne
    @JoinColumn(name = "estado_id")
    private EstadoTarefa estado;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private CategoriaTarefa categoria;
    
    public Tarefa() {
    	
    }

    public Tarefa(int id, String titulo, String descricao, Date dataVencimento, Usuario responsavel, int prioridade, EstadoTarefa estado, CategoriaTarefa categoria) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.dataVencimento = dataVencimento;
        this.concluida = false;
        this.responsavel = responsavel;
        this.prioridade = prioridade;
        this.estado = estado;
        this.categoria = categoria;
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public boolean isConcluida() {
		return concluida;
	}

	public void setConcluida(boolean concluida) {
		this.concluida = concluida;
	}

	public Usuario getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(Usuario responsavel) {
		this.responsavel = responsavel;
	}

	public int getPrioridade() {
		return prioridade;
	}

	public void setPrioridade(int prioridade) {
		this.prioridade = prioridade;
	}

	public EstadoTarefa getEstado() {
		return estado;
	}

	public void setEstado(EstadoTarefa estado) {
		this.estado = estado;
	}

	public CategoriaTarefa getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaTarefa categoria) {
		this.categoria = categoria;
	}
}
