package elementos;

import java.util.Random;

import estructurasDatos.NodoMapa;
import patronesDeDiseno.*;
/**
 * Clase que crea los items y poderes y contiene los atributos m�s importantes de los elemenos a heredar
 * @author andre
 *
 */
@SuppressWarnings("unchecked")
public class Objeto {   
	
	/**
	 *  id Identificaci�n del objeto, �nica para cada moto y su estela. Los objetos llevan un id de 0
	 */
	public String id;
	public Estela siguienteElemento;
	
	public int ubicacionX;
	public int ubicacionY;
	
	public boolean objeto;
	public boolean poder;
	public String tipo;
	
	public int duracion;
	public int masVelocidad;

	/**
	 * Contructor sin par�metros para las clases a heredar
	 */
	public Objeto(){}
	
	/**
 	 * Constructor de objetos o poderes que los coloca autom�ticamente en el mapa
 	 * @param verdad valor para diferenciar el constructor de objetos del que usan las clases heredadas
	 */
	public Objeto(boolean verdad) {
		
		this.id = "0";
		this.siguienteElemento = null;
		this.duracion = 0;
		this.masVelocidad = 0;
		
		Random rand = new Random();
		int randomObjecto = rand.nextInt(3);
		int randomTipo = rand.nextInt(2);
		
		if (randomObjecto == 0){      //En caso de asignar un 0 a randomObjeto pasa a evaluar si ser� combustible o poder de estela de manera random
			if (randomTipo == 0){
				this.objeto = true;
				this.poder = false;
				this.tipo = "Celda de combustible";
			} else if (randomTipo == 1){
				this.objeto = true;
				this.poder = false;
				this.tipo = "Crecimiento de estela";
			}
			
		} else if (randomObjecto == 1){ //En caso de resultar la asignaci�n de 1 a randomObjeto, las posibilades ser�n de ser escudo o hipervelocidad
			if (randomTipo == 0){
				this.objeto = false;
				this.poder = true;
				this.tipo = "Escudo";
			} else if (randomTipo == 1){
				this.objeto = false;
				this.poder = true;
				this.tipo = "Hiper velocidad";
			}
			
		} else if (randomObjecto == 2){   //Finalmente, si randomObjeto toma el valor 2, ser� una bomba
			this.objeto = false;
			this.poder = false;
			this.tipo = "Bomba";
		}
		
		this.posicionadorObjeto();
	}
	
	/**
	 * M�todo que coloca el objeto en el mapa
	 */
	public final void posicionadorObjeto(){
		
		Random rand = new Random();		
		int randomX = (rand.nextInt(TamanoMapa.getAncho()) + 1);
		int randomY = (rand.nextInt(TamanoMapa.getAlto()) + 1);
		
		this.ubicacionX = randomX;
		this.ubicacionY = randomY;
		
		NodoMapa<Objeto> ubicar = (NodoMapa<Objeto>) this.buscarNodo(randomX, randomY);
		
		if (ubicar.dato == null){
			ubicar.dato = this;
		} else {
			this.posicionadorObjeto();
		}
		
	}

	/**
	 * M�todo para encontrar qu� nodo se encuentra en una posici�n dada
	 * @param x posici�n horizontal
	 * @param y posici�n vertical
	 * @return el NodoMapa que se encuentra en esa posici�n
	 */
	public NodoMapa<?> buscarNodo(int x, int y){
		
		NodoMapa<?> nodoEncontrado = (NodoMapa<?>) PosicionCero.getCabezaPrincipal();
		
		for (int linea = 1; linea < x; linea ++){
			nodoEncontrado = nodoEncontrado.derecha;
		}
		
		for (int columna = 1; columna < y; columna ++){
			nodoEncontrado = nodoEncontrado.abajo;
		}		
		
		return nodoEncontrado;
	}
	
	public boolean isObjeto() {
		return objeto;
	}

	public boolean isPoder() {
		return poder;
	}

	public String getTipo() {
		return tipo;
	}

}
