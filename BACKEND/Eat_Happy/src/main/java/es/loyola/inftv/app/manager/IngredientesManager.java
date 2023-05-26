package es.loyola.inftv.app.manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import es.loyola.inftv.app.dao.Categoria;
import es.loyola.inftv.app.dao.CategoriaImpl;
import es.loyola.inftv.app.dao.Ingrediente;
import es.loyola.inftv.app.dao.IngredienteImpl;
import es.loyola.inftv.app.dao.Alergeno.tipoAlergeno;
import es.loyola.inftv.app.util.DBUtil;

public class IngredientesManager {

	
	
	public static List<Ingrediente> getListadoIngrediente(){
		
		
		
		/*Ingrediente harina = new IngredienteImpl(Arrays.asList(tipoAlergeno.GLUTEN), "Harina", "Ingrediente básico para la preparación de pan y pasteles", "1");
		Ingrediente salsa_marisco = new IngredienteImpl(Arrays.asList(tipoAlergeno.CRUSTACEOS, tipoAlergeno.MOSTAZA), "Salsa de mariscos", "Deliciosa salsa para acompañar tus platos de mariscos", "2");
		Ingrediente soja = new IngredienteImpl(Arrays.asList(tipoAlergeno.SOJA), "Soja", "Ingrediente común en la cocina asiática, perfecto para preparaciones vegetarianas", "3");
		Ingrediente mantequilla_cacahuete = new IngredienteImpl(Arrays.asList(tipoAlergeno.CACAHUETES), "Mantequilla de cacahuete", "Deliciosa y versátil crema de cacahuete para untar en panes y preparar salsas", "4");
		Ingrediente huevo = new IngredienteImpl(Arrays.asList(tipoAlergeno.HUEVOS), "Huevo", "Ingrediente básico para preparar tortillas, frittatas, entre otros platos", "5");
		Ingrediente leche = new IngredienteImpl(Arrays.asList(tipoAlergeno.LACTOSA), "Leche", "Ingrediente básico", "6");
		Ingrediente fructosa = new IngredienteImpl(Arrays.asList(tipoAlergeno.FRUCTOSA), "Fructosa", "Edulcorante", "7");*/
		
		List <Ingrediente> lingrediente= new LinkedList <Ingrediente>();
		
		Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = DBUtil.getConnection(); // Obtener la conexión a la base de datos
            String sql = "SELECT * FROM ingredientes"; // Query para obtener las categorías
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                
                String nombre = rs.getString("nombre");
                String descripcion = rs.getString("descripcion");
                String id = rs.getString("id");
                String alergenosParametro = rs.getString("alergenos");
        		List<tipoAlergeno> listaAlergenos = new ArrayList<>();
        		
        		//System.out.println("listaAlergenos: " + alergenosParametro);

        		if (alergenosParametro != null && !alergenosParametro.isEmpty()) {
        		    String[] alergenosArray = alergenosParametro.split(",");
        		    for (String idAlergeno : alergenosArray) {
        		    	tipoAlergeno alergeno = AlergenosManager.getAlergenoById(Integer.parseInt(idAlergeno));
        		    	 
        		        listaAlergenos.add(alergeno);
        		    }
        		}
			
        		Ingrediente ingrediente = new IngredienteImpl(listaAlergenos,nombre,descripcion,id);
        		lingrediente.add(ingrediente);
            }
        } catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
            // Cerrar los recursos en orden inverso
            DBUtil.closeResultSet(rs);
            DBUtil.closeStatement(stmt);
            DBUtil.closeConnection(conn);
        }
		
		/*lingrediente.add(harina);
		lingrediente.add(salsa_marisco);
		lingrediente.add(soja);
		lingrediente.add(mantequilla_cacahuete);
		lingrediente.add(huevo);
		lingrediente.add(leche);
		lingrediente.add(fructosa);*/
		
		
		return lingrediente;
		
		
	}
	
	public static Ingrediente getIngredienteById(String id) {
		
		List <Ingrediente> lingrediente= getListadoIngrediente();
		Ingrediente a = null;
		for(Ingrediente m: lingrediente)
		{
			if(m.getId().equals(id))
			{
				a =  m;
			}
			
		}
		return a;
		
			
}
}
