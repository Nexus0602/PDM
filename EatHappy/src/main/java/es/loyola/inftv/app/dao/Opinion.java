package es.loyola.inftv.app.dao;

import java.sql.Date;

public class Opinion {
	
	private String usuario;
	private String descripcion;
	private Date fecha;
	private Producto producto;
	/**
	 * @param usuario
	 * @param descripcion
	 * @param fecha
	 * @param producto
	 */
	public Opinion(String usuario, String descripcion, Date fecha, Producto producto) {
		super();
		this.usuario = usuario;
		this.descripcion = descripcion;
		this.fecha = fecha;
		this.producto = producto;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public Producto getProducto() {
		return producto;
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	
	
}
