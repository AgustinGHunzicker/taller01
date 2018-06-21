package frsf.isi.died.tp.taller04;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import frsf.isi.died.tp.estructuras.Arbol;
import frsf.isi.died.tp.estructuras.ArbolBinarioBusqueda;
import frsf.isi.died.tp.estructuras.ArbolVacio;
import frsf.isi.died.tp.estructuras.Grafo;
import frsf.isi.died.tp.modelo.BibliotecaABB;
import frsf.isi.died.tp.modelo.productos.Libro;
import frsf.isi.died.tp.modelo.productos.MaterialCapacitacion;
import frsf.isi.died.tp.modelo.productos.Video;


public class TestGrafo {

	Grafo<MaterialCapacitacion> grafo;
	private Libro matA;
	private Libro matB;
	private Libro matC;
	private Libro matD;
	private Libro matE;
	private Libro matF;
	
	@Before
	public void init() {
		matA= new Libro(1, "A", 10.0, 20.0, 10);
		matB= new Libro(2, "B", 20.0, 10.0, 10);
		matC= new Libro(3, "C", 30.0, 20.0, 10);
		matD= new Libro(4, "D", 40.0, 30.0, 10);
		matE= new Libro(5, "E", 50.0, 25.0, 10);
		matF= new Libro(6, "F", 60.0, 20.0, 10);
		grafo = new Grafo();
		grafo.addNodo(matA);
		grafo.addNodo(matB);
		grafo.addNodo(matC);
		grafo.addNodo(matD);
		grafo.addNodo(matE);
		grafo.addNodo(matF);
		grafo.conectar(matA, matB);
		grafo.conectar(matA, matC);
		grafo.conectar(matC, matB);
		grafo.conectar(matC, matF);
		grafo.conectar(matB, matF);
		grafo.conectar(matB, matD);
		grafo.conectar(matD, matE);
		grafo.conectar(matE, matF);
		/*
		 * 
		 *        -> B ------------------> D 
		 *       /   |^ \_                 |
		 *      /    |    \_               |
		 *    A      |      \_             |
		 *      \    |        \          E<|
		 *       \   |         \        /
 	     *        \  |          \      /
         *         \ |           \>   /
 		 *         ->C ----------->F<|
		 * 
		 * 
		 */
		
	}
	
	@Test
	public void testGradoEntrada() {
		assertTrue(grafo.gradoEntrada(matA).equals(0));
		assertTrue(grafo.gradoEntrada(matB).equals(2));
		assertTrue(grafo.gradoEntrada(matC).equals(1));
		assertTrue(grafo.gradoEntrada(matD).equals(1));
		assertTrue(grafo.gradoEntrada(matE).equals(1));
		assertTrue(grafo.gradoEntrada(matF).equals(3));
	}
	
	
	@Test
	public void testGradoSalida() {
		assertTrue(grafo.gradoSalida(matA).equals(2));
		assertTrue(grafo.gradoSalida(matB).equals(2));
		assertTrue(grafo.gradoSalida(matC).equals(2));
		assertTrue(grafo.gradoSalida(matD).equals(1));
		assertTrue(grafo.gradoSalida(matE).equals(1));
		assertTrue(grafo.gradoSalida(matF).equals(0));
	}

	
	
	@Test
	public void primeroGrado1() {
		
		assertTrue(grafo.primerVerticeGradoK(matA,1).getTitulo().equalsIgnoreCase("D"));
	}
	
	@Test
	public void testCaminoEntreAyElongitud3() {
		List<MaterialCapacitacion> mat = grafo.buscarCaminoNSaltos(matA, matB, 3);
		assertTrue(mat.get(0).getTitulo().equalsIgnoreCase("A"));
		assertTrue(mat.get(1).getTitulo().equalsIgnoreCase("B"));
		assertTrue(mat.get(2).getTitulo().equalsIgnoreCase("D"));
		assertTrue(mat.get(3).getTitulo().equalsIgnoreCase("E"));
		
	}

    /* 
	@Test
	public void testCaminoEntreAyElongitud4() {
		List<MaterialCapacitacion> mat = grafo.buscarCaminoNSaltos(matA, matE, 4);
		assertTrue(mat.get(0).getTitulo().equalsIgnoreCase("A"));
		assertTrue(mat.get(1).getTitulo().equalsIgnoreCase("C"));
		assertTrue(mat.get(2).getTitulo().equalsIgnoreCase("B"));
		assertTrue(mat.get(3).getTitulo().equalsIgnoreCase("D"));
		assertTrue(mat.get(4).getTitulo().equalsIgnoreCase("E"));
	}
	*/
	/*
	@Test
 	public void testCaminoEntreAyElongitud5() {
	List<MaterialCapacitacion> mat = grafo.buscarCaminoNSaltos(matA, matE, 5);
    assertTrue(mat.isEmpty());
	}
    */
}