package controlador;

import modelo.Camion;
import modelo.Coche;
import modelo.Modelo;
import vista.Console;
import vista.Vista;

public class Controlador {

	private Vista menu;
	private Modelo gestion;

	public Controlador(Vista menu, Modelo gestion) {
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
					
				case 2:
					tipo = menu.tipoVehiculo();
					
					if (tipo.equals("COCHE")) {
						gestion.mostrarCoche();
					}
					else {
						gestion.mostrarCamiones();
					}
			
					String matricula = menu.pedirMatricula(tipo);
					
					if (gestion.comprobarMatriculas(matricula)) {
						if (tipo.equals("COCHE")) {
							String campo = menu.pedirCampoCoche();
							String nuevoValor = menu.pedirNuevoValor(campo);
							gestion.modificarCampo(campo, nuevoValor, matricula);
							System.out.println("El campo " + campo + " del" + tipo + " con matrícula '" + matricula +  "' ha sido actualizado correctamente");
						}
						else {
							String campo = menu.pedirCampoCamion();
							String nuevoValor = menu.pedirNuevoValor(campo);
							gestion.modificarCampo(campo, nuevoValor, matricula);
							System.out.println("El campo " + campo + " del" + tipo + " con matrícula '" + matricula +  "' ha sido actualizado correctamente");
						}
						
						
					}
					else {
						System.out.println("El " + tipo + " con matrícula '" + matricula + "' no existe en la base de datos");
					}
					break;
					
				case 3:
		   			 tipo = menu.tipoVehiculo();
		   			 if (tipo.equals("COCHE")) {
		   				 String matriculaCoche = menu.pedirMatricula(tipo);
		   				 boolean comprobar = gestion.comprobarMatriculas(matriculaCoche);
		   				 if (comprobar == true) {
		   					 gestion.eliminarDatos(matriculaCoche);
		   				 } else {
		   					 System.out.println("La matricula que has metido no existe");
		   				 }

		   				 break;
		   			 } else if (tipo.equals("CAMION")) {
		   				 gestion.mostrarCamiones();
		   				 String matriculaCamion = menu.pedirMatricula(tipo);
		   				 boolean comprobar = gestion.comprobarMatriculas(matriculaCamion);
		   				 if (comprobar == true) {
		   					 gestion.eliminarDatos(matriculaCamion);
		   				 } else {
		   					 System.out.println("La matricula que has metido no existe");

		   					 break;

		   				 }
		   			 }
		   			 break;

				case 4:
					gestion.mostrarStock();
					break;
				
				case 5:
					String[] fechas = menu.solicitarFechas();
					System.out.println("Estos son los vehiculos disponibles en el rango de fechas: (" + fechas[0] + " - " + fechas[1] + ")");
					gestion.ConsultaStockFechas(fechas);
					break;
					
				case 6:
					String ruta = menu.pedirRuta();
					gestion.exportar(ruta);
					break;
			}
			
		} while (opcion != 8);
		
		System.out.println("Adiós!");
		
		
	}

}
