package modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.nocrala.tools.texttablefmt.BorderStyle;
import org.nocrala.tools.texttablefmt.CellStyle;
import org.nocrala.tools.texttablefmt.Table;

import concesionario.Camion;
import concesionario.Coche;
import concesionario.Vehiculo;

public class GestionBD {

	public void insertarVehiculoBd(Connection conexion, Vehiculo vehiculo) {
		try (Statement st = conexion.createStatement()) {

			ResultSet rs = st.executeQuery("select * from categorias");
			String claveCategoria = vehiculo.getNumSerie();
			boolean existe = false;

			while (rs.next()) {
				String clave = rs.getString(1) + rs.getString(2) + rs.getString(3);
				if (clave.equals(claveCategoria)) {
					existe = true;
				}
			}

			if (!existe) {
				st.executeUpdate("delete from categorias where marca = '" + vehiculo.getMarca() + "' and modelo = '" + vehiculo.getModelo() + "' and Añofab = '" + vehiculo.getFechaFab() + "'");
				
				st.executeUpdate("insert into categorias values ('" + vehiculo.getMarca() + "', '"
						+ vehiculo.getModelo() + "', '" + vehiculo.getFechaFab() + "')");
				st.executeUpdate("insert into num_series values ('" + vehiculo.getNumSerie() + "', '"
						+ vehiculo.getMarca() + "', '" + vehiculo.getModelo() + "', '" + vehiculo.getFechaFab() + "')");
			}

			st.executeUpdate("insert into vehiculos values ('" + vehiculo.getMatricula() + "', '"
					+ vehiculo.getNumBastidor() + "', '" + vehiculo.getColor() + "', " + vehiculo.getNumAsientos()
					+ ", " + vehiculo.getPrecio() + ", '" + vehiculo.getNumSerie() + "')");
		} catch (SQLException e) {
			System.out.println(
					"Ha saltado una excepcion de tipo SQLException " + e.getMessage() + " insertar en vehiculos");
		}

	}

	public void insertarCocheBd(Connection conexion, Coche coche) {
		try (Statement st = conexion.createStatement()) {
			st.executeUpdate("insert into coches values ('" + coche.getMatricula() + "', " + coche.getNumAsientos()
					+ ", " + coche.getCapacidadMaletero() + ")");
		} catch (SQLException e) {
			System.out
					.println("Ha saltado una excepcion de tipo SQLException " + e.getMessage() + " insertar en coches");
		}
	}

	public void insertarCamionBd(Connection conexion, Camion camion) {
		try (Statement st = conexion.createStatement()) {
			st.executeUpdate("insert into camiones values ('" + camion.getMatricula() + "', " + camion.getCarga()
					+ ", '" + camion.getTipoMercancia() + "')");
		} catch (SQLException e) {
			System.out.println(
					"Ha saltado una excepcion de tipo SQLException " + e.getMessage() + " insertar en camiones");
		}
	}

	public void consultaFechas(Connection conexion, String[] fechas) {
		try (Statement st = conexion.createStatement()) {
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
			System.out.println("Ha saltado una excepcion de tipo SQLException " + e.getMessage());
		}
	}

	public boolean comprobar(Connection conexion, String matricula) {
		boolean existe = false;
		try (Statement st = conexion.createStatement()) {
			ResultSet rs = st.executeQuery("select ve.* from vehiculos ve");
			while (rs.next()) {
				if (matricula.equals(rs.getString(1))) {
					existe = true;
				}
			}
		} catch (SQLException e) {
			System.out.println("Ha saltado una excepcion de tipo SQLException " + e.getMessage());
		}
		return existe;
	}

	public void modificarBd(Connection conexion, String campo, String nuevoValor, String matricula) {

		String[] camposVehiculo = { "Matricula", "Num_Bastidor", "Color", "Num_asientos", "Precio", "Num_Serie" };
		String[] camposCoche = { "Num_puertas", "Capacidad_maletero" };
		String[] camposCamion = { "Carga", "Tipo_mercancia" };

		for (int i = 0; i < camposVehiculo.length; i++) {
			if (camposVehiculo[i].equals(campo)) {
				try (Statement st = conexion.createStatement()) {
					st.executeUpdate("update vehiculos set " + campo + " = '" + nuevoValor + "' where matricula = '"
							+ matricula + "'");
				} catch (SQLException e) {
					System.out.println("Ha saltado una excepcion de tipo SQLException " + e.getMessage());
				}

			}
		}

		for (int i = 0; i < camposCoche.length; i++) {
			if (camposCoche[i].equals(campo)) {
				try (Statement st = conexion.createStatement()) {
					st.executeUpdate("update coches set " + campo + " = '" + nuevoValor
							+ "' where matricula = '" + matricula + "'");
				} catch (SQLException e) {
					System.out.println("Ha saltado una excepcion de tipo SQLException " + e.getMessage());
				}

			}
		}

		for (int i = 0; i < camposCamion.length; i++) {
			if (camposCamion[i].equals(campo)) {
				try (Statement st = conexion.createStatement()) {
					st.executeUpdate("update camiones set " + campo + " = '" + nuevoValor
							+ "' where matricula = '" + matricula + "'");
				} catch (SQLException e) {
					System.out.println("Ha saltado una excepcion de tipo SQLException " + e.getMessage());
				}

			}
		}

	}

