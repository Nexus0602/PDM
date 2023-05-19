/*package es.loyola.inftv.app.services;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import es.loyola.inftv.app.dao.Categoria;
import es.loyola.inftv.app.dao.Ingrediente;
import es.loyola.inftv.app.dao.Marca;
import es.loyola.inftv.app.dao.Opinion;
import es.loyola.inftv.app.dao.Producto;
import es.loyola.inftv.app.dao.ProductoImpl;
import es.loyola.inftv.app.dao.Usuario;
import es.loyola.inftv.app.dao.UsuarioImpl;
import es.loyola.inftv.app.manager.ProductosManager;
import es.loyola.inftv.app.manager.UsuariosManager;

public class ModificarProductoServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombre= request.getParameter("nombre");
		Marca marca= request.getParameter("marca");
		List<Ingrediente> composicion = request.getParameter("composicion");
		List<Categoria> categorias = request.getParameter("categorias");
		List<Opinion> historialOpiniones = request.getParameter("historialOpiniones");
		String codBarras = request.getParameter("codBarras");
		Integer id = Integer.parseInt("id");
		response.setContentType("application/json");
		response.setCharacterEncoding("utf-8");
		Producto ve = new ProductoImpl(); 
		List<Producto> t=  new LinkedList<Producto>();
			if (id<=0) {
				
				//ERROR 
			}
			
			else {
				
				for (Producto u: ProductosManager.getListadoProductos()) {
					if(u.getId() == id) {
						if (nombre != null)
							u.setNombre(nombre);
						if ( marca!= null)
							u.setMarca(marca);
						if (composicion != null)
								u.setComposicion(composicion);
						if (categorias != null)
							u.setCategorias(categorias);
						if (historialOpiniones != null)
							u.setHistorialOpiniones(historialOpiniones);
						if (codBarras != null)
							u.setCodBarras(codBarras);
						if (id != null)
							u.setId(id);
						ve=u;
							}

					
					}		
				
			}
				 
			JSONObject res= new JSONObject();
			 
			if (ve == null)
			{ 
				res.put("code","ERROR"); 
				res.put("mensaje", "Listado vacio");
				res.put("resultado", ve);
			} 
			else {
				res.put("code","ok");
				res.put("mensaje","ok");
				res.put("resultado",ve);
				
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
}*/
