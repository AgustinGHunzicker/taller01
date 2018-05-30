package frsf.isi.died.tp.modelo.productos;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class LibroTest {

	Libro libroTestear;
	
	@Before
	public void init() {
		libroTestear = new Libro(1, "Libro 1", 100.0, 200.0, 151);
	}
	
	@Test
	public void testPrecio() {
		Double precioEsperado = 100.0 + (200.0 * 1.03);
		Double precioObtenido = libroTestear.precio();
		assertEquals(precioEsperado, precioObtenido);
	}

	@Test
	public void testEsLibro() {
		assertTrue(libroTestear.esLibro());
	}

	@Test
	public void testEsVideo() {
		assertFalse(libroTestear.esVideo());
	}

	@Test
	public void testToString() {
		Double precioEsperado = 100.0 + (200.0 * 1.03);
		String esperado = "[Titulo: Libro 1; Precio: "+precioEsperado+"]";
		String obtenido = libroTestear.toString();
		assertEquals(esperado, obtenido);
	}

}
