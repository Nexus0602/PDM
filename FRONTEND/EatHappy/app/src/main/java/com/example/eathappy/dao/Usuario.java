package com.example.eathappy.dao;

import java.util.List;

import com.example.eathappy.dao.Alergeno.tipoAlergeno;

public interface Usuario {

	Integer getId();

	void setId(Integer id);

	String getNombre();

	void setNombre(String nombre);

	String getApellidos();

	void setApellidos(String apellidos);

	String getEmail();

	void setEmail(String email);

	String getContrasenya();

	void setContrasenya(String contrasenya);

	List<tipoAlergeno> getAlergenos();

	void setAlergenos(List<tipoAlergeno> alergenos);

	List<Producto> getFavoritos();

	void setFavoritos(List<Producto> favoritos);

}