package estructurasDatos;

public class Cola <T> {   //Implementación de la estructura de cola la cual almacena datos y los evaulúa mediante la función FIFO
	private Nodo<T> inicio;
	public Nodo<T> getInicio() {
		return inicio;
	}
	
	public boolean esVacia(){   //Método que evalúa si la lista está vacía y respecto a esto asigna un valor nulo al inicio 
		return inicio==null;
	}
	public void encolar (T dato){
		encolar (new Nodo<T>(dato));
	}
	public void encolar(Nodo <T> nodo){    //Método que va asignando valores a la cola   
		if (esVacia()){   //Si es vacía, se le asigna al primer nodo como el inicial 
			inicio=nodo;
		}
		else{    //En caso de que la lista ya posea valores, se le asigna al nuevo nodo como el siguiente valor de la lista
			Nodo<T> aux=inicio;
			while(aux.getSiguiente()!=null){				
				aux=aux.getSiguiente();					
			}
			aux.setSiguiente(nodo);			
		}		
	}
	
	public void desencolar(){  //Método que permite "desencolar" la lista y permite extraer el primer valor de esta
		if (!esVacia()){
			inicio=inicio.getSiguiente();		
		}
		else{
			System.err.println("No se pudo eliminar, ya que la cola está vacía");
		}
	}

	
	
}
