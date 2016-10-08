package org.tec.tarea_programada;

public class Mapa <T> {
	
	public NodoMapa <T> cabezaPrincipal; //Puntero que se ubica en el primer nodo de la primera lista
	public NodoMapa <T> cabezaFinal; //Puntero que se ubica en la  lista que se va a enlazar
	

	public Mapa(int i, int j) {
		
		NodoMapa <T> punteroActualHead = null; //Puntero que se ubica en la útlima fila enlazada
		
		for ( int linea = 1; linea <= i; linea ++ ) { //Crea la cantidad de listas necesarios según la cantidad de filas
			
			for ( int columna = 1; columna <= j; columna ++) { //Crea la cantidad de nodos necesarios según la cantidad de columnas
				
				NodoMapa <T> nodo = new NodoMapa <T>(null, linea, columna); //Crea un nodo nuevo para la lista
				
				if (columna > 1 && columna < j) { //Para los nodos que están de por medio, los enlaza derecha e izquierda
					NodoMapa <T> punteroActual = this.cabezaFinal;
					while (punteroActual.derecha != null) {
						punteroActual = punteroActual.derecha;
					}
					punteroActual.derecha = nodo;
					nodo.izquierda = punteroActual;
					
				} else if (columna == 1) { //Ubica el finalHead en la cabeza de la lista que se está creando
					this.cabezaFinal = nodo;
					
					if (this.cabezaPrincipal == null) { //Ubica el mainHead en la primera lista de la matriz
						this.cabezaPrincipal = this.cabezaFinal;
					}
					
				} else if (columna == j ){ //Enlaza el final de la lista con el inicio de la lista para hacerl circular de left y right
					NodoMapa <T> punteroActual = this.cabezaFinal;
					while (punteroActual.derecha != null) {
						punteroActual = punteroActual.derecha;
					}
					punteroActual.derecha = nodo;
					nodo.izquierda = punteroActual;
					this.cabezaFinal.izquierda = nodo;
					nodo.derecha = this.cabezaFinal;
				}
			}
			
			if (this.cabezaFinal == this.cabezaPrincipal){ //Ubica el punteroActual en la primera lista creada para tener el puntero listo cuando se quiera enlazar con la segunda lista
				punteroActualHead = this.cabezaPrincipal;

			} else { //Enlaza los nodos de la última lista enlazada con la nueva lista creada de manera up y down
				NodoMapa <T> nodoUnir1 = punteroActualHead;
				NodoMapa <T> nodoUnir2 = this.cabezaFinal;
				for (int link = 1; link <= j; link ++) {
					nodoUnir1.abajo = nodoUnir2;
					nodoUnir2.arriba = nodoUnir1;
					nodoUnir1 = nodoUnir1.derecha;
					nodoUnir2 = nodoUnir2.derecha;
				}
				punteroActualHead = this.cabezaFinal; //Ubica el punteroActual en la última lista enlazada para tenerlo ubicado en la lista que se tiene que enlazar cuando el finalHead cambie
				
				if (linea == i) { //enlaza la primera lista con la última lista los up y down para hacerla circular
					nodoUnir1 = this.cabezaPrincipal;
					nodoUnir2 = this.cabezaFinal;
					for (int link = 1; link <= j; link ++) {
						nodoUnir1.arriba = nodoUnir2;
						nodoUnir2.abajo = nodoUnir1;
						nodoUnir1 = nodoUnir1.derecha;
						nodoUnir2 = nodoUnir2.derecha;
					}
				}
			} 
		}

	}
}
