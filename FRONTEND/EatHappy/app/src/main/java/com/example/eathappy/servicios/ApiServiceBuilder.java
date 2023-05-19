package com.example.eathappy.servicios;

import com.example.eathappy.adapters.CategoriaTypeAdapter;
import com.example.eathappy.adapters.IngredienteTypeAdapter;
import com.example.eathappy.adapters.MarcaTypeAdapter;
import com.example.eathappy.adapters.ProductoTypeAdapter;
import com.example.eathappy.adapters.UsuarioTypeAdapter;
import com.example.eathappy.dao.Categoria;
import com.example.eathappy.dao.Ingrediente;
import com.example.eathappy.dao.Marca;
import com.example.eathappy.dao.Producto;
import com.example.eathappy.dao.Usuario;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiServiceBuilder {

    private static Retrofit retrofit;

    private static final String BASE_URL = "http://10.0.2.2:8080/Eat_Happy/";
    public static Retrofit getClient(){
        if(retrofit==null){

            //Para poder interceptar las conexiones
            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

            // Crear el interceptor de OKHttpClient para pdoer registrar el uso de la red
            OkHttpClient client = new OkHttpClient.Builder().addInterceptor(loggingInterceptor).build();

            // Para que haga bien el parseado de Usuario
            Gson gson = new GsonBuilder()
                    .registerTypeAdapter(Usuario.class, new UsuarioTypeAdapter())
                    .registerTypeAdapter(Producto.class, new ProductoTypeAdapter())
                    .registerTypeAdapter(Categoria.class, new CategoriaTypeAdapter())
                    .registerTypeAdapter(Marca.class, new MarcaTypeAdapter())
                    .registerTypeAdapter(Ingrediente.class, new IngredienteTypeAdapter())
                    .create();
            GsonConverterFactory gsonConverterFactory = GsonConverterFactory.create(gson);
            //Construccion pearsonalizad de retrofit
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(gsonConverterFactory)
                    .client(client)
                    .build();
            //Construccion basica de retrofit
            //retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit;
    }
}
