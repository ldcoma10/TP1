package elementos;

import java.util.Random;

import estructurasDatos.*;
import patronesDeDiseno.PosicionCero;

/**
 * Clase que genera las motos del juego
 * @author andre
 */
@SuppressWarnings("unchecked")
public class Moto extends Estela{
	
	/**
	 * escudo lo hace inmortal si es true
	 * vida muestra si el jugador puede seguirse moviendo o no
	 * velocidad es un número aleatorio que indica que tan rápido de mueve la moto
	 * combustible indica el combustible que le queda a la moto para moverse
	 * nombre es como se identifica el jugador
	 * contadorDePasos hace que cada 5 movimientos se disminuya en 1 el combustible
	 * colaItems es una lista con los items que se han recogido y se devolverán al mapa cuando muera este jugador (solo crecimiento estela se devuelve ya que la gasolina se consume)
	 * pilaPoderes es una lista con los poderes almacenados, estos se pueden mover arriba o abajo y se consume el primero. 
	 */
	public boolean escudo;
	public boolean vida;
	public int velocidad;
	public int combustible;
	public String nombre;
	public int contadorDePasos;
	public Cola<Objeto> colaItems;
	public Pila<Objeto> pilaPoderes;
	
	/**
	 * Constructor de la moto. Genera 3 estelas automáticamente
	 * @param nombre Nombre del jugador
	 * @param x posición de derecha a izquierda
	 * @param y posición de arriba a abajo
	 */

	public Moto(String nombre, int x, int y){
		
		Random rand = new Random();
		int randomVelocidad = (rand.nextInt(10) + 1);
		int randomID = (rand.nextInt(100) + 1);
		
		this.velocidad = randomVelocidad;
		this.id = String.valueOf(randomID);
		
		this.combustible = 100;
		this.contadorDePasos = 0;
		this.nombre = nombre;
		this.vida = true;
		this.escudo = false;
		
		this.objeto = false;
		this.poder = false;
		this.tipo = "Moto";
		
		this.ubicacionX = x;
		this.ubicacionY = y;
		
		this.siguienteElemento = new Estela(this.id);
		
		Estela actual = this.siguienteElemento;
		
		for (int contadorEstela = 0; contadorEstela < 2; contadorEstela ++){
			actual.siguienteElemento = new Estela(this.id);
			actual = actual.siguienteElemento;
		}
		
		NodoMapa<Objeto> nuevo = (NodoMapa<Objeto>) this.buscarNodo(ubicacionX, ubicacionY);
		nuevo.dato = this;
	}

	/**
	 * Método que verifica que no haya ningún objeto inválido que le genere la muerte
	 * Si hay un objeto lo ejecute y si es un poder lo agrega a la lista
	 * @param nodoMapa Siguiente nodo en el que estará la moto después de moverse
	 * @return False si choca contra algo que lo mate
	 * Existe la oportunidad de usar un escudo para evitar morir por falta de gasolina y en ese tiempo obtener una celda de combustible para salvarse (Intencional)
	 */
	public boolean verificarSiguienteMovimiento(NodoMapa<Objeto> nodoMapa){
		boolean validez = false;
		
		if ((nodoMapa.dato == null || nodoMapa.dato.id == this.id) && this.combustible > 0){
			validez = true;
			
		}  else if ((nodoMapa.dato.poder == true || nodoMapa.dato.objeto == true) && this.combustible > 0){
			
			Random rand = new Random();
			int randomValor = (rand.nextInt(10) + 1);
			
			switch (nodoMapa.dato.tipo){
			
			case "Crecimiento de Estela":
				Objeto punteroSiguiente = (Objeto) this;
				crecimientoEstela(randomValor, punteroSiguiente);
				colaItems.encolar(nodoMapa.dato);
			
			case "Celda de Combustible":
				celdaDeCombustible(randomValor);
				
			case "Escudo":
				nodoMapa.dato.duracion = randomValor;
				pilaPoderes.push(nodoMapa.dato);
				
			case "Hiper Velocidad":
				nodoMapa.dato.duracion = randomValor;
				nodoMapa.dato.masVelocidad = rand.nextInt(10) + 1;
				pilaPoderes.push(nodoMapa.dato);
			}
			
			nodoMapa.dato.ubicacionX = 0;
			nodoMapa.dato.ubicacionY = 0;
			
		} else {
			
			if (this.escudo == true){
				validez = true;
			}
		}
		
		return validez;
	}
	
	/**
	 * Método que rellena el tanque de combustible de la moto
	 * @param cantidadCombustible cantidad de combustible a rellenar
	 */
	public void celdaDeCombustible(int cantidadCombustible){
		this.combustible += cantidadCombustible;
		if (this.combustible > 100){
			this.combustible = 100;
		}
	}
	
	/**
	 * Método que agrega estela a una moto
	 * @param cantidadEstela cantidad que va a aumentar la estela
	 * @param punteroSiguiente moto a la que se le va a agregar la estela
	 */
	public void crecimientoEstela(int cantidadEstela, Objeto punteroSiguiente){
		while (punteroSiguiente.siguienteElemento != null) {
			punteroSiguiente = punteroSiguiente.siguienteElemento;
		}
		for (int contador = 0; contador < cantidadEstela; contador ++){
			punteroSiguiente.siguienteElemento = new Estela(this.id);
			punteroSiguiente = punteroSiguiente.siguienteElemento;
		}
	}
	
