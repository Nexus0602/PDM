package es.loyola.inftv.app.manager;

import java.util.LinkedList;
import java.util.List;

import es.loyola.inftv.app.dao.Producto;
import es.loyola.inftv.app.dao.Supermercado;


public class SupermercadosManager {
	
public static List<Supermercado> getListadoSupermercados(){
	
		List<Producto> prods1 = new LinkedList<Producto>();
		List<Producto> prods2 = new LinkedList<Producto>();
		
		Producto p1 = new Producto ("leche",1);
		Producto p2 = new Producto ("pasta",2);
		Producto p3 = new Producto ("huevos",3);
		Producto p4 = new Producto ("yogurt",4);
		Producto p5 = new Producto ("leche de soja",5);
		
		prods1.add(p5);
		prods1.add(p2);
		prods1.add(p3);
		
		prods2.add(p1);
		prods2.add(p4);
		prods2.add(p2);
		
		
		List<Supermercado> res = new LinkedList<Supermercado>();
		
		Supermercado u1 = new Supermercado("Mercadona", 1, prods1, "Sevilla");
		Supermercado u2 = new Supermercado("Mas", 2, prods2, "Sevilla");
		Supermercado u3 = new Supermercado("Lidl",3, prods1, "Cadiz");
		
		
		res.add(u1);
		res.add(u2);
		res.add(u3);

		
	 	return res;
		
	}

}
