package com.example.eathappy.dao;

import java.sql.Date;

public class OpinionImpl implements Opinion {
	
	private String usuario;
	private String descripcion;
	private Date fecha;
	private Producto producto;
	/**
	 * @param usuario
	 * @param descripcion
	 * @param fecha
	 * @param producto
	 */
	public OpinionImpl(String usuario, String descripcion, Date fecha, Producto producto) {
		super();
		this.usuario = usuario;
		this.descripcion = descripcion;
		this.fecha = fecha;
		this.producto = producto;
	}
	@Override
	public String getUsuario() {
		return usuario;
	}
	@Override
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	@Override
	public String getDescripcion() {
		return descripcion;
	}
	@Override
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	@Override
	public Date getFecha() {
		return fecha;
	}
	@Override
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	@Override
	public Producto getProducto() {
		return producto;
	}
	@Override
	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	
	
}
