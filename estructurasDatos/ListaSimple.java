package estructurasDatos;


/**
 * Clase que implementa una lista simple
 * @param <T> tipo de dato del que se compondran los nodos de la lista
 */

public class ListaSimple<T>  { 

	/**
	 * inicio Puntero al inicio de la lista
	 */
	private Nodo<T> inicio;
	
	/**
	 * Constructor de la lista
	 */
	public ListaSimple(){ 
		inicio = null;
	}

	public Nodo<T> getInicio() {
		return inicio;
	}

	public void setInicio(Nodo<T> inicio) {
		this.inicio = inicio;
	}
	
	/**
	 * Método que verifica que la lista esté vacía
	 * @return true si está vacía
	 */
	public boolean esVacia(){
		return inicio == null;
	}
	
	/**
	 * Método que crea el nodo al inicio de la lista
	 * @param dato dato que contandrá el nodo a crear
	 */
	public void insertarInicio(T dato){  
		
		Nodo <T> nodo =new Nodo<T>(dato);
		insertarInicio(nodo);
	}
	
	/**
	 * Método que insertaa el nodo al inicio de la lista
	 * @param nodo nodo a insertar al inicio de la lisya
	 */
	public void insertarInicio(Nodo<T> nodo){  //Método que decide si asigna el nuevo nodo como el inicial o solo como el siguiente, dependiendo de si la lista es vacía o no.
		
		if (esVacia()){
			setInicio(nodo);
		} else {
			nodo.setSiguiente(inicio);			
			inicio = nodo;
		}
	}
	
	/**
	 * Método que inserta un nodo al final de la lista
	 * @param nodo nodo a insertar al final de la lista
	 */
	public void insertarFinal(Nodo<T> nodo){  //Método que apunte al último nodo de la lista
		if (esVacia()){
			setInicio(nodo);
		} else {
			Nodo<T> aux=inicio;
			while(aux.getSiguiente()!=null){				
				aux=aux.getSiguiente();					
			}
			aux.setSiguiente(nodo);
		}
	}
	
	/**
	 * Método que crea el nodo a insertar al final de la lista
	 * @param dato dato que contandrá el nodo a crear
	 */
	public void insertarFinal(T dato){
		Nodo <T> nodo=new Nodo<T>(dato);
		insertarFinal(nodo);
		
	}
	
	/**
	 * Método que evalúa el tamaño de la lista
	 * @return tamaño de la lista
	 */
	public int tamano(){
		int tamano = 0;
		if (!esVacia()){
			
			Nodo<T> aux = inicio;
			for(;aux.getSiguiente() != null; tamano ++){
				aux = aux.getSiguiente();
			}
			tamano ++;
		}
		return tamano;
	}
	
	/**
	 * Método que crea el nodo a insertar en la posición dada
	 * @param dato dato que contendrá el nodo a crear
	 * @param index posición en la que se insertará el nodo
	 */
	public void insertarPosicion(T dato,int index){   
		Nodo <T> nodo=new Nodo<T>(dato);
		insertarPosicion(nodo,index);
	}
	
	/**
	 * Inserta el nodo en una posición dada
	 * @param nodo nodo a insertar en la lista
	 * @param index posición en la que se insertará el nodo
	 */
	public void insertarPosicion(Nodo<T> nodo,int index){
		if (index <= tamano() && index >= 0){
			if (index == 0){
				insertarInicio(nodo);
			} else if (tamano() == index){
				insertarFinal(nodo);				
			} else{
				Nodo <T> aux = inicio;
				Nodo <T>temp = inicio;
				int contador = 0;
				while (contador != index){
					if (contador == index-1){
						temp = aux;
					}
					aux = aux.getSiguiente();
					contador ++;
				}
				temp.setSiguiente(nodo);
				nodo.setSiguiente(aux);
			}
		} else if (index<0){
			System.err.println("No se pudo insertar, el índice debe ser mayor o igual que cero");
		} else{
			System.err.println("No se pudo insertar, el índice excede el tamaño de la lista");
		}
	}
	
	/**
	 * Método que crea el nodo a eliminar
	 * @param dato dato a evaluar para eliminar el nodo
	 */
	public void eliminar(T dato){
		eliminar(buscar(dato));		
	}
	
	/**
	 * Método que elimina el nodo en la posición dada
	 * @param index posición a eliminar
	 */
	public void eliminar(int index){   //Método que permite eliminar datos dentro de la lista
		if (index<tamano() && index >= 0){
			if (index == 0){
				inicio = inicio.getSiguiente();
			} else if(tamano() - 1 == index){
				Nodo <T> aux = inicio;
				int contador = 0;
				while(contador < tamano() - 2){
					aux = aux.getSiguiente();
					contador ++;
				}
				aux.setSiguiente(null);
			} else{
				Nodo <T> aux = inicio;
				Nodo <T>temp = inicio;
				int contador = 0;
				while (contador != index){
					if (contador == index-1){
						temp = aux;
					}
					aux = aux.getSiguiente();
					contador++;
				}
				temp.setSiguiente(aux.getSiguiente());
				aux.setSiguiente(null);
				
			}
			
		} else if (index<0){
			System.err.println("No se pudo eliminar, el índice debe ser mayor o igual que cero");
		
		} else{
			System.err.println("No se pudo eliminar, el índice excede el tamaño de la lista");
		}
	}
	
	/**
	 * Método que modifica el nodo de la posición dada
	 * @param index posición a modificar
	 * @param nodo nodo a modificar
	 */
	public void modificarPosicion(int index, Nodo<T> nodo){
		modificarPosicion(index, nodo.getDato());		
	}
	
	/**
	 * Método que modifica el dato en la posición dada
	 * @param index posición dada
	 * @param dato dato a modificar
	 */
	public void modificarPosicion(int index,T dato){   //Permite modificar y variar la posición de un dato dentro de la lista
		if (index < tamano()){
			Nodo<T> aux = inicio;
			for(int contador = 0; contador != index; contador ++){
				aux = aux.getSiguiente();
			}
			aux.setDato(dato);
		} else{
			System.err.println("No se pudo modificar, el índice excede el tamaño de la lista");
		}
	}
	
	/**
	 * Método que busca un nodo con el mismo dato
	 * @param dato dato a buscar
	 * @return nodo con el dato a buscar
	 */
	public int buscar(T dato){
		Nodo<T> aux = inicio;		
		for(int i = 0; aux != null;i++){
			if (dato == aux.getDato()){
				return i;
			}
			aux = aux.getSiguiente();
		}
		return -1;
	}
	
	/**
	 * Método que imprime el dato de los nodos de la lista
	 */
	public void imprimir(){ 		

		if (!esVacia()){			
			Nodo<T> aux = inicio;			
			String listaImpresa = "[";
			
			while(aux != null){
				if(aux.getSiguiente() != null){
					listaImpresa += aux.getDato() + ",";					
				} else{
					listaImpresa += aux.getDato();
					
				}
				aux = aux.getSiguiente();	
			}
			
			System.out.println(listaImpresa+"]");
		} else{
			System.out.println("[]");
		}
	}
}
