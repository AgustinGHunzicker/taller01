/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frsf.isi.died.tp.modelo.productos;
import frsf.isi.died.tp.util.Ordenable;

/**
 * Integrantes: Gonzales Agustin, Bernhardt Milton
 * Enlace github: https://github.com/AgustinGHunzicker/taller01.git
 *  
 */
/**
 * Representa de manera abstracta los materiales de capacitación
 * 
 * @author mdominguez
 */
public abstract class MaterialCapacitacion implements Ordenable {
	
	// A T R I B U T O S
	
	protected Integer id;
	/**
	 * Titulo del material
	 */
	protected String titulo;

	/**
	 * Costo básico que debe sumarse al precio por el mero hecho de publicarlo en el
	 * portal
	 */
	protected Double costo;
	

	// M E T O D O S ---------------------------------------------------------------------------
	
	
	/**
	 * Constructor por defecto
	 */
	public MaterialCapacitacion() {
		this(0,"en desarrollo",0.0);
	}

	/**
	 * Constructor que recibe como argumento un ID y un Titulo
	 * 
	 * @param id
	 * @param titulo
	 */
	public MaterialCapacitacion(Integer id, String titulo) {
		this(id,titulo,0.0);
	}

	/**
	 * Constructor que recibe como argumento un ID y un costo
	 * 
	 * @param id
	 * @param titulo
	 */
	public MaterialCapacitacion(Integer id,String titulo, Double costo) {
		this.id =id;
		this.titulo = titulo;
		this.costo = costo;
	}


	//TODO 01 implementar los metodos getters y setters y escribir el javadoc
	// AYUDA: para implementar estos metodos usar un atajo del IDE 
	// elegir el menu "Source" --> "Generate getters y setters" y elegir alli que metodos generar.
	
	
	/**
	 * Retorna el id del Material de Capacitacion
	 * @return
	 */
	public Integer getId() {
		return id;
	}
    
	/**
	 * Establece el id a un Material de Capacitacion 
	 */
	public void setId(Integer id) {
		this.id = id;
	}
    
	/**
	 * Retorna el Titulo del Material de Capacitacion
	 * @return
	 */
	public String getTitulo() {
		return titulo;
	}
    
	/**
	 * Establece el Titulo a un Material de Capacitacion 
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
    
	/**
	 * Retorna el Costo del Material de Capacitacion
	 * @return
	 */
	public Double getCosto() {
		return costo;
	}
    
	/**
	 * Establece el Costo Base a un Material de Capacitacion 
	 */
	public void setCosto(Double costo) {
		this.costo = costo;
	}
	
	/**
	 * El precio de un material se define según el tipo del material y toma como
	 * base el costo del mismo
	 * 
	 * @return
	 */
	public abstract Double precio();
	

	/**
	 * Retorna verdadero si es una instancia de libro, falso en caso contrario
	 * @return
	 */
	public abstract Boolean esLibro();

	/**
	 * Retorna verdadero si es una instancia de video, falso en caso contrario
	 * @return
	 */
	public abstract Boolean esVideo();
	
	//TODO 02: sobrescribir el metodo toString de la clase "Object"
	//	el método toString retorna un string que representa el material actual
	//  retornando el titulo, y el precio 	 * usando el formato : 
	// [Titulo: <titulo> ; Precio: <precio> ]
	
	/**
	 * Metodo toString sobreescrito, el cual retorna una en una String
	 * el titulo y precio de un Material de Capacitacion
	 * @return
	 */
	public String toString() {
		String materialActual = "[Titulo: "+this.titulo+"; Precio: "+this.precio()+"]";
	    return materialActual;
	}
	
	/**
	 * Estamos invocando un metodo abstracto y funciona, debido a que es invocado
	 * por la clase abstracta que lo define como abstracto, MaterialCapaciticacion.
	 */
	
	// TODO 10: implementar Ordenable
	public final int valor() {
		double aux = (double)this.precio();
		int valor = (int)aux;
		return valor;
	}

	  @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MaterialCapacitacion other = (MaterialCapacitacion) obj;
		if (titulo == null) {
			if (other.titulo != null)
				return false;
		} else if (!titulo.equals(other.titulo))
			return false;
		return true;
	}
	
	
	/**
	 * compara dos objetos segun el tamanio de su titulo, si es igual compara por su precio.
	 * Si el objeto this es mas grande retorna -1
	 * Si el objeto parametro es mas grande retorna 1
	 * Si son iguales en titulo y precio retorna 0
	 * @param objeto
	 * @return
	 */
	 public int compareTo(MaterialCapacitacion objeto) {
		 if(this.titulo.compareTo(objeto.titulo) > 0){
		    return 1;
		 }
		 else {
		       if(this.titulo.compareTo(objeto.titulo) == 0){
		    	  if((this.precio()).doubleValue() > (objeto.precio()).doubleValue()){
		    	     return 1;
		    	   }
		           else {
		    		    if((this.precio()).doubleValue() == (objeto.precio()).doubleValue()) {
		    			   return 0;
		    		     }
		    		     else {
		    		    	   return -1;
		    		          }
		    	       }
		        }
		       else{
		    	   return -1;
		       }
		 }
		
	 }
	 
	 
	 
}
		

