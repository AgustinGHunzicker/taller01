package frsf.isi.died.tp.taller03;

import static org.junit.Assert.*;

import java.util.Collection;
import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import frsf.isi.died.tp.modelo.Biblioteca;
import frsf.isi.died.tp.modelo.BibliotecaABB;
import frsf.isi.died.tp.modelo.productos.Libro;
import frsf.isi.died.tp.modelo.productos.MaterialCapacitacion;
import frsf.isi.died.tp.modelo.productos.Video;

public class TestPaso03 {

	private Biblioteca biblioteca;
	private Libro l1;
	private Libro l2;
	private Libro l3;
	private Libro l4;
	private Libro l5;
	private Libro l6;
	private Video v1;
	private Video v2;
	private Video v3;
	private Video v4;
	private Video v5;
	
	@Before
	public void init() {
		biblioteca = new BibliotecaABB();		
		l1= new Libro(1, "Libro1", 10.0, 20.0, 154);
		l2= new Libro(2, "Libro2", 20.0, 24.0, 361);
		l3= new Libro(3, "Libro3", 15.0, 18.0, 108);
		l4= new Libro(4, "Libro4", 30.0, 16.0, 250);
		l5= new Libro(5, "Libro5", 24.0, 32.0, 545);
		l6= new Libro(6, "Libro6", 28.0, 54.0, 302);
		v1= new Video(7, "Video7", 28.0, 360);
		v2= new Video(8, "Video8", 15.0, 625);
		v3= new Video(9, "Video9", 30.0, 145);
		v4= new Video(10, "Video10", 45.0, 38);
		v5= new Video(11, "Video11", 12.0, 60);
	}
	
	@Ignore
	public void testAgregarLibro() {
		Integer obtenido = biblioteca.cantidadMateriales();
		assertEquals(Integer.valueOf(0),obtenido);
		biblioteca.agregar(l1);
		obtenido = biblioteca.cantidadMateriales();
		assertEquals(Integer.valueOf(1),obtenido);
	}
	
	@Ignore
	public void testAgregarVideo() {
		Integer obtenido = biblioteca.cantidadMateriales();
		assertEquals(Integer.valueOf(0),obtenido);
		biblioteca.agregar(v1);
		obtenido = biblioteca.cantidadMateriales();
		assertEquals(Integer.valueOf(1),obtenido);
	}
	
	@Ignore
	public void testNoAgregarMasDeLimite() {
		Integer obtenido = biblioteca.cantidadMateriales();
		assertEquals(Integer.valueOf(0),obtenido);
		biblioteca.agregar(v1);
		biblioteca.agregar(v2);
		biblioteca.agregar(v3);
		biblioteca.agregar(v4);
		biblioteca.agregar(v5);
		biblioteca.agregar(l1);
		biblioteca.agregar(l2);
		biblioteca.agregar(l3);
		biblioteca.agregar(l4);
		biblioteca.agregar(l5);		
		obtenido = biblioteca.cantidadMateriales();
		assertEquals(Integer.valueOf(10),obtenido);
		biblioteca.agregar(l6);		
		obtenido = biblioteca.cantidadMateriales();
		assertEquals(Integer.valueOf(10),obtenido);
	}

	@Ignore
	public void testCantidadLibros() {
		Integer obtenido = biblioteca.cantidadLibros();
		assertEquals(Integer.valueOf(0),obtenido);
		biblioteca.agregar(v1);
		biblioteca.agregar(v2);		
		obtenido = biblioteca.cantidadLibros();
		assertEquals(Integer.valueOf(0),obtenido);
		biblioteca.agregar(l1);
		biblioteca.agregar(l2);
		biblioteca.agregar(l3);
		biblioteca.agregar(l4);
		biblioteca.agregar(l5);	
		obtenido = biblioteca.cantidadLibros();
		assertEquals(Integer.valueOf(5),obtenido);

	}

	@Ignore
	public void testCantidadVideos() {
		Integer obtenido = biblioteca.cantidadVideos();
		assertEquals(Integer.valueOf(0),obtenido);
		biblioteca.agregar(l4);
		biblioteca.agregar(l5);		
		obtenido = biblioteca.cantidadVideos();
		assertEquals(Integer.valueOf(0),obtenido);
		biblioteca.agregar(v1);
		biblioteca.agregar(v2);
		biblioteca.agregar(v3);
		biblioteca.agregar(v4);
		biblioteca.agregar(v5);	
		obtenido = biblioteca.cantidadVideos();
		assertEquals(Integer.valueOf(5),obtenido);
	}

	@Test
	public void testOrdenarPorPrecio() {
		biblioteca.agregar(v1);
		biblioteca.agregar(v2);
		biblioteca.agregar(v3);
		biblioteca.agregar(v4);
		biblioteca.agregar(v5);
		biblioteca.agregar(l1);
		biblioteca.agregar(l2);
		biblioteca.agregar(l3);
		biblioteca.agregar(l4);
		biblioteca.agregar(l5);	
		biblioteca.ordenarPorPrecio(true);
		Double ultimoPrecio = -1.0;
		Collection<MaterialCapacitacion> mats = biblioteca.materiales();
		System.out.println(mats);
		for(MaterialCapacitacion m: mats) {
			System.out.println("PRECIO TEST: "+m.precio());
			assertTrue(m.precio()>ultimoPrecio);
			ultimoPrecio= m.precio();
		}
	}

	@Test
	public void testOrdenarPorTitulo() {
		biblioteca.agregar(v1);
		biblioteca.agregar(v2);
		biblioteca.agregar(v3);
		biblioteca.agregar(v4);
		biblioteca.agregar(v5);
		biblioteca.agregar(l1);
		biblioteca.agregar(l2);
		biblioteca.agregar(l3);
		biblioteca.agregar(l4);
		biblioteca.agregar(l5);	
		biblioteca.ordenarPorPrecio(false);
		String ultimoTitulo = null;
		Collection<MaterialCapacitacion> mats = biblioteca.materiales();
		for(MaterialCapacitacion m: mats) {
			if(ultimoTitulo!=null) {
				System.out.println("Titulo test: "+m.getTitulo());
				assertTrue(m.getTitulo().compareTo(ultimoTitulo)>0);						
			}
			ultimoTitulo= m.getTitulo();
		}
	}

}