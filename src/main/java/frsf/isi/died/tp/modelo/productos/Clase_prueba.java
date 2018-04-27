package frsf.isi.died.tp.modelo.productos;

import static org.junit.Assert.assertTrue;

public class Clase_prueba {
public static void main(String[] agrs) {
	
	Libro l1 = new Libro(1, "ABC",10.0,20.0,50);
	Libro l2 = new Libro(1, "ABC",100.0,50.0,150);
	System.out.println("l1 = "+l1.precio());
	System.out.println("l2 = "+l2.precio());

	// l1.compareTo(l2)<0)
	// l2.compareTo(l1)>0)



}
	
	
	
}
