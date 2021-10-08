package br.edu.vianna.locatemporada.ui.viewFragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import br.edu.vianna.locatemporada.MainActivity;
import br.edu.vianna.locatemporada.R;
import br.edu.vianna.locatemporada.config.RetrofitConfig;
import br.edu.vianna.locatemporada.model.Imovel;
import br.edu.vianna.locatemporada.model.dto.ClienteDTO;
import br.edu.vianna.locatemporada.model.dto.LocacaoDTO;
import br.edu.vianna.locatemporada.model.dto.response.ResponseClienteDTO;
import br.edu.vianna.locatemporada.model.dto.response.ResponseLocacaoDTO;
import br.edu.vianna.locatemporada.service.ClienteService;
import br.edu.vianna.locatemporada.service.LocacaoService;
import br.edu.vianna.locatemporada.utils.DatePickerUniversal;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ViewRealizarLocacaoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ViewRealizarLocacaoFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private TextView tvDataInicio,tvDataFim,tvValorTotal;

    private Button btnSalvarLocacao;

    private EditText editCartao,editDataInicio,editDataFim;

    private ClienteDTO clienteDTO;
    private Imovel imovel;

    public ViewRealizarLocacaoFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ViewRealizarLocacaoFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ViewRealizarLocacaoFragment newInstance(String param1, String param2) {
        ViewRealizarLocacaoFragment fragment = new ViewRealizarLocacaoFragment();
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
        }


        clienteDTO = (ClienteDTO) getArguments().getSerializable("cliente");

        imovel = (Imovel) getArguments().getSerializable("imovel");

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_view_realizar_locacao, container, false);


        // BINDINGS
        editCartao = view.findViewById(R.id.editCartao);
        editDataInicio = view.findViewById(R.id.editDataInicio);
        editDataFim = view.findViewById(R.id.editDataFim);
        tvDataInicio = view.findViewById(R.id.tvDataInicio);
        tvDataFim = view.findViewById(R.id.tvDataFim);
        btnSalvarLocacao = view.findViewById(R.id.btnSalvarLocacao);
        tvValorTotal = view.findViewById(R.id.tvValorTotal);


        //COLOCA UM DIALOG DATEPICKER NOS EDIT TEXT
        new DatePickerUniversal(editDataInicio,"dd-MM-yyyy");
        new DatePickerUniversal(editDataFim,"dd-MM-yyyy");




        btnSalvarLocacao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String dataInicio = editDataInicio.getText().toString();
                String dataFim = editDataFim.getText().toString();
                String numeroCartao = editCartao.getText().toString();

                if(dataInicio.equals("")){
                    Toast.makeText(getContext(), "Campo não pode ser vazio",Toast.LENGTH_LONG).show();
                    return;
                }

                if(dataFim.equals("")){
                    Toast.makeText(getContext(), "Campo não pode ser vazio",Toast.LENGTH_LONG).show();
                    return;
                }

                if(numeroCartao.equals("")){
                    Toast.makeText(getContext(), "Campo não pode ser vazio",Toast.LENGTH_LONG).show();
                    return;
                }


                long dias = validarDias(dataInicio,dataFim);

                if(dias < 0 || dias == 0){
                        Toast.makeText(getContext(),"Data inicio está maior que a Data Fim ",Toast.LENGTH_LONG).show();
                }
                else{
                    // TRANSFORMA PARA DUAS CASAS DECIMAIS
                    DecimalFormat df = new DecimalFormat("0.00");
                    double valorTotal = imovel.getValorDiaria() * dias;


                    // Preenche o objeto LocacaoDTO
                    LocacaoDTO loc = new LocacaoDTO();
                    loc.setCodigo(imovel.getId());
                    loc.setData_inicio(dataInicio);
                    loc.setData_fim(dataFim);
                    loc.setToken(clienteDTO.getToken());
                    loc.setValor_total(valorTotal);
                    loc.setNumeroCartao(numeroCartao);
                    // CHAMA API

                    Retrofit retro = new RetrofitConfig().getRetrofit();

                    LocacaoService locacaoService = retro.create(LocacaoService.class);

                    Call<ResponseLocacaoDTO> locacao = locacaoService.realizarLocacao(loc);


                    locacao.enqueue(new Callback<ResponseLocacaoDTO>() {
                        @Override
                        public void onResponse(Call<ResponseLocacaoDTO> call, Response<ResponseLocacaoDTO> response) {

                            ResponseLocacaoDTO l = response.body();

                            if(l == null){
                                Toast.makeText(getContext(), "Não foi possível completar a locação", Toast.LENGTH_SHORT).show();
                            }
                            else{
                                Toast.makeText(getContext(), ""+ l.getMensagem(), Toast.LENGTH_SHORT).show();
                                //getActivity().getFragmentManager().beginTransaction().remove().commit();
                                getFragmentManager().popBackStack();
                            }
                        }

                        @Override
                        public void onFailure(Call<ResponseLocacaoDTO> call, Throwable t) {
                            Toast.makeText(getContext(),""+t.getMessage(),Toast.LENGTH_LONG).show();
                        }
                    });
                }

            }
        });

        return view;
    }


    public long validarDias(String dataInicio, String dataFim){

        SimpleDateFormat df = new SimpleDateFormat ("dd-MM-yyyy");

        Date d1 = null;
        Date d2 = null;
        try {
            d1 = df.parse (dataInicio);
            d2 = df.parse (dataFim);
        } catch (java.text.ParseException evt ) {}
        long dt = (d2.getTime() - d1.getTime()) + 3600000;
        long dias = (dt / 86400000L);

        return dias;
    }




}