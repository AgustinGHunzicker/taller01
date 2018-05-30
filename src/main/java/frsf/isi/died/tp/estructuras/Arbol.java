package frsf.isi.died.tp.estructuras;

import java.util.List;
import frsf.isi.died.tp.modelo.productos.MaterialCapacitacion;
import java.util.Comparator;

public abstract class Arbol {

	public abstract boolean esVacio();

	public abstract void add(MaterialCapacitacion mat);

	public abstract Arbol izquierdo();

	public abstract Arbol derecho();
	
	public abstract boolean contiene(MaterialCapacitacion unValor);

	public abstract boolean equals(Arbol unArbol);

	public abstract Integer profundidad();
	
	public abstract void imprimir();

	/**
	 * Imprime el �rbol in orden (izquierdo,raiz,derecho)
	 */
	public abstract List<MaterialCapacitacion> inOrden();
	/**
	 * Imprime en pre orden el �rbol (raiz, izquierdo, derecho)
	 */
	public abstract List<MaterialCapacitacion> preOrden();
	/**
	 * Imprime el �rbol en pos orden (izquierdo,derecho,raiz)
	 */
	public abstract List<MaterialCapacitacion> postOrden();

	/**
	 * Retorna la cantidad de nodos del �rbol
	 */
	public abstract Integer tamanio();
	/**
	 * Retorna la cantidad de nodos del �rbol que son libros
	 */
	public abstract Integer tamanioLibros();
	/**
	 * Retorna la cantidad de nodos del �rbol que son videos
	 */
	public abstract Integer tamanioVideos();

	/**
	 * Este m�todo busca el nodo que almacena un MaterialCapacitacion, cuyo precio se
	 * corresponda con el par�metro recibido. Si es as� retorna la instancia de
	 * MaterialCapacitacion. 
	 * @param precio1
	 * @return
	 */
	public abstract MaterialCapacitacion buscar(Integer precio1);
	
	/**
	 * Este m�todo busca todos los nodos cuyo precio
es mayor o igual que el precio minimo y menor o igual que el precio m�ximo, y almacena todas
las instancias de MaterialCapacitacion que cumplen con esta condici�n en una lista que ser� la
que retorna como resultado del m�todo
	 * @param precioMin
	 * @param precioMax
	 * @return
	 */
	public abstract List<MaterialCapacitacion> rango(Double precioMin, Double precioMax);
}