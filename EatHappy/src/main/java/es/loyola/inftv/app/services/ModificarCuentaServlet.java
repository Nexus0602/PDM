package es.loyola.inftv.app.services;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import es.loyola.inftv.app.dao.Ingrediente;
import es.loyola.inftv.app.dao.Usuario;
import es.loyola.inftv.app.manager.IngredientesManager;
import es.loyola.inftv.app.manager.UsuariosManager;



@WebServlet("/modificarCuenta")
public class ModificarCuentaServlet  extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/plain");
		PrintWriter out = response.getWriter();

		String id = request.getParameter ("id");
		String nombre = request.getParameter ("nombre");
		/*String apellido = request.getParameter ("apellido");
		String email = request.getParameter ("email");
		String contrasenya = request.getParameter ("contrasenya");
		/*String lista_ingredientes = request.getParameter ("ingredientes"); 
		List<String> ings = Arrays.asList(lista_ingredientes.split(";"));
		
		List<Ingrediente> ingredientes = new ArrayList<Ingrediente>();
		
		for (String i: ings) {
			
			Ingrediente ing = new Ingrediente()
			ingredientes.add(i);
		}
		*/
		
		List<Usuario> users = UsuariosManager.getListadoUsuarios();
		
		try {
			List<Ingrediente> ingredientes = IngredientesManager.getListadoIngredientes();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		if (id != null) {
			for (Usuario u: users) {
				
				/*out.print(u.getApellidos());
				out.print(u.getEmail());
				out.print(u.getContrasenya());
				out.print(u.getIngredientes());*/
				
				if (u.getId().equals(Integer.parseInt(id))) {
					out.print("Nombre actual: ");
					out.print(u.getNombre());
					out.print("\n");
					if (nombre != null)
						u.setNombre(nombre);
					/*if (apellido != null)
					u.setApellidos(apellido);
					if (email != null
					u.setEmail(email);
					if (contrasenya != null)
					u.setContrasenya(contrasenya);
					if (ingredientes != null)
					u.setIngredientes(ingredientes);*/
					
					out.print("Nombre nuevo: ");
					out.print(u.getNombre());
					/*out.print(u.getApellidos());
					out.print(u.getEmail());
					out.print(u.getContrasenya());
					out.print(u.getIngredientes());*/
				}
			}
		}
		
		
			
	}

}
