package estructurasDatos;

public class NodoMapa <T> {
	private T dato;
	public int cordenadaX;
	public int cordenadaY;
	private NodoMapa <T>  izquierda;
	private NodoMapa <T> arriba;
	private NodoMapa <T> abajo;
	private NodoMapa <T> derecha;
	
	public NodoMapa(T dato){
		this.dato=dato;
		this.izquierda=null;
		this.abajo=null;
		this.arriba=null;
		this.derecha=null;
	}
	public NodoMapa(){		
		this.izquierda=null;
		this.abajo=null;
		this.arriba=null;
		this.derecha=null;
	}

	public T getDato() {
		return dato;
	}

	public void setDato(T dato) {
		this.dato = dato;
	}

	public NodoMapa<T> getIzquierda() {
		return izquierda;
	}

	public void setIzquierda(NodoMapa<T> aux) {
		this.izquierda = aux;
	}

	public NodoMapa<T> getArriba() {
		return arriba;
	}

	public void setArriba(NodoMapa<T> arriba) {
		this.arriba = arriba;
	}

	public NodoMapa<T> getAbajo() {
		return abajo;
	}

	public void setAbajo(NodoMapa<T> abajo) {
		this.abajo = abajo;
	}

	public NodoMapa<T> getDerecha() {
		return derecha;
	}

	public void setDerecha(NodoMapa<T> derecha) {
		this.derecha = derecha;
	}

	

	
	
	
	

}
