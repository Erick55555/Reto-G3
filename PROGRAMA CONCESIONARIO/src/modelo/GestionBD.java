package modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import concesionario.Camion;
import concesionario.Coche;
import concesionario.Vehiculo;

public class GestionBD {

	public void insertarVehiculoBd(Connection conexion, Vehiculo vehiculo) {
		try {
			String codigo1 = "insert into categorias values ('" + vehiculo.getMarca() + "', '" + vehiculo.getModelo()
					+ "', '" + vehiculo.getAñoFab() + "')";
			String codigo2 = "insert into num_series values ('" + vehiculo.getNumSerie() + "', '" + vehiculo.getMarca()
					+ "', '" + vehiculo.getModelo() + "', '" + vehiculo.getAñoFab() + "')";
			String codigo3 = "insert into vehiculos values ('" + vehiculo.getMatricula() + "', '"
					+ vehiculo.getNumBastidor() + "', '" + vehiculo.getColor() + "', " + vehiculo.getNumAsientos()
					+ ", " + vehiculo.getPrecio() + ", '" + vehiculo.getNumSerie() + "')";
			Statement st = conexion.createStatement();
			st.executeUpdate(codigo1);
			st.executeUpdate(codigo2);
			st.executeUpdate(codigo3);
			System.out.println("Se ha añadido un vehiculo correctamente!");
		} catch (SQLException e) {
			System.out.println(
					"Ha saltado una excepción de tipo SQLException " + e.getMessage() + " insertar en vehiculos");
		}

	}

	public void insertarCocheBd(Connection conexion, Coche coche) {
		try {
			String codigo = "insert into coches values ('" + coche.getMatricula() + "', " + coche.getNumAsientos()
					+ ", " + coche.getCapacidadMaletero() + ")";
			Statement st = conexion.createStatement();
			st.executeUpdate(codigo);
			System.out.println("Se ha añadido un coche correctamente!");
		} catch (SQLException e) {
			System.out
					.println("Ha saltado una excepción de tipo SQLException " + e.getMessage() + " insertar en coches");
		}
	}

	public void insertarCamionBd(Connection conexion, Camion camion) {
		try {
			String codigo = "insert into camiones values ('" + camion.getMatricula() + "', " + camion.getCarga() + ", '"
					+ camion.getTipoMercancia() + "')";
			Statement st = conexion.createStatement();
			st.executeUpdate(codigo);
			System.out.println("Se ha añadido un camión correctamente!");
		} catch (SQLException e) {
			System.out.println(
					"Ha saltado una excepción de tipo SQLException " + e.getMessage() + " insertar en camiones");
		}
	}

	public void consultaFechas(Connection conexion, String[] fechas) {
		try {

			Statement st = conexion.createStatement();
			ResultSet rs = st.executeQuery(
			"select * from historial where Fecha > '" + fechas[0] + "' and Fecha < '" + fechas[1] + "' and accion = 'VENDIDO'");
			
			System.out.println("|"
					+ "----------------------------------------------------------------------------------------------------------------|");
			System.out.println("|" + "Matricula \t | \t" + "Color \t | \t" + "Serie\t | \t"
					+ "Fecha\t \t | \t" + "Acción\t |\t" + "Operación" + " \t |");
			System.out.println("|"
					+ "----------------------------------------------------------------------------------------------------------------|");
			
			while (rs.next()) {

				System.out.println("|" + rs.getString(1) + "\t  \t | \t" + rs.getString(2) + "\t | \t" + rs.getString(3) + "\t | \t" + rs.getString(4) + "\t| \t" + rs.getString(5) + "\t | \t" + rs.getString(6) + "\t | \t");

			}
			
			
			
		} catch (SQLException e) {
			System.out.println("Ha saltado una excepción de tipo SQLException " + e.getMessage());
		}
	}

