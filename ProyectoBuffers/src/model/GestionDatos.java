package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class GestionDatos {	//Gestiona el acceso a los ficheros. Se implementarán funciones para abrir y cerrar buffers
	//y las funciones que hagan uso de esos buffers


	public GestionDatos() throws IOException{
		
			FileReader fr = new FileReader("fichero1.txt");
			FileReader fr2 = new FileReader("fichero2.txt");
			BufferedReader br = new BufferedReader(fr);
			BufferedReader br2 = new BufferedReader(fr2);
			String str;

	//TODO: Implementa una función para abrir ficheros
			while((str=br.readLine())!= null){
				System.out.println("He leido: "+str); 
			}
	//TODO: Implementa una función para cerrar ficheros
			fr.close();
			br.close();
	}
	public boolean compararContenido (String fichero1, String fichero2){//Compara fichero1 y fichero2 con .equals
		//Devolverá verdadero o falso según el resultado
		if (fichero1.equals(fichero2)){
			return true;
		}
		else{
			return false;
		}
	}
	
	public int buscarPalabra (String fichero1, String palabra, boolean primera_aparicion) throws IOException{
		//TODO: Implementa la función
		FileReader fr = new FileReader("fichero1.txt");//Inicializamos los readers
		BufferedReader br = new BufferedReader(fr);
		String str = br.readLine();
		do{
		while(primera_aparicion = false){//Mientras no coincidan las palabras, seguirá leyendo
			if(str.equals(palabra)){//Si las palabras coinciden, devuelve true
				primera_aparicion = true;
			}
			else{ primera_aparicion = false; }//Si no coinciden, devuelve false y sigue leyendo
		}
		}while((str=br.readLine())!= null);//No dejará de leer mientras siga habiendo texto
		
		fr.close();//Cerramos los flujos
		br.close();
		return 1;
		
	}	

}