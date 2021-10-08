package br.edu.vianna.locatemporada.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.io.Serializable;
import java.util.List;

import br.edu.vianna.locatemporada.R;
import br.edu.vianna.locatemporada.holder.ImovelHolder;
import br.edu.vianna.locatemporada.model.Imovel;
import br.edu.vianna.locatemporada.model.dto.ClienteDTO;
import br.edu.vianna.locatemporada.ui.viewFragment.ViewImovelFragment;

public class ImovelAdapter extends RecyclerView.Adapter {

    private List<Imovel> listaImoveis;
    private Context context;

    private ClienteDTO clienteDTO;

    public ClienteDTO getClienteDTO() {
        return clienteDTO;
    }

    public void setClienteDTO(ClienteDTO clienteDTO) {
        this.clienteDTO = clienteDTO;
    }

    public ImovelAdapter(Context context, List<Imovel> lista) {
        this.listaImoveis = lista;
        this.context = context;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(context).inflate(R.layout.imovel_linha, parent,false);

        ImovelHolder  holder = new ImovelHolder(v);


        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        ((ImovelHolder)holder).preenche( listaImoveis.get(position));


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AppCompatActivity ac = (AppCompatActivity)view.getContext();

                Bundle bundle = new Bundle();
                bundle.putSerializable("imovel", listaImoveis.get(position));
                bundle.putSerializable("cliente",clienteDTO);
                ViewImovelFragment viewImovel = new ViewImovelFragment();
                viewImovel.setArguments(bundle);

                ac.getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.nav_host_fragment, viewImovel).addToBackStack(null)
                        .commit();


            }
        });

    }




    @Override
    public int getItemCount() {
        return listaImoveis.size();
    }
}
