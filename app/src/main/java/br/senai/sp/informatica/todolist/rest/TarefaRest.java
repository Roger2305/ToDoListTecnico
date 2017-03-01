package br.senai.sp.informatica.todolist.rest;

import android.content.Context;

import com.google.gson.Gson;

import br.senai.sp.informatica.todolist.modelo.Tarefa;
import br.senai.sp.informatica.todolist.util.PrefsUtil;
import br.senai.sp.informatica.todolist.util.RestUtil;

/**
 * Created by Tecnico_Manha on 01/03/2017.
 */

public class TarefaRest {

    public static void novaTarefa(Tarefa tarefa, Context context) throws Exception {
        String url = PrefsUtil.getEndereco(context) + "/tarefa";
        Gson gson = new Gson();
        String json = gson.toJson(tarefa);
        RestUtil.post(json, url, context);
    }
}
