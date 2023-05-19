package com.example.eathappy.dao;

import java.util.List;

public interface Producto {

	Integer getId();

	void setId(Integer id);

	String getNombre();

	void setNombre(String nombre);

	Marca getMarca();

	void setMarca(Marca marca);

	List<Ingrediente> getComposicion();

	void setComposicion(List<Ingrediente> composicion);

	List<Categoria> getCategorias();

	void setCategorias(List<Categoria> categorias);

	List<Opinion> getHistorialOpiniones();

	void setHistorialOpiniones(List<Opinion> historialOpiniones);

	String getCodBarras();

	void setCodBarras(String codBarras);

}