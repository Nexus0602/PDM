
import static org.junit.Assert.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

import org.junit.Before;
import org.junit.Test;

import es.loyola.inftv.app.dao.Usuario;
import es.loyola.inftv.app.services.ModificarCuentaServlet;

public class TestModificarCuenta  {
	private Usuario u1;
	
	
	@Test
	public void testDoGetHttpServletRequestHttpServletResponse() throws IOException, ServletException{
		ModificarCuentaServlet servlet=new ModificarCuentaServlet();
		HttpServletRequest request=new HttpServletRequestWrapper(null) {
            @Override
            public String getParameter(String name) {
                if (name.equals("id")) {
                    return "1";
                }
                return null;
            }
            
            
        };
        
		
		
		
		HttpServletResponse respond= new HttpServletResponseWrapper(null) {
            private StringWriter stringWriter = new StringWriter();
            private PrintWriter writer = new PrintWriter(stringWriter);
            
            @Override
            public PrintWriter getWriter() throws IOException {
                return writer;
            }
            
            @Override
            public String getContentType() {
                return "text/plain";
            }
            
            @Override
            public void setContentType(String type) {
            }
            
            @Override
            public String toString() {
                return stringWriter.toString();
            }
        };
        servlet.doGet(request, respond);
        String output = respond.toString();
        assertEquals("Nombre actual: \n Nombre nuevo: null", output);
		
		
	}
	
}
