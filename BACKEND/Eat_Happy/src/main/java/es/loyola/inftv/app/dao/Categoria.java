package es.loyola.inftv.app.dao;

public interface Categoria{
	
	
	String getNombre();
    void setNombre(String nombre);

    String getDescripcion();
    void setDescripcion(String descripcion);
	
	int hashCode();
	
	boolean equals(Object obj);



}