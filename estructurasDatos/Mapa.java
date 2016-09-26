package estructurasDatos;

import java.util.LinkedList;

public class Mapa<T>  {

	private NodoMapa<T> inicio;
	
	
	public Mapa(){
		inicio=null;
	}

	public NodoMapa<T> getInicio() {
		return inicio;
	}

	public void setInicio(NodoMapa<T> inicio) {
		this.inicio = inicio;
	}
	
	public boolean esVacia(){
		return inicio==null;
	}
	public void insertarInicio(T dato){
		
		NodoMapa <T> nodo=new NodoMapa<T>(dato);
		insertarInicio(nodo);
	}
	public void insertarInicio(NodoMapa<T> nodo){
		
		if (esVacia()){
			setInicio(nodo);


		}
		else{
			nodo.setDerecha(inicio);			
			inicio=nodo;
			
		}
		
	}
	public void insertarFinal(T dato){
		NodoMapa <T> nodo=new NodoMapa<T>(dato);
		insertarFinal(nodo);
		
	}
	
	public void insertarFinal(NodoMapa<T> nodo){
		if (esVacia()){
			setInicio(nodo);
		}
		else{
			NodoMapa<T> aux=inicio;
			while(aux.getDerecha()!=null){				
				aux=aux.getDerecha();					
			}
			aux.setDerecha(nodo);
		}
		
	}
	public int tamano(){
		int tamano=0;
		if (!esVacia()){		
			NodoMapa<T> aux=inicio;
			for(;aux.getDerecha()!=null;tamano++){
				aux=aux.getDerecha();
			}
			tamano++;
		}
		return tamano;
	}
	public void insertarPosicion(T dato,int index){
		NodoMapa <T> nodo=new NodoMapa<T>(dato);
		insertarPosicion(nodo,index);
		
	}
	public void insertarPosicion(NodoMapa<T> nodo,int index){
		if (index<=tamano() && index>=0){
			if (index==0){
				insertarInicio(nodo);
			}
			else if (tamano()==index){
				insertarFinal(nodo);				
			}
			else{
				NodoMapa <T> aux=inicio;
				NodoMapa <T>temp=inicio;
				int contador=0;
				while (contador!=index){
					if (contador==index-1){
						temp=aux;
					}
					aux=aux.getDerecha();
					contador++;
				}
				temp.setDerecha(nodo);
				nodo.setDerecha(aux);
				
			}
			
		}
		else if (index<0){
			System.err.println("No se pudo insertar, el índice debe ser mayor o igual que cero");
		}
		
		else{
			System.err.println("No se pudo insertar, el índice excede el tamaño de la lista");
		}
	}
	public void eliminar(int index){
		if (index<tamano() && index>=0){
			if (index==0){
				inicio=inicio.getDerecha();
			}
			else if(tamano()-1==index){
				NodoMapa <T> aux=inicio;
				int contador=0;
				while(contador<tamano()-2){
					aux=aux.getDerecha();
					contador++;
				}
				aux.setDerecha(null);
			}
			else{
				NodoMapa <T> aux=inicio;
				NodoMapa <T>temp=inicio;
				int contador=0;
				while (contador!=index){
					if (contador==index-1){
						temp=aux;
					}
					aux=aux.getDerecha();
					contador++;
				}
				temp.setDerecha(aux.getDerecha());
				aux.setDerecha(null);
				
			}
			
		}
		else if (index<0){
			System.err.println("No se pudo eliminar, el índice debe ser mayor o igual que cero");
		}
		
		else{
			System.err.println("No se pudo eliminar, el índice excede el tamaño de la lista");
		}
		
	}
	public void modificarPosicion(int index, NodoMapa <T>nodo){
		modificarPosicion(index, nodo.getDato());		
	}
	public void modificarPosicion(int index,T dato){
		if (index<tamano()){
			NodoMapa <T>aux=inicio;
			for(int contador=0;contador!=index;contador++){
				aux=aux.getDerecha();
			}
			aux.setDato(dato);
		}
		else{
			System.err.println("No se pudo modificar, el índice excede el tamaño de la lista");
		}
		
	}
	public void imprimir(){
		
		if (!esVacia()){			
			NodoMapa <T> aux=inicio;			
			String listaImpresa="[";
			
			while(aux.getDerecha()!=null){				
				listaImpresa+=aux.getDato()+",";
				aux=aux.getDerecha();					
			}
			if (aux!=null){
				listaImpresa+=aux.getDato();
			}
			System.out.println(listaImpresa+"]");
		}
		else{
			System.out.println("[]");
		}
	}
	
	
	public /*Mapa*/ void formarMapa(int filas, int columnas){
		NodoMapa<T> aux=null;
		NodoMapa <T>first=inicio;
		ListaSimple<Nodo<T>>formacion=new ListaSimple<Nodo<T>>();
		for(int i=0;i<filas; i++){
			for(int j=0;j<filas;j++){
				NodoMapa <T> celda=new NodoMapa <T>();
				celda.cordenadaX=i;
				celda.cordenadaY=j;
				if (j==0){
					aux=celda;
					first=celda;
				}
				else if(j==filas-1){
					aux.setDerecha(celda);
					Nodo <NodoMapa<T>>nodo=new Nodo<NodoMapa<T>>();
					formacion.insertarFinal((Nodo<T>) nodo);
				}
				else if (j!=0){
					celda.setIzquierda(aux);
					aux.setDerecha(celda);
					aux=aux.getDerecha();					
				}
				
			}
			
			
				
			
		}
			
		//return Mapa;
	}
	
	
}
