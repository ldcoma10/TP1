package estructurasDatos;

public class Cola <T> {
	private Nodo<T> inicio;
	public Nodo<T> getInicio() {
		return inicio;
	}
	
	public boolean esVacia(){
		return inicio==null;
	}
	public void encolar (T dato){
		encolar (new Nodo<T>(dato));
	}
	public void encolar(Nodo <T> nodo){
		if (esVacia()){
			inicio=nodo;
		}
		else{
			Nodo<T> aux=inicio;
			while(aux.getSiguiente()!=null){				
				aux=aux.getSiguiente();					
			}
			aux.setSiguiente(nodo);			
		}		
	}
	
	public void desencolar(){
		if (!esVacia()){
			inicio=inicio.getSiguiente();		
		}
		else{
			System.err.println("No se pudo eliminar, ya que la cola está vacía");
		}
	}

	
	
}
