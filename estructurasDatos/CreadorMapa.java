package estructurasDatos;
public class CreadorMapa <T> {
	
	private NodoMapa <T> cabezaPrincipal; //Puntero que se ubica en el primer nodo de la primera lista
	private NodoMapa <T> cabezaFinal; //Puntero que se ubica en la  lista que se va a enlazar
	
	public CreadorMapa(int i, int j) {
		
		NodoMapa <T> punteroActualHead = null; //Puntero que se ubica en la útlima fila enlazada
		
		for ( int linea = 1; linea <= i; linea ++ ) { //Crea la cantidad de listas necesarios según la cantidad de filas
			
			for ( int columna = 1; columna <= j; columna ++) { //Crea la cantidad de nodos necesarios según la cantidad de columnas
				
				NodoMapa <T> nodo = new NodoMapa <T>(null, linea, columna); //Crea un nodo nuevo para la lista
				
				if (columna > 1 && columna < j) { //Para los nodos que están de por medio, los enlaza derecha e izquierda
					NodoMapa <T> punteroActual = this.cabezaFinal;
					while (punteroActual.getDerecha() != null) {
						punteroActual = punteroActual.getDerecha();
					}
					punteroActual.setDerecha(nodo);
					nodo.setIzquierda(punteroActual);
					
				} else if (columna == 1) { //Ubica el finalHead en la cabeza de la lista que se está creando
					this.cabezaFinal = nodo;
					
					if (this.cabezaPrincipal == null) { //Ubica el mainHead en la primera lista de la matriz
						this.cabezaPrincipal = this.cabezaFinal;
					}
					
				} else if (columna == j ){ //Enlaza el final de la lista con el inicio de la lista para hacerl circular de left y right
					NodoMapa <T> punteroActual = this.cabezaFinal;
					while (punteroActual.getDerecha() != null) {
						punteroActual = punteroActual.getDerecha();
					}
					punteroActual.setDerecha(nodo);
					nodo.setIzquierda(punteroActual);
					this.cabezaFinal.setIzquierda(nodo);
					nodo.setDerecha(this.cabezaFinal);
				}
			}
			
			if (this.cabezaFinal == this.cabezaPrincipal){ //Ubica el punteroActual en la primera lista creada para tener el puntero listo cuando se quiera enlazar con la segunda lista
				punteroActualHead = this.cabezaPrincipal;

			} else { //Enlaza los nodos de la última lista enlazada con la nueva lista creada de manera up y down
				NodoMapa <T> nodoUnir1 = punteroActualHead;
				NodoMapa <T> nodoUnir2 = this.cabezaFinal;
				for (int link = 1; link <= j; link ++) {
					nodoUnir1.setAbajo(nodoUnir2);
					nodoUnir2.setArriba(nodoUnir1);
					nodoUnir1 = nodoUnir1.getDerecha();
					nodoUnir2 = nodoUnir2.getDerecha();
				}
				punteroActualHead = this.cabezaFinal; //Ubica el punteroActual en la última lista enlazada para tenerlo ubicado en la lista que se tiene que enlazar cuando el finalHead cambie
				
				if (linea == i) { //enlaza la primera lista con la última lista los up y down para hacerla circular
					nodoUnir1 = this.cabezaPrincipal;
					nodoUnir2 = this.cabezaFinal;
					for (int link = 1; link <= j; link ++) {
						nodoUnir1.setArriba(nodoUnir2);
						nodoUnir2.setAbajo(nodoUnir1);
						nodoUnir1 = nodoUnir1.getDerecha();
						nodoUnir2 = nodoUnir2.getDerecha();
					}
				}
			} 
		}
	}
}
