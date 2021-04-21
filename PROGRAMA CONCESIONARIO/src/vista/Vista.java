package vista;

import concesionario.Camion;
import concesionario.Coche;
import concesionario.Vehiculo;

public class Vista {
	
	public void mostrarMenu () {
		System.out.println("MEN� DE OPCIONES\n");
		System.out.println("Elige una de estas opciones:");
		
		System.out.println("A�adir un veh�culo [1]");
		System.out.println("Modificar datos de un veh�culo [2]");
		System.out.println("Vender un veh�culo [3]");
		System.out.println("Comprobar stock [4]");
		System.out.println("Consultar ventas en un periodo de tiempo [5]");
		System.out.println("Exportar fichero XML [6]");
		System.out.println("Importar fichero XML [7]");
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
		System.out.println("Introduce la marca");
		String marca = Console.readString();
		System.out.println("Introduce el modelo");
		String modelo = Console.readString();
		System.out.println("Introduce el a�o de fabricaci�n [A�O/MES/D�A]");
		String a�oFab = Console.readString();
		System.out.println("Introduce el n�mero de puertas");
		int numPuertas = Console.readInt();
		System.out.println("Introduce la capacidad del maletero");
		int capacidadMaletero = Console.readInt();
		
		return new Coche (matricula, numBastidor, color, numAsientos, precio, marca, modelo, a�oFab, numPuertas, capacidadMaletero);
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
		System.out.println("Introduce la marca");
		String marca = Console.readString();
		System.out.println("Introduce el modelo");
		String modelo = Console.readString();
		System.out.println("Introduce el a�o de fabricaci�n [A�O/MES/D�A]");
		String a�oFab = Console.readString();
		System.out.println("Introduce el peso de la carga");
		float carga = Console.readFloat();
		System.out.println("Introduce el tipo de mercanc�a [G/A/P]");
		char tipoMercancia = Console.readChar();
		
		return new Camion (matricula, numBastidor, color, numAsientos, precio, marca, modelo, a�oFab, carga, tipoMercancia);
	}
	
	public void mostrarInfoVehiculo (Vehiculo vehiculo) {
		System.out.println(vehiculo.toString());
	}
	
	public String[] solicitarFechas () {
		String[] fechas = new String[2];
		
		System.out.println("Introduce la fecha m�s antigua");
		fechas[0] = Console.readString();
		
		System.out.println("Introduce la fecha m�s reciente");
		fechas[1] = Console.readString();

		return fechas;
	}
	
	public String pedirMatricula (String tipo) {
		System.out.println("Introduce la matricula del " + tipo.toLowerCase());
		String matricula = Console.readString();
		return matricula;
	}
	
	public String pedirRuta () {
		System.out.println("Introduce la ruta d�nde quieres que se guarde el archivo XML [c:/users/nombre_usuario/ruta]");
		String ruta = Console.readString();
		return ruta;
	}
	
	public String pedirCampoCoche () {
		System.out.println("Introduce el nombre del campo que quieres modificar [Matricula, Num_Bastidor, Color, Num_asientos, Precio, Num_Serie, Num_puertas, Capacidad_Maletero]");
		String campo = Console.readString();
		return campo;
	}
	
	public String pedirCampoCamion () {
		System.out.println("Introduce el nombre del campo que quieres modificar [Matricula, Num_Bastidor, Color, Num_asientos, Precio, Num_Serie, Carga, Tipo_mercancia]");
		String campo = Console.readString();
		return campo;
	}
	
	public String pedirNuevoValor (String campo) {
		System.out.println("Introduce el nuevo valor para el campo " + campo);
		String nuevoValor = Console.readString();
		return nuevoValor;
	}
	
	public String cambiarColor (String tipo) {
		System.out.println("Quieres pintar el " + tipo.toLowerCase() + "? [SI/NO]");
  		String respuesta =Console.readString();
  		return respuesta.toUpperCase();
	}
	
	public String pedirColor () {
		System.out.println("�Que color quieres ponerle?");
		String color = Console.readString();
  		return color;
	}
	
}
