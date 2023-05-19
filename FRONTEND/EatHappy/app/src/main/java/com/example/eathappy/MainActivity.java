package com.example.eathappy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.eathappy.adapters.ListaUsuarioRecyclerViewAdapter;
import com.example.eathappy.adapters.ListaProductoRecyclerViewAdapter;
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
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    private Button btnUsuarios;
    private Button btnProductos;

    private MainActivity mainActivity = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnUsuarios = findViewById(R.id.botonUsuarios);
        btnProductos = findViewById(R.id.botonProductos);

        btnUsuarios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mainActivity, ListadoUsuarios.class);
                startActivity(intent);
            }
        });

        btnProductos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mainActivity, ListadoProductos.class);
                startActivity(intent);
            }
        });
    }
}







