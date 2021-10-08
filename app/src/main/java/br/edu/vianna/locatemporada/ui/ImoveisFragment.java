package br.edu.vianna.locatemporada.ui;

import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.edu.vianna.locatemporada.R;
import br.edu.vianna.locatemporada.adapter.ImovelAdapter;
import br.edu.vianna.locatemporada.config.RetrofitConfig;
import br.edu.vianna.locatemporada.model.Imovel;
import br.edu.vianna.locatemporada.model.ListaComentarios;
import br.edu.vianna.locatemporada.model.dto.ClienteDTO;
import br.edu.vianna.locatemporada.model.dto.response.ResponseClienteDTO;
import br.edu.vianna.locatemporada.model.dto.response.ResponseImovelDTO;
import br.edu.vianna.locatemporada.service.ClienteService;
import br.edu.vianna.locatemporada.service.ImovelService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;


public class ImoveisFragment extends Fragment {


    private List<Imovel> listaImoveis;
    private RecyclerView rvImovel;

    private ClienteDTO clienteDTO;

    private ProgressBar progressBarImoveis;


    public ImoveisFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //pegando o cliente
        clienteDTO =(ClienteDTO) getArguments().getSerializable("cliente");



        View view = inflater.inflate(R.layout.fragment_imoveis, container, false);


        progressBarImoveis = view.findViewById(R.id.progressBarImoveis);


        Retrofit retrofit = new RetrofitConfig().getRetrofit();


        ImovelService imService = retrofit.create(ImovelService.class);

        Call<ResponseImovelDTO> imovel = imService.retornarTodosImoveis();

        imovel.enqueue(new Callback<ResponseImovelDTO>() {
            @Override
            public void onResponse(Call<ResponseImovelDTO> call, Response<ResponseImovelDTO> response) {

                progressBarImoveis.setVisibility(View.GONE);


                ResponseImovelDTO resp = response.body();

                rvImovel = view.findViewById(R.id.rvImovel);
                rvImovel.setLayoutManager(new LinearLayoutManager(getContext()));
                ImovelAdapter adapter = new ImovelAdapter(getContext(),resp.getImoveis());
                rvImovel.setAdapter(adapter);

                adapter.setClienteDTO(clienteDTO);
            }

            @Override
            public void onFailure(Call<ResponseImovelDTO> call, Throwable t) {
                progressBarImoveis.setVisibility(View.GONE);
                Log.e("erroRESPONSE","ERRO: "+t.getMessage());
            }
        });



        return view;
        //return inflater.inflate(R.layout.fragment_imoveis, container, false);

    }

    public List<Imovel> preencherLista(){

        listaImoveis = new ArrayList<>();

        return null;
    }



}