package br.edu.vianna.locatemporada.service;

import br.edu.vianna.locatemporada.model.dto.LoginDTO;
import br.edu.vianna.locatemporada.model.dto.response.ResponseClienteDTO;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ClienteService {

    @POST("cliente/login")
    Call<ResponseClienteDTO> validarLogin(@Body LoginDTO login);



}
