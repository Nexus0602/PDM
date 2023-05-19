package es.loyola.inftv.app.dao;

import java.util.List;
import java.util.Objects;

import es.loyola.inftv.app.dao.Alergeno.tipoAlergeno;

public class UsuarioImpl implements Usuario {
	
	@Override
	public int hashCode() {
		return Objects.hash(alergenos, apellidos, contrasenya, email, favoritos, id, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UsuarioImpl other = (UsuarioImpl) obj;
		return Objects.equals(alergenos, other.alergenos) && Objects.equals(apellidos, other.apellidos)
				&& Objects.equals(contrasenya, other.contrasenya) && Objects.equals(email, other.email)
				&& Objects.equals(favoritos, other.favoritos) && Objects.equals(id, other.id)
				&& Objects.equals(nombre, other.nombre);
	}

	private String nombre;
	private String apellidos;
	private String email;
	private String contrasenya;
	private List<tipoAlergeno> alergenos;
	private List<Producto> favoritos;
	private Integer id;
	
	@Override
	public Integer getId() {
		return id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
	}
	
	public UsuarioImpl() {}

	/**
	 * @param nombre
	 * @param id
	 */
	public UsuarioImpl(String nombre, Integer id) {
		super();
		this.nombre = nombre;
		this.id = id;
	}

	/**
	 * @param nombre
	 * @param apellidos
	 * @param email
	 * @param contrasenya
	 * @param alergenos
	 * @param favoritos
	 */
	public UsuarioImpl(Integer id, String nombre, String apellidos, String email, String contrasenya, List<tipoAlergeno> alergenos,
			List<Producto> favoritos) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
		this.contrasenya = contrasenya;
		this.alergenos = alergenos;
		this.favoritos = favoritos;
	}

	public UsuarioImpl(int id, String nombre, String apellidos, String email, String contrasenya) {
		// TODO Auto-generated constructor stub
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
		this.contrasenya = contrasenya;
	}

	public UsuarioImpl(Integer id, String nombre, String apellidos, String email, String contrasenya, List<tipoAlergeno> alergenos) {
		// TODO Auto-generated constructor stub
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
		this.contrasenya = contrasenya;
		this.alergenos = alergenos;
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
	public String getApellidos() {
		return apellidos;
	}

	@Override
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	@Override
	public String getEmail() {
		return email;
	}

	@Override
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String getContrasenya() {
		return contrasenya;
	}

	@Override
	public void setContrasenya(String contrasenya) {
		this.contrasenya = contrasenya;
	}

	@Override
	public List<tipoAlergeno> getAlergenos() {
		return alergenos;
	}

	@Override
	public void setAlergenos(List<tipoAlergeno> alergenos) {
		this.alergenos = alergenos;
	}

	@Override
	public List<Producto> getFavoritos() {
		return favoritos;
	}

	@Override
	public void setFavoritos(List<Producto> favoritos) {
		this.favoritos = favoritos;
	}
	
	

}
