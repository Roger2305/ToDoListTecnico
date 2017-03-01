package br.senai.sp.informatica.todolist.modelo;

/**
 * Created by Tecnico_Manha on 01/03/2017.
 */

public class TokenJwt {
    private String token;

    public TokenJwt(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
