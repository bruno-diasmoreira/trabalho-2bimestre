package br.edu.vianna.locatemporada.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Imovel implements Serializable {

    private int id;

    private String nome;

    private String local;

    private String descricao;

    @SerializedName("valor_diaria")
    private double valorDiaria;

    private String foto;

    @SerializedName("lista_comentarios")
    private List<ListaComentarios> listaComentarios;


    public Imovel() {
    }

    public Imovel(int id, String nome, String local, String descricao, double valorDiaria, String foto, List<ListaComentarios> listaComentarios) {
        this.id = id;
        this.nome = nome;
        this.local = local;
        this.descricao = descricao;
        this.valorDiaria = valorDiaria;
        this.foto = foto;
        this.listaComentarios = listaComentarios;
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

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValorDiaria() {
        return valorDiaria;
    }

    public void setValorDiaria(double valorDiaria) {
        this.valorDiaria = valorDiaria;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public List<ListaComentarios> getListaComentarios() {
        return listaComentarios;
    }

    public void setListaComentarios(ListaComentarios listaComentarios) {
        this.listaComentarios.add(listaComentarios);
    }
}

