package br.edu.vianna.locatemporada.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import br.edu.vianna.locatemporada.R;
import br.edu.vianna.locatemporada.model.Imovel;

public class ImovelHolder extends  RecyclerView.ViewHolder {


    private TextView tvNome,tvLocal,tvDescricao;
    private ImageView imgImovel,imgButton;


    public ImovelHolder(@NonNull View itemView) {
        super(itemView);

        tvNome = itemView.findViewById(R.id.tvTeste);
        tvLocal = itemView.findViewById(R.id.tvLocal);
        tvDescricao = itemView.findViewById(R.id.tvDescricao);
        imgImovel = itemView.findViewById(R.id.imgImovel);
        imgButton = itemView.findViewById(R.id.imgButton);

        imgButton.setImageResource(R.drawable.ic_button);

    }

    public void preenche(Imovel imovel){
        tvNome.setText(imovel.getNome());
        tvLocal.setText(imovel.getLocal());
        tvDescricao.setText(imovel.getDescricao());
        //imgImovel.setImageResource(R.drawable.ic_baseline_apartment_24);
        Picasso.get()
                .load(imovel.getFoto())
                .resize(120, 150)
                .centerCrop()
                .into(imgImovel);
    }


}
