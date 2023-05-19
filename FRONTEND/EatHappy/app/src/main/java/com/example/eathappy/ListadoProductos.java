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

import com.example.eathappy.adapters.ListaProductoRecyclerViewAdapter;
import com.example.eathappy.adapters.ListaUsuarioRecyclerViewAdapter;
import com.example.eathappy.dao.Producto;
import com.example.eathappy.dao.RespuestaProductoImpl;
import com.example.eathappy.dao.Usuario;
import com.example.eathappy.servicios.ApiServiceBuilder;
import com.example.eathappy.servicios.EatHappyApiInterface;

import java.util.LinkedList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListadoProductos extends AppCompatActivity {

    private RecyclerView recyclerView;
    private EatHappyApiInterface apiInterface;
    private List<Producto> listaProductos;
    private ListaProductoRecyclerViewAdapter productoAdapter;
    private Menu menuProductos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_productos);
        listaProductos = new LinkedList<Producto>();
        recyclerView = findViewById(R.id.recyclerView);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        productoAdapter = new ListaProductoRecyclerViewAdapter(listaProductos);
        recyclerView.setAdapter(productoAdapter);

        Intent intent = getIntent();
        apiInterface = ApiServiceBuilder.getClient().create(EatHappyApiInterface.class);
        generarListadoProductos();
    }



    private void showMenuProductos(boolean b) {
        if (menuProductos != null) {
            MenuItem registrarItem = menuProductos.findItem(R.id.registrarp);
            MenuItem categoriasItem = menuProductos.findItem(R.id.categorias);
            if (registrarItem != null) {
                registrarItem.setVisible(b);
                categoriasItem.setVisible(b);
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_productos, menu);
        menuProductos = menu;
        showMenuProductos(true);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.registrarp) {
            //registrar producto
            Intent intent = new Intent(this, RegistarUsuarioActivity.class);
            startActivity(intent);
            return true;
        }
        if (id == R.id.categorias){
            Intent intent = new Intent(this, ListadoCategorias.class);
            startActivity(intent);

        }
        return super.onOptionsItemSelected(item);
    }

    private void generarListadoProductos() {

        Call<RespuestaProductoImpl> call = apiInterface.getListadoProductos();
        call.enqueue(new Callback<RespuestaProductoImpl>() {
            @Override
            public void onResponse(Call<RespuestaProductoImpl> call, Response<RespuestaProductoImpl> response) {
                if (response.isSuccessful() && response.body() != null) {
                    RespuestaProductoImpl respuestaProducto = response.body();
                    String code = respuestaProducto.getCode();
                    if (code.equalsIgnoreCase("ok")) {
                        listaProductos.clear();
                        listaProductos.addAll(respuestaProducto.getResult());
                        productoAdapter.notifyDataSetChanged();
                    } else {
                        Toast.makeText(ListadoProductos.this, "Error: " + respuestaProducto.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<RespuestaProductoImpl> call, Throwable t) {
                Toast.makeText(ListadoProductos.this, "Error en la llamada", Toast.LENGTH_SHORT).show();
                Log.e("onFailureListadoProductos", "Error en la llamada " + t.toString());
                StackTraceElement[] stackTrace = t.getStackTrace();
                if (stackTrace.length > 0) {
                    String errorLine = stackTrace[0].toString();
                    Log.e("onFailureListadoProductos", "Error en la línea: " + errorLine);
                }

            }
        });
    }
}