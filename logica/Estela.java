package logica;

import elementos.Objeto;

public class Estela extends Objeto{
	
	protected Estela cola;
	protected Estela lugarEnMapa;
	
	public Estela(){
		this.objeto = false;
		this.poder = false;
		this.tipo = "Estela";
		this.cola = null;
		this.lugarEnMapa = null;
	}	
	
}
