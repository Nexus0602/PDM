package es.loyola.inftv.app.dao;

import java.util.List;

public class Producto {
	
	private String nombre;
	private Marca marca;
	private List<Ingrediente> composicion;
	private List<Categoria> categorias;
	private List<Opinion> historialOpiniones;
	private String codBarras;
	private Integer id;
	/**
	 * @param nombre
	 * @param marca
	 * @param composicion
	 * @param categorias
	 * @param historialOpiniones
	 * @param codBarras
	 */
	
	
	public Producto(String nombre, Marca marca, List<Ingrediente> composicion, List<Categoria> categorias,
			List<Opinion> historialOpiniones, String codBarras) {
		super();
		this.nombre = nombre;
		this.marca = marca;
		this.composicion = composicion;
		this.categorias = categorias;
		this.historialOpiniones = historialOpiniones;
		this.codBarras = codBarras;
	}
	/**
	 * @param nombre
	 * @param  
	 */
	public Producto(String nombre) {
		super();
		this.nombre = nombre;
	}
	/**
	 * @param nombre
	 * @param codBarras
	 */
	public Producto(String nombre, String codBarras) {
		super();
		this.nombre = nombre;
		this.codBarras = codBarras;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @param nombre
	 * @param id
	 */
	public Producto(String nombre, Integer id) {
		super();
		this.nombre = nombre;
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Marca getMarca() {
		return marca;
	}
	public void setMarca(Marca marca) {
		this.marca = marca;
	}
	public List<Ingrediente> getComposicion() {
		return composicion;
	}
	public void setComposicion(List<Ingrediente> composicion) {
		this.composicion = composicion;
	}
	public List<Categoria> getCategorias() {
		return categorias;
	}
	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}
	public List<Opinion> getHistorialOpiniones() {
		return historialOpiniones;
	}
	public void setHistorialOpiniones(List<Opinion> historialOpiniones) {
		this.historialOpiniones = historialOpiniones;
	}
	public String getCodBarras() {
		return codBarras;
	}
	public void setCodBarras(String codBarras) {
		this.codBarras = codBarras;
	}
	

}
