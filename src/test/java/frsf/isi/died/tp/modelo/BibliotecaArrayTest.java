package frsf.isi.died.tp.modelo;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import frsf.isi.died.tp.modelo.productos.Libro;
import frsf.isi.died.tp.modelo.productos.MaterialCapacitacion;
import frsf.isi.died.tp.modelo.productos.Video;

public class BibliotecaArrayTest {
	Biblioteca biblioteca;
	Libro m1;
	Libro m2;
	Libro m3;
	Libro m4;
	Video m5;
	Video m6;
	Video m7;
	Video m8;
	
	@Before
	public void init() {
		biblioteca=new BibliotecaArray();
		m1 = new Libro(1, "Libro 1", 100.0, 1.0, 10);
		m2 = new Libro(2, "Libro 2", 50.0, 1.0, 10);
		m3 = new Libro(3, "Libro 3", 150.0, 1.0, 10);
		m4 = new Libro(4, "Libro 4", 175.0, 1.0, 10);
		m5 = new Video(5, "Video 1", 75.0,1);
		m6 = new Video(6, "Video 2", 25.0,1);
		m7 = new Video(7, "Video 3", 275.0,1);
		m8 = new Video(8, "Video 4", 145.0,1);
	}
	
	
	@Test
	public void testAgregarMaterialCapacitacion() {
		biblioteca.agregar(m1);
		Integer cantidad = biblioteca.cantidadMateriales();
		assertEquals(Integer.valueOf(1), cantidad);

		biblioteca.agregar(m2);
		cantidad = biblioteca.cantidadMateriales();
		assertEquals(Integer.valueOf(2), cantidad);
		
		biblioteca.agregar(m3);
		cantidad = biblioteca.cantidadMateriales();
		assertEquals(Integer.valueOf(3), cantidad);
		
		biblioteca.agregar(m4);
		cantidad = biblioteca.cantidadMateriales();
		assertEquals(Integer.valueOf(4), cantidad);
		
		biblioteca.agregar(m5);
		cantidad = biblioteca.cantidadMateriales();
		assertEquals(Integer.valueOf(5), cantidad);
		
	
		Integer libros = biblioteca.cantidadLibros();
		Integer videos= biblioteca.cantidadVideos();
		assertEquals(Integer.valueOf(4), libros);
		assertEquals(Integer.valueOf(1), videos);

		biblioteca.agregar(m5);
		biblioteca.agregar(m5);
		biblioteca.agregar(m5);
		biblioteca.agregar(m5);
		biblioteca.agregar(m5);
		biblioteca.agregar(m5);
		biblioteca.agregar(m5);
		biblioteca.agregar(m5);
		biblioteca.agregar(m5);
		cantidad = biblioteca.cantidadMateriales();
		assertEquals(Integer.valueOf(10), cantidad);

	}

	@Test
	public void testOrdenamiento() {
		biblioteca.agregar(m1);
		biblioteca.agregar(m3);
		biblioteca.agregar(m4);
		biblioteca.agregar(m5);
		biblioteca.agregar(m8);		
		biblioteca.ordenarPorPrecio(true);
		MaterialCapacitacion anterior = null;
		

		for(MaterialCapacitacion mat : biblioteca.materiales()) {
			if(mat!=null) assertTrue((anterior==null) || anterior.precio()<mat.precio());
			anterior = mat;
		}
	}

}
