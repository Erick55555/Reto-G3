package modelo;

import java.sql.*;
import java.util.ArrayList;

import concesionario.Camion;
import concesionario.Coche;

public class Modelo {

	private static GestionBD gestionBd = new GestionBD();

	private String user = "Erick", password = "P@ssw0rd", url = "jdbc:mysql://220-08-HZ307518:3306/reto_g3";
	private static Connection conexion;

	public Modelo() throws ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");

		try {
			conexion = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			System.out.println("Ha saltado una excepcion de tipo SQLException " + e.getMessage());
		}
	}

	public void insertarCoche(Coche coche) {
		gestionBd.insertarVehiculoBd(conexion, coche);
		gestionBd.insertarCocheBd(conexion, coche);
	}

	public void insertarCamion(Camion camion) {
		gestionBd.insertarVehiculoBd(conexion, camion);
		gestionBd.insertarCamionBd(conexion, camion);
	}

	public void ConsultaStockFechas(String[] fechas) {
		gestionBd.consultaFechas(conexion, fechas);
	}

	public void mostrarStock() {
		gestionBd.mostrarStock(conexion);
	}

	public void mostrarCoche() {
		gestionBd.consultaCoches(conexion);
	}

	public void mostrarCamiones() {
		gestionBd.consultaCamiones(conexion);
	}

	public void modificarCampo(String campo, String nuevoValor, String matricula) {
		gestionBd.modificarBd(conexion, campo, nuevoValor, matricula);
	}

	public boolean comprobarMatriculas(String probar) {
		return gestionBd.comprobar(conexion, probar);
	}

	public void eliminarDatos(String matricula, String respuesta, String color) {
		gestionBd.eliminarVehiculo(conexion, matricula, respuesta, color);
	}

	public static ResultSet consultarStockCoches() {
		return gestionBd.obtenerCoches(conexion);
	}

	public static ResultSet consultarStockCamiones() {
		return gestionBd.obtenerCamiones(conexion);
	}

	public void exportar(String ruta) {
		ExportarXML.main(null, ruta);
	}

	public boolean cerrarBd() {
		return gestionBd.desconectar(conexion);
	}

	public void importarXML(String ruta) {
		ImportarXML.leerCoches(ruta);
		ImportarXML.leerCamiones(ruta);
	}

	public static void insertarVehiculoXML(ArrayList<String> valores) {
		gestionBd.insertarVehiculoXML(conexion, valores);
	}

	public static void insertarCocheXML(ArrayList<String> valores) {
		gestionBd.insertarCocheXML(conexion, valores);
	}

	public static void insertarCamionXML(ArrayList<String> valores) {
		gestionBd.insertarCamionXML(conexion, valores);
	}

}
