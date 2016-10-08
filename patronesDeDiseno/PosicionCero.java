package org.tec.tarea_programada;
/**
 * Patrón de diseño Singleton
 * @author andre
 *
 */
public class PosicionCero {

	/**
	 * Puntero con la posición (1,1) del mapa creado
	 */
	private static NodoMapa <?> posicionCero; 
	
	public static NodoMapa<?> getCabezaPrincipal() {
		return posicionCero;
	}

	public static void setCabezaPrincipal(NodoMapa<?> cabezaPrincipal) {
		PosicionCero.posicionCero = cabezaPrincipal;
	}
}
