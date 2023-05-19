package com.example.eathappy.dao;

import java.util.List;

public class ProductoImpl implements Producto  {
	
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
	
	
	public ProductoImpl(String nombre, Marca marca, List<Ingrediente> composicion, List<Categoria> categorias,
			List<Opinion> historialOpiniones, String codBarras, Integer id) {
		super();
		this.nombre = nombre;
		this.marca = marca;
		this.composicion = composicion;
		this.categorias = categorias;
		this.historialOpiniones = historialOpiniones;
		this.codBarras = codBarras;
		this.id = id;
	}

	public ProductoImpl() {
		// Constructor sin argumentos
	}

	/**
	 * @param nombre
	 * @param codBarras
	 */
	public ProductoImpl(String nombre, String codBarras) {
		super();
		this.nombre = nombre;
		this.codBarras = codBarras;

	}

    public ProductoImpl(String nombre, String codBarras, int id) {
		this.nombre = nombre;
		this.codBarras = codBarras;
		this.id = id;
    }

	public ProductoImpl(String nombre, String codBarras, int id, Marca marca, List<Categoria> categorias) {
		this.nombre = nombre;
		this.marca = marca;
		this.categorias = categorias;
		this.codBarras = codBarras;
		this.id = id;
	}

	public ProductoImpl(String nombre, String codBarras, int id, List<Categoria> categorias) {

		this.nombre = nombre;
		this.categorias = categorias;
		this.codBarras = codBarras;
		this.id = id;}

	public ProductoImpl(String nombre, Marca marca, List<Ingrediente> composicion, List<Categoria> categorias, String codBarras, int id) {
		this.nombre = nombre;
		this.marca = marca;
		this.composicion = composicion;
		this.categorias = categorias;
		this.codBarras = codBarras;
		this.id = id;
	}

	@Override
	public Integer getId() {
		return id;
	}
	@Override
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @param nombre
	 * @param id
	 */
	public ProductoImpl(String nombre, Integer id) {
		super();
		this.nombre = nombre;
		this.id = id;
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
	public Marca getMarca() {
		return marca;
	}
	@Override
	public void setMarca(Marca marca) {
		this.marca = marca;
	}
	@Override
	public List<Ingrediente> getComposicion() {
		return composicion;
	}
	@Override
	public void setComposicion(List<Ingrediente> composicion) {
		this.composicion = composicion;
	}
	@Override
	public List<Categoria> getCategorias() {
		return categorias;
	}
	@Override
	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}
	@Override
	public List<Opinion> getHistorialOpiniones() {
		return historialOpiniones;
	}
	@Override
	public void setHistorialOpiniones(List<Opinion> historialOpiniones) {
		this.historialOpiniones = historialOpiniones;
	}
	@Override
	public String getCodBarras() {
		return codBarras;
	}
	@Override
	public void setCodBarras(String codBarras) {
		this.codBarras = codBarras;
	}
	

}
