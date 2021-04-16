package modelo;

import java.sql.*;

import concesionario.Camion;
import concesionario.Coche;

public class Modelo {
	
	private GestionBD gestionBd = new GestionBD();
	private GestionXML gestionXml = new GestionXML();
	
	private String user = "Erick", password = "P@ssw0rd", url = "jdbc:mysql://220-08-HZ307518:3306/reto_g3";
	Connection conexion;
	
	public Modelo () throws ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		try {
		conexion = DriverManager.getConnection(url, user, password);
		System.out.println("Conexión a base de datos realizada con éxito!");
		}
		catch (SQLException e) {
			System.out.println("Ha saltado una excepción de tipo SQLException " + e.getMessage());
		}
	}
	
	public void insertarCoche (Coche coche) {
		gestionBd.insertarVehiculoBd(conexion, coche);
		gestionBd.insertarCocheBd(conexion, coche);
	}
	
	public void insertarCamion (Camion camion) {
		gestionBd.insertarVehiculoBd(conexion, camion);
		gestionBd.insertarCamionBd(conexion, camion);
	}
	
	
	
	
}

