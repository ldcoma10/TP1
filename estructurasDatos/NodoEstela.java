package org.tec.tarea_programada.objetos;

public class NodoEstela extends NodoObjeto{
	
	protected NodoEstela cola;
	protected NodoEstela lugarEnMapa;
	
	public NodoEstela(){
		this.objeto = false;
		this.poder = false;
		this.tipo = "Estela";
		this.cola = null;
		this.lugarEnMapa = null;
	}	
	
}
