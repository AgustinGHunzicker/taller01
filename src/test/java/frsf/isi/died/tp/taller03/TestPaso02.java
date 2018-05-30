package frsf.isi.died.tp.taller03;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import frsf.isi.died.tp.estructuras.Arbol;
import frsf.isi.died.tp.estructuras.ArbolBinarioBusqueda;
import frsf.isi.died.tp.estructuras.ArbolVacio;
import frsf.isi.died.tp.modelo.BibliotecaABB;
import frsf.isi.died.tp.modelo.productos.Libro;
import frsf.isi.died.tp.modelo.productos.MaterialCapacitacion;
import frsf.isi.died.tp.modelo.productos.Video;

public class TestPaso02 {

	Arbol arbol;
	private Libro matA;
	private Libro matC;
	private Libro matX;
	private Libro matB;
	private Libro matZ;
	private Libro matK;
	private Video matV;
	private Video matW;
	private Video matN;
	private Video matF;
	private Video matH;
	@Before
	public void init() {
		matA= new Libro(1, "A", 10.0, 20.0, 10);
		matC= new Libro(2, "C", 20.0, 10.0, 10);
		matX= new Libro(3, "X", 30.0, 20.0, 10);
		matB= new Libro(4, "B", 40.0, 30.0, 10);
		matZ= new Libro(5, "Z", 50.0, 25.0, 10);
		matK= new Libro(6, "K", 60.0, 20.0, 10);
		matV= new Video(7, "V", 70.0, 10);
		matW= new Video(8, "W", 80.0, 10);
		matN= new Video(9, "N", 30.0, 10);
		matF= new Video(10, "F", 40.0, 10);
		matH= new Video(11, "H", 50.0, 10);
		arbol = new ArbolVacio();

	}
	
	@Test
	public void testEsVacio() {
		assertTrue(arbol.esVacio());
		arbol = new ArbolBinarioBusqueda(matZ,(mc1,mc2)->mc1.getTitulo().compareTo(mc2.getTitulo()));
		assertFalse(arbol.esVacio());
	}


	@Test
	public void testContiene() {
		arbol = new ArbolBinarioBusqueda(matZ,(mc1,mc2)->mc1.getTitulo().compareTo(mc2.getTitulo()));
		assertTrue(arbol.contiene(matZ));
		arbol.add(matA);
		arbol.add(matN);
		arbol.add(matZ);
		arbol.add(matH);
		assertFalse(arbol.contiene(matB));
		assertTrue(arbol.contiene(matZ));
	}

	@Test
	public void testProfundidad() {
		int prof= arbol.profundidad();
		assertEquals(prof,0);

		arbol = new ArbolBinarioBusqueda(matN,(mc1,mc2)->mc1.getTitulo().compareTo(mc2.getTitulo()));

		prof= arbol.profundidad();
		assertEquals(prof,1);
		
		arbol.add(matB);
		prof= arbol.profundidad();		
		assertEquals(2,prof);
		
		arbol.add(matZ);
		prof= arbol.profundidad();		
		assertEquals(2,prof);

		arbol.add(matA);
		prof= arbol.profundidad();		
		assertEquals(3,prof);

		arbol.add(matC);
		prof= arbol.profundidad();		
		assertEquals(3,prof);

		arbol.add(matF);
		prof= arbol.profundidad();		
		assertEquals(4,prof);
	}

	@Test
	public void testInOrden() {
	
		/**
		 *                  H
		 *                /   \
		 *               C     V
		 *              / \   / \ 
		 *             A   F K   Z
		 *                       /
		 *                      W 
		 */		
		arbol = new ArbolBinarioBusqueda(matH,(mc1,mc2)->mc1.getTitulo().compareTo(mc2.getTitulo()));
		arbol.add(matV);
		arbol.add(matZ);
		arbol.add(matK);
		arbol.add(matW);
		arbol.add(matC);
		arbol.add(matA);
		arbol.add(matF);		
		int prof= arbol.profundidad();
		assertEquals(prof,4);

		List<MaterialCapacitacion> listaInorden = arbol.inOrden();
		assertEquals("A",listaInorden.get(0).getTitulo());
		assertEquals("C",listaInorden.get(1).getTitulo());
		assertEquals("F",listaInorden.get(2).getTitulo());
		assertEquals("H",listaInorden.get(3).getTitulo());
		assertEquals("K",listaInorden.get(4).getTitulo());
		assertEquals("V",listaInorden.get(5).getTitulo());
		assertEquals("W",listaInorden.get(6).getTitulo());
		assertEquals("Z",listaInorden.get(7).getTitulo());
	}

