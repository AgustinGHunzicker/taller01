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
	 * Imprime el árbol in orden (izquierdo,raiz,derecho)
	 */
	public abstract List<MaterialCapacitacion> inOrden();
	/**
	 * Imprime en pre orden el árbol (raiz, izquierdo, derecho)
	 */
	public abstract List<MaterialCapacitacion> preOrden();
	/**
	 * Imprime el árbol en pos orden (izquierdo,derecho,raiz)
	 */
	public abstract List<MaterialCapacitacion> postOrden();

	/**
	 * Retorna la cantidad de nodos del árbol
	 */
	public abstract Integer tamanio();
	/**
	 * Retorna la cantidad de nodos del árbol que son libros
	 */
	public abstract Integer tamanioLibros();
	/**
	 * Retorna la cantidad de nodos del árbol que son videos
	 */
	public abstract Integer tamanioVideos();

	/**
	 * Este método busca el nodo que almacena un MaterialCapacitacion, cuyo precio se
	 * corresponda con el parámetro recibido. Si es así retorna la instancia de
	 * MaterialCapacitacion. 
	 * @param precio1
	 * @return
	 */
	public abstract MaterialCapacitacion buscar(Integer precio1);
	
	/**
	 * Este método busca todos los nodos cuyo precio
es mayor o igual que el precio minimo y menor o igual que el precio máximo, y almacena todas
las instancias de MaterialCapacitacion que cumplen con esta condición en una lista que será la
que retorna como resultado del método
	 * @param precioMin
	 * @param precioMax
	 * @return
	 */
	public abstract List<MaterialCapacitacion> rango(Double precioMin, Double precioMax);
}