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
	 * M�todo que verifica si la lista es vac�a
	 * @return true si est� vac�a la lista
	 */
	public boolean esVacia(){
		return tope == null;
	}
	
	/**
	 * M�todo que crea un nodo
	 * @param dato dato que contiene el nodo a crear
	 */
	public void push (T dato){
		push (new Nodo<T>(dato));
	}
	
	/**
	 * M�todo que a�ade un nodo a la lista
	 * @param nodo nodo a agregar a la lista en la parte de atr�s
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
	 * M�todo que elimina el primer nodo de la lista
	 */
	public void pop(){
		
		if (!esVacia()){
			tope = tope.getSiguiente();		
		} else{
			System.err.println("No se pudo eliminar, ya que la pila est� vac�a");
		}
	}
	
	/**
	 * M�todo que modifica el dato del primer nodo con el dato de nodo de entrada
	 * @param Nodo nodo que contiene el dato a modificar
	 */
	public void modificarTope(Nodo<T> Nodo){
		modificarTope(Nodo.getDato());
	}
	
	/**
	 * M�todo que modifica el dato que contiene el primer nodo
	 * @param dato
	 */
	public void modificarTope(T dato){
		if (!esVacia()){
			tope.setDato(dato);		
		} else{
			System.err.println("No se pudo modificar, ya que la pila est� vac�a");
		}
	}	
}
