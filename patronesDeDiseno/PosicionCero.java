package org.tec.tarea_programada;
/**
 * Patr�n de dise�o Singleton
 * @author andre
 *
 */
public class PosicionCero {

	/**
	 * Puntero con la posici�n (1,1) del mapa creado
	 */
	private static NodoMapa <?> posicionCero; 
	
	public static NodoMapa<?> getCabezaPrincipal() {
		return posicionCero;
	}

	public static void setCabezaPrincipal(NodoMapa<?> cabezaPrincipal) {
		PosicionCero.posicionCero = cabezaPrincipal;
	}
}
