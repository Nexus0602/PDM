	package es.loyola.inftv.app.manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import es.loyola.inftv.app.dao.Categoria;
import es.loyola.inftv.app.dao.CategoriaImpl;
import es.loyola.inftv.app.dao.Marca;
import es.loyola.inftv.app.util.DBUtil;

public class CategoriasManager {
	
	public static List<Categoria> getListadoCategorias(){
		
		List<Categoria> listaCategorias = new ArrayList<Categoria>();
		
		/*Categoria lacteos = new CategoriaImpl("Lacteos", "Productos derivados de la leche");
		Categoria carnes = new CategoriaImpl("Carnes", "Productos de origen animal ricos en proteínas");
		Categoria frutasVerduras = new CategoriaImpl("Frutas y verduras", "Productos frescos y ricos en nutrientes");
		Categoria cerealesGranos = new CategoriaImpl("Cereales y granos", "Productos ricos en carbohidratos y fibra");
		Categoria bebidas = new CategoriaImpl("Bebidas", "Líquidos para hidratarse y refrescarse");
		Categoria dulcesSnacks = new CategoriaImpl("Dulces y snacks", "Productos para disfrutar como postres o aperitivos");
		Categoria panaderiaReposteria = new CategoriaImpl("Panaderia y reposteria", "Productos horneados y dulces");
		
		
		listaCategorias.add(lacteos);
		listaCategorias.add(carnes);
		listaCategorias.add(frutasVerduras);
		listaCategorias.add(cerealesGranos);
		listaCategorias.add(bebidas);
		listaCategorias.add(dulcesSnacks);
		listaCategorias.add(panaderiaReposteria);*/
		
		Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = DBUtil.getConnection(); // Obtener la conexión a la base de datos
            String sql = "SELECT * FROM categorias"; // Query para obtener las categorías
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                
                String nombre = rs.getString("nombre");
                String descripcion = rs.getString("descripcion");
			

                Categoria categoria = new CategoriaImpl( nombre, descripcion);
                listaCategorias.add(categoria);
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
		

		
		return listaCategorias;
		
	}
	public static Categoria getCategoriaByName(String name) {
		
		List<Categoria> listaCategorias= getListadoCategorias();
		Categoria a = null;
		for(Categoria m: listaCategorias)
		{
			if(m.getNombre().equalsIgnoreCase(name))
			{
				a =  m;
			}
			
		}
		return a;
		
		
		
	
}


}
