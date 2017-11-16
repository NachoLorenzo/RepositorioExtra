package marshaller;

import java.io.Serializable;

public class libro implements Serializable{
		
		private String titulo = null;
		private String autor = null;
		private String nombre = null;
		private String editor = null;
		private int paginas = 0;

		public libro(){
		}
		public libro(String t, String a, String n, String e, int p){
			titulo = t;
			autor = a;
			nombre = n;
			editor = e;
			paginas = p;
		}
		public String getTitulo(){
			return titulo;
		}
		public void setTitulo(String t){
			titulo = t;
		}
		public String getAutor(){
			return autor;
		}
		public void setAutor(String a){
			autor = a;
		}
		public String getNombre(){
			return nombre;
		}
		public void setNombre(String n){
			nombre = n;
		}
		public String getEditor(){
			return editor;
		}
		public void setEditor(String e){
			editor = e;
		}
		public int getPaginas(){
			return paginas;
		}
		public void setPaginas(int p){
			paginas = p;
		}
		
		public void print(){
			System.out.println("Titulo: " + titulo + "\n Autor: " + nombre + "\n Editor: " + editor + " Paginas: " + paginas +"");
		}
}
