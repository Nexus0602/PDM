package com.example.eathappy.dao;

import java.util.List;

import com.example.eathappy.dao.Alergeno.tipoAlergeno;

public class UsuarioImpl implements Usuario {
	
	private String nombre;
	private String apellidos;
	private String email;
	private String contrasenya;
	private List<tipoAlergeno> alergenos;
	private List<Producto> favoritos;
	private Integer id;

    public UsuarioImpl(int id, String nombre, String apellidos, String email, String contrasenya) {
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
		this.contrasenya = contrasenya;
    }

	public UsuarioImpl(int id, String nombre, String apellidos, String email, String contrasenya, List<tipoAlergeno> alergenos) {
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
		this.contrasenya = contrasenya;
		this.alergenos = alergenos;
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
