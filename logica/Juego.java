package logica;

import estructurasDatos.*;
import jugadores.*;

public class Juego {
	/**
	 * listaJugadores Lista para saber los jugadores que han estado en el juego
	 * colaEspera Cola en caso que ya hayan 4 jugadores físicos conectados
	 * botConect Lista de Bots activos
	 * jugadorConect Lista que indica cuáles jugadores están actualmente conectados
	 * puerto puerto donde está el servidor
	 * duracion duracion de la partida
	 * getListaJugadores historial de jugadores
	 */
	private ListaSimple<Jugador> listaJugadores; 
	private Cola<Jugador>colaEspera; 
	private ListaSimple<Bot> botConect; 
	private ListaSimple<Fisico>jugadorConect;
	private int puerto;
	private int duracion;
	
	/**
	 * Constructor
	 */
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
	/**
	 * Método que inserta jugador en el historial
	 */
	public void insertarJugador(Jugador jugador){
		listaJugadores.insertarFinal(jugador);
	}
	
	/*
	public void eliminarJugador(Jugador jugador){
		listaJugadores.
		listaJugadores.eliminar(index);(jugador);
		
	}*/
	
	/**
	 * 
	 */
	public void insertarJugadorConect(String name, String IP){
					
			Fisico jugadorNuevo=new Fisico();
			jugadorNuevo.setName(name);
			jugadorNuevo.setIP(IP);
			insertarJugadorConect(jugadorNuevo);
		
	}
	
	/**
	 * 
	 */
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
	
	/**
	 * Método que elimina a un jugador de la partida
	 */
	public void eliminarJugadorConect(Fisico jugador){
		jugadorConect.eliminar(jugador);	
		jugador.setActivo(false);
	}
	
	/**
	 * Método que inserta a un bot
	 * @param nombre nombre del bot
	 */
	public void InsertarBotConect(String nombre){
		Bot jugador= new Bot();
		jugador.setNombre(nombre);
		insertarBotConect(jugador);
		
	}
	
	/**
	 * 
	 * @param jugador
	 */
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
