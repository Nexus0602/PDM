package es.loyola.inftv.app.services;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.LinkedList;
import java.util.List;
import java.io.PrintWriter;
import org.json.*;

import es.loyola.inftv.app.dao.Usuario;
import es.loyola.inftv.app.manager.UsuariosManager;

@WebServlet(urlPatterns = {"/getUsuarios","/getListadoUsuarios"})
public class ListadoUsuariosServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("application/json");
		response.setCharacterEncoding("utf-8");
		
		List<Usuario> usuarios = new LinkedList<Usuario>();
		
		for (Usuario u : UsuariosManager.getListadoUsuarios() ) {
			
			usuarios.add(u);
			
		}
		
		 
		JSONArray array = new JSONArray(usuarios);
		JSONObject resultado = new JSONObject();
		
		if (usuarios.isEmpty())	{
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

