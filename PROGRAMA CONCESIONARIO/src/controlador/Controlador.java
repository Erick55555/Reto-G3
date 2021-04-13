package controlador;

import concesionario.Coche;
import concesionario.Camion;
import modelo.Modelo;
import vista.Console;
import vista.Vista;

public class Controlador {
	
	private Vista menu;
	private Modelo gestion;
	private static int VEHICULO_NUEVO, MODIFICAR_DATOS, VENDER_VEHICULO, COMPRAR_VEHICULO, COMPROBAR_STOCK, CONSULTAR_VENTAS, FICHEROS_XML, SALIR; 
	
	public Controlador (Vista menu, Modelo gestion) {
		this.menu = menu;
		this.gestion = gestion;
	}
	
	public void run () {
		int opcion = 0;
			
		do {
			menu.mostrarMenu();
			opcion = menu.recogerOpcion();
			String tipo;
			
			switch (opcion) {
			
				case 1:
					tipo = menu.tipoVehiculo();
					if (tipo.equals("COCHE")) {
						Coche coche = menu.pedirDatosCoche();
						menu.mostrarInfoVehiculo(coche);
					}
					else {
						Camion camion = menu.pedirDatosCamion();
						menu.mostrarInfoVehiculo(camion);
					}
					break;
					
				case 2:
					tipo = menu.tipoVehiculo();
					if (tipo.equals("COCHE")) {
						boolean respuestaCorrecta = false;
						while (!respuestaCorrecta) {
							System.out.println("¿Qué atributo quieres modificar? [matricula, numBastidor, color, numAsientos, precio, numSerie, numPuertas, capacidadMaletero]");
							String respuesta = Console.readString();
							
							if (respuesta.toLowerCase().equals("matricula")) {
								System.out.println("Introduce el nuevo valor");
								
							}
						}
						
					}
					else {
						System.out.println("¿Qué atributo quieres modificar? []matricula, numBastidor, color, numAsientos, precio, numSerie, carga, tipoMercancia");
					}
					
					
				
			}
			
		} while (opcion != SALIR);
		
		
	}
	

}
