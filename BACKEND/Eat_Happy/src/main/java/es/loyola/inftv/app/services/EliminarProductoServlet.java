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

import es.loyola.inftv.app.dao.Producto;
import es.loyola.inftv.app.manager.ProductosManager;

import org.json.JSONArray;
import org.json.JSONObject;

@WebServlet("/eliminarProducto")


public class EliminarProductoServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");

        Integer id = Integer.parseInt(request.getParameter("id"));
        List<Producto> lista = ProductosManager.getListadoProductos();
        Producto prod = null;

        if (id != null) {
            for (Producto p : lista) {
                if (p.getId() == id) {
                    prod = p;
                }
             }
           lista.remove(prod);
                
        }
            
        
       

        JSONObject obj = new JSONObject();
        JSONArray array = new JSONArray(lista);

        if (prod == null) {
            obj.put("code", "ERROR");
            obj.put("message", "Listado vacío");
            obj.put("result", "Producto no encontrado");
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
    


