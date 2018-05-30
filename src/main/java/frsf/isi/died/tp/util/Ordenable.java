package frsf.isi.died.tp.util;

/**
 * Interface que permite obtener valores para ordenar elementos
 * @author mdominguez
 *
 */
public interface Ordenable {

	/**
	 * Retorna un valor entero que será utilizado por un servicio de ordenamiento de listas
	 * @return ordenable
	 */
	public int valor();
}
