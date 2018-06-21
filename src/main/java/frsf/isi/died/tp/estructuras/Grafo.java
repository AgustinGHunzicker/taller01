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
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Grafo<T> {

	protected List<Arista<T>> aristas;
	protected List<Vertice<T>> vertices;

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

	/**
	 * Retorna v, si posee gradoK de salida o
	 * pasa los parametros aVisitar, gradoK, visitados, agregados al metodo "primerK"
	 * @param v
	 * @param gradoK
	 * @return
	 */
    public T primerVerticeGradoK(T v,Integer gradoK) {
    	HashSet<T> visitados=new HashSet<>();
    	HashSet<T> agregados=new HashSet<>();
    	if(this.gradoSalida(v).intValue() == gradoK.intValue()) {
    		return v;
    	}
    	else {
    		Queue<T> aVisitar = new LinkedList<T>();   //Cola en anchura del Grafo para recorrer
        	visitados.add(v);
    		aVisitar.addAll(this.getAdyacentes(v));
        	int k = gradoK.intValue();
        	return primerK(aVisitar, k, visitados,agregados);	   //Llama a la recursion
    	}
    	
    }
     /**
      * retorna el nodo con gradoK de salidas, si no existe dicho nodo retorna NULL
      * @param aVisitar    nodos ordenado en forma de ANCHURA del grafo A VISITAR
      * @param gradoK      grado de SALIDA que se busca
      * @param visitados   nodos ya visitados
      * @param agregados   nodos a visitar ya agregados en la cola (evita repetidos)
      * @return
      */
    private T primerK(Queue<T> aVisitar,int gradoK,HashSet<T> visitados,HashSet<T> agregados) {
    	Queue<T> colaAux = new LinkedList(); //para ver si tendremos que ver en sus adyacentes o si ya se busco
    	T nodoAux;
    	if((nodoAux = aVisitar.poll())==null) return null;
    	else {
    	if(this.gradoSalida(nodoAux).intValue() == gradoK) {
    		return nodoAux;
    	}
    	else {
    		visitados.add(nodoAux);
    		colaAux.addAll(this.getAdyacentes(nodoAux)); 
    		while((nodoAux = colaAux.poll())!=null) {
    			if(!visitados.contains(nodoAux)&&!agregados.contains(nodoAux)) {
    				aVisitar.add(nodoAux); //verifico si ese adyacente ya no fue visitado
    			}
    		}
    		return primerK(aVisitar,gradoK,visitados,agregados);
    	}
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
		Vertice<T> origen=this.getNodo(n1);
		Vertice<T> destino=this.getNodo(n2);
		List<T> resultado = new ArrayList<>();
        resultado=this.buscarCaminoNSaltos(origen, destino, saltos, new HashSet<Vertice>());
        if(!resultado.isEmpty())resultado.add(n1);
        Collections.reverse(resultado);
        return resultado;
    }
    private List<T> buscarCaminoNSaltos(Vertice<T> n1,Vertice<T> n2,Integer saltos,HashSet<Vertice> visitados){
        ArrayList<T> resultado = new ArrayList<>();
        List<T> adyacentes = new ArrayList<>();
        adyacentes = this.getAdyacentes(n1.getValor());
        visitados.add(n1);
        if(saltos.intValue() == 1 && this.getAdyacentes(n1.getValor()).contains(n2.getValor())) {
        	resultado.add(n2.getValor());
        	visitados.clear();
        	return resultado;
        	}
        if(saltos.intValue()==1) {
        	visitados.clear();
        	return resultado;
        }
        
        for(T aux : adyacentes) {
        	if(!visitados.contains(this.getNodo(aux))) {
        		ArrayList<T> resulta2 = new ArrayList<>();
        		resulta2.addAll(buscarCaminoNSaltos(this.getNodo(aux),n2,(saltos-1),visitados));
        		if(!resulta2.isEmpty())resulta2.add(aux);
        		resultado.addAll(resulta2);
        	}
        }
        return resultado;        
    
   }
}


