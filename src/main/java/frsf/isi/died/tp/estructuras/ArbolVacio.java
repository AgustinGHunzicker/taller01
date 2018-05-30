package frsf.isi.died.tp.estructuras;

import frsf.isi.died.tp.modelo.productos.MaterialCapacitacion;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class ArbolVacio extends Arbol {

    public ArbolVacio() {    }

    @Override
    public boolean esVacio() {
        return true;
    }

    @Override
    public Arbol izquierdo() {
        return new ArbolVacio();
    }

    @Override
    public Arbol derecho() {
        return new ArbolVacio();
    }

    @Override
    public boolean contiene(MaterialCapacitacion unValor) {
        return false;
    }

    @Override
    public boolean equals(Arbol unArbol) {
        return unArbol.esVacio();
    }

    @Override
    public Integer profundidad() {
        return 0;
    }

    @Override
    public void add(MaterialCapacitacion mat) {
        // no hace nada
    }
    
	@Override
	public void imprimir() {
	}

    
    @Override
    public List<MaterialCapacitacion> preOrden(){
        return new ArrayList<MaterialCapacitacion>();
    }    
    
    @Override
    public List<MaterialCapacitacion> inOrden(){
        return new ArrayList<MaterialCapacitacion>();
    }

    @Override
	public List<MaterialCapacitacion> postOrden() {
		return new ArrayList<>();
	}

	@Override
	public Integer tamanio() {
		return 0;
	}

	@Override
	public Integer tamanioLibros() {
		return 0;
	}

	@Override
	public Integer tamanioVideos() {
		return 0;
	}
	
	@Override
	public MaterialCapacitacion buscar(Integer precio1){
        return null;
    }

    @Override
    public List<MaterialCapacitacion> rango(Double precio1, Double precio2) {
        return new ArrayList<MaterialCapacitacion>();
    }
    


}