package frsf.isi.died.tp.modelo.productos;

import static org.junit.Assert.*;

import org.junit.Test;

public class Taller02Paso02Test {
	
	@Test
	public void librosIguales() {
		Libro l1 = new Libro(1, "ABC");
		Libro l2 = new Libro(1, "AbC");
		assertTrue(l1.equals(l2));
	}
	
	@Test
	public void librosDistintos() {
		Libro l1 = new Libro(1, "ABC");
		Libro l2 = new Libro(1, "AbCx");
		assertFalse(l1.equals(l2));
	}
	
	@Test
	public void videosIguales() {
		Video v1 = new Video(1, "ABC");
		Video v2 = new Video(1, "AbC");
		assertTrue(v1.equals(v2));
	}
	
	@Test
	public void videosDistintos() {
		Video v1 = new Video(1, "ABC");
		Video v2 = new Video(1, "AbCx");
		assertFalse(v1.equals(v2));
	}
	
	@Test
	public void libroVideosDistintos() {
		Video v1 = new Video(1, "ABC");
		Libro v2 = new Libro(1, "ABC");
		assertFalse(v1.equals(v2));
	}

}