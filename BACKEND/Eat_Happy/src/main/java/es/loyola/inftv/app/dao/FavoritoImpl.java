package es.loyola.inftv.app.dao;

import java.util.List;
import java.util.Objects;

public class FavoritoImpl implements Favorito {
	
	@Override
	public int hashCode() {
		return Objects.hash(producto, usuario);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FavoritoImpl other = (FavoritoImpl) obj;
		return Objects.equals(producto, other.producto) && Objects.equals(usuario, other.usuario);
	}
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
