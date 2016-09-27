package jugadores;

public class Jugador extends Thread {
	private String nombre;
	private boolean activo;
	
	Jugador(){
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
