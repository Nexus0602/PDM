package es.loyola.inftv.app.dao;

public interface Alergeno {

	public enum tipoAlergeno {
		GLUTEN ("GLUTEN", 1),
		CRUSTACEOS ("CRUSTACEOS", 2),
	    HUEVOS ("HUEVOS", 3),
	    PESCADO ("PESCADO", 4),
	    CACAHUETES ("CACAHUETES", 5),
	    SOJA ("SOJA", 6),
	    LACTOSA ("LACTOSA", 7),
	    FRUTOS_SECOS ("FRUTOS_SECOS", 8),
	    APIO ("APIO", 9),
	    MOSTAZA ("MOSTAZA", 10),
	    SESAMO ("SESAMO", 11),
	    FRUCTOSA ("FRUCTOSA", 12),
	    SULFITOS ("SULFITOS", 13),
	    MOLUSCOS ("MOLUSCOS", 14);

	private String nombre;
	private int id;

	tipoAlergeno(String nombre, int id) {
		this.nombre = nombre;
		this.id = id;
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		// TODO Auto-generated method stub
		return id;
	} 
	
	public String getNombre() {
		// TODO Auto-generated method stub
		return nombre;
	}
	
	
	
	
	
	}
	
	
	
	
	/*public enum tipoAlergeno {
		("GLUTEN", 1)
	    CRUSTACEOS,
	    HUEVOS,
	    PESCADO,
	    CACAHUETES,
	    SOJA,
	    LACTOSA,
	    FRUTOS_SECOS,
	    APIO,
	    MOSTAZA,
	    SESAMO,
	    FRUCTOSA,
	    SULFITOS,
	    MOLUSCOS; }*/

}