package es.loyola.inftv.app.services;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import es.loyola.inftv.app.dao.Ingrediente;
import es.loyola.inftv.app.dao.IngredienteImpl;
import es.loyola.inftv.app.dao.Usuario;
import es.loyola.inftv.app.dao.UsuarioImpl;
import es.loyola.inftv.app.manager.UsuariosManager;



@WebServlet("/modificarUsuario")
public class ModificarUsuarioServlet  extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer id= Integer.parseInt(request.getParameter("id"));
		String nombre= request.getParameter("nombre");
		String apellidos= request.getParameter("apellidos");
		String email= request.getParameter("email");
		String contrasenya= request.getParameter("contrasenya");
		response.setContentType("application/json");
		response.setCharacterEncoding("utf-8");
		Usuario ve = null; 
			if (id<=0) {
				
				//ERROR 
			}
			
			else {
				
				for (Usuario u: UsuariosManager.getListadoUsuarios()) {
					if(u.getId() == id) {
						ve = new UsuarioImpl();
						if (!nombre.isEmpty())
							ve.setNombre(nombre);
						else 
							ve.setNombre(u.getNombre());
						if (!apellidos.isEmpty())
							ve.setApellidos(apellidos);
						else
							ve.setApellidos(u.getApellidos());
						if (!email.isEmpty())
							ve.setEmail(email);
						else
							ve.setEmail(u.getEmail());
						if (!contrasenya.isEmpty())
							ve.setContrasenya(contrasenya);
						else
							ve.setContrasenya(u.getContrasenya());
						
							}

					
					}		
				
			}
				 
			JSONObject res= new JSONObject();
			JSONObject usuario = new JSONObject(ve);
			 
			if (ve == null)
			{ 
				res.put("code","ERROR"); 
				res.put("mensaje", "Listado vacio");
				res.put("resultado", ve);
			} 
			else {
				res.put("code","ok");
				res.put("mensaje","ok");
				res.put("resultado",usuario);
				
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
	
	// guardar el usuario actualizado en la bdd

