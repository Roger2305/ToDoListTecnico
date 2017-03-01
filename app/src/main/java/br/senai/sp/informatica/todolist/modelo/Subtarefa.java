package br.senai.sp.informatica.todolist.modelo;

/**
 * Created by Tecnico_Manha on 01/03/2017.
 */

public class Subtarefa {
    private Long id;
    private String descricao;
    private boolean feito;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isFeito() {
        return feito;
    }

    public void setFeito(boolean feito) {
        this.feito = feito;
    }

    @Override
    public String toString() {
        return descricao;
    }
}
