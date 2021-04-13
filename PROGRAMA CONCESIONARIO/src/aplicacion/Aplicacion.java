package aplicacion;

import concesionario.Camion;
import concesionario.Coche;
import controlador.Controlador;
import modelo.Modelo;
import vista.Vista;

public class Aplicacion {
	public static void main(String[] args) {

		Vista menu = new Vista();
		Modelo gestion = new Modelo();
		Controlador controlador = new Controlador (menu, gestion);
		controlador.run();
		
	}
	
}
