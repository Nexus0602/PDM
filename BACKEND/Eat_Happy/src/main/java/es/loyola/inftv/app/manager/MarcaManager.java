package es.loyola.inftv.app.manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import es.loyola.inftv.app.dao.Marca;
import es.loyola.inftv.app.dao.MarcaImpl;
import es.loyola.inftv.app.util.DBUtil;


public class MarcaManager {

	
		
		public static List<Marca> getListadoMarcas(){
			
			List <Marca> lmarcas= new LinkedList <Marca>();
			
			Connection conn = null;
	        PreparedStatement stmt = null;
	        ResultSet rs = null;

	        try {
	            conn = DBUtil.getConnection(); // Obtener la conexión a la base de datos
	            String sql = "SELECT * FROM marcas"; // Query para obtener las categorías
	            stmt = conn.prepareStatement(sql);
	            rs = stmt.executeQuery();

	            while (rs.next()) {
	                
	                String nombre = rs.getString("nombre");
	                String direccion = rs.getString("direccion");
	                Integer telefono = rs.getInt("telefono");
	                String cif = rs.getString("cif");
				

	                Marca marca = new MarcaImpl (nombre,direccion,telefono,cif);
	                lmarcas.add(marca);
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
	        
	        
			
			/*Marca pascual = new MarcaImpl("PASCUAL","calle",123,"CIF");
			Marca vivesoy = new MarcaImpl("VIVESOY","calle",764,"CIF");
			Marca hacendado = new MarcaImpl("HACENDADO","calle",524,"CIF");
			Marca gallo = new MarcaImpl("GALLO","calle",326,"CIF");
			Marca asturiana = new MarcaImpl("ASTURIANA","calle",184,"CIF");
			Marca nestle = new MarcaImpl("NESTLE","calle",584,"CIF");
			
			
			
			lmarcas.add(pascual);
			lmarcas.add(vivesoy);
			lmarcas.add(hacendado);
			lmarcas.add(gallo);
			lmarcas.add(asturiana);
			lmarcas.add(nestle);*/
			
			
			
			
			return lmarcas;
			
			
		}
		
		public static Marca getMarcaByName(String name) {
			
			List <Marca> lmarcas= getListadoMarcas();
			Marca a = null;
			for(Marca m: lmarcas)
			{
				if(m.getNombre().equalsIgnoreCase(name))
				{
					a =  m;
				}
				
			}
			return a;
			
			
			
		
	}

}