	public void mostrarStock(Connection conexion) {
		try (Statement st = conexion.createStatement()) {
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
			System.out.println("Ha saltado una excepcion de tipo SQLException " + e.getMessage());
		}

	}

	public void consultaCoches(Connection conexion) {
		try (Statement st = conexion.createStatement()) {
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
			System.out.println("Ha saltado una excepcion de tipo SQLException " + e.getMessage());
		}
	}

	public void consultaCamiones(Connection conexion) {
		try (Statement st = conexion.createStatement()) {
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
			System.out.println("Ha saltado una excepcion de tipo SQLException " + e.getMessage());
		}
	}

	public void eliminarVehiculo(Connection conexion, String matricula, String respuesta, String color) {
		try (Statement st = conexion.createStatement()) {
			if (respuesta.equals("SI")) {
				st.executeUpdate("Update vehiculos set color= '" + color + "'  WHERE matricula='" + matricula + "'");
				st.executeUpdate("DELETE FROM vehiculos WHERE matricula='" + matricula + "'");
				st.executeUpdate("DELETE FROM coches WHERE matricula='" + matricula + "'");
				System.out.println("Vendido y pintado correctamente");
			} else {
				st.executeUpdate("DELETE FROM vehiculos WHERE matricula='" + matricula + "'");
				st.executeUpdate("DELETE FROM coches WHERE matricula='" + matricula + "'");
				System.out.println("Vendido correctamente sin repintar");
			}

		} catch (SQLException e) {
			System.out.println("Ha saltado una excepcion de tipo SQLException " + e.getMessage());
		}

	}

	public ResultSet obtenerCoches(Connection conexion) {
		ResultSet rs = null;
		try {
			Statement st = conexion.createStatement();
			rs = st.executeQuery(
					"select v.*,c.num_puertas,c.capacidad_maletero from Vehiculos v,Coches c where v.matricula=c.matricula");

		} catch (SQLException e) {
			System.out.println("Ha saltado una excepcion de tipo SQLException " + e.getMessage());
			e.printStackTrace();
		}
		return rs;
	}

	public ResultSet obtenerCamiones(Connection conexion) {
		ResultSet rs = null;
		try {
			Statement st = conexion.createStatement();
			rs = st.executeQuery(
					"select v.*,c.carga,c.tipo_mercancia from Vehiculos v,Camiones c where v.matricula=c.matricula");

		} catch (SQLException e) {
			System.out.println("Ha saltado una excepcion de tipo SQLException " + e.getMessage());
			e.printStackTrace();
		}
		return rs;
	}

	public boolean desconectar(Connection conexion) {
		try {
			conexion.close();
			return true;
		} catch (SQLException e) {
			return false;
		}

	}

	public void insertarVehiculoXML(Connection conexion, ArrayList<String> valores) {
		try {
			Statement st = conexion.createStatement();

			ResultSet rs = st.executeQuery("select * from categorias");
			String claveCategoria = valores.get(0) + valores.get(1) + valores.get(2);
			boolean existe = false;

			while (rs.next()) {
				String clave = rs.getString(1) + rs.getString(2) + rs.getString(3);
				if (clave.equals(claveCategoria)) {
					existe = true;
				}
			}

			if (!existe) {
				st.executeUpdate("delete from categorias where marca = '" + valores.get(0) + "' and modelo = '" + valores.get(1) + "' and Añofab = '" + valores.get(2) + "'");
				st.executeUpdate("insert into categorias values ('" + valores.get(0) + "', '" + valores.get(1) + "', '"
						+ valores.get(2) + "')");
				st.executeUpdate("insert into num_series values ('" + valores.get(0) + valores.get(1) + valores.get(2)
						+ "', '" + valores.get(0) + "', '" + valores.get(1) + "', '" + valores.get(2) + "')");
			}

			st.executeUpdate("insert into vehiculos values ('" + valores.get(3) + "', '" + valores.get(4) + "', '"
					+ valores.get(5) + "', " + Integer.parseInt(valores.get(6)) + ", "
					+ Float.parseFloat(valores.get(7)) + ", '" + valores.get(0) + valores.get(1) + valores.get(2)
					+ "')");
		} catch (SQLException e) {
			System.out.println(
					"Ha saltado una excepcion de tipo SQLException " + e.getMessage() + " insertar en vehiculos");
		}
	}

	public void insertarCocheXML(Connection conexion, ArrayList<String> valores) {
		try {
			Statement st = conexion.createStatement();
			st.executeUpdate("insert into coches values ('" + valores.get(3) + "', " + Integer.parseInt(valores.get(9))
					+ ", " + Integer.parseInt(valores.get(10)) + ")");
		} catch (SQLException e) {
			System.out
					.println("Ha saltado una excepcion de tipo SQLException " + e.getMessage() + " insertar en coches");
		}
	}

	public void insertarCamionXML(Connection conexion, ArrayList<String> valores) {
		try {
			Statement st = conexion.createStatement();
			st.executeUpdate("insert into camiones values ('" + valores.get(3) + "', " + Integer.parseInt(valores.get(9))
					+ ", '" + valores.get(10) + "')");
		} catch (SQLException e) {
			System.out
					.println("Ha saltado una excepcion de tipo SQLException " + e.getMessage() + " insertar en camiones");
		}
	}

}
