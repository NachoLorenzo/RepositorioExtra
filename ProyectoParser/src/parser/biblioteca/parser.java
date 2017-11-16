package parser.biblioteca;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import org.xml.sax.SAXException;

public class parser {

	private Document dom = null; //Objeto de clase document
	private ArrayList<libro> Biblioteca = null;//Array de libros con nombre biblioteca
	
	public parser(){
		Biblioteca = new ArrayList<libro>();
	}
	
	public void parseFicheroXML(String fichero){
		//Se crea la factory
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		
		try {
		//Se crea el document builder
			DocumentBuilder db = dbf.newDocumentBuilder();

		//Realizamos el parse para obtener un fichero dom
			dom = db.parse(fichero);
		} catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		} catch (SAXException se) {
			se.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
	
	//Método para parsear el documento
	public void parseDocument(){
		//Obtenemos el elemento raíz del documento XML (en este caso, biblioteca)
		Element docEle = dom.getDocumentElement();
		
		//Obtenemos la lista de nodos del documento (cada uno de los apartados: titulo, autor, editor, etc)
		NodeList nl = docEle.getElementsByTagName("libro"); 	//Buscaremos por el tag "libro"
		if(nl != null && nl.getLength() > 0){					//Se comprueba que haya nodos (que no se haya llegado al final del documento, por ejemplo)
			for(int i = 0; i < nl.getLength(); i++){			//Iteración para ir recorriendo el documento
				//Obtenemos uno de los elementos de la lista
				Element el = (Element) nl.item(i);
				//Obtenemos un libro
				libro lib = getLibro(el);
				//Se añade al array Biblioteca
				Biblioteca.add(lib);
			}
		}
	}
	
	private libro getLibro(Element libroEle){
		//Para cada libro, obtendremos sus atributos:
		String titulo = getTextValue(libroEle, "titulo");
		String autor = getTextValue(libroEle, "autor");
		String nombre = getTextValue(libroEle, "nombre");
		String editor = getTextValue(libroEle, "editor");
		int paginas = getIntValue(libroEle, "titulo");
		
		//Creamos un objeto libro con los elementos del nodo
		libro l = new libro(titulo, autor, nombre, editor, paginas);
		return l;
	}
	//MÉTODOS PARA OBTENER VALORES STRING Y ENTEROS
	private String getTextValue(Element ele, String tagName) {
		String textVal = null;
		NodeList nl = ele.getElementsByTagName(tagName);
		if(nl != null && nl.getLength() > 0) {
			Element el = (Element)nl.item(0);
			textVal = el.getFirstChild().getNodeValue();
		}		
		return textVal;
	}
	
	private int getIntValue(Element ele, String tagName) {				
		return Integer.parseInt(getTextValue(ele,tagName));
	}
	
	public void print(){
		
		Iterator it = Biblioteca.iterator();
		while(it.hasNext()){
			libro lib = (libro) it.next();
			lib.print();
		}
	}
	
}
