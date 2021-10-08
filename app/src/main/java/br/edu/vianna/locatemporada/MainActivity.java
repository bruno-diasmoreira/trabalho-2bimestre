package br.edu.vianna.locatemporada;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import br.edu.vianna.locatemporada.model.dto.ClienteDTO;
import br.edu.vianna.locatemporada.ui.ContatoFragment;
import br.edu.vianna.locatemporada.ui.ImoveisFragment;
import br.edu.vianna.locatemporada.ui.MinhasLocacoesFragment;
import br.edu.vianna.locatemporada.ui.viewFragment.ViewImovelFragment;

public class MainActivity extends AppCompatActivity {

    public static final int VIEW_LOGIN = 10;
    public static final int RESULT_LOGIN = 20;
    private AppBarConfiguration mAppBarConfiguration;
    private DrawerLayout drawer;
    private NavigationView navigationView;
    private ClienteDTO clienteDTO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //CONFIGURAÇÃO DA TOOLBAR
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        drawer = findViewById(R.id.drawer_layout);

        navigationView = findViewById(R.id.nav_view);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();



        navigationView.setNavigationItemSelectedListener( clickMenu() );
        habilitarMenu();
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        if(requestCode == VIEW_LOGIN && resultCode == RESULT_LOGIN){

            clienteDTO = (ClienteDTO) data.getExtras().getSerializable("cliente");
            habilitarMenu();
            changeHeader();
        }
    }

    private NavigationView.OnNavigationItemSelectedListener clickMenu() {
        return new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                if(item.getItemId() == R.id.nav_log){

                    Intent it = new Intent(getApplicationContext(),LoginActivity.class);
                    startActivityForResult(it, VIEW_LOGIN);

                }
                else if(item.getItemId() == R.id.nav_imoveis){




                    Bundle bundle = new Bundle();
                    bundle.putSerializable("cliente",clienteDTO );
                    ImoveisFragment imoveisFragment = new ImoveisFragment();
                    imoveisFragment.setArguments(bundle);

                    changeFragment(imoveisFragment);

                }
                else if(item.getItemId() == R.id.nav_minhaslocacoes){

                    Bundle bundle = new Bundle();
                    bundle.putSerializable("cliente",clienteDTO );
                    MinhasLocacoesFragment minhasLocacoesFragment = new MinhasLocacoesFragment();
                    minhasLocacoesFragment.setArguments(bundle);

                    changeFragment(minhasLocacoesFragment);
                }
                else if(item.getItemId() == R.id.nav_contato){

                    changeFragment(new ContatoFragment());
                }
                else if(item.getItemId() == R.id.nav_sair){
                    clienteDTO = null;
                    habilitarMenu();
                    changeHeader();
                }else{
                    Toast.makeText(getApplicationContext(),"Teste",Toast.LENGTH_LONG).show();
                }

                drawer.closeDrawer(GravityCompat.START);

                return true;
            }
        };
    }


    private void changeHeader() {
        View header = navigationView.getHeaderView(0);

        TextView tv1 = header.findViewById(R.id.tvTitulo);
        TextView tv2 = header.findViewById(R.id.tvTituloNome);

        if (clienteDTO != null){
            tv1.setText("Bem Vindo");
            tv2.setText( clienteDTO.getNome());
        }else{
            tv1.setText("LOCA TEMPORADA");
            tv2.setText("Locações de imóveis");
        }

    }


    private void habilitarMenu() {

        Menu mn = navigationView.getMenu();

        mn.findItem(R.id.nav_log).setVisible( clienteDTO == null );
        mn.findItem(R.id.nav_sair).setVisible( clienteDTO != null );
        mn.findItem(R.id.nav_imoveis).setVisible( clienteDTO != null);
        mn.findItem(R.id.nav_minhaslocacoes).setVisible( clienteDTO != null);
    }


    // FAZ A TROCA DOS FRAGMENT
    private void changeFragment(Fragment f) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.nav_host_fragment, f);
        ft.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public void onBackPressed() {

        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}