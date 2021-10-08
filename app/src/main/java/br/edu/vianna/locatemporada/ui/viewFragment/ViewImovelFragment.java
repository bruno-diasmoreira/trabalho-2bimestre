package br.edu.vianna.locatemporada.ui.viewFragment;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import br.edu.vianna.locatemporada.R;
import br.edu.vianna.locatemporada.model.Imovel;
import br.edu.vianna.locatemporada.model.dto.ClienteDTO;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ViewImovelFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ViewImovelFragment extends Fragment  {

    private TextView tec,tvViewLocalImovel,tvViewDescricaoImovel,tvViewValor;
    private ImageView imgViewImovel,imgComentario,imgFazerLocacao;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private Imovel imovel;
    private ClienteDTO clienteDTO;

    public ViewImovelFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ViewImovelFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ViewImovelFragment newInstance(String param1, String param2) {
        ViewImovelFragment fragment = new ViewImovelFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);


            imovel = (Imovel)getArguments().getSerializable("imovel");
            clienteDTO = (ClienteDTO) getArguments().getSerializable("cliente");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view =  inflater.inflate(R.layout.fragment_view_imovel, container, false);

        tec = view.findViewById(R.id.tec);
        imgViewImovel = view.findViewById(R.id.imgViewImovel);
        imgComentario = view.findViewById(R.id.imgComentario);
        imgFazerLocacao = view.findViewById(R.id.imgFazerLocacao);

        tvViewLocalImovel = view.findViewById(R.id.tvViewLocalImovel);
        tvViewDescricaoImovel = view.findViewById(R.id.tvViewDescricaoImovel);
        tvViewValor = view.findViewById(R.id.tvViewValor);

        tec.setText(imovel.getNome());

        //SETANDO A IMAGEM
        Picasso.get()
                .load(imovel.getFoto())
                .resize(1080, 500)
                .centerCrop()
                .into(imgViewImovel);


        tvViewLocalImovel.setText(imovel.getLocal());
        tvViewDescricaoImovel.setText(imovel.getDescricao());
        tvViewValor.setText("R$"+imovel.getValorDiaria()+"");




        // IR PARA TELA DE COMENTARIOS

        imgComentario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(),"TESTE: "+ imovel.getValorDiaria(),Toast.LENGTH_LONG).show();
            }
        });


        // IR PARA TELA DE FAZER LOCAÇÕES
        imgFazerLocacao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                AppCompatActivity ac = (AppCompatActivity)view.getContext();

                Bundle bundle = new Bundle();
                bundle.putSerializable("cliente",clienteDTO);
                bundle.putSerializable("imovel",imovel);
                ViewRealizarLocacaoFragment viewRealizarLocacaoFragment = new ViewRealizarLocacaoFragment();
                viewRealizarLocacaoFragment.setArguments(bundle);

                ac.getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.nav_host_fragment, viewRealizarLocacaoFragment).addToBackStack(null)
                        .commit();

            }
        });




        return view;
    }

}