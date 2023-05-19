	package es.loyola.inftv.app.manager;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import es.loyola.inftv.app.dao.Categoria;
import es.loyola.inftv.app.dao.CategoriaImpl;
import es.loyola.inftv.app.dao.Marca;

public class CategoriasManager {
	
	public static List<Categoria> getListadoCategorias(){
		
		List<Categoria> listaCategorias = new ArrayList<Categoria>();
		
		Categoria lacteos = new CategoriaImpl("Lácteos", "Productos derivados de la leche");
		Categoria carnes = new CategoriaImpl("Carnes", "Productos de origen animal ricos en proteínas");
		Categoria frutasVerduras = new CategoriaImpl("Frutas y verduras", "Productos frescos y ricos en nutrientes");
		Categoria cerealesGranos = new CategoriaImpl("Cereales y granos", "Productos ricos en carbohidratos y fibra");
		Categoria bebidas = new CategoriaImpl("Bebidas", "Líquidos para hidratarse y refrescarse");
		Categoria dulcesSnacks = new CategoriaImpl("Dulces y snacks", "Productos para disfrutar como postres o aperitivos");
		Categoria panaderiaReposteria = new CategoriaImpl("Panadería y repostería", "Productos horneados y dulces");
		
		
		listaCategorias.add(lacteos);
		listaCategorias.add(carnes);
		listaCategorias.add(frutasVerduras);
		listaCategorias.add(cerealesGranos);
		listaCategorias.add(bebidas);
		listaCategorias.add(dulcesSnacks);
		listaCategorias.add(panaderiaReposteria);

		
		return listaCategorias;
		
	}
	public static Categoria getCategoriaByName(String name) {
		
		List<Categoria> listaCategorias= getListadoCategorias();
		Categoria a = null;
		for(Categoria m: listaCategorias)
		{
			if(m.getNombre()==name)
			{
				a =  m;
			}
			
		}
		return a;
		
		
		
	
}


}
