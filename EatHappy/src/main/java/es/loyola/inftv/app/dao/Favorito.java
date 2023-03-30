package es.loyola.inftv.app.dao;

import java.util.List;

public class Favorito {
	
	private String usuario;
	private List<Producto> producto;
	/**
	 * @param usuario
	 * @param producto
	 */
	public Favorito(String usuario, List<Producto> producto) {
		super();
		this.usuario = usuario;
		this.producto = producto;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public List<Producto> getProducto() {
		return producto;
	}
	public void setProducto(List<Producto> producto) {
		this.producto = producto;
	}

	
}
