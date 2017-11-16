package marshaller;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

public class marshaller {
	
	private Document dom = null;
	private ArrayList<libro> Biblioteca = null;
	
	public marshaller(ArrayList<libro> bib){
		Biblioteca = bib;
	}
	//Primer paso: crear un documento y la instancia DOM (document)
	public void crearDocumento(){
		//Creamos primero una factory
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		try{
			//Creamos un documentbuilder
			DocumentBuilder db = dbf.newDocumentBuilder();
			
			//Creamos una instancia de DOM
			dom = db.newDocument();
		}catch(ParserConfigurationException pce){
			pce.printStackTrace();
		}
	}
	
	//Segundo paso: crear el árbol
	//Crearemos el elemento raíz y toda la estructura DOM
	
	public void crearDOM(){
		Element docEle = dom.createElement("biblioteca");
		dom.appendChild(docEle);//Se añade al document
		
		//Recorremos el array de libros
		Iterator it = Biblioteca.iterator();
		while(it.hasNext()){
			libro lib = (libro) it.next();
			//Para cada libro creamos el elemento <libro> y lo añadimos al array
			Element libroEle = setLibro(lib);
			docEle.appendChild(libroEle);
		}
	}
	
	private Element setLibro(libro lib){//Crea los libros con todos sus elementos
		
		//Creamos el elemento libro
		Element libroEle = dom.createElement("libro");
		
		//Creamo los nodos (título, autor, etc) y los añadimos al elemento
		Element tituloEle = dom.createElement("titulo");
		Text tituloTexto = dom.createTextNode(lib.getTitulo());
		tituloEle.appendChild(tituloTexto);
		libroEle.appendChild(tituloEle);
		return libroEle;
		
		//NO ENTIENDO ESTE ERROR
		Element autorEle = dom.createElement("autor");
		Text autorTexto = dom.createTextNode(lib.getAutor());
		autorEle.appendChild(autorTexto);
		libroEle.appendChild(autorEle);
		return libroEle;
		
		Element nombreEle = dom.createElement("nombre");
		Text nombreTexto = dom.createTextNode(lib.getNombre());
		nombreEle.appendChild(nombreTexto);
		libroEle.appendChild(nombreEle);//¿El padre de "nombre" no es "autor"?
		return libroEle;
		
		
		Element editorEle = dom.createElement("editor");
		Text editorTexto = dom.createTextNode(lib.getEditor());
		editorEle.appendChild(editorTexto);
		libroEle.appendChild(editorEle);
		return libroEle;
		
		Element paginasEle = dom.createElement("edad");
		Text paginasTexto = dom.createTextNode(Integer.toString(lib.getPaginas()));
		paginasEle.appendChild(paginasTexto);
		libroEle.appendChild(paginasEle);
		return libroEle;
	}
	
	public void escribirDocumentAXml(File file) throws TransformerException{//Método para escribir en el documento XML
		
		//Aquí se escribe el resultado. Utilizamos la factory en la misma instrucción en lugar de 2 separadas
		Transformer trans = TransformerFactory.newInstance().newTransformer();
		trans.setOutputProperty(OutputKeys.INDENT, "yes");//Propiedad para saltos de línea
		
		//Especificamos dónde escribiremos los resultados y la fuente de los datos
		StreamResult result = new StreamResult(file);//Instancia con los resultados (indicando el fichero donde queremos escribir)
		DOMSource source = new DOMSource(dom);//Fuente de datos
		trans.transform(source, result);
	}
}
