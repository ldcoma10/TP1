package logica;

import java.util.Random;

public class Moto extends Estela{    //Clase Moto la cual define la posición, velocidad y ubicación de la moto del usuario
	
	public int velocidad;
	public int combustible;
	public String nombre;
	public int ubicacionMotoX;
	public int ubicacionMotoY;
	
	public Moto(String id, String nombre){
		Random rand = new Random();
		int randomVelocidad = (rand.nextInt(11) + 1);
	
		this.velocidad = randomVelocidad;
		combustible = 100;
		this.id = id;
		this.nombre = nombre;
		
		//this.siguienteEstela = new Estela(this.id);
		Estela actual = this;
		
		for (int contadorEstela = 0; contadorEstela < 3; contadorEstela ++){
			actual.siguienteEstela = new Estela(this.id);
			actual = actual.siguienteEstela;
		}
	}

	
	public boolean verificarSiguienteMovimiento(NodoMapa<?> siguienteMovimiento){     //Método que evalúa la validez del siguiente puesto que adopte la moto del usuario, dependiendo de su decisión.
		boolean validez = false;
		
		if (siguienteMovimiento.getDato() == null || siguienteMovimiento.getDato() == "0"){
			validez = true;
			
		}  else {
			
			try {
				if (siguienteMovimiento.getDato().getId == this.id){
					validez = true;
				}
			} catch (Exception e){}
		}
		
		return validez;
	}
	
	public void moverDerecha(){     //Método que se ejecuta si el usuario selecciona virar hacia la derecha
		if (this.verificarSiguienteMovimiento(this.lugarEnMapa.getDerecha()) == true){
			mover(this.lugarEnMapa, this.lugarEnMapa.getDerecha());
			this.ubicacionMotoX = this.lugarEnMapa.getCoordenadaX();
			this.ubicacionMotoY = this.lugarEnMapa.getCoordenadaY();
		} else {
			eliminarMoto(this.lugarEnMapa, this.siguienteEstela.lugarEnMapa);
		}
	}
	
	public void moverIzquierda(){    //Método que ejecuta el movimiento hacia la izquierda de la moto del usuario
		if (this.verificarSiguienteMovimiento(this.lugarEnMapa.getIzquierda()) == true){
			mover(this.lugarEnMapa, this.lugarEnMapa.getIzquierda());
			this.ubicacionMotoX = this.lugarEnMapa.getCoordenadaX();
			this.ubicacionMotoY = this.lugarEnMapa.getCoordenadaY();			
		} else {
			eliminarMoto(this.lugarEnMapa, this.siguienteEstela.lugarEnMapa);
		}		
	}
	
	public void moverArriba(){    //Método que hace que la moto se desplaze hacia arriba
		if (this.verificarSiguienteMovimiento(this.lugarEnMapa.getArriba()) == true){
			mover(this.lugarEnMapa, this.lugarEnMapa.getArriba());
			this.ubicacionMotoX = this.lugarEnMapa.getCoordenadaX();
			this.ubicacionMotoY = this.lugarEnMapa.getCoordenadaY();
		} else {
			eliminarMoto(this.lugarEnMapa, this.siguienteEstela.lugarEnMapa);
		}
	}
	
	public void moverAbajo(){     //Método que hace que la moto se desplaze hacia abajo
		if (this.verificarSiguienteMovimiento(this.lugarEnMapa.getAbajo()) == true){
			mover(this.lugarEnMapa, this.lugarEnMapa.getAbajo());
			this.ubicacionMotoX = this.lugarEnMapa.getCoordenadaX();
			this.ubicacionMotoY = this.lugarEnMapa.getCoordenadaY();
		} else {
			eliminarMoto(this.lugarEnMapa, this.siguienteEstela.lugarEnMapa);
		}
	}
	
	public static void mover(NodoMapa<?> actual, NodoMapa<?> siguiente){
		try {
			
			while (actual.getDato().siguienteEstela != null){
				siguiente.setDato(actual.getDato());
				actual.getDato().lugarEnMapa = siguiente;
				
				siguiente = actual;
				actual = actual.getDato().siguienteEstela.lugarEnMapa;
				
				if (actual == null){
					siguiente.setDato(siguiente.getDato().siguienteEstela);
					siguiente.getDato().lugarEnMapa = siguiente;
					break;
				}
			} 
			
			if (actual != null){
				siguiente.setDato(actual.getDato());
				actual.getDato().lugarEnMapa = siguiente;
				actual.setDato(null);
			}
			
		} catch (Exception e){}
	}
	
	public static void eliminarMoto(NodoMapa<?> actual, NodoMapa<?> anterior){      //Método que elimina la moto si esta choca contra otra moto o la estela de esta.
		try {
			if (anterior != null){
				while (anterior.getDato().siguienteEstela != null){
					actual.getDato().lugarEnMapa = null;
					actual.setDato(null);
					
					actual = anterior;
					anterior = anterior.getDato().siguienteEstela.lugarEnMapa;
					
				}
				
				anterior.getDato().lugarEnMapa = null;
				anterior.setDato(null);
			}
			
			actual.getDato().lugarEnMapa = null;
			actual.setDato(null);

		} catch (Exception e){}		
		
	}
	
}