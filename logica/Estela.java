package org.tec.tarea_programada;

public class Estela{

	public String id;
	public Estela siguienteEstela;
	public int ubicacionX;
	public int ubicacionY;
	
	public Estela(String id){

		this.id = id;
		this.siguienteEstela = null;
		this.ubicacionX = 0;
		this.ubicacionY = 0;
	}	
	
	public Estela(){}
	
}
