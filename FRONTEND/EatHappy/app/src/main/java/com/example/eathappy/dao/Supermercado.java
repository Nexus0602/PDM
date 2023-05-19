package com.example.eathappy.dao;

import java.util.List;

public interface Supermercado {

	String getNombre();

	void setNombre(String nombre);

	Integer getId();

	void setId(Integer id);

	List<Producto> getProductos();

	void setProductos(List<Producto> productos);

	String getUbicación();

	void setUbicación(String ubicación);

}