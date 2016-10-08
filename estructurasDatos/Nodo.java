package estructurasDatos;
/**
 * Clase creadora de nodos
 * @param <T>
 */
public class Nodo <T> {
	
	/**
	 * dato dato de tipo T que guarda el nodo
	 * siguiente puntero haciendo referencia al pr�ximo nodo
	 */
	private T dato;
	private Nodo <T>  siguiente;
	
	/**
	 * Constructor del nodo sin par�metros
	 */
	public Nodo(){
		this.dato = null;
		this.siguiente = null;
	}
	
	/**
	 * Constructor del nodo
	 * @param dato dato a guardar en el nodo
	 */
	public Nodo(T dato){
		this.dato = dato;
		this.siguiente = null;
	}

	public T getDato() {
		return dato;
	}

	public void setDato(T dato) {
		this.dato = dato;
	}

	public Nodo<T> getSiguiente() {
		return siguiente;
	}

	public void setSiguiente(Nodo<T> siguiente) {
		this.siguiente = siguiente;
	}
}