	@Test
	public void testPreOrden() {
		/**
		 *                  H
		 *                /   \
		 *               C     V
		 *              / \   / \ 
		 *             A   F K   Z
		 *                       /
		 *                      W 
		 */

		arbol = new ArbolBinarioBusqueda(matH,(mc1,mc2)->mc1.getTitulo().compareTo(mc2.getTitulo()));
		arbol.add(matV);
		arbol.add(matZ);
		arbol.add(matK);
		arbol.add(matW);
		arbol.add(matC);
		arbol.add(matA);
		arbol.add(matF);		
		int prof= arbol.profundidad();
		assertEquals(4,prof);
		
		List<MaterialCapacitacion> listaInorden = arbol.preOrden();
		assertEquals("H",listaInorden.get(0).getTitulo());
		assertEquals("C",listaInorden.get(1).getTitulo());
		assertEquals("A",listaInorden.get(2).getTitulo());
		assertEquals("F",listaInorden.get(3).getTitulo());
		assertEquals("V",listaInorden.get(4).getTitulo());
		assertEquals("K",listaInorden.get(5).getTitulo());
		assertEquals("Z",listaInorden.get(6).getTitulo());
		assertEquals("W",listaInorden.get(7).getTitulo());
	}

	@Ignore
	public void testPostOrden() {
		/**
		 *                  H
		 *                /   \
		 *               C     V
		 *              / \   / \ 
		 *             A   F K   Z
		 *                       /
		 *                      W 
		 */

		arbol = new ArbolBinarioBusqueda(matH,(mc1,mc2)->mc1.getTitulo().compareTo(mc2.getTitulo()));
		arbol.add(matV);
		arbol.add(matZ);
		arbol.add(matK);
		arbol.add(matW);
		arbol.add(matC);
		arbol.add(matA);
		arbol.add(matF);		
		int prof= arbol.profundidad();
		assertEquals(4,prof);
		
		List<MaterialCapacitacion> listaPostOrden = arbol.postOrden();
		assertEquals("A",listaPostOrden.get(0).getTitulo());
		assertEquals("F",listaPostOrden.get(1).getTitulo());
		assertEquals("C",listaPostOrden.get(2).getTitulo());
		assertEquals("K",listaPostOrden.get(3).getTitulo());
		assertEquals("W",listaPostOrden.get(4).getTitulo());
		assertEquals("Z",listaPostOrden.get(5).getTitulo());
		assertEquals("V",listaPostOrden.get(6).getTitulo());
		assertEquals("H",listaPostOrden.get(7).getTitulo());	

	}

	@Test
	public void testTamanio() {
		arbol = new ArbolBinarioBusqueda(matH,(mc1,mc2)->mc1.getTitulo().compareTo(mc2.getTitulo()));
		arbol.add(matV);
		arbol.add(matZ);
		arbol.add(matK);
		arbol.add(matW);
		arbol.add(matC);
		arbol.add(matA);
		arbol.add(matF);		
		int cantMat = arbol.tamanio();
		assertEquals(8,cantMat);
	}

	@Test
	public void testTamanioLibros() {
		arbol = new ArbolBinarioBusqueda(matH,(mc1,mc2)->mc1.getTitulo().compareTo(mc2.getTitulo()));
		arbol.add(matV);
		arbol.add(matZ);
		arbol.add(matK);
		arbol.add(matW);
		arbol.add(matC);
		arbol.add(matA);
		arbol.add(matF);		
		int libros= arbol.tamanioLibros();
		assertEquals(4,libros);
	}

	@Test
	public void testTamanioVideos() {
		arbol = new ArbolBinarioBusqueda(matH,(mc1,mc2)->mc1.getTitulo().compareTo(mc2.getTitulo()));
		arbol.add(matV);
		arbol.add(matZ);
		arbol.add(matK);
		arbol.add(matW);
		arbol.add(matC);
		arbol.add(matA);
		arbol.add(matF);		
		int videos = arbol.tamanioVideos();
		assertEquals(4,videos);
		arbol.add(matX);		
		videos = arbol.tamanioVideos();
		assertEquals(4,videos);
		arbol.add(matN);		
		videos = arbol.tamanioVideos();
		assertEquals(5,videos);
	}

}