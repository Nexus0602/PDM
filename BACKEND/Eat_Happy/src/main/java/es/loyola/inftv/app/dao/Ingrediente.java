package es.loyola.inftv.app.dao;

import java.util.List;

import es.loyola.inftv.app.dao.Alergeno.tipoAlergeno;

public interface Ingrediente {

	List<tipoAlergeno> getAlergenos();

	void setAlergenos(List<tipoAlergeno> alergenos);

	String getNombre();

	void setNombre(String nombre);

	String getDescripcion();

	void setDescripcion(String descripcion);

	String getId();

	void setId(String id);

	String toString();
	
	int hashCode();
	
	boolean equals(Object obj);

}