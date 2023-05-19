package com.example.eathappy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.eathappy.dao.RespuestaUsuarioImpl;
import com.example.eathappy.servicios.ApiServiceBuilder;
import com.example.eathappy.servicios.EatHappyApiInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ModificarUsuario extends AppCompatActivity {

    private EatHappyApiInterface apiInterface;
    private EditText nombre;
    private EditText apellido;
    private EditText email;
    private EditText contrasenya;
    private Button btnmodificar;
    private TextView texto;
    private TextView textoalergenos;
    private String id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modificar_usuario);
        Intent intent = getIntent();
        if (intent.hasExtra("id")){
            id = intent.getStringExtra("id");
            apiInterface = ApiServiceBuilder.getClient().create(EatHappyApiInterface.class);
        }
        btnmodificar = findViewById(R.id.buttonRegistrar);
        nombre = findViewById(R.id.editTextNombre);
        apellido = findViewById(R.id.editTextApellido);
        email = findViewById(R.id.editTextEmail);
        contrasenya = findViewById(R.id.editTextContrasenya);
        texto = findViewById(R.id.succes);
        textoalergenos = findViewById(R.id.alergenos);
        apiInterface = ApiServiceBuilder.getClient().create(EatHappyApiInterface.class);

        btnmodificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombreText = nombre.getText().toString();
                String apellidoText = apellido.getText().toString();
                String emailText = email.getText().toString();
                String contrasenyaText = contrasenya.getText().toString();
                modificarUsuario(id, nombreText,apellidoText,emailText,contrasenyaText);
                mostrarUsuarioRegistrado(id,nombreText,apellidoText,emailText,contrasenyaText);

            }
        });
    }

    private void mostrarUsuarioRegistrado( String id, String nombreText, String apellidoText, String emailText, String contrasenyaText) {

        nombre.setVisibility(View.GONE);
        apellido.setVisibility(View.GONE);
        email.setVisibility(View.GONE);
        contrasenya.setVisibility(View.GONE);
        btnmodificar.setVisibility(View.GONE);
        textoalergenos.setVisibility(View.GONE);

    }


    public void modificarUsuario( String id, String nombreText, String apellidoText, String emailText, String contrasenyaText){

        Call<RespuestaUsuarioImpl> call = apiInterface.modificarUsuario( id, nombreText, apellidoText, emailText, contrasenyaText);
        call.enqueue(new Callback<RespuestaUsuarioImpl>() {
            @Override
            public void onResponse(Call<RespuestaUsuarioImpl> call, Response<RespuestaUsuarioImpl> response) {
                if(response.isSuccessful() && response.body() != null){
                    RespuestaUsuarioImpl respuestaUsuario = response.body();
                    String code = respuestaUsuario.getCode();
                    if (code.equalsIgnoreCase("ok")){
                        texto.setText("Usuario modificado correctamente \n Nombre: " + nombreText + "\n Apellidos: " + apellidoText + "\n Email: " + emailText + "\n  Contrasenya " + contrasenyaText );


                    } else {
                        Toast.makeText(ModificarUsuario.this, "Error: " + respuestaUsuario.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<RespuestaUsuarioImpl> call, Throwable t) {
                Toast.makeText(ModificarUsuario.this, "Error en la llamada", Toast.LENGTH_SHORT).show();
                Log.e("onFailure", "Error en la llamada " + t.toString());
            }

        });


    }
}