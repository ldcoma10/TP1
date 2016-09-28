package org.tec.tarea_programada.objetos;

import java.util.Random;;

public class NodoObjeto {
	protected boolean objeto;
	protected boolean poder;
	protected String tipo;
	
	public NodoObjeto(){
		
	}
	
	public NodoObjeto(boolean objeto, boolean poder, String tipo){
		this.objeto = objeto;
		this.poder = poder;
		this.tipo = tipo;
		this.objetos = null;
	}
	
	public final NodoObjeto crearObjeto(){
		
		Random rand = new Random();
		int randomObjecto = rand.nextInt(3);
		int randomTipo = rand.nextInt(2);
		
		NodoObjeto nuevoObjeto = null;
		
		if (randomObjecto == 0){
			if (randomTipo == 0){
				nuevoObjeto = new NodoObjeto(true, false, "Celda de combustible");
			} else if (randomTipo == 1){
				nuevoObjeto = new NodoObjeto(true, false, "Crecimiento de estela");
			}
			
		} else if (randomObjecto == 1){
			if (randomTipo == 0){
				nuevoObjeto = new NodoObjeto(false, true, "Escudo");
			} else if (randomTipo == 1){
				nuevoObjeto = new NodoObjeto(false, true, "Hiper velocidad");
			}
			
		} else if (randomObjecto == 2){
			nuevoObjeto = new NodoObjeto(false, false, "Bomba");
			
		}
		
		return nuevoObjeto;

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
