package br.edu.vianna.locatemporada.model;

import com.google.gson.annotations.Expose;

import java.time.LocalDateTime;
import java.util.Date;

public class ListaComentarios {

    private int id;


    private String nome;

    private String texto;


    private String data;

    public ListaComentarios() {
    }

    public ListaComentarios(int id, String nome, String texto, String data) {
        this.id = id;
        this.nome = nome;
        this.texto = texto;
        this.data = data;
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

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
