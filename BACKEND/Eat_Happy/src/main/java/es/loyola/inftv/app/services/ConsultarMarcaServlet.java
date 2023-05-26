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

import es.loyola.inftv.app.dao.Marca;
import es.loyola.inftv.app.manager.MarcaManager;

@WebServlet(urlPatterns = {"/getMarca","/consultarMarca"})

public class ConsultarMarcaServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("application/json");
		response.setCharacterEncoding("utf-8");
		
		String id = request.getParameter("nombre");
		List<Marca> marcas = new LinkedList<Marca>();
		
		Marca marca = null;
				
		marca = MarcaManager.getMarcaByName(id);
		marcas.add(marca);
		
		JSONObject resultado = new JSONObject();
		JSONArray array = new JSONArray(marcas);
		if (marca != null) {
		    resultado.put("code", "OK");
		    resultado.put("message", "OK");
		    resultado.put("result", array);
		} else {
		    resultado.put("code", "ERROR");
		    resultado.put("message", "Marca no encontrada");
		    resultado.put("result", array);
		}

		// Enviar la respuesta al cliente
		PrintWriter writer = response.getWriter();
		try {
		    writer.write(resultado.toString());
		} finally {
		    writer.close();
		}}}