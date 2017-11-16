package parser.biblioteca;

public class principal {
	
	public static void main(String[] args){
		
		parser parser = new parser();
		parser.parseFicheroXML("Biblioteca.xml");
		parser.parseDocument();
		parser.print();
	}

}
