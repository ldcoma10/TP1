package logica;

import java.util.Random;

import elementos.Objeto;
import estructurasDatos.Cola;
import estructurasDatos.Pila;

public class Moto extends Estela{
	
	public int velocidad;
	private int combustible;
	private Cola<Objeto> colaItems;
	private Pila<Objeto> pilaPoderes;
	
	public Moto(String tipo){
		Random rand = new Random();
		int randomVelocidad = (rand.nextInt(11) + 1);
	
		this.tipo = tipo;
		this.velocidad = randomVelocidad;
		this.setCombustible(100);
		this.colaItems=null;
		this.pilaPoderes = null;
	}

	public int getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}

	public Pila<Objeto> getPilaPoderes() {
		return pilaPoderes;
	}

	public void setPilaPoderes(Pila<Objeto> pilaPoderes) {
		this.pilaPoderes = pilaPoderes;
	}

	public int getCombustible() {
		return combustible;
	}

	public void setCombustible(int combustible) {
		this.combustible = combustible;
	}

	public Cola<Objeto> getColaItems() {
		return colaItems;
	}

	public void setColaItems(Cola<Objeto> colaItems) {
		this.colaItems = colaItems;
	}
	
	public boolean verificarSiguienteMovimiento(){
		boolean validez = false;
		//Falta codigo
		return validez;
	}
	
	public void consumirPoder(){
		
	}
	
	public void consumirItem(){
		
	}
	
	public void agregarPoder(){
		
	}
	
	public void moverDerecha(){
		
	}
	
	public void moverIzquierda(){
		
	}
	
	public void moverArriba(){
		
	}
	
	public void moverAbajo(){
		
	}
	
}
