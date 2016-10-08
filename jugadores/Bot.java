package jugadores;

/**
 * Clase que crea bots
 *
 */
public class Bot extends Jugador {      //Clase Bot que asigna las características de este
	
	/**
	 * nombre nombre del jugador
	 * activo si está jugando en la partida
	 * ubicacionFila posicion en fila del jugador
	 * ubicacionColumna posicion en columna del jugador
	 */
	private String nombre;
	private boolean activo;
	private Integer ubicacionFila;
	private Integer ubicacionColumna;
	
	/**
	 * Método que evalúa si el bot se encuentra activo o no
	 */
	public Bot(){						
		activo=false;
		}
		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {   //Método que retorna el nombre del jugador
			this.nombre = nombre;
		}

		public boolean isActivo() {   //Método que retorna el estado de activo que presenta el jugador en el momento
			return activo;
		}

		public void setActivo(boolean activo) {
			this.activo = activo;
		}
		
	}
