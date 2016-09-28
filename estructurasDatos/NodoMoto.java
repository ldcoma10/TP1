package org.tec.tarea_programada.objetos;

import java.util.Random;

public class NodoMoto extends NodoEstela{
	
	public int velocidad;
	private int combustible;
	private Cola<Item> colaItems;
	private Pila<Poder> colaPoderes;
	
	public NodoMoto(String tipo){
		Random rand = new Random();
		int randomVelocidad = (rand.nextInt(11) + 1);
	
		this.tipo = tipo;
		this.velocidad = randomVelocidad;
		this.setCombustible(100);
		this.setListaItems(null);
		this.listaPoderes = null;
	}

	public int getCombustible() {
		return combustible;
	}

	public void setCombustible(int combustible) {
		this.combustible = combustible;
	}

	public NodoObjeto getColaItems() {
		return colaItems;
	}

	public void setColaItems(NodoObjeto colaItems) {
		this.colaItems = colaItems;
	}
	
	public boolean verificarSiguienteMovimiento(){
		boolean validez = false;
		//Falta codigo
		return validez;
	}
	
	public void consumirPoder(){
		
	}
	
	public void consumirItem(){
		
	}
	
	public void agregarPoder(){
		
	}
	
	public void moverDerecha(){
		
	}
	
	public void moverIzquierda(){
		
	}
	
	public void moverArriba(){
		
	}
	
	public void moverAbajo(){
		
	}
	
}
