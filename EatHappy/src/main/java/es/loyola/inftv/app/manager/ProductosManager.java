package es.loyola.inftv.app.manager;

import java.util.LinkedList;
import java.util.List;

import es.loyola.inftv.app.dao.Producto;

public class ProductosManager {
	
public static List<Producto> getListadoProductos(){
		
		List<Producto> res = new LinkedList<Producto>();
		
		
		
		Producto i1 = new Producto ("leche de avena", "A23254" );
		Producto i2 = new Producto ( "zumo de naranja","D35652");
		
		
		res.add(i1);
		res.add(i2);

		
	 	return res;
		
	}

}
