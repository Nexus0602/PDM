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

import es.loyola.inftv.app.dao.Usuario;
import es.loyola.inftv.app.manager.UsuariosManager;

@WebServlet(urlPatterns = {"/login","/iniciarSesion"})


public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("application/json");
		response.setCharacterEncoding("utf-8");
		
		String nombre = request.getParameter("nombre");
		String contrasenya = request.getParameter("contrasenya");
		List<Usuario> usuarios = new LinkedList<Usuario>();
		
		for (Usuario u : UsuariosManager.getListadoUsuarios() ) {
			
			if (nombre.equals(u.getNombre()) && contrasenya.equals(u.getContrasenya())) {
				 usuarios.add(u);
			}
		}
	
		JSONObject resultado = new JSONObject();
		JSONArray array = new JSONArray(usuarios);
	if (!usuarios.isEmpty()) {
	    resultado.put("code", "OK");
	    resultado.put("message", "Sesion iniciada");
	    resultado.put("result", array);
	} else {
	    resultado.put("code", "ERROR");
	    resultado.put("message", "El usuario o la contrasenya son incorrectos");
	    resultado.put("result", array);
	}

	// Enviar la respuesta al cliente
	PrintWriter writer = response.getWriter();
	try {
	    writer.write(resultado.toString());
	} finally {
	    writer.close();
	}
	}
	

}
