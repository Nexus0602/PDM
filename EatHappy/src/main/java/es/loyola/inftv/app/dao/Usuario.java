package es.loyola.inftv.app.dao;

import java.util.List;

public class Usuario {
	
	private String nombre;
	private String apellidos;
	private String email;
	private String contrasenya;
	private List<Ingrediente> ingredientes;
	private List<Producto> favoritos;
	private Integer id;
	
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
	public Usuario(String nombre, Integer id) {
		super();
		this.nombre = nombre;
		this.id = id;
	}

	/**
	 * @param nombre
	 * @param apellidos
	 * @param email
	 * @param contrasenya
	 * @param ingredientes
	 * @param favoritos
	 */
	public Usuario(String nombre, String apellidos, String email, String contrasenya, List<Ingrediente> ingredientes,
			List<Producto> favoritos) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
		this.contrasenya = contrasenya;
		this.ingredientes = ingredientes;
		this.favoritos = favoritos;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContrasenya() {
		return contrasenya;
	}

	public void setContrasenya(String contrasenya) {
		this.contrasenya = contrasenya;
	}

	public List<Ingrediente> getIngredientes() {
		return ingredientes;
	}

	public void setIngredientes(List<Ingrediente> ingredientes) {
		this.ingredientes = ingredientes;
	}

	public List<Producto> getFavoritos() {
		return favoritos;
	}

	public void setFavoritos(List<Producto> favoritos) {
		this.favoritos = favoritos;
	}
	
	

}
