package es.loyola.inftv.app.manager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import es.loyola.inftv.app.dao.*;
import es.loyola.inftv.app.dao.Alergeno.tipoAlergeno;

import java.sql.*;


public class IngredientesManager {
	
public static List<Ingrediente> getListadoIngredientes() throws SQLException{
		
		/*List<IngredienteImpl> res = new LinkedList<IngredienteImpl>();
		String sentenciaSql="SELECT * FROM ingredientes";
		List<Alergeno> alergenos = new ArrayList<Alergeno>();
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:8080/pdm", "root", "");//conexion, hay que comabiar los campos
		
		
		Statement sentencia = connection.createStatement();
		ResultSet resultado = sentencia.executeQuery(sentenciaSql);
        
		while (resultado.next()) {
		
			String alergenos1 = resultado.getString("alergenos");
            String nombre = resultado.getString("nombre");
            String descripcion = resultado.getString("descripcion");
            String id=resultado.getString("id");
            String [] arregloPalabras=alergenos1.split(",");
            List<String> listaalergenos = new ArrayList<String>();
            
            for(String palabra: arregloPalabras)
            {
            	listaalergenos.add(palabra);
            }
            IngredienteImpl in=new IngredienteImpl(listaalergenos,nombre,descripcion,id);
            res.add(in);
		}
	
	 	return res;*/
	
	List<Ingrediente> listaIngredientes = new ArrayList<>();
	

	Ingrediente ingrediente1 = new IngredienteImpl(Arrays.asList(tipoAlergeno.GLUTEN, tipoAlergeno.LACTOSA), "Harina", "Ingrediente básico para la preparación de pan y pasteles", "1");
	Ingrediente ingrediente2 = new IngredienteImpl(Arrays.asList(tipoAlergeno.CRUSTACEOS, tipoAlergeno.MOSTAZA), "Salsa de mariscos", "Deliciosa salsa para acompañar tus platos de mariscos", "2");
	Ingrediente ingrediente3 = new IngredienteImpl(Arrays.asList(tipoAlergeno.SOJA), "Tofu", "Ingrediente común en la cocina asiática, perfecto para preparaciones vegetarianas", "3");
	Ingrediente ingrediente4 = new IngredienteImpl(Arrays.asList(tipoAlergeno.CACAHUETES), "Mantequilla de cacahuete", "Deliciosa y versátil crema de cacahuete para untar en panes y preparar salsas", "4");
	Ingrediente ingrediente5 = new IngredienteImpl(Arrays.asList(tipoAlergeno.HUEVOS), "Huevos", "Ingrediente básico para preparar tortillas, frittatas, entre otros platos", "5");

	listaIngredientes.add(ingrediente1);
	listaIngredientes.add(ingrediente2);
	listaIngredientes.add(ingrediente3);
	listaIngredientes.add(ingrediente4);
	listaIngredientes.add(ingrediente5);
	
	return listaIngredientes;
		
	}
	
	

}
