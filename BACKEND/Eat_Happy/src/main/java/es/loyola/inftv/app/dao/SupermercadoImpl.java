package es.loyola.inftv.app.dao;

import java.util.List;
import java.util.Objects;

public class SupermercadoImpl implements Supermercado {
	
	@Override
	public int hashCode() {
		return Objects.hash(id, nombre, productos, ubicación);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SupermercadoImpl other = (SupermercadoImpl) obj;
		return Objects.equals(id, other.id) && Objects.equals(nombre, other.nombre)
				&& Objects.equals(productos, other.productos) && Objects.equals(ubicación, other.ubicación);
	}
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
	public SupermercadoImpl(String nombre, Integer id, List<Producto> productos, String ubicación) {
		super();
		this.nombre = nombre;
		this.id = id;
		this.productos = productos;
		this.ubicación = ubicación;
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
	public Integer getId() {
		return id;
	}
	@Override
	public void setId(Integer id) {
		this.id = id;
	}
	@Override
	public List<Producto> getProductos() {
		return productos;
	}
	@Override
	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}
	@Override
	public String getUbicación() {
		return ubicación;
	}
	@Override
	public void setUbicación(String ubicación) {
		this.ubicación = ubicación;
	}
	
	
	

}
