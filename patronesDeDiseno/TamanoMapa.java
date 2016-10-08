package patronesDeDiseno;

/**
 * Singleton del tamaño del mapa ya que estas variables nunca cambian por la duración del juego
 * @author andre
 *
 */
public class TamanoMapa {

	/**
	 * ancho del mapa (valor de x)
	 * alto del mapa (valor de y)
	 */
	private static int ancho;
	private static int alto;
	
	public static int getAncho() {
		return ancho;
	}
	public static void setAncho(int ancho) {
		TamanoMapa.ancho = ancho;
	}
	public static int getAlto() {
		return alto;
	}
	public static void setAlto(int alto) {
		TamanoMapa.alto = alto;
	}
	
	
}
