package modelo;

import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

public class ExportarXML {

	public static void main(String[] args, String ruta) {

		ResultSet rsCoches = Modelo.consultarStockCoches();
		ResultSet rsCamiones = Modelo.consultarStockCamiones();

		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			DOMImplementation implementation = builder.getDOMImplementation();

			Document documento = implementation.createDocument(null, "concesionario", null);
			documento.setXmlVersion("1.0");

			Element Vehiculos = documento.createElement("Vehiculos");

			while (rsCoches.next()) {

				Element coche = documento.createElement("coche");

				Element matricula_coc = documento.createElement("matricula");
				Text textMatricula_coc = documento.createTextNode(rsCoches.getNString(1));
				matricula_coc.appendChild(textMatricula_coc);
				coche.appendChild(matricula_coc);

				Element num_bastidor_coc = documento.createElement("num_bastidor");
				Text textnum_bastidor_coc = documento.createTextNode(rsCoches.getNString(2));
				num_bastidor_coc.appendChild(textnum_bastidor_coc);
				coche.appendChild(num_bastidor_coc);

				Element color_coc = documento.createElement("color");
				Text textcolor_coc = documento.createTextNode(rsCoches.getNString(3));
				color_coc.appendChild(textcolor_coc);
				coche.appendChild(color_coc);

				Element num_asientos_coc = documento.createElement("num_asientos");
				Text textnum_asientos_coc = documento.createTextNode(Integer.toString(rsCoches.getInt(4)));
				num_asientos_coc.appendChild(textnum_asientos_coc);
				coche.appendChild(num_asientos_coc);

				Element precio_coc = documento.createElement("precio");
				Text textprecio_coc = documento.createTextNode(Integer.toString(rsCoches.getInt(5)));
				precio_coc.appendChild(textprecio_coc);
				coche.appendChild(precio_coc);

				Element num_serie_coc = documento.createElement("num_serie");
				Text textnum_serie_coc = documento.createTextNode(rsCoches.getString(6));
				num_serie_coc.appendChild(textnum_serie_coc);
				coche.appendChild(num_serie_coc);

				Element num_puertas = documento.createElement("num_puertas");
				Text textnum_puertas = documento.createTextNode(Integer.toString(rsCoches.getInt(7)));
				num_puertas.appendChild(textnum_puertas);
				coche.appendChild(num_puertas);

				Element capacidad_maletero = documento.createElement("capacidad_maletero");
				Text textcapacidad_maletero = documento.createTextNode(Integer.toString(rsCoches.getInt(8)));
				capacidad_maletero.appendChild(textcapacidad_maletero);
				coche.appendChild(capacidad_maletero);

				Vehiculos.appendChild(coche);

			}

			while (rsCamiones.next()) {

				Element camion = documento.createElement("camion");

				Element matricula_cam = documento.createElement("matricula");
				Text textMatricula_cam = documento.createTextNode(rsCamiones.getNString(1));
				matricula_cam.appendChild(textMatricula_cam);
				camion.appendChild(matricula_cam);

				Element num_bastidor_cam = documento.createElement("num_bastidor");
				Text textnum_bastidor_cam = documento.createTextNode(rsCamiones.getNString(2));
				num_bastidor_cam.appendChild(textnum_bastidor_cam);
				camion.appendChild(num_bastidor_cam);

				Element color_cam = documento.createElement("color");
				Text textcolor_cam = documento.createTextNode(rsCamiones.getNString(3));
				color_cam.appendChild(textcolor_cam);
				camion.appendChild(color_cam);

				Element num_asientos_cam = documento.createElement("num_asientos");
				Text textnum_asientos_cam = documento.createTextNode(Integer.toString(rsCamiones.getInt(4)));
				num_asientos_cam.appendChild(textnum_asientos_cam);
				camion.appendChild(num_asientos_cam);

				Element precio_cam = documento.createElement("precio");
				Text textprecio_cam = documento.createTextNode(Integer.toString(rsCamiones.getInt(5)));
				precio_cam.appendChild(textprecio_cam);
				camion.appendChild(precio_cam);

				Element num_serie_cam = documento.createElement("num_serie");
				Text textnum_serie_cam = documento.createTextNode(rsCamiones.getString(6));
				num_serie_cam.appendChild(textnum_serie_cam);
				camion.appendChild(num_serie_cam);

				Element carga = documento.createElement("carga");
				Text textcarga = documento.createTextNode(Integer.toString(rsCamiones.getInt(7)));
				carga.appendChild(textcarga);
				camion.appendChild(carga);

				Element tipo_mercancia = documento.createElement("tipo_mercancia");
				Text texttipo_mercancia = documento.createTextNode((rsCamiones.getString(8)));
				tipo_mercancia.appendChild(texttipo_mercancia);
				camion.appendChild(tipo_mercancia);

				Vehiculos.appendChild(camion);

			}

			documento.getDocumentElement().appendChild(Vehiculos);

			Source source = new DOMSource(documento);

			Result result = new StreamResult(new File(ruta + "/concesionario.xml"));
			Transformer transformer = TransformerFactory.newDefaultInstance().newTransformer();
			transformer.transform(source, result);

		} catch (ParserConfigurationException | TransformerException | SQLException ex) {
			System.out.println(ex.getMessage());
		}
	}

}
