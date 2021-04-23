package modelo;

import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;

public class ImportarXML {

	public static Document leerFichero(String ruta) {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = null;
		try {
			builder = factory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			System.out.println("Ha saltado una excepcion de tipo SQLException " + e.getMessage());
			e.printStackTrace();
		}

		Document documento = null;
		;
		try {
			documento = builder.parse(new File(ruta));
		} catch (SAXException | IOException e) {
			System.out.println("Ha saltado una excepcion de tipo SQLException " + e.getMessage());
			e.printStackTrace();
		}
		return documento;
	}

	public static void leerCoches(String ruta) {

		Document documento = leerFichero(ruta);

		NodeList listaCoches = (NodeList) documento.getElementsByTagName("coche");
		for (int i = 0; i < listaCoches.getLength(); i++) {
			Node nodo = listaCoches.item(i);
			if (nodo.getNodeType() == Node.ELEMENT_NODE) {
				Element e = (Element) nodo;
				NodeList hijos = e.getChildNodes();
				ArrayList<String> valores = new ArrayList<String>();
				for (int j = 0; j < hijos.getLength() - 1; j++) {
					Node hijo = hijos.item(j);
					if (hijo.getNodeType() == Node.ELEMENT_NODE) {
						System.out.println("Propiedad: " + hijo.getNodeName() + " Valor: " + hijo.getTextContent());
						valores.add(hijo.getTextContent());
					}
				}
				Modelo.insertarVehiculoXML(valores);
				Modelo.insertarCocheXML(valores);
				System.out.println("");
			}
		}

	}

	public static void leerCamiones(String ruta) {
		Document documento = leerFichero(ruta);

		NodeList listaCamiones = (NodeList) documento.getElementsByTagName("camion");
		for (int i = 0; i < listaCamiones.getLength(); i++) {
			Node nodo = listaCamiones.item(i);
			if (nodo.getNodeType() == Node.ELEMENT_NODE) {
				Element e = (Element) nodo;
				NodeList hijos = e.getChildNodes();
				ArrayList<String> valores = new ArrayList<String>();
				for (int j = 0; j < hijos.getLength(); j++) {
					Node hijo = hijos.item(j);
					if (hijo.getNodeType() == Node.ELEMENT_NODE) {
						System.out.println("Propiedad: " + hijo.getNodeName() + " Valor: " + hijo.getTextContent());
						valores.add(hijo.getTextContent());
					}
				}
				Modelo.insertarVehiculoXML(valores);
				Modelo.insertarCamionXML(valores);
				System.out.println("");
			}

		}

	}

}
