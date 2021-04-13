package vista;

import concesionario.Camion;
import concesionario.Coche;
import concesionario.Vehiculo;

public class Vista {
	
	public void mostrarMenu () {
		System.out.println("MEN� DE OPCIONES\n");
		System.out.println("Elige una de estas opciones:");
		
		System.out.println("Crear un veh�culo [1]");
		System.out.println("Modificar datos de un veh�culo [2]");
		System.out.println("Vender un veh�culo [3]");
		System.out.println("Comprar un veh�culo [4]");
		System.out.println("Comprobar stock [5]");
		System.out.println("Consultar ventas en un periodo de tiempo [5]");
		System.out.println("Ficheros XML [7]");
		System.out.println("Salir [8]");
	}
	
	public int recogerOpcion () {
		int opcion = Console.readInt();
		
		boolean opcionCorrecta = false;
		while (!opcionCorrecta) {
			if (opcion < 1 || opcion > 8) {
				System.out.println("Opci�n inv�lida, vuelve a introducir una opci�n");
				opcion = Console.readInt();
			}
			else {
				opcionCorrecta = true;
			}
		}
		return opcion;
	}
	
	public String tipoVehiculo () {
		String tipo = "";
		boolean respuestaCorrecta = false;
		
		while (!respuestaCorrecta) {
			System.out.println("�Que tipo de vehiculo? [COCHE/CAMION]");
			tipo = Console.readString();
			
			if (tipo.toUpperCase().equals("COCHE") || tipo.toUpperCase().equals("CAMION")) {
				respuestaCorrecta = true;
			}
			else {
				System.out.println(tipo + " no es una respuesta v�lida");
			}
		}
	
		return tipo.toUpperCase();
	}
	
	public Coche pedirDatosCoche () {
		System.out.println("Introduce la matr�cula");
		String matricula = Console.readString();
		System.out.println("Introduce el n�mero de bastidor");
		String numBastidor = Console.readString();
		System.out.println("Introduce el color");
		String color = Console.readString();
		System.out.println("Introduce el n�mero de asientos");
		int numAsientos = Console.readInt();
		System.out.println("Introduce el precio");
		float precio = Console.readFloat();
		System.out.println("Introduce el n�mero de serie");
		String numSerie = Console.readString();
		System.out.println("Introduce el n�mero de puertas");
		int numPuertas = Console.readInt();
		System.out.println("Introduce la capacidad del maletero");
		int capacidadMaletero = Console.readInt();
		
		return new Coche (matricula, numBastidor, color, numAsientos, precio, numSerie, numPuertas, capacidadMaletero);
	}
	
	public Camion pedirDatosCamion () {
		System.out.println("Introduce la matr�cula");
		String matricula = Console.readString();
		System.out.println("Introduce el n�mero de bastidor");
		String numBastidor = Console.readString();
		System.out.println("Introduce el color");
		String color = Console.readString();
		System.out.println("Introduce el n�mero de asientos");
		int numAsientos = Console.readInt();
		System.out.println("Introduce el precio");
		float precio = Console.readFloat();
		System.out.println("Introduce el n�mero de serie");
		String numSerie = Console.readString();
		System.out.println("Introduce el peso de la carga");
		float carga = Console.readFloat();
		System.out.println("Introduce el tipo de mercanc�a [G/A/P]");
		char tipoMercancia = Console.readChar();
		
		return new Camion (matricula, numBastidor, color, numAsientos, precio, numSerie, carga, tipoMercancia);
	}
	
	public void mostrarInfoVehiculo (Vehiculo vehiculo) {
		System.out.println(vehiculo.toString());
	}
	
}
