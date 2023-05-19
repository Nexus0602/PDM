package com.example.eathappy.servicios;

import com.example.eathappy.dao.RespuestaCategoriaImpl;
import com.example.eathappy.dao.RespuestaProductoImpl;
import com.example.eathappy.dao.RespuestaUsuarioImpl;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface EatHappyApiInterface {

    @GET("getListadoUsuarios")
    Call<RespuestaUsuarioImpl> getListadoUsuarios();
    @GET("getListadoProductos")
    Call<RespuestaProductoImpl> getListadoProductos();
    @GET("getUsuario")
    Call<RespuestaUsuarioImpl> getUsuario(@Query("id") String id);
    @GET("getProducto")
    Call<RespuestaProductoImpl> getProducto(@Query("id") String id);
    @POST("modificarUsuario")
    Call<RespuestaUsuarioImpl> modificarUsuario(@Query("id")String id, @Query("nombre")String nombre, @Query("apellidos")String apellidos, @Query("email")String email, @Query("contrasenya")String contrasenya);
    @POST("eliminarUsuario")
    Call<RespuestaUsuarioImpl> eliminarUsuario(@Query("id") String id);
    @POST("eliminarProducto")
    Call<RespuestaProductoImpl> eliminarProducto(@Query("id") String id);
    @POST("registrarUsuario")
    Call<RespuestaUsuarioImpl> registrarUsuario(@Query("id")String id, @Query("nombre")String nombre, @Query("apellidos")String apellidos, @Query("email")String email, @Query("contrasenya")String contrasenya, @Query("alergenos")String alergenosSeleccionados);
    @GET("getCategorias")
    Call<RespuestaCategoriaImpl> getListadoCategorias();
    @GET("getProductosPorCategoria")
    Call<RespuestaProductoImpl> getProductosPorCategoria(@Query("categoria") String categoria);
}
