package es.loyola.inftv.app.manager;

import java.util.List;

import es.loyola.inftv.app.dao.Alergeno.tipoAlergeno;

public class AlergenosManager {
	
	public static tipoAlergeno getAlergenoById(int id) {
		
		tipoAlergeno a = null ;
		
		for (tipoAlergeno alergeno : tipoAlergeno.values())
		{
			if(alergeno.getId() == id)
			{
				a = alergeno;
			}
			
		}
		return a;
				
}

	

}
