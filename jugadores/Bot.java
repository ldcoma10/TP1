package jugadores;

public class Bot extends Jugador {      //Clase Bot que asigna las características de este
	private String nombre;
	private boolean activo;
	private Integer ubicacionFila;
	private Integer ubicacionColumna;
	
		
	public Bot(){						
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