	public void consultarMatriculas(Connection conexion, String tipo) {
		ArrayList<String> matriculas = new ArrayList<String>();
		if (tipo.equals("COCHES")) {
			try {

				Statement st = conexion.createStatement();
				ResultSet rs = st.executeQuery(
						"select v.* from vehiculos v, coches where v.Matricula = c.Matricula where v.Matricula = c.Matricula;");
				while (rs.next()) {
					matriculas.add(rs.getString(1));
				}
			} catch (SQLException e) {
				System.out.println("Ha saltado una excepción de tipo SQLException " + e.getMessage());
			}
		} else {

		}
	}

	public void mostrarStock(Connection conexion) {
		try {

			Statement st = conexion.createStatement();
			ResultSet rs = st.executeQuery("select ve.* from vehiculos ve");
			System.out.println("|"
					+ "-------------------------------------------------------------------------------------------------------------------------------|");
			System.out.println("|" + "Matricula \t | \t" + "Num_Bastidor \t | \t" + "Color\t | \t"
					+ "Num_Asientos\t | \t" + "Precio\t |\t" + "Num_serie" + "\t \t|");
			System.out.println("|"
					+ "-------------------------------------------------------------------------------------------------------------------------------|");
			while (rs.next()) {

				System.out.println("|" + rs.getString(1) + "\t  \t | \t" + rs.getString(2) + "\t  \t | \t"
						+ rs.getString(3) + "\t | \t" + rs.getInt(4) + "\t  \t | \t" + rs.getInt(5) + "\t | \t"
						+ rs.getString(6) + "\t|");

			}
			System.out.println("|"
					+ "-------------------------------------------------------------------------------------------------------------------------------|");

		} catch (SQLException e) {
			System.out.println("Ha saltado una excepción de tipo SQLException " + e.getMessage());
		}

	}

	public void consultaCoches(Connection conexion) {
		try {

			Statement st = conexion.createStatement();
			ResultSet rs = st
					.executeQuery("select ve.* from vehiculos ve, coches co where ve.matricula = co.matricula");
			System.out.println("|"
					+ "-------------------------------------------------------------------------------------------------------------------------------|");
			System.out.println("|" + "Matricula \t | \t" + "Num_Bastidor \t | \t" + "Color\t | \t"
					+ "Num_Asientos\t | \t" + "Precio\t |\t" + "Num_serie" + "\t \t|");
			System.out.println("|"
					+ "-------------------------------------------------------------------------------------------------------------------------------|");
			while (rs.next()) {

				System.out.println("|" + rs.getString(1) + "\t  \t | \t" + rs.getString(2) + "\t  \t | \t"
						+ rs.getString(3) + "\t | \t" + rs.getInt(4) + "\t  \t | \t" + rs.getInt(5) + "\t | \t"
						+ rs.getString(6) + "\t|");

			}
			System.out.println("|"
					+ "-------------------------------------------------------------------------------------------------------------------------------|");

		} catch (SQLException e) {
			System.out.println("Ha saltado una excepción de tipo SQLException " + e.getMessage());
		}
	}

	public void consultaCamiones(Connection conexion) {
		try {

			Statement st = conexion.createStatement();
			ResultSet rs = st
					.executeQuery("select ve.* from vehiculos ve, camiones co where ve.matricula = co.matricula");
			System.out.println("|"
					+ "-------------------------------------------------------------------------------------------------------------------------------|");
			System.out.println("|" + "Matricula \t | \t" + "Num_Bastidor \t | \t" + "Color\t | \t"
					+ "Num_Asientos\t | \t" + "Precio\t |\t" + "Num_serie" + "\t \t|");
			System.out.println("|"
					+ "-------------------------------------------------------------------------------------------------------------------------------|");
			while (rs.next()) {

				System.out.println("|" + rs.getString(1) + "\t  \t | \t" + rs.getString(2) + "\t  \t | \t"
						+ rs.getString(3) + "\t | \t" + rs.getInt(4) + "\t  \t | \t" + rs.getInt(5) + "\t | \t"
						+ rs.getString(6) + "\t|");

			}
			System.out.println("|"
					+ "-------------------------------------------------------------------------------------------------------------------------------|");

		} catch (SQLException e) {
			System.out.println("Ha saltado una excepción de tipo SQLException " + e.getMessage());
		}
	}

}
