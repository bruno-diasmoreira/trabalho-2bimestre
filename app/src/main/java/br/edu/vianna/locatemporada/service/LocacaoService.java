package br.edu.vianna.locatemporada.service;

import br.edu.vianna.locatemporada.model.dto.LocacaoDTO;
import br.edu.vianna.locatemporada.model.dto.LoginDTO;
import br.edu.vianna.locatemporada.model.dto.response.ResponseClienteDTO;
import br.edu.vianna.locatemporada.model.dto.response.ResponseLocacaoClienteDTO;
import br.edu.vianna.locatemporada.model.dto.response.ResponseLocacaoDTO;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface LocacaoService {

    @POST("locacao/efetuarlocacao")
    Call<ResponseLocacaoDTO> realizarLocacao(@Body LocacaoDTO locacaoDTO);


    @GET("locacao/locacaocliente")
    Call<ResponseLocacaoClienteDTO> buscarLocacoesCliente(@Query(value = "token", encoded = true) String token);

}
