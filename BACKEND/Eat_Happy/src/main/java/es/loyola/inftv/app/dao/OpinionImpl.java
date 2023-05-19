package es.loyola.inftv.app.dao;

import java.sql.Date;
import java.util.Objects;

public class OpinionImpl implements Opinion {
	
	@Override
	public int hashCode() {
		return Objects.hash(descripcion, fecha, producto, usuario);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OpinionImpl other = (OpinionImpl) obj;
		return Objects.equals(descripcion, other.descripcion) && Objects.equals(fecha, other.fecha)
				&& Objects.equals(producto, other.producto) && Objects.equals(usuario, other.usuario);
	}
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
	public OpinionImpl(String usuario, String descripcion, Date fecha, Producto producto) {
		super();
		this.usuario = usuario;
		this.descripcion = descripcion;
		this.fecha = fecha;
		this.producto = producto;
	}
	@Override
	public String getUsuario() {
		return usuario;
	}
	@Override
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	@Override
	public String getDescripcion() {
		return descripcion;
	}
	@Override
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	@Override
	public Date getFecha() {
		return fecha;
	}
	@Override
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	@Override
	public Producto getProducto() {
		return producto;
	}
	@Override
	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	
	
}
