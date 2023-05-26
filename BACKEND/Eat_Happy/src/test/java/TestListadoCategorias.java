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

import es.loyola.inftv.app.manager.CategoriasManager;
import es.loyola.inftv.app.services.ListadoCategoriasServlet;

public class TestListadoCategorias {
	
	@Test
	public void testGetProductos() throws IOException, ServletException {
		
		HttpServletRequest request = mock(HttpServletRequest.class);
		HttpServletResponse response = mock(HttpServletResponse.class);
		
		
		StringWriter stringWriter = new StringWriter();
		PrintWriter out = new PrintWriter(stringWriter);
		when(response.getWriter()).thenReturn(out);
		
		new ListadoCategoriasServlet().doGet(request,response);
		
		out.flush();
		
		String res = stringWriter.toString();
		JSONObject objResponse = new JSONObject(res);
		
		if(objResponse.has("code") && objResponse.has("resultado") && objResponse.has("mensaje") ) {
			assertTrue("El codigo devuelto no es ok", objResponse.get("code").equals("OK"));
			assertTrue("El mensaje devuelto no es ok", objResponse.get("mensaje").equals("OK"));
			
			JSONArray arrayRes = objResponse.getJSONArray("resultado");
			assertTrue( "El array no tiene un elemento", arrayRes.length() == CategoriasManager.getListadoCategorias().size());
			
		}

	}
}
