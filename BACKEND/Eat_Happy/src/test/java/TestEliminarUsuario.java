import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;

import es.loyola.inftv.app.manager.UsuariosManager;
import es.loyola.inftv.app.services.EliminarUsuarioServlet;

public class TestEliminarUsuario {
	
	@Test
	public void testEliminarUsuario() throws IOException, ServletException {
		
		HttpServletRequest request=mock(HttpServletRequest.class);   
		HttpServletResponse response=mock(HttpServletResponse.class);
		when(request.getParameter("id")).thenReturn("8");

		StringWriter stringWriter=new StringWriter();
		PrintWriter out=new PrintWriter(stringWriter);
		
		when(response.getWriter()).thenReturn(out);
		
		new EliminarUsuarioServlet().doPost(request,response);
		
		out.flush();
		
		String res=stringWriter.toString();
		System.out.println(res);
		
		JSONObject objresponse=new JSONObject();
		
		if(objresponse.has("code") && objresponse.has("mensaje")&& objresponse.has("resultado"))
		{
			assertTrue("El codigo devuelto no es ok", objresponse.get("code").equals("ok"));
			assertTrue("El mensaje devuelto no es ok",objresponse.get("mensaje").equals("ok"));
			JSONArray arrayRes = objresponse.getJSONArray("resultado");
			assertTrue( "El tamanyo del array es incorrecto ", arrayRes.length() == UsuariosManager.getListadoUsuarios().size()-1);
		}

	}
	
	@Test
	public void test2EliminarUsuario() throws IOException, ServletException {
		
		HttpServletRequest request=mock(HttpServletRequest.class);   
		HttpServletResponse response=mock(HttpServletResponse.class);
		when(request.getParameter("id")).thenReturn("8");

		StringWriter stringWriter=new StringWriter();
		PrintWriter out=new PrintWriter(stringWriter);
		
		when(response.getWriter()).thenReturn(out);
		
		new EliminarUsuarioServlet().doPost(request,response);
		
		out.flush();
		
		String res=stringWriter.toString();
		System.out.println(res);
		
		JSONObject objresponse=new JSONObject();
		
		if(objresponse.has("code") && objresponse.has("mensaje")&& objresponse.has("resultado"))
		{
			assertTrue("El codigo devuelto no es ok", objresponse.get("code").equals("ok"));
			assertTrue("El mensaje devuelto no es ok",objresponse.get("mensaje").equals("Usuario no encontrado"));
			JSONArray arrayRes = objresponse.getJSONArray("resultado");
			assertTrue( "El tamanyo del array es incorrecto ", arrayRes.length() == UsuariosManager.getListadoUsuarios().size());
		}

	}

}
