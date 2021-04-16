package controlador;

import concesionario.Coche;
import concesionario.Vehiculo;
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
						Vehiculo.agregarVehiculo(coche);
						System.out.println("Coche creado satisfactoriamente!, esta es su info:");
						menu.mostrarInfoVehiculo(coche);
					}
					else {
						Camion camion = menu.pedirDatosCamion();
						Vehiculo.agregarVehiculo(camion);
						System.out.println("Camión creado satisfactoriamente!, esta es su info:");
						menu.mostrarInfoVehiculo(camion);
					}
					break;
					
				case 2:
					tipo = menu.tipoVehiculo();
					System.out.println("Introduce el número de la matrícula del vehiculo");
					String matriculaVehiculo = Console.readString();
					
					if (Vehiculo.getVehiculos().containsKey(matriculaVehiculo)) {
						
						if (tipo.equals("COCHE")) {
							System.out.println("Valores del vehiculo:");
							Vehiculo.getVehiculos().get(matriculaVehiculo).toString();
							String[] atributos = {"matricula", "numBastidor", "color", "numAsientos", "precio", "numSerie", "numPuertas", "capacidadMaletero"};
							boolean respuestaCorrecta = false;
							String respuesta = "";
			
							while (!respuestaCorrecta) {
								System.out.println("¿Qué atributo quieres modificar? [matricula, numBastidor, color, numAsientos, precio, numSerie, numPuertas, capacidadMaletero]");
								respuesta = Console.readString();
								
								for (int i = 0; i < atributos.length; i++) {
									if (atributos[i].equals(respuesta.toLowerCase())) {
										respuestaCorrecta = true;
									}
								}
								
								if (!respuestaCorrecta) {
									System.out.println("Ese atributo no es válido, vuelve a intentarlo");
								}
							}
							
							System.out.println("Introduce el nuevo valor");
							String nuevoValor = Console.readString();
							
							if (respuesta.equals(atributos[0])) {
								Vehiculo.getVehiculos().get(matriculaVehiculo).setMatricula(nuevoValor);
							}
							else if (respuesta.equals(atributos[1])) {
								Vehiculo.getVehiculos().get(matriculaVehiculo).setNumBastidor(nuevoValor);
							}
							else if (respuesta.equals(atributos[2])) {
								Vehiculo.getVehiculos().get(matriculaVehiculo).setColor(nuevoValor);
							}
							else if (respuesta.equals(atributos[3])) {
								int nuevoValorInt = Integer.parseInt(nuevoValor);
								Vehiculo.getVehiculos().get(matriculaVehiculo).setNumAsientos(nuevoValorInt);
							}
							else if (respuesta.equals(atributos[4])) {
								float nuevoValorFloat = Float.parseFloat(nuevoValor);
								Vehiculo.getVehiculos().get(matriculaVehiculo).setPrecio(nuevoValorFloat);
							}
							else if (respuesta.equals(atributos[5])) {
								Vehiculo.getVehiculos().get(matriculaVehiculo).setNumSerie(nuevoValor);
							}
							else if (respuesta.equals(atributos[6])) {
								int nuevoValorInt = Integer.parseInt(nuevoValor);
								((Coche) Vehiculo.getVehiculos().get(matriculaVehiculo)).setNumPuertas(nuevoValorInt);
							}else {
								int nuevoValorInt = Integer.parseInt(nuevoValor);
								((Coche) Vehiculo.getVehiculos().get(matriculaVehiculo)).setCapacidadMaletero(nuevoValorInt);
							}
							
							System.out.println("Valor actualizado!");
							Vehiculo.getVehiculos().get(matriculaVehiculo).toString();
							
						}
						else {
							System.out.println("Valores del vehiculo:");
							Vehiculo.getVehiculos().get(matriculaVehiculo).toString();
							String[] atributos = {"matricula", "numBastidor", "color", "numAsientos", "precio", "numSerie", "carga", "tipoMercancia"};
							boolean respuestaCorrecta = false;
							String respuesta = "";
			
							while (!respuestaCorrecta) {
								System.out.println("¿Qué atributo quieres modificar? [matricula, numBastidor, color, numAsientos, precio, numSerie, carga, tipoMercancia]");
								respuesta = Console.readString();
								
								for (int i = 0; i < atributos.length; i++) {
									if (atributos[i].toLowerCase().equals(respuesta)) {
										respuestaCorrecta = true;
									}
								}
								
								if (!respuestaCorrecta) {
									System.out.println("Ese atributo no es válido, vuelve a intentarlo");
								}
								
							}
							
							System.out.println("Introduce el nuevo valor");
							String nuevoValor = Console.readString();
							
							if (respuesta.equals(atributos[0])) {
								Vehiculo.getVehiculos().get(matriculaVehiculo).setMatricula(nuevoValor);
							}
							else if (respuesta.equals(atributos[1])) {
								Vehiculo.getVehiculos().get(matriculaVehiculo).setNumBastidor(nuevoValor);
							}
							else if (respuesta.equals(atributos[2])) {
								Vehiculo.getVehiculos().get(matriculaVehiculo).setColor(nuevoValor);
							}
							else if (respuesta.equals(atributos[3])) {
								int nuevoValorInt = Integer.parseInt(nuevoValor);
								Vehiculo.getVehiculos().get(matriculaVehiculo).setNumAsientos(nuevoValorInt);
							}
							else if (respuesta.equals(atributos[4])) {
								float nuevoValorFloat = Float.parseFloat(nuevoValor);
								Vehiculo.getVehiculos().get(matriculaVehiculo).setPrecio(nuevoValorFloat);
							}
							else if (respuesta.equals(atributos[5])) {
								Vehiculo.getVehiculos().get(matriculaVehiculo).setNumSerie(nuevoValor);
							}
							else if (respuesta.equals(atributos[6])) {
								int nuevoValorInt = Integer.parseInt(nuevoValor);
								((Camion) Vehiculo.getVehiculos().get(matriculaVehiculo)).setCarga(nuevoValorInt);
							}else {
								char nuevoValorChar = nuevoValor.charAt(0);
								((Camion) Vehiculo.getVehiculos().get(matriculaVehiculo)).setTipoMercancia(nuevoValorChar);
							}
							
							System.out.println("Valor actualizado!");
							Vehiculo.getVehiculos().get(matriculaVehiculo).toString();
						}
					}
					else {
						System.out.println("No has creado ningun vehículo con esa matrícula");
					}
					break;
				
				case 3:
					tipo = menu.tipoVehiculo();
					System.out.println("Introduce el número de la matrícula del vehiculo");
					String matricula = Console.readString();
					
					if (Vehiculo.getVehiculos().containsKey(matricula)) {
						System.out.println("Esta es su info:");
						menu.mostrarInfoVehiculo(Vehiculo.getVehiculos().get(matricula));
						if (tipo.equals("COCHE")) {
							gestion.insertarCoche((Coche) Vehiculo.getVehiculos().get(matricula));
						}
						else {
							gestion.insertarCamion((Camion) Vehiculo.getVehiculos().get(matricula));
						}
					}
					
			}
			
		} while (opcion != 8);
		
		System.out.println("Adiós!");
		
		
	}
	

}
