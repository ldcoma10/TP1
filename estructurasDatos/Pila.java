package estructurasDatos;

public class Pila <T> {
	private Nodo<T> tope;
	public Nodo<T> getTope() {
		return tope;
	}
	public void setTope(Nodo<T> tope) {
		this.tope = tope;
	}
	public boolean esVacia(){
		return tope==null;
	}
	public void push (T dato){
		push (new Nodo<T>(dato));
	}
	public void push(Nodo <T> nodo){
		if (esVacia()){
			setTope(nodo);
		}
		else{
			nodo.setSiguiente(tope);			
			tope=nodo;			
		}		
	}
	
	public void pop(){
		if (!esVacia()){
			tope=tope.getSiguiente();		
		}
		else{
			System.err.println("No se pudo eliminar, ya que la pila está vacía");
		}
	}
	public void modificarTope(Nodo <T>Nodo){
		modificarTope(Nodo.getDato());
	}
	public void modificarTope(T dato){
		if (!esVacia()){
			tope.setDato(dato);		
		}
		else{
			System.err.println("No se pudo modificar, ya que la pila está vacía");
		}
	}
	
	
}
