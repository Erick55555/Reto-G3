package modelo;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import concesionario.Camion;
import concesionario.Coche;
import concesionario.Vehiculo;

public class GestionBD {
	
	public void insertarVehiculoBd (Connection conexion, Vehiculo vehiculo) {
		try {
			String codigo1 = "insert into categorias values ('" + vehiculo.getMarca() + "', '" + vehiculo.getModelo() + "', '" + vehiculo.getAñoFab() + "')";
			String codigo2 = "insert into num_series values ('" + vehiculo.getNumSerie() + "', '" + vehiculo.getMarca() + "', '" + vehiculo.getModelo() + "', '" + vehiculo.getAñoFab() + "')";
			String codigo3 = "insert into vehiculos values ('" + vehiculo.getMatricula() + "', '" + vehiculo.getNumBastidor() + "', '" + vehiculo.getColor() + "', " + vehiculo.getNumAsientos() + ", " + vehiculo.getPrecio() + ", '" + vehiculo.getNumSerie() + "')";
			Statement st = conexion.createStatement();
			st.executeUpdate(codigo1);
			st.executeUpdate(codigo2);
			st.executeUpdate(codigo3);
			System.out.println("Se ha añadido un vehiculo correctamente!");
		}
		catch (SQLException e) {
			System.out.println("Ha saltado una excepción de tipo SQLException " + e.getMessage() + " insertar en vehiculos");
		}	
		
	}
	
	public void insertarCocheBd (Connection conexion, Coche coche) {
		try {
			String codigo = "insert into coches values ('" + coche.getMatricula() + "', " + coche.getNumAsientos() + ", " + coche.getCapacidadMaletero() + ")";
			Statement st = conexion.createStatement();
			st.executeUpdate(codigo);
			System.out.println("Se ha añadido un coche correctamente!");
		}
		catch (SQLException e) {
			System.out.println("Ha saltado una excepción de tipo SQLException " + e.getMessage()  + " insertar en coches");
		}
	}
	
	public void insertarCamionBd (Connection conexion, Camion camion) {
		try {
			String codigo = "insert into camiones values ('" + camion.getMatricula() + "', " + camion.getCarga() + ", '" + camion.getTipoMercancia() + "')";
			Statement st = conexion.createStatement();
			st.executeUpdate(codigo);
			System.out.println("Se ha añadido un camión correctamente!");
		}
		catch (SQLException e) {
			System.out.println("Ha saltado una excepción de tipo SQLException " + e.getMessage() + " insertar en camiones");
		}
	}
	
}
