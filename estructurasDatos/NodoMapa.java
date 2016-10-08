package estructurasDatos;

/**
 * Clase que define los nodos que compondr�n el mapa del juego
 * @author andre
 *
 * @param <T> tipo de dato del que se compondr� los nodos
 */
public class NodoMapa <T> {
		
	/**
	 * dato dato que contiene el nodo
	 * arriba enlace al nodo que est� arriba
	 * abajo enlace al nodo que est� abajo
	 * iquierda enlace al nodo que est� en la izquierda
	 * derecha enlace al nodo que est� en la derecha
	 * coordenadaY posici�n vertical del mapa
	 * coordenadaX posici�n horizontal del mapa
	 */
	public T dato;
	public NodoMapa<T> arriba;
	public NodoMapa<T> abajo;
	public NodoMapa<T> izquierda;
	public NodoMapa<T> derecha;
	public int coordenadaY;
	public int coordenadaX;

	/**
	 * Constructor del nodo
	 * @param i posici�n hotizontal del mapa
	 * @param j posici�n vertical del mapa
	 */
	public NodoMapa(int i, int j){
		this.dato = null;
		this.arriba = null;
		this.abajo = null;
		this.izquierda = null;
		this.derecha = null;
		this.coordenadaY = i;
		this.coordenadaX = j;		
	}

	/**
	 * Constructor del nodo
	 * @param dato dato que almacena
	 */
	public NodoMapa(T dato2) {
		// TODO Auto-generated constructor stub
	}
		
	/**
	 * Contructor
	 */
	public NodoMapa() {
		
	}

}
