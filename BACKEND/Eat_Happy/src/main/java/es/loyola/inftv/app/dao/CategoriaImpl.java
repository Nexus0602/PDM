package es.loyola.inftv.app.dao;

import java.util.Objects;

public class CategoriaImpl implements Categoria {
	
	@Override
	public int hashCode() {
		return Objects.hash(descripcion, nombre);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CategoriaImpl other = (CategoriaImpl) obj;
		return Objects.equals(descripcion, other.descripcion) && Objects.equals(nombre, other.nombre);
	}
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
