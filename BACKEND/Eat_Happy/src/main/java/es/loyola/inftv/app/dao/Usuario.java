package es.loyola.inftv.app.dao;

import java.util.List;

import es.loyola.inftv.app.dao.Alergeno.tipoAlergeno;

public interface Usuario {

	Integer getId();

	void setId(Integer id);

	String getNombre();

	void setNombre(String nombre);

	String getApellidos();

	void setApellidos(String apellidos);

	String getEmail();

	void setEmail(String email);

	String getContrasenya();

	void setContrasenya(String contrasenya);

	List<tipoAlergeno> getAlergenos();

	void setAlergenos(List<tipoAlergeno> alergenos);

	List<Producto> getFavoritos();

	void setFavoritos(List<Producto> favoritos);
	
	
	int hashCode();
	
	boolean equals(Object obj);

}