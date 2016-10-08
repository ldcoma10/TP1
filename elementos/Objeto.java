package elementos;
import java.util.Random;;

public class Objeto {                 // Clase objeto la cual contiene lo relacionado a items y poderes
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
	
	public final Objeto crearObjeto(){      //Asignación de items o de objetos mediante un método random
		
		Random rand = new Random();
		int randomObjecto = rand.nextInt(3);
		int randomTipo = rand.nextInt(2);
		
		Objeto nuevoObjeto = null;
		
		if (randomObjecto == 0){      //En caso de asignar un 0 a randomObjeto pasa a evaluar si será combustible o poder de estela de manera random
			if (randomTipo == 0){
				nuevoObjeto = new Objeto(true, false, "Celda de combustible");
			} else if (randomTipo == 1){
				nuevoObjeto = new Objeto(true, false, "Crecimiento de estela");
			}
			
		} else if (randomObjecto == 1){ //En caso de resultar la asignación de 1 a randomObjeto, las posibilades serán de ser escudo o hipervelocidad
			if (randomTipo == 0){
				nuevoObjeto = new Objeto(false, true, "Escudo");
			} else if (randomTipo == 1){
				nuevoObjeto = new Objeto(false, true, "Hiper velocidad");
			}
			
		} else if (randomObjecto == 2){   //Finalmente, si randomObjeto toma el valor 2, será una bomba
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
