package matrix;


public class Node <T> {
	
	private T data;
	private Node up;
	private Node down;
	private Node left;
	private Node right;
	private int i;
	private int j;
	
	public Node(T data, int i, int j) {
		this.data = data;
		this.up = null;
		this.down = null;
		this.left = null;
		this.right = null;
		this.i = i;
		this.j = j;
	}
	
	public Node getRight() {
		return right;
	}
	
	public void setRight(Node right) {
		this.right = right;
	}
	
	public Node getLeft() {
		return left;
	}
	
	public void setLeft(Node left) {
		this.left = left;
	}
	
	public Node getDown() {
		return down;
	}
	
	public void setDown(Node down) {
		this.down = down;
	}
	
	public Node getUp() {
		return up;
	}
	
	public void setUp(Node up) {
		this.up = up;
	}
	
	public T getData() {
		return data;
	}
	
	public void setData(T data) {
		this.data = data;
	}
	
	public int getI() {
		return i;
	}
	
	public int getJ() {
		return j;
	}
}

