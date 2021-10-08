package br.edu.vianna.locatemporada;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;


import br.edu.vianna.locatemporada.config.RetrofitConfig;
import br.edu.vianna.locatemporada.model.dto.ClienteDTO;
import br.edu.vianna.locatemporada.model.dto.LoginDTO;
import br.edu.vianna.locatemporada.model.dto.response.ResponseClienteDTO;
import br.edu.vianna.locatemporada.service.ClienteService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class LoginActivity extends AppCompatActivity {

    public static final int RESULT_OK = 20;
    private TextInputLayout edtLogin,edtSenha;
    private Button btnLogar;
    private ClienteDTO clienteDT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        binding();
        // PEGA A BARRA DE VOLTAR
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        // CLICK NO BOTAO LOGAR

        btnLogar.setOnClickListener( callVerificaLogin());

    }

    private View.OnClickListener callVerificaLogin() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String cpf = edtLogin.getEditText().getText().toString();
                String senha = edtSenha.getEditText().getText().toString();
                LoginDTO login = new LoginDTO(cpf,senha);



                Retrofit retro = new RetrofitConfig().getRetrofit();

                ClienteService cService = retro.create(ClienteService.class);

                Call<ResponseClienteDTO> cliente = cService.validarLogin(login);


              cliente.enqueue(new Callback<ResponseClienteDTO>() {
                  @Override
                  public void onResponse(Call<ResponseClienteDTO> call, Response<ResponseClienteDTO> response) {
                      ClienteDTO clienteDT = response.body().getCliente();

                      if(clienteDT.getToken() == null){
                          Toast.makeText(getApplicationContext(),"ERRO AO UTILIZAR O SERVIÇO",Toast.LENGTH_LONG).show();
                      }
                      else{
                          Intent it = new Intent();

                          it.putExtra("cliente",clienteDT);

                          setResult(RESULT_OK,it);
                          //setResult(RESULT_OK);
                          finish();
                          Toast.makeText(getApplicationContext(),"LOGADO COM SUCESSO",Toast.LENGTH_LONG).show();
                      }
                  }
                  @Override
                  public void onFailure(Call<ResponseClienteDTO> call, Throwable t) {
                      Toast.makeText(getApplicationContext(),""+t.getMessage(),Toast.LENGTH_LONG).show();
                  }
              });


            }
        };
    }

    private void binding() {

        edtLogin = findViewById(R.id.edtLogin);
        edtSenha = findViewById(R.id.edtSenha);
        btnLogar = findViewById(R.id.btnLogar);

    }


    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }




}