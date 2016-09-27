package matrix;


public class MatrixCreator {
	
	private Node mainHead; //Puntero que se ubica en el primer nodo de la primera lista
	private Node finalHead; //Puntero que se ubica en la  lista que se va a enlazar
	
	public MatrixCreator(int i, int j) {
		
		Node currentHead = null; //Puntero que se ubica en la útlima fila enlazada
		
		for ( int line = 1; line <= i; line ++ ) { //Crea la cantidad de listas necesarios según la cantidad de filas
			
			for ( int column = 1; column <= j; column ++) { //Crea la cantidad de nodos necesarios según la cantidad de columnas
				
				Node node = new Node(null, line, column); //Crea un nodo nuevo para la lista
				
				if (column > 1 && column < j) { //Para los nodos que están de por medio, los enlaza derecha e izquierda
					Node current = this.finalHead;
					while (current.getRight() != null) {
						current = current.getRight();
					}
					current.setRight(node);
					node.setLeft(current);
					
				} else if (column == 1) { //Ubica el finalHead en la cabeza de la lista que se está creando
					this.finalHead = node;
					
					if (this.mainHead == null) { //Ubica el mainHead en la primera lista de la matriz
						this.mainHead = this.finalHead;
					}
					
				} else if (column == j ){ //Enlaza el final de la lista con el inicio de la lista para hacerl circular de left y right
					Node current = this.finalHead;
					while (current.getRight() != null) {
						current = current.getRight();
					}
					current.setRight(node);
					node.setLeft(current);
					this.finalHead.setLeft(node);
					node.setRight(this.finalHead);
				}
			}
			
			if (this.finalHead == this.mainHead){ //Ubica el current en la primera lista creada para tener el puntero listo cuando se quiera enlazar con la segunda lista
				currentHead = this.mainHead;

			} else { //Enlaza los nodos de la última lista enlazada con la nueva lista creada de manera up y down
				Node linkNode1 = currentHead;
				Node linkNode2 = this.finalHead;
				for (int link = 1; link <= j; link ++) {
					linkNode1.setDown(linkNode2);
					linkNode2.setUp(linkNode1);
					linkNode1 = linkNode1.getRight();
					linkNode2 = linkNode2.getRight();
				}
				currentHead = this.finalHead; //Ubica el current en la última lista enlazada para tenerlo ubicado en la lista que se tiene que enlazar cuando el finalHead cambie
				
				if (line == i) { //enlaza la primera lista con la última lista los up y down para hacerla circular
					linkNode1 = this.mainHead;
					linkNode2 = this.finalHead;
					for (int link = 1; link <= j; link ++) {
						linkNode1.setUp(linkNode2);
						linkNode2.setDown(linkNode1);
						linkNode1 = linkNode1.getRight();
						linkNode2 = linkNode2.getRight();
					}
				}
			} 
			

		}
	}
	
	
	public void Imprimir(){
		//Toma el inicio de la matriz
		Node aux=mainHead;
		//Para ver el tama�o de la matriz se busca los �ndices
		int maxI=aux.getUp().getI();
		int maxJ=aux.getLeft().getJ();
		
		System.out.println(maxI+"   "+maxJ);
		
		//Imprime cada uno de los nodos. Se imprimen las filas y luego las columnas
		for (int i=0;i<maxI;i++){
			for(int j=0;j<maxJ;j++){
				System.out.println("i="+aux.getI()+"    j="+aux.getJ());
				aux=aux.getRight();
				
			}
			
			aux=aux.getDown();
		}
	}
	
	
}
