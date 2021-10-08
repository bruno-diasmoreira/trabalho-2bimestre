package br.edu.vianna.locatemporada.service;

import br.edu.vianna.locatemporada.model.dto.LoginDTO;
import br.edu.vianna.locatemporada.model.dto.response.ResponseClienteDTO;
import br.edu.vianna.locatemporada.model.dto.response.ResponseImovelDTO;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;

public interface ImovelService {


    @GET("imovel")
    Call<ResponseImovelDTO> retornarTodosImoveis();


}
