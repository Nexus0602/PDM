package es.loyola.inftv.app.services;

import java.io.IOException;
import java.io.PrintWriter;
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

@WebServlet("/eliminarUsuario")

public class EliminarUsuarioServlet extends HttpServlet  {
	private static final long serialVersionUID = 1L;
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
	response.setContentType("application/json");
	response.setCharacterEncoding("utf-8");

	Integer id = Integer.parseInt(request.getParameter ("id"));
	List <Usuario> us2 =UsuariosManager.getListadoUsuarios();
    Usuario usuario = null;

		if(id !=null){
			
			for (Usuario p: us2) 
			{
				if(p.getId() == id) 
				{
					usuario = p;
					
				}
					
			}
			
			if (usuario!= null)
				us2.remove(usuario);		
		}
		
		JSONObject obj = new JSONObject();
        JSONArray array = new JSONArray(us2);

        if (usuario == null) {
            obj.put("code", "ERROR");
            obj.put("message", "Usuario no encontrado");
            obj.put("result", us2);
        } else {
            
            obj.put("code", "ok");
            obj.put("message", "ok");
            obj.put("result", array);
        }

        PrintWriter writer = response.getWriter();
        try {
            writer.write(obj.toString());
        } finally {
            writer.close();
        }
			}
			
}
