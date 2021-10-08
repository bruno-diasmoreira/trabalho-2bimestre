package br.edu.vianna.locatemporada.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import java.util.List;

import br.edu.vianna.locatemporada.R;
import br.edu.vianna.locatemporada.adapter.ImovelAdapter;
import br.edu.vianna.locatemporada.adapter.LocacaoAdapter;
import br.edu.vianna.locatemporada.config.RetrofitConfig;
import br.edu.vianna.locatemporada.model.Locacao;
import br.edu.vianna.locatemporada.model.dto.ClienteDTO;
import br.edu.vianna.locatemporada.model.dto.response.ResponseImovelDTO;
import br.edu.vianna.locatemporada.model.dto.response.ResponseLocacaoClienteDTO;
import br.edu.vianna.locatemporada.model.dto.response.ResponseLocacaoDTO;
import br.edu.vianna.locatemporada.service.ImovelService;
import br.edu.vianna.locatemporada.service.LocacaoService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;


public class MinhasLocacoesFragment extends Fragment {

    private List<Locacao> locacoes;

    private RecyclerView rvMinhasLocacoes;

    private ClienteDTO clienteDTO;

    private ProgressBar progressBarMinhasLocacoes;


    public MinhasLocacoesFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }

        clienteDTO =(ClienteDTO) getArguments().getSerializable("cliente");

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_minhas_locacoes, container, false);



        progressBarMinhasLocacoes = view.findViewById(R.id.progressBarMinhasLocacoes);



        Retrofit retrofit = new RetrofitConfig().getRetrofit();


        LocacaoService locacaoService = retrofit.create(LocacaoService.class);

        Call<ResponseLocacaoClienteDTO> locacaoCliente = locacaoService.buscarLocacoesCliente(clienteDTO.getToken());



        locacaoCliente.enqueue(new Callback<ResponseLocacaoClienteDTO>() {
            @Override
            public void onResponse(Call<ResponseLocacaoClienteDTO> call, Response<ResponseLocacaoClienteDTO> response) {

                progressBarMinhasLocacoes.setVisibility(View.GONE);

                ResponseLocacaoClienteDTO resp = response.body();


                rvMinhasLocacoes = view.findViewById(R.id.rvMinhasLocacoes);
                rvMinhasLocacoes.setLayoutManager(new LinearLayoutManager(getContext()));
                LocacaoAdapter adapter = new LocacaoAdapter(getContext(),resp.getLocacoes());
                rvMinhasLocacoes.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<ResponseLocacaoClienteDTO> call, Throwable t) {
                progressBarMinhasLocacoes.setVisibility(View.GONE);
                Log.e("erroRESPONSE","ERRO: "+t.getMessage());
            }
        });






        return view;
    }
}