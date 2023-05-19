package es.loyola.inftv.app.dao;



public interface Marca {

	String getNombre();

	void setNombre(String nombre);
	
	String getDireccion();

	void setDireccion(String direccion);

	Integer getTelefono();

	void setTelefono(Integer telefono);

	String getCif();

	void setCif(String cif);

	String toString();
	
	int hashCode();
	
	boolean equals(Object obj);

	

}