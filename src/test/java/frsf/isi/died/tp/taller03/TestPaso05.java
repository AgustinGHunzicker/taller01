package frsf.isi.died.tp.taller03;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import frsf.isi.died.tp.estructuras.Arbol;
import frsf.isi.died.tp.estructuras.ArbolBinarioBusqueda;
import frsf.isi.died.tp.estructuras.ArbolVacio;
import frsf.isi.died.tp.modelo.Biblioteca;
import frsf.isi.died.tp.modelo.BibliotecaABB;
import frsf.isi.died.tp.modelo.productos.Libro;
import frsf.isi.died.tp.modelo.productos.MaterialCapacitacion;
import frsf.isi.died.tp.modelo.productos.Video;

public class TestPaso05 {

	private ArbolBinarioBusqueda arbolInicio;
	private Libro matA;
	private Libro matC;
	private Libro matX;
	private Libro matB;
	private Libro matZ;
	private Libro matK;
	private Libro matV;
	private Libro matW;
	private Libro matN;
	private Libro matF;
	private Libro matH;
	private Double precioMax;
	private Double precioMin;
	private Comparator<MaterialCapacitacion> comparaPrecio= (mc1,mc2)-> mc1.precio().intValue()- mc2.precio().intValue();
	private List<MaterialCapacitacion> listaObtenida;
	private List<MaterialCapacitacion> listaOriginal;

	@Before
	public void init() {
		matA= new Libro(1, "A", 10.0, 09.0, 10);
		matC= new Libro(2, "C", 20.0, 10.0, 10);
		matX= new Libro(3, "X", 30.0, 11.0, 10);
		matB= new Libro(4, "B", 40.0, 12.0, 10);
		matZ= new Libro(5, "Z", 50.0, 13.0, 10);
		matK= new Libro(6, "K", 60.0, 14.0, 10);
		matV= new Libro(7, "V", 70.0, 15.0, 10);
		matW= new Libro(8, "W", 80.0, 16.0, 10);
		matN= new Libro(9, "N", 90.0, 17.0, 10);
		matF= new Libro(10, "F", 100.0, 18.0, 10);
		matH= new Libro(11, "H", 110.0, 19.0, 10);
		arbolInicio = new ArbolBinarioBusqueda(comparaPrecio);
		precioMin = 30.0;
		precioMax = 107.0;
		listaOriginal = new ArrayList<MaterialCapacitacion>();
		listaObtenida = new ArrayList<MaterialCapacitacion>();

	}
	
	@Test
	public void testRangoPrecios() {
		
		listaOriginal.add(matC);
		listaOriginal.add(matX);
		listaOriginal.add(matB);
		listaOriginal.add(matZ);
		listaOriginal.add(matK);
		listaOriginal.add(matV);
		listaOriginal.add(matW);
		listaOriginal.add(matN);
		
		arbolInicio.add(matW);
		arbolInicio.add(matF);
		arbolInicio.add(matZ);
		arbolInicio.add(matN);
		arbolInicio.add(matA);
		arbolInicio.add(matX);
		arbolInicio.add(matH);
		arbolInicio.add(matV);
		arbolInicio.add(matC);
		arbolInicio.add(matB);
		arbolInicio.add(matK);
		
		listaObtenida = arbolInicio.rango(precioMin, precioMax);
	
		System.out.println(listaOriginal);
		System.out.println(listaObtenida);
		
		assertEquals(listaOriginal,listaObtenida);
		
	}



}