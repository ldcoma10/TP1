package elementos;
import java.util.Random;;

public class Objeto {
	protected boolean objeto;
	protected boolean poder;
	protected String tipo;
	
	public Objeto(){
		
	}
	
	public Objeto(boolean objeto, boolean poder, String tipo){
		this.objeto = objeto;
		this.poder = poder;
		this.tipo = tipo;
		
	}
	
	public final Objeto crearObjeto(){
		
		Random rand = new Random();
		int randomObjecto = rand.nextInt(3);
		int randomTipo = rand.nextInt(2);
		
		Objeto nuevoObjeto = null;
		
		if (randomObjecto == 0){
			if (randomTipo == 0){
				nuevoObjeto = new Objeto(true, false, "Celda de combustible");
			} else if (randomTipo == 1){
				nuevoObjeto = new Objeto(true, false, "Crecimiento de estela");
			}
			
		} else if (randomObjecto == 1){
			if (randomTipo == 0){
				nuevoObjeto = new Objeto(false, true, "Escudo");
			} else if (randomTipo == 1){
				nuevoObjeto = new Objeto(false, true, "Hiper velocidad");
			}
			
		} else if (randomObjecto == 2){
			nuevoObjeto = new Objeto(false, false, "Bomba");
			
		}
		
		return nuevoObjeto;

	}

	public boolean isObjeto() {
		return objeto;
	}

	public boolean isPoder() {
		return poder;
	}

	public String getTipo() {
		return tipo;
	}

}
