package es.loyola.inftv.app.services;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.json.*;

import es.loyola.inftv.app.dao.Producto;
import es.loyola.inftv.app.dao.Usuario;
import es.loyola.inftv.app.manager.ProductosManager;
import es.loyola.inftv.app.manager.UsuariosManager;

@WebServlet(urlPatterns = {"/guardarFavorito","/favorito"})

public class GuardarFavoritoServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("application/json");
		response.setCharacterEncoding("utf-8");
		
		List<Usuario> lista = new LinkedList<Usuario>();
		
		Integer prodId = Integer.parseInt(request.getParameter("idProducto"));
		Integer usId = Integer.parseInt(request.getParameter("idUsuario"));
		
		Producto p = ProductosManager.getProdById(prodId);
		Usuario u = UsuariosManager.getUsuarioById(usId);
		
		// Antes de agregar el producto a la lista de favoritos
		List<Producto> favoritos = new ArrayList<>(u.getFavoritos());
		favoritos.add(p);
		u.setFavoritos(favoritos);
		lista.add(u);
		

		JSONObject resultado = new JSONObject();
		JSONArray usuario = new JSONArray(lista);
		if (p != null && u != null) {
		    resultado.put("code", "OK");
		    resultado.put("message", "OK");
		    resultado.put("result", usuario);
		} else {
		    resultado.put("code", "ERROR");
		    resultado.put("message", "ERROR");
		    resultado.put("result", usuario);
		}

		PrintWriter writer = response.getWriter();
		try {
		    writer.write(resultado.toString());
		} finally {
		    writer.close();
		}

	}

}
