package es.loyola.inftv.app.dao;

public class Marca {
	
	private String nombre;
	private String direccion;
	private Integer telefono;
	private String cif;
	
	
	/**
	 * @param nombre
	 * @param direccion
	 * @param telefono
	 * @param cif
	 */
	public Marca(String nombre, String direccion, Integer telefono, String cif) {
		super();
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
		this.cif = cif;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	public Integer getTelefono() {
		return telefono;
	}


	public void setTelefono(Integer telefono) {
		this.telefono = telefono;
	}


	public String getCif() {
		return cif;
	}


	public void setCif(String cif) {
		this.cif = cif;
	}
	
	

}
