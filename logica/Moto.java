package org.tec.tarea_programada;

import java.util.Random;

public class Moto extends Estela{
	
	public boolean vida;
	public int velocidad;
	public int combustible;
	public String nombre;
	public NodoMapa<Estela> cabezaPrincipal;
	
	public Moto(String id, String nombre, int x, int y, NodoMapa<Estela> cabezaPrincipal){
		
		Random rand = new Random();
		int randomVelocidad = (rand.nextInt(11) + 1);
	
		this.velocidad = randomVelocidad;
		this.combustible = 100;
		this.id = id;
		this.nombre = nombre;
		this.cabezaPrincipal = cabezaPrincipal;
		this.vida = true;
		
		this.ubicacionX = x;
		this.ubicacionY = y;
		
		this.siguienteEstela = new Estela(this.id);
		
		Estela actual = this.siguienteEstela;
		
		for (int contadorEstela = 0; contadorEstela < 3; contadorEstela ++){
			actual.siguienteEstela = new Estela(this.id);
			actual = actual.siguienteEstela;
		}
	}


	public boolean verificarSiguienteMovimiento(NodoMapa<Estela> nodoMapa){
		boolean validez = false;
		
		if (nodoMapa.dato == null){
			validez = true;
			
		}  else {
			
			try {
				if (nodoMapa.dato.id == this.id){
					validez = true;
				}
			} catch (Exception e){}
		}
		
		return validez;
	}
	
	public void moverDerecha(){
		if (this.vida == true){

			NodoMapa<Estela> siguienteNodo = this.buscarNodo(ubicacionX, ubicacionY).derecha;
			
			if (this.verificarSiguienteMovimiento(siguienteNodo) == true){
				this.mover(siguienteNodo.coordenadaX, siguienteNodo.coordenadaY);
			} else {
				eliminarMoto(this.ubicacionX, this.ubicacionY);
			}
		}
	}
	
	public void moverIzquierda(){
		if (this.vida == true){

			NodoMapa<Estela> siguienteNodo = this.buscarNodo(ubicacionX, ubicacionY).izquierda;
			
			if (this.verificarSiguienteMovimiento(siguienteNodo) == true){
				this.mover(siguienteNodo.coordenadaX, siguienteNodo.coordenadaY);
			} else {
				eliminarMoto(this.ubicacionX, this.ubicacionY);
			}
		}
	}
	
	public void moverArriba(){
		if (this.vida == true){

			NodoMapa<Estela> siguienteNodo = this.buscarNodo(ubicacionX, ubicacionY).arriba;
			
			if (this.verificarSiguienteMovimiento(siguienteNodo) == true){
				this.mover(siguienteNodo.coordenadaX, siguienteNodo.coordenadaY);
			} else {
				eliminarMoto(this.ubicacionX, this.ubicacionY);
			}
		}
	}
	
	public void moverAbajo(){
		if (this.vida == true){

			NodoMapa<Estela> siguienteNodo = this.buscarNodo(ubicacionX, ubicacionY).abajo;
			
			if (this.verificarSiguienteMovimiento(siguienteNodo) == true){
				this.mover(siguienteNodo.coordenadaX, siguienteNodo.coordenadaY);
			} else {
				eliminarMoto(this.ubicacionX, this.ubicacionY);
			}
		}
	}
	
	public void mover(int siguienteX, int siguienteY){
		
		NodoMapa<Estela> siguiente = this.buscarNodo(siguienteX, siguienteY);
		NodoMapa<Estela> actual = this.buscarNodo(this.ubicacionX, this.ubicacionY);
		
		while (actual.dato.siguienteEstela != null){
			siguiente.dato = actual.dato;
			
			siguiente.dato.ubicacionX = siguiente.coordenadaX;
			siguiente.dato.ubicacionY = siguiente.coordenadaY;
			
			siguiente = actual;
			actual = this.buscarNodo(actual.dato.siguienteEstela.ubicacionX, actual.dato.siguienteEstela.ubicacionY);
			
			if (actual == this.cabezaPrincipal){
				siguiente.dato = siguiente.dato.siguienteEstela;
				break;
			}
		} 
		
		if (actual != this.cabezaPrincipal){
			siguiente.dato = actual.dato;
			actual.dato = null;
		}		
		
	}
	
	public NodoMapa<Estela> buscarNodo(int x, int y){
		
		NodoMapa<Estela> nodoEncontrado = cabezaPrincipal;
		
		for (int linea = 1; linea < x; linea ++){
			nodoEncontrado = nodoEncontrado.derecha;
		}
		
		for (int columna = 1; columna < y; columna ++){
			nodoEncontrado = nodoEncontrado.abajo;
		}		
		
		return nodoEncontrado;
	}
	
	public void eliminarMoto(int x, int y){
		NodoMapa<Estela> actual = buscarNodo(x, y);
		NodoMapa<Estela> borrar = actual;
		
		while (actual.dato != null){
			actual = buscarNodo(actual.dato.siguienteEstela.ubicacionX, actual.dato.siguienteEstela.ubicacionY);
			borrar.dato = null;
			borrar = actual;
		}
		this.vida = false;
		this.cabezaPrincipal = null;
	}
	
}
