package com.example.eathappy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.eathappy.adapters.ListaUsuarioRecyclerViewAdapter;
import com.example.eathappy.dao.RespuestaUsuarioImpl;
import com.example.eathappy.dao.Usuario;
import com.example.eathappy.servicios.ApiServiceBuilder;
import com.example.eathappy.servicios.EatHappyApiInterface;

import java.util.LinkedList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListadoUsuarios extends AppCompatActivity {

    private RecyclerView recyclerView;
    private EatHappyApiInterface apiInterface;
    private List<Usuario> listaUsuarios;
    private ListaUsuarioRecyclerViewAdapter usuarioAdapter;
    private Menu menuUsuarios;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_usuarios);
        listaUsuarios = new LinkedList<Usuario>();
        recyclerView = findViewById(R.id.recyclerView);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        usuarioAdapter = new ListaUsuarioRecyclerViewAdapter(listaUsuarios);
        recyclerView.setAdapter(usuarioAdapter);

        Intent intent = getIntent();
        apiInterface = ApiServiceBuilder.getClient().create(EatHappyApiInterface.class);
        generarListadoUsuarios();

    }

    private void showMenuUsuarios(boolean b) {
        if (menuUsuarios != null) {
            MenuItem registrarItem = menuUsuarios.findItem(R.id.registrar);

            if (registrarItem != null) {
                registrarItem.setVisible(b);
            }
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_usuarios, menu);
        menuUsuarios = menu;
        showMenuUsuarios(true);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.registrar) {
            //"Registrar Usuario"
            Intent intent = new Intent(this, RegistarUsuarioActivity.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    public void generarListadoUsuarios() {
        Call<RespuestaUsuarioImpl> call = apiInterface.getListadoUsuarios();
        call.enqueue(new Callback<RespuestaUsuarioImpl>() {
            @Override
            public void onResponse(Call<RespuestaUsuarioImpl> call, Response<RespuestaUsuarioImpl> response) {
                if(response.isSuccessful() && response.body() != null){
                    RespuestaUsuarioImpl respuestaUsuario = response.body();
                    String code = respuestaUsuario.getCode();
                    if (code.equalsIgnoreCase("ok")){
                        listaUsuarios.clear();
                        listaUsuarios.addAll(respuestaUsuario.getResult());
                        usuarioAdapter.notifyDataSetChanged();
                    } else {
                        Toast.makeText(ListadoUsuarios.this, "Error: " + respuestaUsuario.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<RespuestaUsuarioImpl> call, Throwable t) {
                Toast.makeText(ListadoUsuarios.this, "Error en la llamada", Toast.LENGTH_SHORT).show();
                Log.e("onFailure-generarlistadousuarios", String.valueOf(t));
            }



        });
    }
}