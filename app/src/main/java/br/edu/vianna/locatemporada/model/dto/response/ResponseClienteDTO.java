package br.edu.vianna.locatemporada.model.dto.response;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

import br.edu.vianna.locatemporada.model.dto.ClienteDTO;

public class ResponseClienteDTO implements Serializable {

    private int statusCode;

    @SerializedName("data")
    ClienteDTO cliente;

    public ResponseClienteDTO() {
    }

    public ResponseClienteDTO(int statusCode, ClienteDTO cliente) {
        this.statusCode = statusCode;
        this.cliente = cliente;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public ClienteDTO getCliente() {
        return cliente;
    }

    public void setCliente(ClienteDTO cliente) {
        this.cliente = cliente;
    }
}
