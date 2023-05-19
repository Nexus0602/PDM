package com.example.eathappy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

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

public class ListadoProductosPorCategoria extends AppCompatActivity {


    private RecyclerView recyclerView;
    private EatHappyApiInterface apiInterface;
    private List<Producto> listaProductos;
    private ListaProductoRecyclerViewAdapter categoriaAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_categorias);
        listaProductos = new LinkedList<Producto>();
        recyclerView = findViewById(R.id.recyclerView);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        categoriaAdapter = new ListaProductoRecyclerViewAdapter(listaProductos);
        recyclerView.setAdapter(categoriaAdapter);

        Intent intent = getIntent();
        if (intent.hasExtra("nombre")){
            String nombre = intent.getStringExtra("nombre");
            apiInterface = ApiServiceBuilder.getClient().create(EatHappyApiInterface.class);
            mostrarProductosCategoria(nombre);
        }
        apiInterface = ApiServiceBuilder.getClient().create(EatHappyApiInterface.class);
    }

    public void mostrarProductosCategoria(String categoria) {

        Call<RespuestaProductoImpl> call = apiInterface.getProductosPorCategoria(categoria);
        call.enqueue(new Callback<RespuestaProductoImpl>() {
            @Override
            public void onResponse(Call<RespuestaProductoImpl> call, Response<RespuestaProductoImpl> response) {
                if (response.isSuccessful() && response.body() != null) {
                    RespuestaProductoImpl respuestaProducto = response.body();
                    String code = respuestaProducto.getCode();
                    if (code.equalsIgnoreCase("ok")) {
                        listaProductos.clear();
                        listaProductos.addAll(respuestaProducto.getResult());
                        categoriaAdapter.notifyDataSetChanged();
                    } else {
                        Toast.makeText(ListadoProductosPorCategoria.this, "Error: " + respuestaProducto.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<RespuestaProductoImpl> call, Throwable t) {
                Toast.makeText(ListadoProductosPorCategoria.this, "Error en la llamada", Toast.LENGTH_SHORT).show();
                Log.e("onFailure", "Error en la llamada " + t.toString());

            }
        });


    }
}