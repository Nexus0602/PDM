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

import es.loyola.inftv.app.services.ModificarUsuarioServlet;

public class TestModificarUsuario {
	@Test
	public void testDoPost() throws IOException,ServletException{
		HttpServletRequest request=mock(HttpServletRequest.class);   
		HttpServletResponse response=mock(HttpServletResponse.class);
		when(request.getParameter("id")).thenReturn("9");
		when(request.getParameter("nombre")).thenReturn("Pablo");
		when(request.getParameter("apellidos")).thenReturn("Torti");
		when(request.getParameter("email")).thenReturn("pablotorti@gmail.com");
		when(request.getParameter("contrasenya")).thenReturn("Pablo1234");

		
		
		StringWriter stringWriter=new StringWriter();
		PrintWriter out=new PrintWriter(stringWriter);
		
		when(response.getWriter()).thenReturn(out);
		
		new ModificarUsuarioServlet().doPost(request,response);
		
		out.flush();
		
		String res=stringWriter.toString();
		System.out.println(res);
		 
		JSONObject objresponse=new JSONObject();
		
		if(objresponse.has("code") && objresponse.has("mensaje")&& objresponse.has("resultado"))
		{
			assertTrue("El codigo devuelto no es ok", objresponse.get("code").equals("ok"));
			assertTrue("El mensaje devuelto no es ok",objresponse.get("mensaje").equals("ok"));
			JSONArray arrayResultado=objresponse.getJSONArray("resultado");
			assertTrue("El codigo devulto no es ok", arrayResultado.length()==1); 
			 
			 
			 
		}

		
	}
	
	@Test
	public void test2DoPost() throws IOException,ServletException{
		HttpServletRequest request=mock(HttpServletRequest.class);   
		HttpServletResponse response=mock(HttpServletResponse.class);
		when(request.getParameter("id")).thenReturn("15");
		when(request.getParameter("nombre")).thenReturn("Pablo");
		when(request.getParameter("apellidos")).thenReturn("Torti");
		when(request.getParameter("email")).thenReturn("pablotorti@gmail.com");
		when(request.getParameter("contrasenya")).thenReturn("Pablo1234");

		
		
		StringWriter stringWriter=new StringWriter();
		PrintWriter out=new PrintWriter(stringWriter);
		
		when(response.getWriter()).thenReturn(out);
		
		new ModificarUsuarioServlet().doPost(request,response);
		
		out.flush();
		
		String res=stringWriter.toString();
		System.out.println(res);
		 
		JSONObject objresponse=new JSONObject();
		
		if(objresponse.has("code") && objresponse.has("mensaje")&& objresponse.has("resultado"))
		{
			assertTrue("El codigo devuelto no es ERROR", objresponse.get("code").equals("ERROR"));
			assertTrue("El mensaje devuelto no es ok",objresponse.get("mensaje").equals("ERROR"));
			
			 
		}

		
	}
}
