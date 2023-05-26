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
import es.loyola.inftv.app.dao.Usuario;
import es.loyola.inftv.app.dao.UsuarioImpl;
import es.loyola.inftv.app.dao.Alergeno.tipoAlergeno;


public class UsuariosManager {
	
public static List<Usuario> getListadoUsuarios(){
		
		List<Usuario> res = new LinkedList<Usuario>();
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
		Marca donSimon = MarcaManager.getMarcaByName("DONSIMON");
	
		Producto p1 = new ProductoImpl ("leche desnatada", pascual,Arrays.asList(harina),Arrays.asList(lacteos,bebidas),o1,"A34624", 1);
		Producto p2 = new ProductoImpl ( "bebida de soja con chocolate",vivesoy,Arrays.asList(soja), Arrays.asList(lacteos,bebidas),o2,"S35652",2);
		Producto p3 = new ProductoImpl ( "bizcocho",hacendado,Arrays.asList(harina, leche, huevo), Arrays.asList(dulcesSnacks,panaderiaReposteria),o3,"R85652",3);
		Producto p4 = new ProductoImpl ( "pizza",hacendado,Arrays.asList(harina, leche ), Arrays.asList(precocinados),o3,"D35752",4);
		
		Usuario usuario1 = new UsuarioImpl(1,"Juan", "Pérez", "juan.perez@gmail.com", "contraseña123", Arrays.asList(tipoAlergeno.GLUTEN,tipoAlergeno.SULFITOS), Arrays.asList(p4, p1));
		Usuario usuario2 = new UsuarioImpl(2,"Alicia", "González", "maria.gonzalez@gmail.com", "contraseña456", Arrays.asList(tipoAlergeno.GLUTEN, tipoAlergeno.HUEVOS), Arrays.asList(p2));
		Usuario usuario3 = new UsuarioImpl(3,"Pedro", "Martínez", "pedro.martinez@gmail.com", "contraseña789", Arrays.asList(tipoAlergeno.LACTOSA), Arrays.asList(p2,p1));
		Usuario usuario4 = new UsuarioImpl(4,"Ana", "Gebrael", "ana.martinez@gmail.com", "contraseñaabc", Arrays.asList(tipoAlergeno.CACAHUETES), Arrays.asList(p3, p4,p1));
		Usuario usuario5 = new UsuarioImpl(5,"Jordi", "Pérez", "sara.rodriguez@gmail.com", "contraseñadef", Arrays.asList(tipoAlergeno.GLUTEN, tipoAlergeno.HUEVOS,tipoAlergeno.LACTOSA), Arrays.asList(p3));
		Usuario usuario6 = new UsuarioImpl(6,"Pablo", "Tordera", "juan.perez@gmail.com", "contraseña123", Arrays.asList(tipoAlergeno.GLUTEN,tipoAlergeno.SULFITOS), Arrays.asList(p4, p1));
		Usuario usuario7 = new UsuarioImpl(7,"Jose", "González", "maria.gonzalez@gmail.com", "contraseña456", Arrays.asList(tipoAlergeno.GLUTEN, tipoAlergeno.HUEVOS), Arrays.asList(p2,p1));
		Usuario usuario8 = new UsuarioImpl(8,"Lucia", "Montesinos", "lucia.monts@gmail.com", "contra789", Arrays.asList(tipoAlergeno.LACTOSA,tipoAlergeno.GLUTEN,tipoAlergeno.HUEVOS), Arrays.asList(p4,p1,p3,p2));
		Usuario usuario9 = new UsuarioImpl(9,"Raul", "Coloma", "raul.coloma@gmail.com", "contraaabc", Arrays.asList(tipoAlergeno.CACAHUETES, tipoAlergeno.FRUCTOSA), Arrays.asList(p3,p1));
		Usuario usuario10 = new UsuarioImpl(10,"Mauri", "Rodríguez", "sara.rodriguez@gmail.com", "contraseñadef", Arrays.asList(tipoAlergeno.GLUTEN, tipoAlergeno.HUEVOS,tipoAlergeno.LACTOSA), Arrays.asList(p1));
		
		
		/*Usuario usuario1 = new UsuarioImpl(1,"Juan", "Pérez", "juan.perez@gmail.com", "contraseña123");
		Usuario usuario2 = new UsuarioImpl(2,"Alicia", "González", "maria.gonzalez@gmail.com", "contraseña456");
		Usuario usuario3 = new UsuarioImpl(3,"Pedro", "Sánchez", "pedro.sanchez@gmail.com", "contraseña789");
		Usuario usuario4 = new UsuarioImpl(4,"Ana", "Gebrael", "ana.martinez@gmail.com", "contraseñaabc");
		Usuario usuario5 = new UsuarioImpl(5,"Jordi", "Pérez", "sara.rodriguez@gmail.com", "contraseñadef");
		Usuario usuario6 = new UsuarioImpl(6,"Pablo", "Tordera", "juan.perez@gmail.com", "contraseña123");
		Usuario usuario7 = new UsuarioImpl(7,"Jose", "González", "maria.gonzalez@gmail.com", "contraseña456");
		Usuario usuario8 = new UsuarioImpl(8,"Lucia", "Montesinos", "pedro.sanchez@gmail.com", "contraseña789");
		Usuario usuario9 = new UsuarioImpl(9,"Raul", "Coloma", "ana.martinez@gmail.com", "contraseñaabc");
		Usuario usuario10 = new UsuarioImpl(10,"Mauri", "Rodríguez", "sara.rodriguez@gmail.com", "contraseñadef");*/
		
		res.add(usuario1);
		res.add(usuario2);
		res.add(usuario3);
		res.add(usuario4);
		res.add(usuario5);
		res.add(usuario6);
		res.add(usuario7);
		res.add(usuario8);
		res.add(usuario9);
		res.add(usuario10);
		
	 	return res;
		
	}

	public static Usuario getUsuarioById(int id) {
		
		List <Usuario> lus= getListadoUsuarios();
		Usuario us = null;
		for(Usuario u: lus)
		{
			if(u.getId() == id)
			{
				us = u;
			}
			
		}
		return us;
	
}
	


}
