package es.loyola.inftv.app.manager;

import java.util.LinkedList;
import java.util.List;

import es.loyola.inftv.app.dao.Marca;
import es.loyola.inftv.app.dao.MarcaImpl;
import es.loyola.inftv.app.dao.Supermercado;


public class MarcaManager {

	
		
		public static List<Marca> getListadoMarcas(){
			
			Marca pascual = new MarcaImpl("PASCUAL","calle",123,"CIF");
			Marca vivesoy = new MarcaImpl("VIVESOY","calle",764,"CIF");
			Marca hacendado = new MarcaImpl("HACENDADO","calle",524,"CIF");
			Marca gallo = new MarcaImpl("GALLO","calle",326,"CIF");
			Marca asturiana = new MarcaImpl("ASTURIANA","calle",184,"CIF");
			Marca nestle = new MarcaImpl("NESTLE","calle",584,"CIF");
			
			List <Marca> lmarcas= new LinkedList <Marca>();
			
			lmarcas.add(pascual);
			lmarcas.add(vivesoy);
			lmarcas.add(hacendado);
			lmarcas.add(gallo);
			lmarcas.add(asturiana);
			lmarcas.add(nestle);
			
			
			return lmarcas;
			
			
		}
		
		public static Marca getMarcaById(String cif) {
			
			List <Marca> lmarcas= getListadoMarcas();
			Marca a = null;
			for(Marca m: lmarcas)
			{
				if(m.getCif()==cif)
				{
					a =  m;
				}
				
			}
			return a;
			
			
			
		
	}

}
