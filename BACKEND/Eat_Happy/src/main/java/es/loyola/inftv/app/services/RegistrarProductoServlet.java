package es.loyola.inftv.app.services;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringJoiner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import es.loyola.inftv.app.dao.Categoria;
import es.loyola.inftv.app.dao.Ingrediente;
import es.loyola.inftv.app.dao.Marca;
import es.loyola.inftv.app.dao.Producto;
import es.loyola.inftv.app.dao.ProductoImpl;
import es.loyola.inftv.app.manager.CategoriasManager;
import es.loyola.inftv.app.manager.IngredientesManager;
import es.loyola.inftv.app.manager.MarcaManager;
import es.loyola.inftv.app.manager.ProductosManager;
import es.loyola.inftv.app.util.DBUtil;


@WebServlet("/registrarProducto")
public class RegistrarProductoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Connection conn = null;
        PreparedStatement stmt = null;
        PreparedStatement stmt2 = null;
        ResultSet rs = null;
        
	    String productoString= request.getParameter("producto");
	    //System.out.println("producto: " + productoString);
	    JSONObject productoJson= new JSONObject(productoString);
	    String nombre = productoJson.getString("nombre");
	    String codBarras = productoJson.getString("codigo");
	    //System.out.println("nombre: " + nombre);
	    Integer id = Integer.parseInt(productoJson.getString("id"));
	    //System.out.println("id: " + id);
	    String nombreMarca= productoJson.getString("marca");
	    //System.out.println("marca: " + idMarca);
	    Marca marca=MarcaManager.getMarcaByName(nombreMarca);
	    
	    JSONArray ingredientesJson = productoJson.getJSONArray("composicion");
	    List<Ingrediente> ingredientes = new ArrayList<Ingrediente>();
	    for (int i = 0; i < ingredientesJson.length(); i++) {
	        String idIngrediente = ingredientesJson.getString(i);
	        Ingrediente ingrediente = IngredientesManager.getIngredienteById(idIngrediente);
	        if (ingrediente != null) {
	            ingredientes.add(ingrediente);
	            
	        }
	    }
	    //System.out.println("composicion: " + ingredientes);
	    JSONArray categoriasJson = productoJson.getJSONArray("categorias");
	    List<Categoria> categorias = new ArrayList<Categoria>();
	    List<String> nombrescategorias = new ArrayList<String>();
	    for (int i = 0; i < categoriasJson.length(); i++) {
	        String idCategoria = categoriasJson.getString(i);
	        Categoria categoria = CategoriasManager.getCategoriaByName(idCategoria);
	        if (categoria != null) {
	            categorias.add(categoria);
	            nombrescategorias.add(categoria.getNombre());
	        }
	    }
	    //System.out.println("categorias: " + categorias);
	    

	    response.setContentType("application/json");
	    response.setCharacterEncoding("utf-8");
	    Producto ve = new ProductoImpl();
	    List<Producto> t=  new LinkedList<Producto>();
	    t=ProductosManager.getListadoProductos();
	    if (!productoString.isEmpty())
	    {
	    	ve.setId(id);
	        ve.setNombre(nombre);
	        ve.setCodBarras(codBarras);
	        ve.setMarca(marca);
	        ve.setComposicion(ingredientes);
	        ve.setCategorias(categorias);
	        t.add(ve);
	    }
	       
	   try {
	        conn = DBUtil.getConnection(); // Obtener la conexión a la base de datos
	        String sql = "INSERT INTO productos (nombre,codBarras) VALUES (?, ?)"; // Consulta SQL con parámetros de enlace
	        stmt = conn.prepareStatement(sql);
	        stmt.setString(1, nombre); // Establecer el valor del primer parámetro de enlace
	        stmt.setString(2, codBarras); // Establecer el valor del segundo parámetro de enlace
	        stmt.executeUpdate(); // Ejecutar la consulta de inserción
	        
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
	   
	   String nombreProducto = ve.getNombre(); // Nombre del producto
	   int idProducto = 0;

	   try {
	       conn = DBUtil.getConnection(); // Obtener la conexión a la base de datos
	       String sql = "SELECT id FROM productos WHERE nombre = ?"; // Consulta SQL con parámetro de enlace
	       stmt = conn.prepareStatement(sql);
	       stmt.setString(1, nombreProducto); // Establecer el valor del parámetro de enlace
	       rs = stmt.executeQuery(); // Ejecutar la consulta SELECT

	       if (rs.next()) {
	           idProducto = rs.getInt("id"); // Obtener el valor del campo "id"
	           // Hacer algo con el ID del producto obtenido
	       }
	   } catch (SQLException e) {
	       // Manejo de excepciones
		   e.printStackTrace();
	   } catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} finally {
		 DBUtil.closeResultSet(rs);
         DBUtil.closeStatement(stmt);
         DBUtil.closeConnection(conn);
	   }
	   
	   int idMarca = 0;
	   try {
	       conn = DBUtil.getConnection(); // Obtener la conexión a la base de datos
	       String sql = "SELECT id FROM marcas WHERE nombre = ?"; // Consulta SQL con parámetro de enlace
	       stmt = conn.prepareStatement(sql);
	       stmt.setString(1, nombreMarca); // Establecer el valor del parámetro de enlace
	       rs = stmt.executeQuery(); // Ejecutar la consulta SELECT

	       if (rs.next()) {
	           idMarca = rs.getInt("id"); // Obtener el valor del campo "id"
	           // Hacer algo con el ID de la marca obtenido
	       }
	   } catch (SQLException e) {
	       // Manejo de excepciones
		   e.printStackTrace();
	   } catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} finally {
		 DBUtil.closeResultSet(rs);
         DBUtil.closeStatement(stmt);
         DBUtil.closeConnection(conn);
	   }
	   
	   
	   try {
	        conn = DBUtil.getConnection(); // Obtener la conexión a la base de datos
	        String sql = "INSERT INTO productos_marcas (idProducto,idMarca) VALUES (?, ?)"; // Consulta SQL con parámetros de enlace
	        stmt = conn.prepareStatement(sql);
	        stmt.setInt(1, idProducto); // Establecer el valor del primer parámetro de enlace
	        stmt.setInt(2, idMarca); // Establecer el valor del segundo parámetro de enlace
	        stmt.executeUpdate(); // Ejecutar la consulta de inserción
	        
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
	   
	  List<Integer> idsCategorias = new LinkedList<Integer>();

	   try {
	       conn = DBUtil.getConnection(); // Obtener la conexión a la base de datos
	       StringJoiner joiner = new StringJoiner(",");
	       for (int i = 0; i < nombrescategorias.size(); i++) {
	           joiner.add("?");
	       }
	       String placeholders = joiner.toString();

	       String sql = "SELECT id FROM categorias WHERE nombre IN (" + placeholders + ")";

	       stmt = conn.prepareStatement(sql);

	       // Establecer los valores de los parámetros de enlace
	       for (int i = 0; i < nombrescategorias.size(); i++) {
	           stmt.setString(i + 1, nombrescategorias.get(i));
	       }

	       rs = stmt.executeQuery(); // Ejecutar la consulta SELECT

	       while (rs.next()) {
	           int idCategoria = rs.getInt("id"); // Obtener el valor del campo "id" para cada categoría
	           idsCategorias.add(idCategoria);
	       }
	   } catch (SQLException e) {
	       // Manejo de excepciones
	   } catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} finally {
		DBUtil.closeResultSet(rs);
        DBUtil.closeStatement(stmt);
        DBUtil.closeConnection(conn);
	   }
	   
	   
	   try {
	       conn = DBUtil.getConnection(); // Obtener la conexión a la base de datos
	       String sql = "INSERT INTO productos_categorias (idProducto, idCategoria) VALUES (?, ?)"; // Consulta SQL con parámetros de enlace
	       stmt = conn.prepareStatement(sql);

	       // Insertar la relación para cada par de IDs
	       for (int idCategoria : idsCategorias) {
	           stmt.setInt(1, idProducto); // Establecer el valor del primer parámetro de enlace (ID del producto)
	           stmt.setInt(2, idCategoria); // Establecer el valor del segundo parámetro de enlace (ID de la categoría)
	           stmt.executeUpdate(); // Ejecutar la consulta de inserción
	       }
	   } catch (SQLException e) {
	       // Manejo de excepciones
	   } catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} finally {
		DBUtil.closeResultSet(rs);
        DBUtil.closeStatement(stmt);
        DBUtil.closeConnection(conn);
	   }
	   
	   try {
	       conn = DBUtil.getConnection(); // Obtener la conexión a la base de datos
	       String sql = "INSERT INTO productos_ingredientes (idProducto, idIngrediente) VALUES (?, ?)"; // Consulta SQL con parámetros de enlace
	       stmt = conn.prepareStatement(sql);

	       // Insertar la relación para cada par de IDs
	       for (Ingrediente ing : ingredientes) {
	           stmt.setInt(1, idProducto); // Establecer el valor del primer parámetro de enlace (ID del producto)
	           stmt.setInt(2, Integer.parseInt(ing.getId())); // Establecer el valor del segundo parámetro de enlace (ID de la categoría)
	           stmt.executeUpdate(); // Ejecutar la consulta de inserción
	       }
	   } catch (SQLException e) {
	       // Manejo de excepciones
	   } catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} finally {
		DBUtil.closeResultSet(rs);
        DBUtil.closeStatement(stmt);
        DBUtil.closeConnection(conn);
	   }
   
	    JSONObject res= new JSONObject();
	    JSONObject prod = new JSONObject(ve);

	    if (prod.isEmpty())
	    {
	        res.put("code","ERROR");
	        res.put("mensaje", "Listado vacio");
	        res.put("resultado", prod);
	    }
	    else {
	        res.put("code","ok");
	        res.put("mensaje","ok");
	        res.put("resultado",prod);

	    }

	    PrintWriter writer= response.getWriter();
	    try
	    {
	        writer.write(res.toString());
	    }
	    finally
	    {
	        writer.close();
	    }
	}


}

