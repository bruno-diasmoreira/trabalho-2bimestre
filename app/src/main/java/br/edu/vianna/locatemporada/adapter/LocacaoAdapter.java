package br.edu.vianna.locatemporada.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import br.edu.vianna.locatemporada.R;
import br.edu.vianna.locatemporada.holder.ImovelHolder;
import br.edu.vianna.locatemporada.holder.LocacaoHolder;
import br.edu.vianna.locatemporada.model.Imovel;
import br.edu.vianna.locatemporada.model.Locacao;
import br.edu.vianna.locatemporada.model.dto.ClienteDTO;

public class LocacaoAdapter extends RecyclerView.Adapter {

    private List<Locacao> listaLocacoes;
    private Context context;

    private ClienteDTO clienteDTO;

    public ClienteDTO getClienteDTO() {
        return clienteDTO;
    }

    public void setClienteDTO(ClienteDTO clienteDTO) {
        this.clienteDTO = clienteDTO;
    }

    public LocacaoAdapter(Context context, List<Locacao> lista) {
        this.listaLocacoes = lista;
        this.context = context;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(context).inflate(R.layout.locacao_linha, parent,false);

        LocacaoHolder holder = new LocacaoHolder(v);


        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        ((LocacaoHolder)holder).preenche( listaLocacoes.get(position));

    }

    @Override
    public int getItemCount() {
        return listaLocacoes.size();
    }
}
