package com.example.eathappy.dao;

import java.util.List;

public class FavoritoImpl implements Favorito {
	
	private Usuario usuario;
	private List<Producto> producto;
	/**
	 * @param usuario
	 * @param producto
	 */
	public FavoritoImpl(Usuario usuario, List<Producto> producto) {
		super();
		this.usuario = usuario;
		this.producto = producto;
	}
	@Override
	public Usuario getUsuario() {
		return usuario;
	}
	@Override
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	@Override
	public List<Producto> getProducto() {
		return producto;
	}
	@Override
	public void setProducto(List<Producto> producto) {
		this.producto = producto;
	}
	@Override
	public String toString() {
		return "Favorito [usuario=" + usuario + ", producto=" + producto + "]";
	}

	
}
