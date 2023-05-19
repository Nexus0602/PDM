package com.example.eathappy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.example.eathappy.dao.Categoria;
import com.example.eathappy.dao.Ingrediente;
import com.example.eathappy.dao.Opinion;
import com.example.eathappy.dao.Producto;
import com.example.eathappy.dao.RespuestaProductoImpl;
import com.example.eathappy.servicios.ApiServiceBuilder;
import com.example.eathappy.servicios.EatHappyApiInterface;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class ConsultarProducto extends AppCompatActivity {
    private EatHappyApiInterface apiInterface;
    private Producto currentProducto;
    private TextView idProductoTextView;
    private TextView nombreProductoTextView;
    private TextView marcaProductoTextView;
    private TextView codBarrasProductoTextView;
    private TextView categoriaProductoTextView;
    private TextView composicionProductoTextView;
    private TextView opinionesProductoTextView;
    private List<Producto> listaProductos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar_producto);
        listaProductos = new LinkedList<Producto>();

        idProductoTextView = findViewById(R.id.idProducto);
        nombreProductoTextView = findViewById(R.id.nombreProducto);
        codBarrasProductoTextView = findViewById(R.id.codBarrasProducto);
        categoriaProductoTextView = findViewById(R.id.categoriaProducto);
        marcaProductoTextView = findViewById(R.id.marcaProducto);
        composicionProductoTextView = findViewById(R.id.composicionProducto);
        opinionesProductoTextView = findViewById(R.id.opinionesProducto);

        Intent intent = getIntent();
        if (intent.hasExtra("id")){
            String id = intent.getStringExtra("id");
            apiInterface = ApiServiceBuilder.getClient().create(EatHappyApiInterface.class);
            consultarProducto(id);
        }
    };

    public void consultarProducto(String id) {

        Call<RespuestaProductoImpl> call = apiInterface.getProducto(id);
        call.enqueue(new Callback<RespuestaProductoImpl>() {
            @Override
            public void onResponse(Call<RespuestaProductoImpl> call, Response<RespuestaProductoImpl> response) {
                if(response.isSuccessful() && response.body() != null){
                    RespuestaProductoImpl respuestaProducto = response.body();
                    String code = respuestaProducto.getCode();
                    if (code.equalsIgnoreCase("ok")){
                        listaProductos.clear();
                        listaProductos.addAll(respuestaProducto.getResult());
                        currentProducto = listaProductos.get(0);
                        idProductoTextView.setText("ID: " + currentProducto.getId().toString());
                        nombreProductoTextView.setText("Nombre: " + currentProducto.getNombre());
                        codBarrasProductoTextView.setText("Código: " + currentProducto.getCodBarras());

                        List<String> nombresCategorias = new ArrayList<>();
                        for (Categoria categoria : currentProducto.getCategorias()) {
                            nombresCategorias.add(categoria.getNombre());
                        }

                        String categoriasText = "Categorías: " + TextUtils.join(", ", nombresCategorias);
                        categoriaProductoTextView.setText(categoriasText);

                        marcaProductoTextView.setText("Marca: " + currentProducto.getMarca().getNombre());

                        List<String> nombresIngredientes = new ArrayList<>();
                        for (Ingrediente ingrediente : currentProducto.getComposicion()) {
                            nombresIngredientes.add(ingrediente.getNombre());
                        }
                        String alergenosText = "Alérgenos: " + TextUtils.join(", ", nombresIngredientes);

                        composicionProductoTextView.setText(alergenosText);

                        List<String> opiniones = new ArrayList<>();
                        for (Opinion opinion : currentProducto.getHistorialOpiniones()) {
                            opiniones.add(opinion.getDescripcion());
                        }

                        String opinionesText = "Opiniones: " + TextUtils.join(", ", opiniones);
                        opinionesProductoTextView.setText(opinionesText);
                    } else {
                        Toast.makeText(ConsultarProducto.this, "Error: " + respuestaProducto.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<RespuestaProductoImpl> call, Throwable t) {
                Toast.makeText(ConsultarProducto.this, "Error en la llamada", Toast.LENGTH_SHORT).show();
                Log.e("onFailureConsultarProducto", "Error en la llamada " + t.toString());
            }



        });


    }

};
