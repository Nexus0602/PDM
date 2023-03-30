package es.loyola.inftv.app.dao;

import java.util.List;

public class Supermercado {
	
	private String nombre;
	private Integer id;
	private List<Producto> productos;
	private String ubicación;
	/**
	 * @param nombre
	 * @param id
	 * @param productos
	 * @param ubicación
	 */
	public Supermercado(String nombre, Integer id, List<Producto> productos, String ubicación) {
		super();
		this.nombre = nombre;
		this.id = id;
		this.productos = productos;
		this.ubicación = ubicación;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public List<Producto> getProductos() {
		return productos;
	}
	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}
	public String getUbicación() {
		return ubicación;
	}
	public void setUbicación(String ubicación) {
		this.ubicación = ubicación;
	}
	
	
	

}
