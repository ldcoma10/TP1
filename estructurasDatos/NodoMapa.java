/**
 * coordenadaX: coordanada que tiene
 */
package org.tec.tarea_programada;

public class NodoMapa <T> {
		
	public T dato;
	public NodoMapa<T> arriba;
	public NodoMapa<T> abajo;
	public NodoMapa<T> izquierda;
	public NodoMapa<T> derecha;
	public int coordenadaY;
	public int coordenadaX;
	
	public NodoMapa(T dato, int i, int j) {
		this.dato = dato;
		this.arriba = null;
		this.abajo = null;
		this.izquierda = null;
		this.derecha = null;
		this.coordenadaY = i;
		this.coordenadaX = j;
	}
	
	public NodoMapa(int i, int j){
		this.dato = null;
		this.arriba = null;
		this.abajo = null;
		this.izquierda = null;
		this.derecha = null;
		this.coordenadaY = i;
		this.coordenadaX = j;		
	}

}
