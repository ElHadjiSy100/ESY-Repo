import java.util.ArrayList;
/**
 * 
 * Implements a stack using a self-made node class.
 * @author El Hadji Sy
 */
public class MyStack<T> extends MyNode<T> implements StackInterface<T>{
	private int maxSize;
	private int size;
	MyNode<T> head;
	
	/**
	 * Creates a stack with a max size as the parameter.
	 * @param size - max size of stack.
	 */
	public MyStack(int size) {
		head = null;
		maxSize = size;
	}
	
	/**
	 * Creates a stack with the max size of the stack being 256.
	 * @param size - max size of stack.
	 */
	public MyStack() {
		maxSize = 256;
	}
	
	/**
	 * Checks if stack is empty.
	 */
	@Override
	public boolean isEmpty() {
		return(size == 0);
	}
	
	/**
	 * Checks if the stack is full.
	 */
	@Override
	public boolean isFull() {
		return(size == maxSize);
	}
	
	/**
	 * Removes and returns the most recent item that was entered into the stack.
	 */
	@Override
	public T pop() throws StackUnderflowException {
		
		if(head != null) {
			T temp = (T) head.data;
			head = head.next;
			size--;
			return temp;
		}else {
			throw new StackUnderflowException("Stack is empty.");
		}
	}
	
	/**
	 * Checks what the most recently added item to the stack is without removing it from the stack.
	 */
	@Override
	public T top() throws StackUnderflowException {
		if(head != null) {
			return head.data;
		} else {
			throw new StackUnderflowException("Stack is empty.");
		}
	}
	
	/**
	 * Returns the size of the stack.
	 */
	@Override
	public int size() {
		return size;
	}
	
	/**
	 * Adds an item to the stack.
	 */
	@Override
	public boolean push(T e) throws StackOverflowException  {
		MyNode<T> temp = new MyNode<T>(e);
		if(head == null && size != maxSize) {
			temp.data = e;
			head = temp;
			size++;
			return true;
		}
		else if(head != null && size != maxSize) {
			temp.next = head;
			head = temp;
			size++;
			return true;
		}else {
			throw new StackOverflowException("Stack is full.");
		}
	}
	
	/**
	 * Converts the items in the stack into one string and returns it.
	 */
	@Override
	public String toString() {
		return toString("");
	}
	
	/**
	 * Converts the items into the stack into one string and returns it with delimiters in between every item.
	 */
	@Override
	public String toString(String delimiter) {
		String s = "";
		try {
			if(size > 0) {
				MyNode<T> current = head;
				while(current.next != null) {
					s = delimiter + current.data + s;
					current = current.next;
				}
				s = current.data + s; 
			}
		} catch(Exception e) {
			e.getMessage();
		}
		return s;
	}
	
	/**
	 * Fills stack with items from a list that is given in the parameters.
	 */
	@Override
	public void fill(ArrayList<T> list) {
		ArrayList<T> listcopy = new ArrayList<T>();
		for(T items: list) {
			listcopy.add(items);
		}
		try {
			for(T copieditems: listcopy) {
				this.push(copieditems);
			}
		} catch(Exception e) {
			e.getMessage();
		}
	}
}
