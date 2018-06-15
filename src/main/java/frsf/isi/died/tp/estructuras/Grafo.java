/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frsf.isi.died.tp.estructuras;

/**
 *
 * @author mdominguez
 */
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Grafo<T> {

	protected List<Arista<T>> aristas;
	protected List<Vertice<T>> vertices;

	/**
	 * 
	 */
	public Grafo(){
		this.aristas = new ArrayList<Arista<T>>();
		this.vertices = new ArrayList<Vertice<T>>();
	}

	/**
	 * @param nodo
	 */
	public void addNodo(T nodo){
		this.addNodo(new Vertice<T>(nodo));
	}

	/**
	 * @param nodo
	 */
	public void addNodo(Vertice<T> nodo){
		this.vertices.add(nodo);
	}
	
	/**
	 * @param n1
	 * @param n2
	 */
	public void conectar(T n1,T n2){
		this.conectar(getNodo(n1), getNodo(n2), 0.0);
	}

        /**
	 * @param nodo1
	 * @param nodo2
	 */
	public Arista<T> conectar(Vertice<T> nodo1,Vertice<T> nodo2){
            Arista<T> arista = new Arista<T>(nodo1,nodo2,0.0);
            this.aristas.add(arista);
            return arista;
	}
        
	/**
	 * @param n1
	 * @param n2
	 * @param valor
	 */
	public void conectar(T n1,T n2,Number valor){
		this.conectar(getNodo(n1), getNodo(n2), valor);
	}

	/**
	 * @param nodo1
	 * @param nodo2
	 * @param valor
	 */
	public void conectar(Vertice<T> nodo1,Vertice<T> nodo2,Number valor){
		this.aristas.add(new Arista<T>(nodo1,nodo2,valor));
	}
	
	/**
	 * @param valor
	 * @return
	 */
	public Vertice<T> getNodo(T valor){
		return this.vertices.get(this.vertices.indexOf(new Vertice<T>(valor)));
	}

	/**
	 * @param valor
	 * @return
	 */
	public List<T> getAdyacentes(T valor){ 
		Vertice<T> unNodo = this.getNodo(valor);
		List<T> salida = new ArrayList<T>();
		for(Arista<T> enlace : this.aristas){
			if( enlace.getInicio().equals(unNodo)){
				salida.add(enlace.getFin().getValor());
			}
		}
		return salida;
	}
	

	/**
	 * @param unNodo
	 * @return
	 */
	protected List<Vertice<T>> getAdyacentes(Vertice<T> unNodo){ 
		List<Vertice<T>> salida = new ArrayList<Vertice<T>>();
		for(Arista<T> enlace : this.aristas){
			if( enlace.getInicio().equals(unNodo)){
				salida.add(enlace.getFin());
			}
		}
		return salida;
	}
                
	/**
	 * 
	 */
	public void imprimirAristas(){
		System.out.println(this.aristas.toString());
	}


        
	/**
	 * @param v1
	 * @param v2
	 * @returnthis.vertices.get(i)
	 */
	protected boolean esAdyacente(Vertice<T> v1,Vertice<T> v2){
            List<Vertice<T>> ady = this.getAdyacentes(v1);
            for(Vertice<T> unAdy : ady){
                if(unAdy.equals(v2)) return true;
            }
            return false;
    }
        
    public Boolean esVacio(){
    	if(this.vertices!= null && !this.vertices.isEmpty()) return false;
    	return true;
    }
    
    public List<T> listaVertices(){
    	List<T> lista = new ArrayList<>();
    	this.vertices.forEach(v -> lista.add(v.getValor()));
    	return lista;
    }

		/**
	 * @param vertice
	 * @return
	 */
	public Integer gradoEntrada(T v){
		Vertice<T> vertice = this.getNodo(v);
		Integer res =0;
		//TODO
		for(int i=0; i<this.aristas.size(); i++) {
			
			if(this.aristas.get(i).getFin().equals(vertice)) { //capaz el errro
				res++;
			}
			
		}
		return res;
	}

	/**
	 * @param vertice
	 * @return
	 */
	public Integer gradoSalida(T v){
		Vertice<T> vertice = this.getNodo(v);
		Integer res =0;
		//TODO
		
		for(int i=0; i<this.aristas.size(); i++) {
			
			if(this.aristas.get(i).getInicio().equals(vertice)) { //capaz el errro
				res++;
			}
			
		}
	
		
		return res;
	}

    public T primerVerticeGradoK(T v,Integer gradoK) {
    	HashSet<Vertice> visitados= new HashSet<>();
    	//TODO

    	
    		if(this.gradoSalida(v).equals(gradoK)) {
    			
    			return v;
    			
    		}
    		
    		else {
    			
    			visitados.add((Vertice)v);
    			
    			List<T> adyacentes = this.getAdyacentes(v);
    			
    			int k = 0;
    			
    			while(k < adyacentes.size()) {
    				
    							
    				if(visitados.contains((Vertice)v) == false) {
    					T verticeEncontrado = this.primerVerticeGradoK( adyacentes.get(k), gradoK, visitados);
        				
        				if( !verticeEncontrado.equals(null)) { //verticeEncontrado != null
        					return  verticeEncontrado;
        				}	
    				}
    				
    			
    				k++;
    			}
    			
    		}

		return null;
    }

    private T primerVerticeGradoK(T v,Integer gradoK, HashSet<Vertice> visitados) {
    
    	if(visitados.contains((Vertice)v) == false) {
    		
    		if(this.gradoSalida(v).equals(gradoK)) {
    			
    			return v;
    			
    		}
    		else {
    			
    			visitados.add((Vertice)v);
    			
    			List<T> adyacentes = this.getAdyacentes(v);
    			
    			int k = 0;
    			
    			while(k<adyacentes.size()) {
    				T verticeEncontrado = this.primerVerticeGradoK( adyacentes.get(k), gradoK, visitados);
    				
    				if( !verticeEncontrado.equals(null) ) {
    					return  verticeEncontrado;
    				}
    				k++;
    			}
    		}
    		return  null;
    		
    	}
    	
    	else {
    		return null;
    	}
	

	
    }
    
    
    
    public boolean existeCamino(T v) {
		Vertice<T> vertice = this.getNodo(v);
    	return true;
    }
    
    
    /**
     * @param n1
     * @param n2
     * @param valor
     */
    public List<T> buscarCaminoNSaltos(T n1,T n2,Integer saltos){
		Vertice<T> origen = this.getNodo(n1);
		Vertice<T> destino= this.getNodo(n2);
        return this.buscarCaminoNSaltos(origen, destino, saltos, new HashSet<Vertice>());
         
    }
    private List<T> buscarCaminoNSaltos(Vertice<T> n1,Vertice<T> n2,Integer saltos,HashSet<Vertice> visitados){
        ArrayList<T> resultado = new ArrayList<>();
       //TODO
        return resultado;
    }

    
  

}
