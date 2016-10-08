package estructurasDatos;

/**
 * Clase de lista pila
 * @param <T>
 */
public class Pila <T> {
	
	/**
	 * Puntero del primer nodo
	 */
	private Nodo<T> tope;
	
	public Nodo<T> getTope() {
		return tope;
	}
	
	public void setTope(Nodo<T> tope) {
		this.tope = tope;
	}
	
	/**
	 * Método que verifica si la lista es vacía
	 * @return true si está vacía la lista
	 */
	public boolean esVacia(){
		return tope == null;
	}
	
	/**
	 * Método que crea un nodo
	 * @param dato dato que contiene el nodo a crear
	 */
	public void push (T dato){
		push (new Nodo<T>(dato));
	}
	
	/**
	 * Método que añade un nodo a la lista
	 * @param nodo nodo a agregar a la lista en la parte de atrás
	 */
	public void push(Nodo <T> nodo){
		if (esVacia()){
			setTope(nodo);
		} else{
			nodo.setSiguiente(tope);			
			tope = nodo;			
		}		
	}
	
	/**
	 * Método que elimina el primer nodo de la lista
	 */
	public void pop(){
		
		if (!esVacia()){
			tope = tope.getSiguiente();		
		} else{
			System.err.println("No se pudo eliminar, ya que la pila está vacía");
		}
	}
	
	/**
	 * Método que modifica el dato del primer nodo con el dato de nodo de entrada
	 * @param Nodo nodo que contiene el dato a modificar
	 */
	public void modificarTope(Nodo<T> Nodo){
		modificarTope(Nodo.getDato());
	}
	
	/**
	 * Método que modifica el dato que contiene el primer nodo
	 * @param dato
	 */
	public void modificarTope(T dato){
		if (!esVacia()){
			tope.setDato(dato);		
		} else{
			System.err.println("No se pudo modificar, ya que la pila está vacía");
		}
	}	
}
