package es.loyola.inftv.app.services;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import es.loyola.inftv.app.dao.Producto;
import es.loyola.inftv.app.manager.ProductosManager;


@WebServlet(urlPatterns = {"/getProductos","/getListadoProductos"})
public class ListadoProductosServlet extends HttpServlet {
	
private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("application/json");
		response.setCharacterEncoding("utf-8");
		
		List<Producto> productos = new LinkedList<Producto>();
		
		for (Producto p : ProductosManager.getListadoProductos() ) {
			
			productos.add(p);
			
		}
		
		 
		JSONArray array = new JSONArray(productos);
		JSONObject resultado = new JSONObject();
		
		if (productos.isEmpty())	{
			resultado.put("code", "ERROR");
			resultado.put("message", "Listado Vacio");
			resultado.put("result", "{}");
			
		}
		else {
			
			resultado.put("code", "OK");
			resultado.put("message", "OK");
			resultado.put("result", array);
			
		}
		
		PrintWriter writer = response.getWriter();
		try {
			writer.write(resultado.toString());
		}
		finally {
			writer.close();
		}
		
	}
	

}
