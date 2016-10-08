/**
 * Clase que genera las estelas del juego
 * @author andre
 */

package org.tec.tarea_programada;

public class Estela extends Objeto{

	/**
	 * Constructor para generar las estelas de cada moto
	 * Las ubicaciones están en 0 porque no se insertan de inmediato en la matriz
	 * @param id ID del Jugador
	 */
	public Estela(String id){
		
		this.siguienteElemento = null;
		this.id = id;
		this.ubicacionX = 0;
		this.ubicacionY = 0;
		
		this.objeto = false;
		this.poder = false;
		this.tipo = "Estela";
	}	
	
	/**
	 * Contructor vacío para la herencia de clases
	 */
	public Estela(){}
	
}
