package frsf.isi.died.tp.modelo.productos;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class VideoTest {
	Video videoTestear;

	@Before
	public void init() {
		videoTestear = new Video(1, "Video 1", 100.0, 200);
	}

	@Test
	public void testPrecio() {
		Double precioEsperado = 100.0 + (200.0 * 0.15);
		Double precioObtenido = videoTestear.precio();
		assertEquals(precioEsperado, precioObtenido);
	}

	@Test
	public void testEsLibro() {
		assertFalse(videoTestear.esLibro());
	}

	@Test
	public void testEsVideo() {
		assertTrue(videoTestear.esVideo());
	}

	@Test
	public void testToString() {
		Double precioEsperado = 100.0 + (200.0 * 0.15);
		String esperado = "[Titulo: Video 1; Precio: " + precioEsperado+"]";
		String obtenido = videoTestear.toString();
		assertEquals(esperado, obtenido);
	}

}
