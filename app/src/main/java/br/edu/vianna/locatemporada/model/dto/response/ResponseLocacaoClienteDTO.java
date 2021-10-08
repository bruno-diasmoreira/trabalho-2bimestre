package br.edu.vianna.locatemporada.model.dto.response;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

import br.edu.vianna.locatemporada.model.Imovel;
import br.edu.vianna.locatemporada.model.Locacao;

public class ResponseLocacaoClienteDTO implements Serializable {

    private int statusCode;

    @SerializedName("data")
   private List<Locacao> locacoes;

    public ResponseLocacaoClienteDTO() {
    }

    public ResponseLocacaoClienteDTO(int statusCode, List<Locacao> locacoes) {
        this.statusCode = statusCode;
        this.locacoes = locacoes;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public List<Locacao> getLocacoes() {
        return locacoes;
    }

    public void setLocacoes(Locacao locacoes) {
        this.locacoes.add(locacoes);
    }
}
