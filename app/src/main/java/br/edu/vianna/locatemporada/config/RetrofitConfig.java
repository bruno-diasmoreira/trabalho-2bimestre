package br.edu.vianna.locatemporada.config;

import br.edu.vianna.locatemporada.service.ClienteService;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitConfig {

    private Retrofit retrofit;


    public RetrofitConfig() {

       retrofit =  new Retrofit.Builder().baseUrl("http://localhost:8080/").
                addConverterFactory(GsonConverterFactory.create()).build();

    }

    public Retrofit getRetrofit() {
        return retrofit;
    }
}
//"http://10.0.0.67:9001/"