package br.edu.vianna.locatemporada.model.dto;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;


public class ClienteDTO implements Serializable {


    private String nome;
    private String token;

    public ClienteDTO() {
    }

    public ClienteDTO(String nome, String token) {
        this.nome = nome;
        this.token = token;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
