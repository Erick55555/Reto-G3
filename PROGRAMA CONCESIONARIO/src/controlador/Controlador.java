package controlador;

import concesionario.Coche;
import concesionario.Vehiculo;

import java.sql.Connection;

import concesionario.Camion;
import modelo.Modelo;
import vista.Console;
import vista.Vista;

public class Controlador {
	
	private Vista menu;
	private Modelo gestion;
	
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
						gestion.insertarCoche(coche);
						System.out.println("Coche creado satisfactoriamente!, esta es su info:");
						menu.mostrarInfoVehiculo(coche);
					}
					else {
						Camion camion = menu.pedirDatosCamion();
						gestion.insertarCamion(camion);
						System.out.println("Camión creado satisfactoriamente!, esta es su info:");
						menu.mostrarInfoVehiculo(camion);
					}
					break;
					
				case 2: // falta terminar
					tipo = menu.tipoVehiculo();
					gestion.matriculasExistentes(tipo);
					
					System.out.println("Introduce el número de la matrícula del vehiculo");
					String matriculaVehiculo = Console.readString();
					
					
					break;
				case 3: // Falta terminar
					System.out.println("¿Que tipo de vehiculo quieres comprar?");
	   				 tipo = menu.tipoVehiculo();
	   				 if (tipo.equals("coche")) {
	   					 gestion.mostrarCoche();
	   				 }else if(tipo.equals("camion") ) {
	   					 
	   				 }

				case 4:
					gestion.mostrarStock();
					break;
				
				case 5:
					String[] fechas = menu.solicitarFechas();
					System.out.println("Estos son los vehiculos disponibles en el rango de fechas: (" + fechas[0] + " - " + fechas[1] + ")");
					gestion.ConsultaStockFechas(fechas);
					break;
			}
			
		} while (opcion != 7);
		
		System.out.println("Adiós!");
		
		
	}
	

}
