package es.loyola.inftv.app.dao;

import java.util.List;

public class Ingrediente {
	
	private List<String> alergenos;
	private String nombre;
	private String descripcion;
	private String id;
	
	
	/**
	 * @param alergenos
	 * @param nombre
	 * @param descripcion
	 * @param id
	 */
	public Ingrediente(List<String> alergenos, String nombre, String descripcion, String id) {
		super();
		this.alergenos = alergenos;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.id = id;
	}


	public Ingrediente() {
		// TODO Auto-generated constructor stub
	}


	public List<String> getAlergenos() {
		return alergenos;
	}


	public void setAlergenos(List<String> alergenos) {
		this.alergenos = alergenos;
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


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}

	
}
