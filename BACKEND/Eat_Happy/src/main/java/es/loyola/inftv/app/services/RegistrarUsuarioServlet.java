package es.loyola.inftv.app.services;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import es.loyola.inftv.app.dao.Alergeno.tipoAlergeno;
import es.loyola.inftv.app.dao.Usuario;
import es.loyola.inftv.app.dao.UsuarioImpl;
import es.loyola.inftv.app.manager.UsuariosManager;

@WebServlet("/registrarUsuario")
public class RegistrarUsuarioServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Integer a= Integer.parseInt(request.getParameter("id"));
		String b= request.getParameter("nombre");
		String c= request.getParameter("apellidos");
		String d= request.getParameter("email");
		String e= request.getParameter("contrasenya");
		
		String alergenosParametro = request.getParameter("alergenos");
		List<tipoAlergeno> listaAlergenos = new ArrayList<>();
		
		System.out.println("listaAlergenos: " + alergenosParametro);

		if (alergenosParametro != null && !alergenosParametro.isEmpty()) {
		    String[] alergenosArray = alergenosParametro.split(",");
		    for (String nombreAlergeno : alergenosArray) {
		    	System.out.println("Alergeno : " + nombreAlergeno);
		    	tipoAlergeno alergeno = tipoAlergeno.valueOf(nombreAlergeno.toUpperCase());
		        listaAlergenos.add(alergeno);
		        System.out.println("Alergeno añadido: " + alergeno);
		    }
		}
		
		System.out.println("listaAlergenos: " + listaAlergenos);
		
		response.setContentType("application/json");
		response.setCharacterEncoding("utf-8");
		Usuario ve = new UsuarioImpl();
		List<Usuario> t=  new LinkedList<Usuario>();
		t =  UsuariosManager.getListadoUsuarios();
		
		if (a != null && b != null && c != null && d!=null && e!=null)
		{
			//Crear el usuario
		    ve.setId(a);
		    ve.setNombre(b);
		    ve.setApellidos(c);
		    ve.setEmail(d);
		    ve.setContrasenya(e);
		    ve.setAlergenos(listaAlergenos);
		    t.add(ve);
		    
		}
		//JSONArray array=new JSONArray(ve);
		JSONObject res= new JSONObject();
		JSONArray array = new JSONArray(t);
		
		 
		if (t == null)
		{ 
			res.put("code","ERROR");
			res.put("message", "Listado vacio");
			res.put("result", array);
		} 
		else {
			res.put("code","ok");
			res.put("message","ok");
			res.put("result",array);
			
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
