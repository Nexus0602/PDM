package com.example.eathappy.dao;

import java.util.List;

import com.example.eathappy.dao.Alergeno.tipoAlergeno;

public interface Ingrediente {

	List<tipoAlergeno> getAlergenos();

	void setAlergenos(List<tipoAlergeno> alergenos);

	String getNombre();

	void setNombre(String nombre);

	String getDescripcion();

	void setDescripcion(String descripcion);

	String getId();

	void setId(String id);

	String toString();

}