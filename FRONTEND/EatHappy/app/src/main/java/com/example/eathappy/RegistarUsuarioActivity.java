package com.example.eathappy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.eathappy.dao.RespuestaUsuarioImpl;
import com.example.eathappy.servicios.ApiServiceBuilder;
import com.example.eathappy.servicios.EatHappyApiInterface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegistarUsuarioActivity extends AppCompatActivity {

    private EatHappyApiInterface apiInterface;
    private EditText id;
    private EditText nombre;
    private EditText apellido;
    private EditText email;
    private EditText contrasenya;
    private Button btnregistrar;
    private TextView texto;
    private TextView textoalergenos;
    private CheckBox alergeno1;
    private CheckBox alergeno2;
    private CheckBox alergeno3;
    private CheckBox alergeno4;
    private CheckBox alergeno5;
    private CheckBox alergeno6;
    private CheckBox alergeno7;
    private CheckBox alergeno8;
    private CheckBox alergeno9;
    private CheckBox alergeno10;
    private CheckBox alergeno11;
    private CheckBox alergeno12;
    private CheckBox alergeno13;
    private CheckBox alergeno14;



    private List<String> alergenosSeleccionados = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registar_usuario);
        Intent intent = getIntent();
        btnregistrar = findViewById(R.id.buttonRegistrar);
        id = findViewById(R.id.editTextId);
        nombre = findViewById(R.id.editTextNombre);
        apellido = findViewById(R.id.editTextApellido);
        email = findViewById(R.id.editTextEmail);
        contrasenya = findViewById(R.id.editTextContrasenya);
        texto = findViewById(R.id.succes);
        textoalergenos = findViewById(R.id.alergenos);
        apiInterface = ApiServiceBuilder.getClient().create(EatHappyApiInterface.class);
        alergeno1 = findViewById(R.id.checkBoxAlergeno1);
        alergeno2 = findViewById(R.id.checkBoxAlergeno2);
        alergeno3 = findViewById(R.id.checkBoxAlergeno3);
        alergeno4 = findViewById(R.id.checkBoxAlergeno4);
        alergeno5= findViewById(R.id.checkBoxAlergeno5);
        alergeno6 = findViewById(R.id.checkBoxAlergeno6);
        alergeno7 = findViewById(R.id.checkBoxAlergeno7);
        alergeno8 = findViewById(R.id.checkBoxAlergeno8);
        alergeno9 = findViewById(R.id.checkBoxAlergeno9);
        alergeno10 = findViewById(R.id.checkBoxAlergeno10);
        alergeno11 = findViewById(R.id.checkBoxAlergeno11);
        alergeno12 = findViewById(R.id.checkBoxAlergeno12);
        alergeno13 = findViewById(R.id.checkBoxAlergeno13);
        alergeno14 = findViewById(R.id.checkBoxAlergeno14);


        btnregistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String idText = id.getText().toString();
                String nombreText = nombre.getText().toString();
                String apellidoText = apellido.getText().toString();
                String emailText = email.getText().toString();
                String contrasenyaText = contrasenya.getText().toString();
                String alergenosParametro = null;
                for (int i = 1; i <= 14; i++) {
                    int checkBoxId = getResources().getIdentifier("checkBoxAlergeno" + i, "id", getPackageName());
                    CheckBox checkBox = findViewById(checkBoxId);
                    if (checkBox.isChecked()) {
                        alergenosSeleccionados.add(checkBox.getText().toString());
                        alergenosParametro = String.join(",", alergenosSeleccionados);

                    }
                }

                registrarUsuario(idText,nombreText,apellidoText,emailText,contrasenyaText,alergenosParametro);
                mostrarUsuarioRegistrado(idText,nombreText,apellidoText,emailText,contrasenyaText,alergenosParametro);
            }
        });
    }

    private void mostrarUsuarioRegistrado(String idText, String nombreText, String apellidoText, String emailText, String contrasenyaText, String alergenosSeleccionados) {

        id.setVisibility(View.GONE);
        nombre.setVisibility(View.GONE);
        apellido.setVisibility(View.GONE);
        email.setVisibility(View.GONE);
        contrasenya.setVisibility(View.GONE);
        btnregistrar.setVisibility(View.GONE);
        textoalergenos.setVisibility(View.GONE);
        alergeno1.setVisibility(View.GONE);
        alergeno2.setVisibility(View.GONE);
        alergeno3.setVisibility(View.GONE);
        alergeno4.setVisibility(View.GONE);
        alergeno5.setVisibility(View.GONE);
        alergeno6.setVisibility(View.GONE);
        alergeno7.setVisibility(View.GONE);
        alergeno8.setVisibility(View.GONE);
        alergeno9.setVisibility(View.GONE);
        alergeno10.setVisibility(View.GONE);
        alergeno11.setVisibility(View.GONE);
        alergeno12.setVisibility(View.GONE);
        alergeno13.setVisibility(View.GONE);
        alergeno14.setVisibility(View.GONE);

        texto.setText("Usuario registrado correctamente \n ID: " + idText + "\n Nombre: " + nombreText + "\n Apellidos: " + apellidoText + "\n Email: " + emailText + "\n Contrasenya: " + contrasenyaText + "\n Alergenos: " + alergenosSeleccionados );


    }

    public void registrarUsuario(String idText, String nombreText, String apellidoText, String emailText, String contrasenyaText, String alergenosSeleccionados){

        Call<RespuestaUsuarioImpl> call = apiInterface.registrarUsuario(idText, nombreText, apellidoText, emailText, contrasenyaText, alergenosSeleccionados);
        call.enqueue(new Callback<RespuestaUsuarioImpl>() {
            @Override
            public void onResponse(Call<RespuestaUsuarioImpl> call, Response<RespuestaUsuarioImpl> response) {
                if(response.isSuccessful() && response.body() != null){
                    RespuestaUsuarioImpl respuestaUsuario = response.body();
                    String code = respuestaUsuario.getCode();
                    if (code.equalsIgnoreCase("ok")){
                        texto.setText("Usuario registrado correctamente \n ID: " + idText + "\n Nombre: " + nombreText + "\n Apellidos: " + apellidoText + "\n Email: " + emailText + "\n Contrasenya: " + contrasenyaText + "\n Alergenos: " + alergenosSeleccionados.toString() );
                    } else {
                        Toast.makeText(RegistarUsuarioActivity.this, "Error: " + respuestaUsuario.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<RespuestaUsuarioImpl> call, Throwable t) {
                Toast.makeText(RegistarUsuarioActivity.this, "Error en la llamada", Toast.LENGTH_SHORT).show();
                Log.e("onFailureRegistararUsuario", "Error en la llamada " + t.toString());
            }

        });


    }
}