package frsf.isi.died.tp.modelo.productos;

import static org.junit.Assert.*;

import org.junit.Test;

public class Taller02Paso03Test {
	
	@Test
	public void ordenarPorTitulo() {
		Libro l1 = new Libro(1, "ABC",100.0,50.0,150);
		Libro l2 = new Libro(1, "ZBC",100.0,50.0,150);
		assertTrue(l1.compareTo(l2)<0);
		assertTrue(l2.compareTo(l1)>0);
	}

	@Test
	public void ordenarIguales() {
		Libro l1 = new Libro(1, "ABC",100.0,50.0,150);
		Libro l2 = new Libro(1, "ABC",100.0,50.0,150);
		assertTrue(l1.compareTo(l2)==0);
		assertTrue(l2.compareTo(l1)==0);
		
	}
	
	@Test
	public void ordenarPorPrecio() {
		Libro l1 = new Libro(1, "ABC",10.0,20.0,50);
		Libro l2 = new Libro(1, "ABC",100.0,50.0,150);
		assertTrue(l1.compareTo(l2)<0);
		assertTrue(l2.compareTo(l1)>0);
	}

	@Test
	public void ordenarVideoLibroTitulo() {
		Libro l1 = new Libro(1, "ABC",100.0,50.0,150);
		Video l2 = new Video(1, "ZBC",100.0,150);
		assertTrue(l1.compareTo(l2)<0);
		assertTrue(l2.compareTo(l1)>0);
	}
	
}