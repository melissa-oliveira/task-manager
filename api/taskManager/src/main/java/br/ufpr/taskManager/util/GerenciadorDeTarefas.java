package br.ufpr.taskManager.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.ufpr.taskManager.entity.CategoriaTarefa;
import br.ufpr.taskManager.entity.EstadoTarefa;
import br.ufpr.taskManager.entity.Tarefa;
import br.ufpr.taskManager.entity.Usuario;

public class GerenciadorDeTarefas {
	private List<Tarefa> listaTarefas;

    public List<Tarefa> getListaTarefas() {
        return listaTarefas;
    }

    public void setListaTarefas(List<Tarefa> listaTarefas) {
        this.listaTarefas = listaTarefas;
    }
    

    public GerenciadorDeTarefas(List<Tarefa> listaTarefas) {
        this.listaTarefas = listaTarefas;
    }

    public void criarTarefa(int id, String titulo, String descricao, Date dataVencimento, Usuario responsavel, int prioridade, EstadoTarefa estado, CategoriaTarefa categoria) {
        Tarefa novaTarefa = new Tarefa(id, titulo, descricao, dataVencimento, responsavel, prioridade, estado, categoria);
        listaTarefas.add(novaTarefa);
    }

    public void atribuirTarefaAUsuario(Tarefa tarefa, Usuario usuario) {
        if (listaTarefas.contains(tarefa)) {
            tarefa.setResponsavel(usuario);
            usuario.adicionarTarefa(tarefa);
        } else {
            System.out.println("Tarefa não encontrada na lista de tarefas.");
        }
    }

    public void removerTarefa(Tarefa tarefa) {
        if (listaTarefas.contains(tarefa)) {
            listaTarefas.remove(tarefa);
            tarefa.getResponsavel().removerTarefa(tarefa);
        } else {
            System.out.println("Tarefa não encontrada na lista de tarefas.");
        }
    }

    public List<Tarefa> listarTarefas() {
        return listaTarefas;
    }

    public List<Tarefa> listarTarefasConcluidas() {
        List<Tarefa> tarefasConcluidas = new ArrayList<>();
        for (Tarefa tarefa : listaTarefas) {
            if (tarefa.isConcluida()) {
                tarefasConcluidas.add(tarefa);
            }
        }
        return tarefasConcluidas;
    }

    public List<Tarefa> listarTarefasAtrasadas() {
        List<Tarefa> tarefasAtrasadas = new ArrayList<>();
        Date dataAtual = new Date();
        for (Tarefa tarefa : listaTarefas) {
            if (!tarefa.isConcluida() && tarefa.getDataVencimento().before(dataAtual)) {
                tarefasAtrasadas.add(tarefa);
            }
        }
        return tarefasAtrasadas;
    }
}
