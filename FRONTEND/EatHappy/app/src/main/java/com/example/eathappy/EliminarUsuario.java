package com.example.eathappy;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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

public class EliminarUsuario extends AppCompatActivity {

    private RecyclerView recyclerView;
    private EatHappyApiInterface apiInterface;
    private List<Usuario> listaUsuarios;
    private ListaUsuarioRecyclerViewAdapter usuarioAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eliminar_usuario);

        listaUsuarios = new LinkedList<Usuario>();
        recyclerView = findViewById(R.id.recyclerView);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        usuarioAdapter = new ListaUsuarioRecyclerViewAdapter(listaUsuarios);
        recyclerView.setAdapter(usuarioAdapter);

        Intent intent = getIntent();
        if (intent.hasExtra("id")){
            String id = intent.getStringExtra("id");
            apiInterface = ApiServiceBuilder.getClient().create(EatHappyApiInterface.class);
            eliminarUsuario(id);
        }

    };

    public void eliminarUsuario(String id) {

        Call<RespuestaUsuarioImpl> call = apiInterface.eliminarUsuario(id);
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
                        Toast.makeText(EliminarUsuario.this, "Error: " + respuestaUsuario.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<RespuestaUsuarioImpl> call, Throwable t) {
                Toast.makeText(EliminarUsuario.this, "Error en la llamada", Toast.LENGTH_SHORT).show();
                Log.e("onFailure", "Error en la llamada " + t.toString());
            }



        });


    }

};
