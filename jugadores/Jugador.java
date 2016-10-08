package jugadores;

/**
 * Clase jugador
 *
 */
public class Jugador extends Thread {    //Un thread es un hilo, el cual permite realizar de manera paralela actividades de diversas clases o métodos.
	private String nombre;
	private boolean activo;
	private Integer ubicacionFila;
	private Integer ubicacionColumna;
	
	/**
	 * Constructor
	 */
	public Jugador(){
		nombre=null;
		activo=false;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}
}