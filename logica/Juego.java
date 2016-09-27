package logica;

import estructurasDatos.*;
import jugadores.*;

public class Juego {
	private ListaSimple<Jugador> listaJugadores; //Lista para saber los jugadores que han estado en el juego
	private Cola<Jugador>colaEspera; //Cola en caso que ya hayan 4 jugadores físicos conectados
	private ListaSimple<Bot> botConect; //Lista de Bots activos
	private ListaSimple<Fisico>jugadorConect; //Lista que indica cuáles jugadores están actualmente conectados
	private int puerto;
	private int duracion;
	public ListaSimple<Jugador> getListaJugadores() {
		return listaJugadores;
	}
	
	public Cola<Jugador> getColaEspera() {
		return colaEspera;
	}
	
	public ListaSimple<Bot> getBotConect() {
		return botConect;
	}
	
	public ListaSimple<Fisico> getJugadorConect() {
		return jugadorConect;
	}
	
	public int getPuerto() {
		return puerto;
	}
	public void setPuerto (int puerto){
		this.puerto=puerto;
	}
	
	public int getDuracion() {
		return duracion;		
	}
	public void setDuracion(int duracion){
		this.duracion=duracion;
		
	}
	//
	public void insertarJugador(Jugador jugador){
		listaJugadores.insertarFinal(jugador);
					
		
	}
	/*
	public void eliminarJugador(Jugador jugador){
		listaJugadores.
		listaJugadores.eliminar(index);(jugador);
		
	}
	*/
	public void insertarJugadorConect(String name, String IP){
					
			Fisico jugadorNuevo=new Fisico();
			jugadorNuevo.setName(name);
			jugadorNuevo.setIP(IP);
			insertarJugadorConect(jugadorNuevo);
		
	}
	public void insertarJugadorConect(Fisico jugadorNuevo){
		if (jugadorConect.tamano()<5){
			jugadorConect.insertarFinal(jugadorNuevo);	
			jugadorNuevo.setActivo(true);
			insertarJugador(jugadorNuevo);
		}
		else{
			colaEspera.encolar(jugadorNuevo);
		}
		
		
	}
	public void eliminarJugadorConect(Fisico jugador){
		jugadorConect.eliminar(jugador);	
		jugador.setActivo(false);
	}
	public void InsertarBotConect(String nombre){
		Bot jugador= new Bot();
		jugador.setNombre(nombre);
		insertarBotConect(jugador);
		
	}
	
	public void insertarBotConect(Bot jugador){
		botConect.insertarFinal(jugador);
		jugador.setActivo(true);
		insertarJugador(jugador);
		
	}	
	public void eliminarBotConect(Bot jugador){
		botConect.eliminar(jugador);
		jugador.setActivo(false);
	}
	
}
