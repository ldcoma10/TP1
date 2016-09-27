package logica;

import Elementos.*;
import estructurasDatos.*;

public class Moto {
	private int velocidad;
	private int tamEstela;
	private int cantCombustible;
	private Cola<Item> colaItems;
	private Pila<Poder> pilaPoderes;
	
	
	//Falta terminar este constructor
	public Moto(){
		tamEstela=3;
		
	}
	public int getVelocidad() {
		return velocidad;
	}
	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}
	public int getTamEstela() {
		return tamEstela;
	}
	public void setTamEstela(int tamEstela) {
		this.tamEstela = tamEstela;
	}
	public int getCantCombustible() {
		return cantCombustible;
	}
	public void setCantCombustible(int cantCombustible) {
		this.cantCombustible = cantCombustible;
	}
	public void insertarPoder(Poder poder){
		pilaPoderes.push(poder);
	}
	public void eliminarPoder(){
		
	}

}