	/**
	 * Método que consume el primer poder de la cola
	 */
	public void consumirPoder(){
		switch (pilaPoderes.getTope().getDato().tipo){
		
		case "Escudo":
			this.escudo = true;
			int tiempo1 = pilaPoderes.getTope().getDato().duracion * 1000;
	       
			try {
	            wait(tiempo1);
	        } catch (Exception e) {}
			
			this.escudo = false;
			
		case "Hiper Velocidad":
			this.velocidad += pilaPoderes.getTope().getDato().masVelocidad;
			int tiempo2 = pilaPoderes.getTope().getDato().duracion * 1000;
			
	        try {
	            wait(tiempo2);
	        } catch (Exception e) {}
			
			this.velocidad -= pilaPoderes.getTope().getDato().masVelocidad;
		}
		
		pilaPoderes.pop();
	}
	
	/**
	 * Método para moverse al este del mapa
	 */
	public void moverDerecha(){
		if (this.vida == true){

			NodoMapa<Objeto> siguienteNodo = (NodoMapa<Objeto>) this.buscarNodo(ubicacionX, ubicacionY).derecha;
			
			if (this.verificarSiguienteMovimiento(siguienteNodo) == true){
				this.mover(siguienteNodo.coordenadaX, siguienteNodo.coordenadaY);
			} else {
				eliminarMoto(this.ubicacionX, this.ubicacionY);
			}
		}
	}
	
	/**
	 * Método para moverse al oeste del mapa
	 */
	public void moverIzquierda(){
		if (this.vida == true){

			NodoMapa<Objeto> siguienteNodo = (NodoMapa<Objeto>) this.buscarNodo(ubicacionX, ubicacionY).izquierda;
			
			if (this.verificarSiguienteMovimiento(siguienteNodo) == true){
				this.mover(siguienteNodo.coordenadaX, siguienteNodo.coordenadaY);
			} else {
				eliminarMoto(this.ubicacionX, this.ubicacionY);
			}
		}
	}
	
	/**
	 * Método para moverse al norte del mapa
	 */
	public void moverArriba(){
		if (this.vida == true){

			NodoMapa<Objeto> siguienteNodo = (NodoMapa<Objeto>) this.buscarNodo(ubicacionX, ubicacionY).arriba;
			
			if (this.verificarSiguienteMovimiento(siguienteNodo) == true){
				this.mover(siguienteNodo.coordenadaX, siguienteNodo.coordenadaY);
			} else {
				eliminarMoto(this.ubicacionX, this.ubicacionY);
			}
		}
	}
	
	/**
	 * Método para moverse al sur del mapa
	 */
	public void moverAbajo(){
		if (this.vida == true){

			NodoMapa<Objeto> siguienteNodo = (NodoMapa<Objeto>) this.buscarNodo(ubicacionX, ubicacionY).abajo;
			
			if (this.verificarSiguienteMovimiento(siguienteNodo) == true){
				this.mover(siguienteNodo.coordenadaX, siguienteNodo.coordenadaY);
			} else {
				eliminarMoto(this.ubicacionX, this.ubicacionY);
			}
		}
	}
	
	/**
	 * Método para moverse al siguiente nodo
	 * @param siguienteX es la próxima posición horizontal en la que estará la moto
	 * @param siguienteY es la próxima posición vertical en la que estará la moto
	 */
	public void mover(int siguienteX, int siguienteY){
		
		NodoMapa<Objeto> siguiente = (NodoMapa<Objeto>) this.buscarNodo(siguienteX, siguienteY);
		NodoMapa<Objeto> actual = (NodoMapa<Objeto>) this.buscarNodo(this.ubicacionX, this.ubicacionY);
		
		while (actual.dato.siguienteElemento != null){
			siguiente.dato = actual.dato;
			
			siguiente.dato.ubicacionX = siguiente.coordenadaX;
			siguiente.dato.ubicacionY = siguiente.coordenadaY;
			
			siguiente = actual;
			actual = (NodoMapa<Objeto>) this.buscarNodo(actual.dato.siguienteElemento.ubicacionX, actual.dato.siguienteElemento.ubicacionY);
			
			if (actual == PosicionCero.getCabezaPrincipal()){
				siguiente.dato = siguiente.dato.siguienteElemento;
				siguiente.dato.ubicacionX = siguiente.coordenadaX;
				siguiente.dato.ubicacionY = siguiente.coordenadaY;
				break;
			}
		} 
		
		if (actual != PosicionCero.getCabezaPrincipal()){
			siguiente.dato = actual.dato;
			actual.dato = null;
		}		
		
		this.contadorDePasos ++;
		
		if (this.contadorDePasos >= 5){
			this.combustible --;
			this.contadorDePasos = 0;
		}
	}
	
	
	/**
	 * Método que desvilcula el mapa de la moto al borrarla en todo nodo que se encuentre. También pone la vida en false para inhabilitarla
	 * @param x posición horizontal de la moto
	 * @param y posición vertical de la moto
	 */
	public void eliminarMoto(int x, int y){
		NodoMapa<Moto> jugadorActual = (NodoMapa<Moto>) buscarNodo(x, y);
		
		while (jugadorActual.dato.pilaPoderes.esVacia() != true){
			
			jugadorActual.dato.pilaPoderes.getTope().getDato().posicionadorObjeto();
			jugadorActual.dato.pilaPoderes.pop();
		}
		
		while (jugadorActual.dato.colaItems.esVacia() != true){
			jugadorActual.dato.colaItems.getInicio().getDato().posicionadorObjeto();			
			jugadorActual.dato.colaItems.desencolar();
		}
		
		NodoMapa<Objeto> actual = (NodoMapa<Objeto>) buscarNodo(x, y);
		NodoMapa<Objeto> borrar = actual;
		
		
		while (actual.dato != null){
			actual = (NodoMapa<Objeto>) buscarNodo(actual.dato.siguienteElemento.ubicacionX, actual.dato.siguienteElemento.ubicacionY);
			borrar.dato = null;
			borrar = actual;
		}
		this.vida = false;
	}
	
}
