package es.loyola.inftv.app.manager;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import es.loyola.inftv.app.dao.Usuario;

public class UsuariosManager {
	
public static List<Usuario> getListadoUsuarios(){
		
		List<Usuario> res = new LinkedList<Usuario>();
		
		Usuario u1 = new Usuario("Pablo", 1);
		Usuario u2 = new Usuario("Lourdes", 2);
		Usuario u3 = new Usuario("Ana", 3);
		
		
		res.add(u1);
		res.add(u2);
		res.add(u3);

		
	 	return res;
		
	}
	


}
