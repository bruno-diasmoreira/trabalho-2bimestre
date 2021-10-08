package br.edu.vianna.locatemporada.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import br.edu.vianna.locatemporada.R;
import br.edu.vianna.locatemporada.model.Locacao;

public class LocacaoHolder extends  RecyclerView.ViewHolder {

    private ImageView imgMinhaLocacao;

    private TextView tvMinhaLocacaoNome,tvMinhaLocacaoData,tvMinhaLocacaoValorPago;



    public LocacaoHolder(@NonNull View itemView) {
        super(itemView);

        imgMinhaLocacao = itemView.findViewById(R.id.imgMinhaLocacao);
        tvMinhaLocacaoNome = itemView.findViewById(R.id.tvMinhaLocacaoNome);
        tvMinhaLocacaoData = itemView.findViewById(R.id.tvMinhaLocacaoData);
        tvMinhaLocacaoValorPago = itemView.findViewById(R.id.tvMinhaLocacaoValorPago);

    }



    public void preenche(Locacao locacao){

        tvMinhaLocacaoNome.setText("Locacao: "+locacao.getImovel().getNome());
        tvMinhaLocacaoData.setText("Data Inicio: "+locacao.getDataInicio() + "   Data Fim: "+locacao.getDataFim());
        tvMinhaLocacaoValorPago.setText("Valor Pago: "+locacao.getPagamento().getValorPago());

        Picasso.get()
                .load(locacao.getImovel().getFoto())
                .resize(550, 250)
                .centerCrop()
                .into(imgMinhaLocacao);

    }

}



