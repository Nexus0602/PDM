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
		
		
		Ingrediente harina = new IngredienteImpl(Arrays.asList(tipoAlergeno.GLUTEN), "Harina", "Ingrediente básico para la preparación de pan y pasteles", "1");
		Ingrediente salsa_marisco = new IngredienteImpl(Arrays.asList(tipoAlergeno.CRUSTACEOS, tipoAlergeno.MOSTAZA), "Salsa de mariscos", "Deliciosa salsa para acompañar tus platos de mariscos", "2");
		Ingrediente soja = new IngredienteImpl(Arrays.asList(tipoAlergeno.SOJA), "Soja", "Ingrediente común en la cocina asiática, perfecto para preparaciones vegetarianas", "3");
		Ingrediente mantequilla_cacahuete = new IngredienteImpl(Arrays.asList(tipoAlergeno.CACAHUETES), "Mantequilla de cacahuete", "Deliciosa y versátil crema de cacahuete para untar en panes y preparar salsas", "4");
		Ingrediente huevo = new IngredienteImpl(Arrays.asList(tipoAlergeno.HUEVOS), "Huevo", "Ingrediente básico para preparar tortillas, frittatas, entre otros platos", "5");
		Ingrediente leche = new IngredienteImpl(Arrays.asList(tipoAlergeno.LACTOSA), "Leche", "Ingrediente básico", "6");
		Ingrediente fructosa = new IngredienteImpl(Arrays.asList(tipoAlergeno.FRUCTOSA), "Fructosa", "Edulcorante", "7");
		
		Categoria lacteos = new CategoriaImpl("Lácteos", "Productos derivados de la leche");
		Categoria carnes = new CategoriaImpl("Carnes", "Productos de origen animal ricos en proteínas");
		Categoria frutasVerduras = new CategoriaImpl("Frutas y verduras", "Productos frescos y ricos en nutrientes");
		Categoria cerealesGranos = new CategoriaImpl("Cereales y granos", "Productos ricos en carbohidratos y fibra");
		Categoria bebidas = new CategoriaImpl("Bebidas", "Líquidos para hidratarse y refrescarse");
		Categoria dulcesSnacks = new CategoriaImpl("Dulces y snacks", "Productos para disfrutar como postres o aperitivos");
		Categoria panaderiaReposteria = new CategoriaImpl("Panadería y repostería", "Productos horneados y dulces");
		Categoria precocinados = new CategoriaImpl("Precocinados", "Productos precocinados");

		Marca pascual = new MarcaImpl("PASCUAL","calle",123,"CIF");
		Marca vivesoy = new MarcaImpl("VIVESOY","calle",764,"CIF");
		Marca hacendado = new MarcaImpl("HACENDADO","calle",524,"CIF");
		Marca gallo = new MarcaImpl("GALLO","calle",326,"CIF");
		Marca asturiana = new MarcaImpl("ASTURIANA","calle",184,"CIF");
		Marca nestle = new MarcaImpl("NESTLE","calle",584,"CIF");
		Marca donSimon = new MarcaImpl("donSimon","calle",584,"CIF");
	
		Producto p1 = new ProductoImpl ("leche desnatada", pascual,Arrays.asList(harina),Arrays.asList(lacteos,bebidas),o1,"A34624", 1);
		Producto p2 = new ProductoImpl ( "bebida de soja con chocolate",vivesoy,Arrays.asList(soja), Arrays.asList(lacteos,bebidas),o2,"S35652",2);
		Producto p3 = new ProductoImpl ( "bizcocho",hacendado,Arrays.asList(harina, leche, huevo), Arrays.asList(dulcesSnacks,panaderiaReposteria),o3,"R85652",3);
		Producto p4 = new ProductoImpl ( "pizza",hacendado,Arrays.asList(harina, leche ), Arrays.asList(precocinados),o3,"D35752",4);
		Producto p5 = new ProductoImpl ("zumo de naranja", donSimon ,Arrays.asList(fructosa),Arrays.asList(bebidas),o1,"A34624", 5);
		Producto p6 = new ProductoImpl ( "pasta",gallo,Arrays.asList(harina), Arrays.asList(cerealesGranos),o2,"Y35352",6);
		Producto p7 = new ProductoImpl ( "ternera en salsa",hacendado,Arrays.asList(harina, leche, huevo), Arrays.asList(carnes),o3,"X",7);
		Producto p8 = new ProductoImpl ( "tomate",hacendado,Arrays.asList(), Arrays.asList(frutasVerduras),o3,"W35452",8);
		Producto p9 = new ProductoImpl ( "chocolate",nestle,Arrays.asList(leche), Arrays.asList(dulcesSnacks),o3,"K85652",9);
		Producto p10 = new ProductoImpl ( "batido de vainilla",asturiana,Arrays.asList( leche ), Arrays.asList(bebidas),o3,"F85752",10);
		
		
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

}
