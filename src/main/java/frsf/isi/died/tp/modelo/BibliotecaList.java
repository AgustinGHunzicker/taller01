package frsf.isi.died.tp.modelo;
import java.util.*;

import frsf.isi.died.tp.modelo.productos.*;
public class BibliotecaList implements Biblioteca {
	
	// A T R I B U T O 
	private ArrayList<MaterialCapacitacion> materiales;
	
	
	// M E T O D O S --------------------------------------------------------------
	public BibliotecaList() {
		this.materiales = new ArrayList<>();
		}
	
	public void agregar(MaterialCapacitacion mat){
		this.materiales.add(mat);
	}
	
	public Integer cantidadMateriales() {
		return this.materiales.size();
	}
	
	public Integer cantidadLibros() {
		int tamanio = (this.materiales).size();
		Integer cantLibros = 0;
		for(int i=0; i < tamanio; i++) {
			if(this.materiales.get(i) instanceof Libro) {
				cantLibros++;
			}

		}
		return cantLibros;
	}
	
	public Integer cantidadVideos() {
		int tamanio = (this.materiales).size();
		Integer cantVideos = 0;
		for(int i=0; i < tamanio; i++) {
			if(this.materiales.get(i) instanceof Video) {
				cantVideos++;
			}

		}
		return cantVideos;
	}
	
	public Collection<MaterialCapacitacion> materiales(){
		return this.materiales;
		}
	 
	public void imprimir() {
		int tamanio = (this.materiales).size();
		for(int i=0; i < tamanio; i++) {
			System.out.println(this.materiales.get(i));
		}
	}
	
	
	/**
	 * Cuando b = false ordena alfabeticamente, si b = true lo ordena por precio
	 * @param b
	 */
	public void ordenarPorPrecio(Boolean b) {
		if(b == false) {
		
			Collections.sort((List<MaterialCapacitacion>)this.materiales,compararNombreMateriales);
			for(int i=0; i<this.materiales.size();i++) {
				System.out.println(this.materiales.get(i).getTitulo());
			}
				
		}
		else {
			Collections.sort((List<MaterialCapacitacion>)this.materiales,compararPrecioMateriales);
		}
	}
	
	
	/*
	 * comparador segun el titulo del MaterialCapacitacion	
	 */
	Comparator<MaterialCapacitacion> compararNombreMateriales = new Comparator<MaterialCapacitacion>() {
		   @Override
		   public int compare(MaterialCapacitacion o1, MaterialCapacitacion o2) {
		       if(o1.getTitulo().compareTo(o1.getTitulo())<0){
		    	   return 1;
		       }
		       else {
		    	   
		    	   if(o1.getTitulo().compareTo(o1.getTitulo())>0) {
		    		   return -1;
		    	   }
		    	   else {
		    		   return 0;
		    	   }
		    	   
		       }
		   }
		};
	
		/*
		 * comparador segun el precio del MaterialCapacitacion	
		 */
	Comparator<MaterialCapacitacion> compararPrecioMateriales = new Comparator<MaterialCapacitacion>() {
		   @Override
		   public int compare(MaterialCapacitacion o1, MaterialCapacitacion o2) {
		       if(o1.precio().doubleValue() > o2.precio().doubleValue()){
		    	   return 1;
		       }
		       else {
		    	   
		    	   if(o1.precio().doubleValue() < o2.precio().doubleValue()) {
		    		   return -1;
		    	   }
		    	   else {
		    		   return 0;
		    	   }
		    	   
		       }
		   }
		};
		
			
	/*
	 * comparador segun el costo del MaterialCapacitacion	
	 */
	Comparator<MaterialCapacitacion> compararCostoMateriales = new Comparator<MaterialCapacitacion>() {
			@Override
			public int compare(MaterialCapacitacion o1, MaterialCapacitacion o2) {
			if(o1.getCosto().doubleValue() > o2.getCosto().doubleValue()){
			   return 1;
			     }
			else {
			    	   
			    if(o1.getCosto().doubleValue() < o2.getCosto().doubleValue()) {
			    	return -1;
			    }
			    
			    else {
			    	return 0;
			    }
  
			}
		}
		};
	
	/*
	 * busca segun el costo el material de capacitacion primero igual al costo 
	 * pasado como parametro (precio)
	 * @see frsf.isi.died.tp.modelo.Biblioteca#buscar(java.lang.Integer)
	 */
	@Override
	public MaterialCapacitacion buscar(Integer precio) {
		int fin = this.materiales.size();
		int inicio = 0;
		this.ordenarPorPrecio(true);
		return buscadorBinario(inicio, fin, precio);
	}
	
	
	/**
	 * busca el parametro costo en el ArrayList, y los parametros inicio y fin marcan los indices 
	 * extremos del ArrayList
	 * @param inicio
	 * @param fin
	 * @param costo
	 * @return
	 */
	private MaterialCapacitacion buscadorBinario(Integer inicio, Integer fin,Integer costo){
		Integer mitad = ((inicio + fin)/2);
		if ((inicio >= fin) && (((materiales.get(inicio)).getCosto()).intValue() != (int)costo)){
			throw new RuntimeException("Material de precio " + costo + " no encontrado");
			}
		else if ((((materiales.get(mitad)).getCosto()).intValue()) == (int)costo){
				return materiales.get(mitad);
			    }
		else if ((((materiales.get(mitad)).getCosto()).intValue() < (int)costo)){
					return buscadorBinario (mitad+1, fin, costo);
				}
		
		
	    return buscadorBinario (inicio,mitad,costo);
      }
	
	}

