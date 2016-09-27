package Elementos;

public class Poder {
     TiposPoderes tipo;
     
     Poder(TiposPoderes tipo){
    	 this.tipo=tipo;
     }

	public TiposPoderes getTipo() {
		return tipo;
	}

	public void setTipo(TiposPoderes tipo) {
		this.tipo = tipo;
	}
}
