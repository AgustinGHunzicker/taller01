package frsf.isi.died.app;

import frsf.isi.died.tp.modelo.Biblioteca;
import frsf.isi.died.tp.modelo.BibliotecaArray;
import frsf.isi.died.tp.modelo.productos.Libro;
import frsf.isi.died.tp.modelo.productos.MaterialCapacitacion;
import frsf.isi.died.tp.modelo.productos.Video;

public class Paso06App {
	
	
	public static void main(String[] args) {
		Libro l1 = new Libro(1,"Algoritmos 1",50.0,25.0, 310);
		System.out.println("Libro creado: "+l1.toString());

		Libro l2 = new Libro(2,"Java 1",30.0,40.0, 155);
		System.out.println("Libro creado: "+l2.toString());
		
		Libro l3 = new Libro(3,"Python",20.0,100.0, 460);
		System.out.println("Libro creado: "+l3.toString());
		
		Video v1 = new Video(1,"Algoritmos de busqueda",50.0,350);
		System.out.println("Video creado: "+v1.toString());

		Video v2 = new Video(2,"Metodos de ordenamiento",40.0, 740);
		System.out.println("Video creado: "+v2.toString());
		
		System.out.println("Test");
		Biblioteca biblioteca = new BibliotecaArray();
		biblioteca.agregar(l1);
		biblioteca.agregar(l2);
		biblioteca.agregar(l3);
		biblioteca.agregar(v1);
		biblioteca.agregar(v2);
		
		for(MaterialCapacitacion mat : biblioteca.materiales()) {
			if(mat!=null) System.out.println(mat.toString());
		}
		// crear un sexto material de capacitacion que no se agregará porque el arreglo solo tiene capacidad de 5
		Libro l4 = new Libro(3,"Complejidad y BigO",56.0,35.0, 125);
		System.out.println("Libro creado: "+l4.toString());
		biblioteca.agregar(l4);
		
		System.out.println("==================================================================================");
		System.out.println("Verificar que seguimos teniendo 5 Materiales de capacitacion (3 libros y 2 Videos)");
		System.out.println("Cantidad de material disponible:"+biblioteca.cantidadMateriales()+ " ("+biblioteca.cantidadLibros()+" libros y "+biblioteca.cantidadVideos()+ " videos) ");
		System.out.println("==================================================================================");
		
		for(MaterialCapacitacion mat : biblioteca.materiales()) {
			if(mat!=null) System.out.println(mat.toString());
		}			
	
	}
}
