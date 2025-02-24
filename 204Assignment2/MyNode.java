/**
 * Simple  implementation of a node class  to build linked lists.
 * @author El Hadji Sy
 */
public class MyNode<T> {
	T data;
	MyNode<T> next;
	
	/**
	 * Creates a new node.
	 */
	public MyNode(){
	}
	
	/**
	 * Creates a new node and sets its data field to e, which is passed into from the parameters.
	 * @param e
	 */
	public MyNode(T e){
		this.data = e;
	}
}

