package modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.nocrala.tools.texttablefmt.BorderStyle;
import org.nocrala.tools.texttablefmt.CellStyle;
import org.nocrala.tools.texttablefmt.Table;

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
			ResultSet rs = st.executeQuery("select * from historial where Fecha > '" + fechas[0] + "' and Fecha < '"
					+ fechas[1] + "' and accion = 'VENDIDO'");

			Table t = new Table(6, BorderStyle.DESIGN_TUBES_WIDE);
			CellStyle estilo = new CellStyle(CellStyle.HorizontalAlign.center);
			t.addCell("Matricula", estilo);
			t.addCell("Color", estilo);
			t.addCell("Serie", estilo);
			t.addCell("Fecha", estilo);
			t.addCell("Acción", estilo);
			t.addCell("Operación", estilo);
			while (rs.next()) {
				t.addCell(rs.getString(1), estilo);
				t.addCell(rs.getString(2), estilo);
				t.addCell(rs.getString(3), estilo);
				t.addCell(rs.getString(4), estilo);
				t.addCell(rs.getString(5), estilo);
				t.addCell(rs.getString(6), estilo);
			}
			System.out.println(t.render());

		} catch (SQLException e) {
			System.out.println("Ha saltado una excepción de tipo SQLException " + e.getMessage());
		}
	}

	public boolean comprobar(Connection conexion, String matricula) {
		boolean existe = false;
		try {
			Statement st = conexion.createStatement();
			ResultSet rs = st.executeQuery("select ve.* from vehiculos ve");
			while (rs.next()) {
				if (matricula.equals(rs.getString(1))) {
					existe = true;
				}
			}
		} catch (SQLException e) {
			System.out.println("Ha saltado una excepción de tipo SQLException " + e.getMessage());
		}
		return existe;
	}

	public void modificarBd(Connection conexion, String campo, String nuevoValor, String matricula) {

		String[] camposVehiculo = { "Matricula", "Num_Bastidor", "Color", "Num_asientos", "Precio", "Num_Serie" };
		String[] camposCoche = { "Num_puertas", "Capacidad_maletero" };
		String[] camposCamion = { "Carga", "Tipo_mercancia" };

		for (int i = 0; i < camposVehiculo.length; i++) {
			if (camposVehiculo[i].equals(campo)) {
				try {
					Statement st = conexion.createStatement();
					st.executeUpdate("update vehiculos set " + campo + " = '" + nuevoValor + "' where matricula = '"
							+ matricula + "'");
				} catch (SQLException e) {
					System.out.println("Ha saltado una excepción de tipo SQLException " + e.getMessage());
				}

			}
		}

		for (int i = 0; i < camposCoche.length; i++) {
			if (camposCoche[i].equals(campo)) {
				try {
					Statement st = conexion.createStatement();
					ResultSet rs = st.executeQuery("update coches set " + campo + " = '" + nuevoValor
							+ "' where matricula = '" + matricula + "'");
				} catch (SQLException e) {
					System.out.println("Ha saltado una excepción de tipo SQLException " + e.getMessage());
				}

			}
		}

		for (int i = 0; i < camposCamion.length; i++) {
			if (camposCamion[i].equals(campo)) {
				try {
					Statement st = conexion.createStatement();
					ResultSet rs = st.executeQuery("update camiones set " + campo + " = '" + nuevoValor
							+ "' where matricula = '" + matricula + "'");
				} catch (SQLException e) {
					System.out.println("Ha saltado una excepción de tipo SQLException " + e.getMessage());
				}

			}
		}

	}

	public void mostrarStock(Connection conexion) {
		try {
			Statement st = conexion.createStatement();
			ResultSet rs = st.executeQuery("select ve.* from vehiculos ve");
			Table t = new Table(6, BorderStyle.DESIGN_TUBES_WIDE);
			CellStyle estilo = new CellStyle(CellStyle.HorizontalAlign.center);
			t.addCell("Matricula", estilo);
			t.addCell("Num_Bastridor", estilo);
			t.addCell("Color", estilo);
			t.addCell("Num_Asientos", estilo);
			t.addCell("Precio", estilo);
			t.addCell("Num_serie", estilo);
			while (rs.next()) {
				t.addCell(rs.getString(1), estilo);
				t.addCell(rs.getString(2), estilo);
				t.addCell(rs.getString(3), estilo);
				t.addCell(rs.getString(4), estilo);
				t.addCell(rs.getString(5), estilo);
				t.addCell(rs.getString(6), estilo);
			}
			System.out.println(t.render());

		} catch (SQLException e) {
			System.out.println("Ha saltado una excepción de tipo SQLException " + e.getMessage());
		}

	}

	public void consultaCoches(Connection conexion) {
		try {

			Statement st = conexion.createStatement();
			ResultSet rs = st
					.executeQuery("select ve.* from vehiculos ve, coches co where ve.matricula = co.matricula");

			Table t = new Table(6, BorderStyle.DESIGN_TUBES_WIDE);
			CellStyle estilo = new CellStyle(CellStyle.HorizontalAlign.center);
			t.addCell("Matricula", estilo);
			t.addCell("Num_Bastidor", estilo);
			t.addCell("Color", estilo);
			t.addCell("Num_Asientos", estilo);
			t.addCell("Precio", estilo);
			t.addCell("Num_serie", estilo);
			while (rs.next()) {
				t.addCell(rs.getString(1), estilo);
				t.addCell(rs.getString(2), estilo);
				t.addCell(rs.getString(3), estilo);
				t.addCell(rs.getString(4), estilo);
				t.addCell(rs.getString(5), estilo);
				t.addCell(rs.getString(6), estilo);
			}
			System.out.println(t.render());

		} catch (SQLException e) {
			System.out.println("Ha saltado una excepción de tipo SQLException " + e.getMessage());
		}
	}

	public void consultaCamiones(Connection conexion) {
		try {

			Statement st = conexion.createStatement();
			ResultSet rs = st
					.executeQuery("select ve.* from vehiculos ve, camiones co where ve.matricula = co.matricula");
			Table t = new Table(6, BorderStyle.DESIGN_TUBES_WIDE);
			CellStyle estilo = new CellStyle(CellStyle.HorizontalAlign.center);
			t.addCell("Matricula", estilo);
			t.addCell("Num_Bastidor", estilo);
			t.addCell("Color", estilo);
			t.addCell("Num_Asientos", estilo);
			t.addCell("Precio", estilo);
			t.addCell("Num_serie", estilo);
			while (rs.next()) {
				t.addCell(rs.getString(1), estilo);
				t.addCell(rs.getString(2), estilo);
				t.addCell(rs.getString(3), estilo);
				t.addCell(rs.getString(4), estilo);
				t.addCell(rs.getString(5), estilo);
				t.addCell(rs.getString(6), estilo);
			}
			System.out.println(t.render());

		} catch (SQLException e) {
			System.out.println("Ha saltado una excepción de tipo SQLException " + e.getMessage());
		}
	}

	public void eliminarCoche(Connection conexion, String matricula) {
		try {
			Statement st = conexion.createStatement();
			st.executeUpdate("DELETE FROM vehiculos WHERE matricula='" + matricula + "'");
			st.executeUpdate("DELETE FROM coches WHERE matricula='" + matricula + "'");
			System.out.println("Vendido correctamente");
		} catch (SQLException e) {
			System.out.println("Ha saltado una excepción de tipo SQLException " + e.getMessage());
		}

	}

	public ResultSet obtenerCoches(Connection conexion) {
		ResultSet rs = null;
		try {
			Statement st;
			st = conexion.createStatement();
			rs = st.executeQuery(
					"select v.*,c.num_puertas,c.capacidad_maletero from Vehiculos v,Coches c where v.matricula=c.matricula");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}

	public ResultSet obtenerCamiones(Connection conexion) {
		ResultSet rs = null;
		try {
			Statement st;
			st = conexion.createStatement();
			rs = st.executeQuery(
					"select v.*,c.carga,c.tipo_mercancia from Vehiculos v,Camiones c where v.matricula=c.matricula");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}

}
