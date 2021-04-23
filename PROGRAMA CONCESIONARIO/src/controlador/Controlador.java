package controlador;

import concesionario.Camion;
import concesionario.Coche;
import modelo.Modelo;
import vista.Vista;

public class Controlador {

	private Vista menu;
	private Modelo gestion;

	public Controlador(Vista menu, Modelo gestion) {
		this.menu = menu;
		this.gestion = gestion;
	}

	public void run() {
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
					menu.escribirInfo("Coche creado satisfactoriamente!, esta es su info:");
					menu.mostrarInfoVehiculo(coche);
				} else {
					Camion camion = menu.pedirDatosCamion();
					gestion.insertarCamion(camion);
					menu.escribirInfo("Camion creado satisfactoriamente!, esta es su info:");
					menu.mostrarInfoVehiculo(camion);
				}
				break;

			case 2:
				tipo = menu.tipoVehiculo();

				if (tipo.equals("COCHE")) {
					gestion.mostrarCoche();
				} else {
					gestion.mostrarCamiones();
				}

				String matricula = menu.pedirMatricula(tipo);

				if (gestion.comprobarMatriculas(matricula)) {
					if (tipo.equals("COCHE")) {
						String campo = menu.pedirCampoCoche();
						String nuevoValor = menu.pedirNuevoValor(campo);
						gestion.modificarCampo(campo, nuevoValor, matricula);
						menu.escribirInfo("El campo " + campo + " del" + tipo + " con matricula '" + matricula
								+ "' ha sido actualizado correctamente");
					} else {
						String campo = menu.pedirCampoCamion();
						String nuevoValor = menu.pedirNuevoValor(campo);
						gestion.modificarCampo(campo, nuevoValor, matricula);
						menu.escribirInfo("El campo " + campo + " del" + tipo + " con matricula '" + matricula
								+ "' ha sido actualizado correctamente");
					}

				} else {
					menu.escribirInfo(
							"El " + tipo + " con matricula '" + matricula + "' no existe en la base de datos");
				}
				break;

			case 3:
				tipo = menu.tipoVehiculo();
				if (tipo.equals("COCHE")) {

					gestion.mostrarCoche();
					String matriculaCoche = menu.pedirMatricula(tipo);
					boolean comprobar = gestion.comprobarMatriculas(matriculaCoche);
					if (comprobar == true) {
						String respuesta = menu.cambiarColor(tipo);
						String color = "";
						if (respuesta.equals("SI")) {
							color = menu.pedirColor();
						}
						gestion.eliminarDatos(matriculaCoche, respuesta, color);
					} else {
						menu.escribirInfo("La matricula que has metido no existe");
					}

				} else if (tipo.equals("CAMION")) {
					gestion.mostrarCamiones();
					String matriculaCamion = menu.pedirMatricula(tipo);
					boolean comprobar = gestion.comprobarMatriculas(matriculaCamion);
					if (comprobar == true) {
						String respuesta = menu.cambiarColor(tipo);
						String color = "";
						if (respuesta.equals("SI")) {
							color = menu.pedirColor();
						}
						gestion.eliminarDatos(matriculaCamion, respuesta, color);
					} else {
						menu.escribirInfo("La matricula que has metido no existe");
					}
				}
				break;

			case 4:
				gestion.mostrarStock();
				break;

			case 5:
				String[] fechas = menu.solicitarFechas();
				menu.escribirInfo("Estos son los vehiculos disponibles en el rango de fechas: (" + fechas[0] + " - "
						+ fechas[1] + ")");
				gestion.ConsultaStockFechas(fechas);
				break;

			case 6:
				String rutaExportar = menu.pedirRuta();
				gestion.exportar(rutaExportar);
				break;

			case 7:
				String rutaImportar = menu.pedirRutaImportar();
				gestion.importarXML(rutaImportar);
				break;
			}

		} while (opcion != 8);

		if (gestion.cerrarBd()) {
			menu.escribirInfo("Conexion cerrada");
		} else {
			menu.escribirInfo("Error al cerrar la conexion");

		}

		menu.escribirInfo("Adios!");

	}

}
