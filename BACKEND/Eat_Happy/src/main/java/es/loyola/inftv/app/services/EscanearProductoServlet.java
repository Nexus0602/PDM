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

import org.json.*;

import es.loyola.inftv.app.dao.Producto;
import es.loyola.inftv.app.dao.ProductoImpl;
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
		List<Producto> lista = new LinkedList<Producto>();
		Producto producto = null;
	
		if (cod_barras != null) {
			for (Producto p : ProductosManager.getListadoProductos()) {
				
					if (p.getCodBarras().equals(cod_barras)){
						producto = new ProductoImpl();
						producto = p;
						lista.add(producto);
					}	
				}	
			}
		
		//JSONObject prod = new JSONObject(producto);
		JSONArray array = new JSONArray(lista);
		JSONObject res = new JSONObject();
		
		if (array.isEmpty()) {
			res.put("code","ERROR");
			res.put("message","ERROR");
			res.put("result",lista);
		}
		else {
			res.put("code","ok");
			res.put("message","ok");
			res.put("result",lista);
			
		}
		
		PrintWriter writer = response.getWriter();
		try {
			writer.write(res.toString());
		} finally {
			writer.close();
		}

		
			
	}


}

