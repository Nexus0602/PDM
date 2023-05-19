package com.example.eathappy;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.eathappy.dao.Alergeno;
import com.example.eathappy.dao.Favorito;
import com.example.eathappy.dao.Ingrediente;
import com.example.eathappy.dao.Producto;
import com.example.eathappy.dao.RespuestaUsuarioImpl;
import com.example.eathappy.dao.Usuario;
import com.example.eathappy.servicios.ApiServiceBuilder;
import com.example.eathappy.servicios.EatHappyApiInterface;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ConsultarUsuario extends AppCompatActivity {

    private EatHappyApiInterface apiInterface;
    private Usuario currentUsuario;
    private TextView idUsuarioTextView;
    private TextView nombreUsuarioTextView;
    private TextView apellidosUsuarioTextView;
    private TextView emailUsuarioTextView;
    private TextView contrasenyaUsuarioTextView;
    private TextView alergenosUsuarioTextView;
    private TextView favoritosUsuarioTextView;
    private List<Usuario> listaUsuarios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_consultar_usuario);
        listaUsuarios = new LinkedList<Usuario>();

        idUsuarioTextView = findViewById(R.id.idUsuario);
        nombreUsuarioTextView = findViewById(R.id.nombreUsuario);
        apellidosUsuarioTextView = findViewById(R.id.apellidosUsuario);
        emailUsuarioTextView = findViewById(R.id.emailUsuario);
        contrasenyaUsuarioTextView = findViewById(R.id.contrasenyaUsuario);
        alergenosUsuarioTextView = findViewById(R.id.alergenosUsuario);
        favoritosUsuarioTextView = findViewById(R.id.favoritosUsuario);


        Intent intent = getIntent();
        if (intent.hasExtra("usuario")){
            String id = intent.getStringExtra("usuario");
            apiInterface = ApiServiceBuilder.getClient().create(EatHappyApiInterface.class);
            consultarUsuario(id);
            //Log.i("onCreate-dentro del intent", currentUsuario.toString() );
        }
    };

    public void consultarUsuario(String id) {

        Call<RespuestaUsuarioImpl> call = apiInterface.getUsuario(id);
        call.enqueue(new Callback<RespuestaUsuarioImpl>() {
            @Override
            public void onResponse(Call<RespuestaUsuarioImpl> call, Response<RespuestaUsuarioImpl> response) {
                if(response.isSuccessful() && response.body() != null){
                    RespuestaUsuarioImpl respuestaUsuario = response.body();
                    String code = respuestaUsuario.getCode();
                    if (code.equalsIgnoreCase("ok")){
                        listaUsuarios.clear();
                        listaUsuarios.addAll(respuestaUsuario.getResult());
                        for (Usuario u : respuestaUsuario.getResult()) {
                            Log.i("onResponse",u.toString());
                        }

                        currentUsuario =listaUsuarios.get(0);
                        idUsuarioTextView.setText("ID: " + currentUsuario.getId().toString());
                        nombreUsuarioTextView.setText("Nombre: " +currentUsuario.getNombre());
                        apellidosUsuarioTextView.setText("Apellidos: " + currentUsuario.getApellidos());
                        emailUsuarioTextView.setText("Email: " + currentUsuario.getEmail());
                        contrasenyaUsuarioTextView.setText("Contrasenya : " + currentUsuario.getContrasenya());
                        List<String> alergenos = new ArrayList<>();
                        for (Alergeno.tipoAlergeno alergeno : currentUsuario.getAlergenos()) {
                            alergenos.add(alergeno.toString());
                        }
                        String alergenosText = "Alérgenos: " + TextUtils.join(", ", alergenos);

                        alergenosUsuarioTextView.setText(alergenosText);

                        if (currentUsuario.getFavoritos() == null) {
                            favoritosUsuarioTextView.setText("Favoritos: ");
                        }
                        else{
                        List<String> favoritos = new ArrayList<>();
                        for (Producto favorito : currentUsuario.getFavoritos()){
                            favoritos.add(favorito.toString());
                        }
                        String favoritosText = "Favoritos: " + TextUtils.join(", ", favoritos);

                        favoritosUsuarioTextView.setText(favoritosText);}

                    } else {
                        Toast.makeText(ConsultarUsuario.this, "Error: " + respuestaUsuario.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<RespuestaUsuarioImpl> call, Throwable t) {
                Toast.makeText(ConsultarUsuario.this, "Error en la llamada", Toast.LENGTH_SHORT).show();
                Log.e("onFailure", "Error en la llamada " + t.toString());
            }



        });


    }

};
