/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frsf.isi.died.tp.estructuras;

import java.util.Objects;

/**
 *
 * @author mdominguez
 */
public class Arista<T> {
	private Vertice<T> inicio;
	private Vertice<T> fin;
	private Number valor;
        
	public Arista(){
		valor=0.0;
	} 
	
	public Arista(Vertice<T> ini,Vertice<T> fin){
		this();
		this.inicio = ini;
		this.fin = fin;
	}

	public Arista(Vertice<T> ini,Vertice<T> fin,Number val){
		this(ini,fin);
		this.valor= val;
	}
	
	public Vertice<T> getInicio() {
		return inicio;
	}
	
	public void setInicio(Vertice<T> inicio) {
		this.inicio = inicio;
	}
	
	public Vertice<T> getFin() {
		return fin;
	}
	
	public void setFin(Vertice<T> fin) {
		this.fin = fin;
	}

	public Number getValor() {
		return valor;
	}

	public void setValor(Number valor) {
		this.valor = valor;
	}
	
	
	@Override
	public String toString() {
		return "( "+this.inicio.getValor()+" --> "+this.fin.getValor()+" )";
	}

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.inicio);
        hash = 29 * hash + Objects.hashCode(this.fin);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Arista<?> other = (Arista<?>) obj;
        if (!Objects.equals(this.inicio, other.inicio)) {
            return false;
        }
        if (!Objects.equals(this.fin, other.fin)) {
            return false;
        }
        return true;
    }
	

}