package com.example.eathappy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.eathappy.adapters.CategoriaTypeAdapter;
import com.example.eathappy.adapters.ListaCategoriasReciclerViewAdapter;
import com.example.eathappy.adapters.ListaProductoRecyclerViewAdapter;
import com.example.eathappy.dao.Categoria;
import com.example.eathappy.dao.Producto;
import com.example.eathappy.dao.RespuestaCategoriaImpl;
import com.example.eathappy.dao.RespuestaProductoImpl;
import com.example.eathappy.servicios.ApiServiceBuilder;
import com.example.eathappy.servicios.EatHappyApiInterface;

import java.util.LinkedList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListadoCategorias extends AppCompatActivity {

    private RecyclerView recyclerView;
    private EatHappyApiInterface apiInterface;
    private List<Categoria> listaCategorias;
    private ListaCategoriasReciclerViewAdapter categoriaAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_categorias);
        listaCategorias = new LinkedList<Categoria>();
        recyclerView = findViewById(R.id.recyclerView);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        categoriaAdapter = new ListaCategoriasReciclerViewAdapter(listaCategorias);
        recyclerView.setAdapter(categoriaAdapter);

        Intent intent = getIntent();
        apiInterface = ApiServiceBuilder.getClient().create(EatHappyApiInterface.class);
        generarListadoCategorias();
    }

    private void generarListadoCategorias() {

        Call<RespuestaCategoriaImpl> call = apiInterface.getListadoCategorias();
        call.enqueue(new Callback<RespuestaCategoriaImpl>() {
            @Override
            public void onResponse(Call<RespuestaCategoriaImpl> call, Response<RespuestaCategoriaImpl> response) {
                if (response.isSuccessful() && response.body() != null) {
                    RespuestaCategoriaImpl respuestaProducto = response.body();
                    String code = respuestaProducto.getCode();
                    if (code.equalsIgnoreCase("ok")) {
                        listaCategorias.clear();
                        listaCategorias.addAll(respuestaProducto.getResult());
                        categoriaAdapter.notifyDataSetChanged();
                    } else {
                        Toast.makeText(ListadoCategorias.this, "Error: " + respuestaProducto.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<RespuestaCategoriaImpl> call, Throwable t) {
                Toast.makeText(ListadoCategorias.this, "Error en la llamada", Toast.LENGTH_SHORT).show();
                Log.e("onFailure", "Error en la llamada " + t.toString());

            }
        });
    }
}