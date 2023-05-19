package es.loyola.inftv.app.services;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
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
import es.loyola.inftv.app.manager.CategoriasManager;

@WebServlet(urlPatterns = {"/getCategorias","/getListadoCategorias"})

public class ListadoCategoriasServlet extends HttpServlet {
	
private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("application/json");
		response.setCharacterEncoding("utf-8");
		
		List<Categoria> categorias = new LinkedList<Categoria>();
		
		categorias = CategoriasManager.getListadoCategorias();
		
		 
		JSONArray array = new JSONArray(categorias);
		JSONObject resultado = new JSONObject();
		
		if (categorias.isEmpty())	{
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
