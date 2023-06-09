package es.loyola.inftv.app.services;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

import org.json.*;

import es.loyola.inftv.app.dao.Usuario;
import es.loyola.inftv.app.manager.UsuariosManager;

@WebServlet(urlPatterns = {"/getUsuario","/consultarUsuario"})

public class ConsultarUsuarioServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("application/json");
		response.setCharacterEncoding("utf-8");
		
		Integer id = Integer.parseInt(request.getParameter("id"));
		List<Usuario> usuarios = new LinkedList<Usuario>();
		
		//JSONObject jsonUsuario = new JSONObject();
		
		for (Usuario u : UsuariosManager.getListadoUsuarios() ) {
			
			if (id == u.getId()) {
				usuarios.add(u);
			}
		}
		
		
		JSONObject resultado = new JSONObject();
		JSONArray array = new JSONArray(usuarios);
		if (!usuarios.isEmpty()) {
		    resultado.put("code", "OK");
		    resultado.put("message", "OK");
		    resultado.put("result", array);
		} else {
		    resultado.put("code", "ERROR");
		    resultado.put("message", "Usuario no encontrado");
		    resultado.put("result", JSONObject.NULL);
		}

		// Enviar la respuesta al cliente
		PrintWriter writer = response.getWriter();
		try {
		    writer.write(resultado.toString());
		} finally {
		    writer.close();
		}}}

