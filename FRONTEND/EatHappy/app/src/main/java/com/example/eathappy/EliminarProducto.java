package com.example.eathappy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.eathappy.adapters.ListaProductoRecyclerViewAdapter;
import com.example.eathappy.adapters.ListaUsuarioRecyclerViewAdapter;
import com.example.eathappy.dao.Producto;
import com.example.eathappy.dao.RespuestaProductoImpl;
import com.example.eathappy.dao.RespuestaUsuarioImpl;
import com.example.eathappy.dao.Usuario;
import com.example.eathappy.servicios.ApiServiceBuilder;
import com.example.eathappy.servicios.EatHappyApiInterface;

import java.util.LinkedList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EliminarProducto extends AppCompatActivity {

    private RecyclerView recyclerView;
    private EatHappyApiInterface apiInterface;
    private List<Producto> listaProducto;
    private ListaProductoRecyclerViewAdapter productoAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eliminar_producto);

        listaProducto = new LinkedList<Producto>();
        recyclerView = findViewById(R.id.recyclerView);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        productoAdapter = new ListaProductoRecyclerViewAdapter(listaProducto);
        recyclerView.setAdapter(productoAdapter);

        Intent intent = getIntent();
        if (intent.hasExtra("id")){
            String id = intent.getStringExtra("id");
            apiInterface = ApiServiceBuilder.getClient().create(EatHappyApiInterface.class);
            eliminarProducto(id);
        }

    }

    public void eliminarProducto(String id) {

        Call<RespuestaProductoImpl> call = apiInterface.eliminarProducto(id);
        call.enqueue(new Callback<RespuestaProductoImpl>() {
            @Override
            public void onResponse(Call<RespuestaProductoImpl> call, Response<RespuestaProductoImpl> response) {
                if(response.isSuccessful() && response.body() != null){
                    RespuestaProductoImpl respuestaProducto = response.body();
                    String code = respuestaProducto.getCode();
                    if (code.equalsIgnoreCase("ok")){
                        listaProducto.clear();
                        listaProducto.addAll(respuestaProducto.getResult());
                        productoAdapter.notifyDataSetChanged();
                    } else {
                        Toast.makeText(EliminarProducto.this, "Error: " + respuestaProducto.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<RespuestaProductoImpl> call, Throwable t) {
                Toast.makeText(EliminarProducto.this, "Error en la llamada", Toast.LENGTH_SHORT).show();
                Log.e("onFailure", "Error en la llamada " + t.toString());
            }
        });
    }

}