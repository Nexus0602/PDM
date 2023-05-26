package es.loyola.inftv.app.manager;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import es.loyola.inftv.app.dao.Categoria;
import es.loyola.inftv.app.dao.CategoriaImpl;
import es.loyola.inftv.app.dao.Ingrediente;
import es.loyola.inftv.app.dao.IngredienteImpl;
import es.loyola.inftv.app.dao.Marca;
import es.loyola.inftv.app.dao.MarcaImpl;

import es.loyola.inftv.app.dao.Opinion;
import es.loyola.inftv.app.dao.Producto;
import es.loyola.inftv.app.dao.ProductoImpl;
import es.loyola.inftv.app.dao.Alergeno.tipoAlergeno;

public class ProductosManager {
	
public static List<Producto> getListadoProductos(){
		
		List<Producto> res = new LinkedList<Producto>();
		List<Opinion> o1 = new LinkedList<Opinion>();
		List<Opinion> o2 = new LinkedList<Opinion>();
		List<Opinion> o3 = new LinkedList<Opinion>();
		
		
		Ingrediente harina = IngredientesManager.getIngredienteById("1");
		Ingrediente apio = IngredientesManager.getIngredienteById("10");
		Ingrediente mostaza = IngredientesManager.getIngredienteById("11");
		Ingrediente sesamo = IngredientesManager.getIngredienteById("12");
		Ingrediente fructosa = IngredientesManager.getIngredienteById("13");
		Ingrediente dioxido_de_azufre = IngredientesManager.getIngredienteById("14");
		Ingrediente mejillones = IngredientesManager.getIngredienteById("15");
		Ingrediente langostinos = IngredientesManager.getIngredienteById("3");
		Ingrediente huevos = IngredientesManager.getIngredienteById("4");
		Ingrediente salmon = IngredientesManager.getIngredienteById("5");
		Ingrediente cacahuetes = IngredientesManager.getIngredienteById("6");
		Ingrediente soja = IngredientesManager.getIngredienteById("7");
		Ingrediente leche_de_vaca = IngredientesManager.getIngredienteById("8");
		Ingrediente nueces = IngredientesManager.getIngredienteById("9");
		
		Categoria lacteos = CategoriasManager.getCategoriaByName("Lacteos");
		Categoria carnes = CategoriasManager.getCategoriaByName("Carnes");
		Categoria frutasVerduras = CategoriasManager.getCategoriaByName("Frutas y verduras");
		Categoria cerealesGranos = CategoriasManager.getCategoriaByName("Cereales y granos");
		Categoria bebidas = CategoriasManager.getCategoriaByName("Bebidas");
		Categoria dulcesSnacks = CategoriasManager.getCategoriaByName("Dulces y snacks");
		Categoria panaderiaReposteria = CategoriasManager.getCategoriaByName("Panaderia y reposteria");
		Categoria precocinados = CategoriasManager.getCategoriaByName("Precocinados");

		Marca pascual = MarcaManager.getMarcaByName("PASCUAL");
		Marca vivesoy = MarcaManager.getMarcaByName("VIVESOY");
		Marca hacendado = MarcaManager.getMarcaByName("HACENDADO");
		Marca gallo = MarcaManager.getMarcaByName("GALLO");
		Marca asturiana = MarcaManager.getMarcaByName("ASTURIANA");
		Marca nestle = MarcaManager.getMarcaByName("NESTLE");
		Marca donSimon = MarcaManager.getMarcaByName("DON SIMON");
	
		Producto p1 = new ProductoImpl ("leche desnatada", pascual,Arrays.asList(harina),Arrays.asList(lacteos,bebidas),o1,"A34624", 1);
		Producto p2 = new ProductoImpl ( "bebida de soja con chocolate",vivesoy,Arrays.asList(soja), Arrays.asList(lacteos,bebidas),o2,"S35652",2);
		Producto p3 = new ProductoImpl ( "bizcocho",hacendado,Arrays.asList(harina, leche_de_vaca, huevos), Arrays.asList(dulcesSnacks,panaderiaReposteria),o3,"R85652",3);
		Producto p4 = new ProductoImpl ( "pizza",hacendado,Arrays.asList(harina, leche_de_vaca ), Arrays.asList(precocinados),o3,"D35752",4);
		Producto p5 = new ProductoImpl ("zumo de naranja", donSimon ,Arrays.asList(fructosa),Arrays.asList(bebidas),o1,"A34624", 5);
		Producto p6 = new ProductoImpl ( "pasta",gallo,Arrays.asList(harina), Arrays.asList(cerealesGranos),o2,"Y35352",6);
		Producto p7 = new ProductoImpl ( "ternera en salsa",hacendado,Arrays.asList(harina, leche_de_vaca, huevos), Arrays.asList(carnes),o3,"X",7);
		Producto p8 = new ProductoImpl ( "tomate",hacendado,Arrays.asList(), Arrays.asList(frutasVerduras),o3,"W35452",8);
		Producto p9 = new ProductoImpl ( "chocolate",nestle,Arrays.asList(leche_de_vaca), Arrays.asList(dulcesSnacks),o3,"K85652",9);
		Producto p10 = new ProductoImpl ( "batido de vainilla",asturiana,Arrays.asList( leche_de_vaca ), Arrays.asList(bebidas),o3,"F85752",10);
		
		res.add(p1);
		res.add(p2);
		res.add(p3);
		res.add(p4);
		res.add(p5);
		res.add(p6);
		res.add(p7);
		res.add(p8);
		res.add(p9);
		res.add(p10);
		
	 	return res;
		
	}

	public static Producto getProdById(int id) {
		
		List <Producto> lprods= getListadoProductos();
		Producto prod = null;
		for(Producto p: lprods)
		{
			if(p.getId() == id)
			{
				prod = p;
			}
			
		}
		return prod;
		
	}

}
