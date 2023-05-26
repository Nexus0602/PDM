
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.junit.Test;

import es.loyola.inftv.app.services.ConsultarMarcaServlet;


public class TestConsultarMarca {
	
	@Test
	public void testConsultarMarca() throws IOException,ServletException{
		HttpServletRequest request=mock(HttpServletRequest.class);   
		HttpServletResponse response=mock(HttpServletResponse.class);
		when(request.getParameter("nombre")).thenReturn("ASTURIANA");

		
		StringWriter stringWriter=new StringWriter();
		PrintWriter out=new PrintWriter(stringWriter);
		
		when(response.getWriter()).thenReturn(out);
		
		new ConsultarMarcaServlet().doGet(request,response);
		
		out.flush();
		
		String res=stringWriter.toString();
		System.out.println(res);
		
		JSONObject objresponse=new JSONObject();
		
		if(objresponse.has("code") && objresponse.has("mensaje")&& objresponse.has("resultado"))
		{
			assertTrue("El codigo devuelto no es ERROR", objresponse.get("code").equals("ok"));
			assertTrue("El mensaje devuelto no es ok",objresponse.get("mensaje").equals("ok"));
		}

		
	}
	
	@Test
	public void test2ConsultarMarca() throws IOException,ServletException{
		HttpServletRequest request=mock(HttpServletRequest.class);   
		HttpServletResponse response=mock(HttpServletResponse.class);
		when(request.getParameter("nombre")).thenReturn("PULEVA");

		
		StringWriter stringWriter=new StringWriter();
		PrintWriter out=new PrintWriter(stringWriter);
		
		when(response.getWriter()).thenReturn(out);
		
		new ConsultarMarcaServlet().doGet(request,response);
		
		out.flush();
		
		String res=stringWriter.toString();
		System.out.println(res);
		
		JSONObject objresponse=new JSONObject();
		
		if(objresponse.has("code") && objresponse.has("mensaje")&& objresponse.has("resultado"))
		{
			assertTrue("El codigo devuelto no es ERROR", objresponse.get("code").equals("ERROR"));
			assertTrue("El mensaje devuelto no es ok",objresponse.get("mensaje").equals("Marca no encontrada"));
		}

		
	}
	
	
}
