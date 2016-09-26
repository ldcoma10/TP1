package estructurasDatos;

public class Laucher {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ListaSimple <Integer> ls=new ListaSimple<Integer>();
		
		ls.insertarFinal(1);		
		
		ls.insertarFinal(4);		
		
		ls.insertarInicio(3);		
		
		ls.insertarFinal(2);
		
		ls.insertarFinal(1);
		ls.imprimir();
		ls.eliminar(4);
		ls.imprimir();
		ls.modificarPosicion(0,5);		
		ls.imprimir();
		
		
		
		
		
		
		
		
	}

}
