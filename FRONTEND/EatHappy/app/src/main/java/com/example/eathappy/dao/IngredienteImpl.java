package com.example.eathappy.dao;

import java.util.List;

import com.example.eathappy.dao.Alergeno.tipoAlergeno;

public class IngredienteImpl implements Ingrediente {
	
	private List<tipoAlergeno> alergenos;
	private String nombre;
	private String descripcion;
	private String id;
	
	
	
	/**
	 * @param alergenos
	 * @param nombre
	 * @param descripcion
	 * @param id
	 */
	public IngredienteImpl(List<tipoAlergeno> alergenos, String nombre, String descripcion, String id) {
		super();
		this.alergenos = alergenos;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.id = id;
	}


	/**
	 * @param nombre
	 */
	public IngredienteImpl(String nombre) {
		super();
		this.nombre = nombre;
	}


	public IngredienteImpl() {
		// TODO Auto-generated constructor stub
	}


	@Override
	public List<tipoAlergeno> getAlergenos() {
		return alergenos;
	}


	@Override
	public void setAlergenos(List<tipoAlergeno> alergenos) {
		this.alergenos = alergenos;
	}


	@Override
	public String getNombre() {
		return nombre;
	}


	@Override
	public void setNombre(String nombre) {
		this.nombre = nombre;
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
	public String getId() {
		return id;
	}


	@Override
	public void setId(String id) {
		this.id = id;
	}


	@Override
	public String toString() {
		return "Ingrediente [alergenos=" + alergenos + ", nombre=" + nombre + ", descripcion=" + descripcion + ", id="
				+ id + "]";
	}
	
	

	
}
