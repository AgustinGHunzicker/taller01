package frsf.isi.died.app;

import frsf.isi.died.tp.modelo.productos.Video;

public class Paso05App {
	public static void main(String[] args) {
		Video v1 = new Video(1, "Algoritmos de busqueda", 50.0, 350);
		System.out.println("Video creado: " + v1.toString());
		Video v2 = new Video(2, "Metodos de ordenamiento", 40.0, 740);
		System.out.println("Video creado: " + v2.toString());
	}
}
