package br.edu.vianna.locatemporada.model.dto.response;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

import br.edu.vianna.locatemporada.model.Imovel;
import br.edu.vianna.locatemporada.model.dto.ClienteDTO;

public class ResponseImovelDTO implements Serializable {

    private int statusCode;

    @SerializedName("data")
    List<Imovel> imoveis;


    public ResponseImovelDTO() {
    }

    public ResponseImovelDTO(int statusCode, List<Imovel> imoveis) {
        this.statusCode = statusCode;
        this.imoveis = imoveis;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public List<Imovel> getImoveis() {
        return imoveis;
    }

    public void addImoveis(Imovel imoveis) {
        this.imoveis.add(imoveis);
    }
}
