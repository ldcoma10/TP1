package org.tec.tarea_programada;

public class Estela{
	
	public String id;
	public Estela siguienteEstela;
	public NodoMapa<?> lugarEnMapa;
	
	public Estela(String id){

		this.id = id;
		this.siguienteEstela = null;
		this.lugarEnMapa = null;
	}	
	
	public Estela(){}
	
}
