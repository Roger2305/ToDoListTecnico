package br.senai.sp.informatica.todolist.modelo;

import java.util.List;

/**
 * Created by Tecnico_Manha on 01/03/2017.
 */

public class Tarefa {
    private Long id;
    private String titulo;
    private List<Subtarefa> subtarefas;
    private boolean feita;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public List<Subtarefa> getSubtarefas() {
        return subtarefas;
    }

    public void setSubtarefas(List<Subtarefa> subtarefas) {
        this.subtarefas = subtarefas;
    }

    public boolean isFeita() {
        return feita;
    }

    public void setFeita(boolean feita) {
        this.feita = feita;
    }
}
