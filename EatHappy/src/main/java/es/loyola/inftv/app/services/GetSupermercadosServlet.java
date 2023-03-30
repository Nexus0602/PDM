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
import es.loyola.inftv.app.dao.Supermercado;
import es.loyola.inftv.app.manager.SupermercadosManager;


//@WebServlet(urlPatterns = {"/listaSupermercados" ,"/supermercados"}, description = "supermercados service");
@WebServlet("/getSupermercados")
public class GetSupermercadosServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String product_id = request.getParameter("id");
		response.setContentType("application/json");
		response.setCharacterEncoding("utf-8");
		List<Supermercado> supermercados = new LinkedList<Supermercado>();
		List<String> stringSupermercados = new LinkedList<String>();
		if (product_id != null) {
			for (Supermercado s : SupermercadosManager.getListadoSupermercados()) {
				
				for(Producto p: s.getProductos()) {
					if (p.getId().equals(Integer.parseInt(product_id))){
						supermercados.add(s);
						stringSupermercados.add(s.getNombre());
					}
					
				}
				
			}
			
		}
		
		JSONArray array = new JSONArray (stringSupermercados);
		JSONObject res = new JSONObject();
		
		if (stringSupermercados.isEmpty()) {
			res.put("code","ERROR");
			res.put("mensaje","ListadoVacío");
			res.put("resultado",array);
		}
		else {
			res.put("code","ok");
			res.put("mensaje","ok");
			res.put("resultado",array);
			
		}
		
		PrintWriter writer = response.getWriter();
		try {
			writer.write(res.toString());
		} finally {
			writer.close();
		}

		
			
	}

}

