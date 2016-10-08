package jugadores;

public class Bot extends Jugador {      //Clase Bot que asigna las características de este
	private String nombre;
	private boolean activo;
	private Integer ubicacionFila;
	private Integer ubicacionColumna;
	
		
	public Bot(){				//Evalúa si el bot se encuentra activo o no		
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
