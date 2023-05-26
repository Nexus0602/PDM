package es.loyola.inftv.app.services;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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

@WebServlet("/modificarProducto")
public class ModificarProductoServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("application/json");
		response.setCharacterEncoding("utf-8");
		Integer id= Integer.parseInt(request.getParameter("id"));
		String nombre= request.getParameter("nombre");
		String codBarras = request.getParameter("codBarras");
		String marcaId = request.getParameter("marca");
		String composicionString = request.getParameter("composicion");
		String categoriasString = request.getParameter("categorias");
		
		Marca marca = null;
		if (!marcaId.isEmpty()) {
		    marca = MarcaManager.getMarcaByName(marcaId);
		}
		
		
		List<Ingrediente> composicion = new ArrayList<Ingrediente>();
		if (!composicionString.isEmpty()) {
		    String[] ingredientesIds = composicionString.split(",");
		    for (String ingredienteId : ingredientesIds) {
		        Ingrediente ingrediente = IngredientesManager.getIngredienteById(ingredienteId);
		        if (ingrediente != null) {
		            composicion.add(ingrediente);
		        }
		    }
		}
		
		
		List<Categoria> categorias = new ArrayList<Categoria>();
		if (!categoriasString.isEmpty()) {
		
		    String[] categoriasIds = categoriasString.split(",");
		    for (String categoriaId : categoriasIds) {
		        Categoria categoria = CategoriasManager.getCategoriaByName(categoriaId);
		        if (categoria != null) {
		            categorias.add(categoria);
		        }
		    }
		}
		
		
		
		
		Producto ve = null;
	    List<Producto> t=  new LinkedList<Producto>();
	   
				for (Producto u: ProductosManager.getListadoProductos()) {
					if(u.getId() == id) {
						ve = new ProductoImpl();
						ve.setId(id);
						if (!nombre.isEmpty())
							ve.setNombre(nombre);
						else
							ve.setNombre(u.getNombre());
						if ( marca!= null)
							ve.setMarca(marca);
						else
							ve.setMarca(u.getMarca());
						if (!composicion.isEmpty())
							ve.setComposicion(composicion);
						else
							ve.setComposicion(u.getComposicion());
						if (!categorias.isEmpty())
							ve.setCategorias(categorias);
						else
							ve.setCategorias(u.getCategorias());
						if (codBarras != null)
							ve.setCodBarras(codBarras);
						else
							ve.setCodBarras(u.getCodBarras());
						t.add(ve);
							
							}
					
					}		
				
				 
			JSONObject res= new JSONObject();
			JSONArray array = new JSONArray(t);
			
			if (t.isEmpty())
			{ 
				res.put("code","ERROR"); 
				res.put("message", "Producto no encontrado");
				res.put("result", array);
			} 
			else {
				res.put("code","ok");
				res.put("message","ok");
				res.put("result",array);
				
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
