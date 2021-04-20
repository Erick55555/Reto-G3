package modelo;

import java.sql.*;
import java.util.ArrayList;

public class Modelo {

	private static GestionBD gestionBd = new GestionBD();


	private String user = "Erick", password = "P@ssw0rd", url = "jdbc:mysql://220-08-HZ307518:3306/reto_g3";
	private static Connection conexion;

	public Modelo() throws ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");

		try {
			conexion = DriverManager.getConnection(url, user, password);
			System.out.println("Conexi�n a base de datos realizada con �xito!");
		} catch (SQLException e) {
			System.out.println("Ha saltado una excepci�n de tipo SQLException " + e.getMessage());
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

	public void eliminarDatos(String misma) {
		gestionBd.eliminarCoche(conexion, misma);
	}

	public static ResultSet consultarStockCoches() {
		return gestionBd.obtenerCoches(conexion);
	}

	public static ResultSet consultarStockCamiones() {
		return gestionBd.obtenerCamiones(conexion);
	}
	
	public void exportar (String ruta) {
		ExportarXML.main(null, ruta);;
	}

}
