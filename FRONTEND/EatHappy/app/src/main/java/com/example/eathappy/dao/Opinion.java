package com.example.eathappy.dao;

import java.sql.Date;

public interface Opinion {

	String getUsuario();

	void setUsuario(String usuario);

	String getDescripcion();

	void setDescripcion(String descripcion);

	Date getFecha();

	void setFecha(Date fecha);

	Producto getProducto();

	void setProducto(Producto producto);

}