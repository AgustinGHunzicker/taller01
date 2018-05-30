package frsf.isi.died.tp.util;

/**
 * Clase abstracta que almacena un puntero a un arreglo y ofrece operaciones sobre el mismo
 * @author mdominguez
 *
 */
public abstract class ListasService {
	
	/**
	 * Puntero a un arreglo de elementos que son ordenables
	 */
	protected Ordenable[] arregloOrdenable; 

	public ListasService(Ordenable[] arreglo) {
		this.arregloOrdenable = arreglo;
	}
	
	/**
	 * Metodo que imprime el arreglo ordenable por consola
	 */
	public void imprimir() {
		int i = 0;
		for(Ordenable obj : arregloOrdenable) {
			if(obj!=null) System.out.println("Elemento en posicion "+(++i)+": "+obj);
		}
	}
	
	/**
	 * Metodo que reordena los elementos del arreglo. 
	 * Sera implementado por cada clase hija, con un algortimo particular
	 */
	public abstract void ordenar() ;
	
}
