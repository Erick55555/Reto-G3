package aplicacion;

import controlador.Controlador;
import modelo.Modelo;
import vista.Vista;

public class Aplicacion {
	public static void main(String[] args) {

		Vista menu = new Vista();
		try {
			Modelo gestion = new Modelo();
			Controlador controlador = new Controlador (menu, gestion);
			controlador.run();
		}
		catch (ClassNotFoundException e) {
			System.out.println("Ha saltado una excepci�n de tipo ClassNotFoundException " + e.getMessage());
		}
	
		
	}
	
}
