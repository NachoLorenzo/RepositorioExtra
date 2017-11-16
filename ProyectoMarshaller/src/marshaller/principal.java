package marshaller;

import java.util.ArrayList;
import java.io.File;

import javax.xml.transform.TransformerException;

public class principal {

	public static void main (String[] args){
		
		ArrayList<libro> Biblioteca;
		
		//Cargamos los datos
		Biblioteca = new ArrayList<libro>();
		//Objetos tipo "libro"
		Biblioteca.add(new libro("Introduction to Linux", "Machtelt", "Garrels", "O'Reilly", 256));
		Biblioteca.add(new libro("El lenguaje de programación C", "Kernighan", "Ritchie", "Prentice Hall", 294));
		
		marshaller marshaller = new marshaller(Biblioteca);
		marshaller.crearDocumento();
		marshaller.crearDOM();
		
		
		File file = new File("Biblioteca.xml");
		try{
			marshaller.escribirDocumentAXml(file);
		}catch (TransformerException e){
			e.printStackTrace();
		}
	}	
}
