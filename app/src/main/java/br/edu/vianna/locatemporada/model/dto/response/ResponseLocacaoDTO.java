package br.edu.vianna.locatemporada.model.dto.response;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ResponseLocacaoDTO implements Serializable {

    private int statusCode;

    @SerializedName("data")
    private String mensagem;


    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}
