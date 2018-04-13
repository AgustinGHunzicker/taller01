package frsf.isi.died.tp.util;

/**
 * Servicio de operaciones sobre listas que ordena una lista siguiendo el
 * algoritmo Radix Sort - ordenamiento por residuos
 * 
 * Ejemplo ordenar el siguiente arreglo {315,601,385,218} 
 * En la primer iteracion ordeno por unidad por lo que la matriz "residuos" tendra la siguiente estructura 
 *  residuos= [ 
 *              [null...null], // i=0 
 *              [601,...null], // i=1
 *              [null...null], // i=2 
 *              [null...null], // i=3 
 *              [null...null], // i=4
 *              [315,385...null], // i=5 
 *              [null...null], // i=6 
 *              [null...null], // i=7
 *              [218...null], // i=8 
 *              [null...null], // i=9 
 *            ] 
 *
 * Luego se reordena el arreglo ordenable de segun aparecen los valores en la matriz 
 *  arregloOrdenable =  * {601,315,385,218}
 *
 * En la primer iteracion ordeno por DECENA por lo que la matriz "residuos" tendra la siguiente estructura 
 *  residuos= [ 
 *              [601...null], // i=0 
 *              [315,218,...null], // i=1
 *              [null...null], // i=2 
 *              [null...null], // i=3 
 *              [null...null], // i=4
 *              [null,..null], // i=5 
 *              [null...null], // i=6 
 *              [null...null], // i=7
 *              [385...null], // i=8 
 *              [null...null], // i=9 
 *            ] 
 * Luego se  reordena el arreglo ordenable de segun aparecen los valores en la matriz
 * arregloOrdenable = {601,315,218,385}
 * 
 * En la primer iteracion ordeno por CENTENA por lo que la matriz "residuos" tendra la siguiente estructura 
 *  residuos= [ 
 *              [null...null], // i=0 
 *              [null,...null], // i=1
 *              [218,...,null], // i=2 
 *              [315,385,null], // i=3 
 *              [null...null], // i=4
 *              [null,..null], // i=5 
 *              [601...null], // i=6 
 *              [null...null], // i=7
 *              [null...null], // i=8 
 *              [null...null], // i=9 
 *            ] 
 * Luego se  reordena el arreglo ordenable de segun aparecen los valores en la matriz
 * arregloOrdenable = {218,315,385,601} y el arreglo está finalmente ordenado
 * 
 * @author mdominguez
 *
 */
public class ListaServiceRadix extends ListasService {

	/**
	 * Matriz de 10 x 10 que permite almacenar en cada indice el elemento ordenable
	 * asociado al residuo.
	 */

	private Ordenable[][] residuos = new Ordenable[10][10];
	
	/**
	 * Arreglo auxiliar que en cada iteracion nos indica la cantidad de elementos que hay en cada fila de la matriz residuos.
	 * Se utiliza para no iterar y acceder fuera del rango del arreglo.
	 */
	private int[] cantidadPorFila = new int[10];

	public ListaServiceRadix(Ordenable[] arr) {
		super(arr);
	}

	@Override
	public void ordenar() {

		for (int i = 0; i < 5; i++) {
			// calcular la base de la posicion actual
			// para la unidad es 1, para la decena 10, para la centena 100
			// asi el numero 237 se puede descomponer en 2*100 + 3*10 + 7* 1
			int peso = (int) Math.pow(10.0, i);

			for (Ordenable mat : this.arregloOrdenable) {
				// TODO 11: IMPLEMENTAR el ALGORITMO que chequea el residuo 
				// e inserta el elemento en la posicion de la matriz de residuos
				// e incrementa el contador en cantidadPorFila en 1
	            if(mat != null) {
				int aux;
				aux = (((int)(mat.valor() / peso))%10);
				residuos[aux][cantidadPorFila[aux]] = mat;
				cantidadPorFila[aux]++;
	            }
			}
			int indiceArregloOrdenado = 0;
			for (int j = 0; j < 10; j++) {
				for (int k = 1; k <= cantidadPorFila[j]; k++) {
					this.arregloOrdenable[indiceArregloOrdenado++] = residuos[j][k - 1];
				}
				// reiniciar el contador
				cantidadPorFila[j] = 0;
			}
		}
	}

}
