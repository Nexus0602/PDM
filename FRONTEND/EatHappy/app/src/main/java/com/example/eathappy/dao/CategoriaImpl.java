package com.example.eathappy.dao;

public class CategoriaImpl implements Categoria {
	private String nombre;
	private String descripcion;
	/**
	 * @param nombre
	 * @param descripcion
	 */
	public CategoriaImpl(String nombre, String descripcion) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	@Override
	public String toString() {
		return "Categoria [nombre=" + nombre + ", descripcion=" + descripcion + "]";
	}
	
	

}
