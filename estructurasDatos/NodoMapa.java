package org.tec.tarea_programada.matriz;

public class NodoMapa <T> {
		
	private T dato;
	private NodoMapa<T> arriba;
	private NodoMapa<T> abajo;
	private NodoMapa<T> izquierda;
	private NodoMapa<T> derecha;
	private int coordenadaY;
	private int coordenadaX;
	
	public NodoMapa(T dato, int i, int j) {
		this.dato = dato;
		this.arriba = null;
		this.abajo = null;
		this.izquierda = null;
		this.derecha = null;
		this.coordenadaY = i;
		this.coordenadaX = j;
	}

	public NodoMapa<T> getArriba() {
		return arriba;
	}

	public void setArriba(NodoMapa<T> arriba) {
		this.arriba = arriba;
	}

	public NodoMapa<T> getAbajo() {
		return abajo;
	}

	public void setAbajo(NodoMapa<T> abajo) {
		this.abajo = abajo;
	}

	public NodoMapa<T> getIzquierda() {
		return izquierda;
	}

	public void setIzquierda(NodoMapa<T> izquierda) {
		this.izquierda = izquierda;
	}

	public NodoMapa<T> getDerecha() {
		return derecha;
	}

	public void setDerecha(NodoMapa<T> derecha) {
		this.derecha = derecha;
	}

	public int getI() {
		return coordenadaY;
	}

	public int getJ() {
		return coordenadaX;
	}

	public T getDato() {
		return dato;
	}

	public void setDato(T dato) {
		this.dato = dato;
	}
	
	

}
