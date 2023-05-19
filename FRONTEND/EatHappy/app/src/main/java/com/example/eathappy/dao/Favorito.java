package com.example.eathappy.dao;

import java.util.List;

public interface Favorito {

	Usuario getUsuario();

	void setUsuario(Usuario usuario);

	List<Producto> getProducto();

	void setProducto(List<Producto> producto);

	String toString();

}