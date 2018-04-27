package frsf.isi.died.tp.modelo;
import java.util.*;
import frsf.isi.died.tp.modelo.productos.*;
public class BibliotecaList {
	// Atributo
	private ArrayList<MaterialCapacitacion> materiales;
	
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
		if(!b) {
			Collections.sort((List)this.materiales);
		}
		else {
			Collections.sort((List<MaterialCapacitacion>)this.materiales,compararPrecioMateriales);
		}
	}
	
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

		
}
