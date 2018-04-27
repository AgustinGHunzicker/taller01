package frsf.isi.died.tp.modelo;

import java.util.Arrays;
import java.util.Collection;
import frsf.isi.died.tp.modelo.productos.MaterialCapacitacion;
import frsf.isi.died.tp.util.ListaServiceRadix;




/**
 * Esta clase implementa la interface Biblioteca y todas sus operaciones, gestionando todos los
 * @see MaterialCapacitacion en un arreglo.
 * @author mdominguez
 *
 */
public class BibliotecaArray implements Biblioteca{

	
	// A T R I B U T O S
	
	/**
	 * Arreglo donde se almacenan todos los materiales de capacitacion
	 */
	private MaterialCapacitacion[] materialCapacitacion;
	/**
	 * Variable interna de control que se utiliza para llevar registro de cuantos materiales 
	 * se llevan insertados. Se utiliza para evitar insertar un nuevo material fuera de rango
	 * y tambien para responder la consulta acerca de cuantos materiales hay insertados
	 */
	private Integer cantidadMaterial;
	
	// TODO 12: crear una variable de tipo ListaService que apuntará a una instancia del servicio de operaciones de lista
    private ListaServiceRadix serviceOp;
	
    
    // M E T O D O S -------------------------------------------------------------------------------------
    
	public BibliotecaArray() {
		cantidadMaterial=0;
		this.materialCapacitacion= new MaterialCapacitacion[10];
		// TODO 13: inicializar la variable de tipo ListaService para que apunte el servicio de operaciones de listas		
	    this.serviceOp = new ListaServiceRadix(this.materialCapacitacion); 
	}
    
	/**
	 * Si cantidadMaterial (cantidad de materiales insertados) es menor al tamano del arreglo,
	 * entonces agrego en la posicion siguiente al ultimo material insertado, el nuevo material.
	 * Fijarse que el Material (por ejemplo) numero 9 estara en la posicion 8, entonces solo
	 * debo insertar el proximo en el indice que es igual a la cantidad actual de materiales insertados.
	 */
	@Override
	public void agregar(MaterialCapacitacion material) {
		// TODO 06: se agrega un material al arreglo de materiales de capacitacion si hay espacio en el arreglo
		// caso contrario el metodo no agrega ningun elemento y termina su ejecución
		if(materialCapacitacion.length > cantidadMaterial) {
			materialCapacitacion[cantidadMaterial] = material;
			cantidadMaterial++;
		}
	}
 

	
	@Override
	public Integer cantidadMateriales() {
		// TODO 07: retorna la cantidad de materiales que hay ingresados en el sistema
		return cantidadMaterial;
	}


	@Override
	public Integer cantidadLibros() {
		// TODO 08: retorna la cantidad de libros registrados en el sistema.
		// No se puede usar para este método el operador "instanceOf" ni realizar ningun tipo de casting.
		Integer libros = 0;
		for(int i=0; i < cantidadMaterial; i++) {
			if(materialCapacitacion[i].esLibro()) libros++;
		}
		return libros;
	}


	@Override
	public Integer cantidadVideos() {
		// TODO 09: retorna la cantidad de videos registrados en el sistema. 
		// No se puede usar para este método el operador "instanceOf" ni realizar ningun tipo de casting. 
		Integer videos = 0;
		for(int i=0; i < cantidadMaterial; i++) {
			if(materialCapacitacion[i].esVideo()) videos++;
		}
		return videos;
	}

	@Override
	public void imprimir() {		
		//TODO 14: invocar al método imprimir de la variable de tipo ListaService para que imprima el arreglo
		this.serviceOp.imprimir();
	}
		

	@Override
	public void ordenarPorPrecio(Boolean b) {
		// TODO 15: invocar al metodo ordenar de la variable de tipo ListaService para que ordene el arreglo 
		this.serviceOp.ordenar();
	}


	@Override
	public Collection<MaterialCapacitacion> materiales() {
		return Arrays.asList(this.materialCapacitacion);
	}

	@Override 
	public MaterialCapacitacion buscar(Integer precio) {
		// TODO Auto-generated method stub
		return null;
		}

}
