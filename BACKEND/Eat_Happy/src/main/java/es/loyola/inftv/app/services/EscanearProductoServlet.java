package es.loyola.inftv.app.services;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.*;

import es.loyola.inftv.app.dao.Producto;
import es.loyola.inftv.app.manager.ProductosManager;

@WebServlet("/escanearProducto")
public class EscanearProductoServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String cod_barras = request.getParameter("cb");
		response.setContentType("application/json");
		response.setCharacterEncoding("utf-8");
		Producto producto = null;
	
		if (cod_barras != null) {
			for (Producto p : ProductosManager.getListadoProductos()) {
				
					if (p.getCodBarras().equals(cod_barras)){
						producto = p;
					}	
				}	
			}
		
		//JSONObject prod = new JSONObject(producto);
		JSONObject res = new JSONObject();
		
		if (producto == null) {
			res.put("code","ERROR");
			res.put("mensaje","ListadoVacío");
			res.put("resultado","Introduzca un codigo de barras");
		}
		else {
			res.put("code","ok");
			res.put("mensaje","ok");
			res.put("resultado",producto.getNombre());
			
		}
		
		PrintWriter writer = response.getWriter();
		try {
			writer.write(res.toString());
		} finally {
			writer.close();
		}

		
			
	}


}

