package es.loyola.inftv.app.dao;

import java.util.Objects;

public class MarcaImpl implements Marca {
	

	@Override
	public int hashCode() {
		return Objects.hash(cif, direccion, nombre, telefono);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MarcaImpl other = (MarcaImpl) obj;
		return Objects.equals(cif, other.cif) && Objects.equals(direccion, other.direccion)
				&& Objects.equals(nombre, other.nombre) && Objects.equals(telefono, other.telefono);
	}


	public String nombre;
	
	private String direccion;
	private Integer telefono;
	private String cif;
	
	
	/**
	 * @param nombre
	 * @param direccion
	 * @param telefono
	 * @param cif
	 */
	
	
	public MarcaImpl(String nombre, String direccion, Integer telefono, String cif) {
		super();
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
		this.cif = cif;
	}
	/**
	 * 
	 */
	public MarcaImpl() {
		super();
	}
	public MarcaImpl(String nombre) {
		this.nombre = nombre;
		
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
	public String getDireccion() {
		return direccion;
	}


	@Override
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	@Override
	public Integer getTelefono() {
		return telefono;
	}


	@Override
	public void setTelefono(Integer telefono) {
		this.telefono = telefono;
	}


	@Override
	public String getCif() {
		return cif;
	}


	@Override
	public void setCif(String cif) {
		this.cif = cif;
	}


	@Override
	public String toString() {
		return "Marca [nombre=" + nombre + ", direccion=" + direccion + ", telefono=" + telefono + ", cif=" + cif + "]";
	}


	
	
	
	
	

}

	
	
	
