package es.loyola.inftv.app.manager;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import es.loyola.inftv.app.dao.Ingrediente;
import java.sql.*;


public class IngredientesManager {
	
public static List<Ingrediente> getListadoIngredientes() throws SQLException{
		
		List<Ingrediente> res = new LinkedList<Ingrediente>();
		String sentenciaSql="SELECT * FROM ingredientes";
		List<String> alergenos = new ArrayList<String>();
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
            Ingrediente in=new Ingrediente(listaalergenos,nombre,descripcion,id);
            res.add(in);
		}
		

	

		
	 	return res;
		
	}
	
	

}
