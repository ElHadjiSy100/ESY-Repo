import java.util.ArrayList;
/**
 * 
 * Implements a queue using a self-made node class.
 * @author El Hadji Sy
 */

public class MyQueue<T> extends MyNode<T> implements QueueInterface<T> {
	int maxSize;
	int size;
	MyNode<T> head; 
	MyNode<T> tail;
	
	/**
	 * Creates a queue with a max size as the parameter.
	 * @param size - max size of queue.
	 */
	public MyQueue(int size) {
		maxSize = size;
	}
	
	/**
	 * Creates a queue with a max size of 256.
	 */
	public MyQueue() {
		maxSize = 256;
	}

	/**
	 * Checks if queue is empty.
	 */
	@Override
	public boolean isEmpty() {
		return(size == 0);
	}
	
	/**
	 * Checks if queue is full.
	 */
	@Override
	public boolean isFull() {
		return(size == maxSize);
		}

	/**
	 * Dequeues the first item entered into the queue.
	 */
	@Override
	public T dequeue() throws QueueUnderflowException {
		T temp;
		if(head != null) {
			System.out.println("DeQing now");
			temp = head.data;
			head = head.next;
			size--;
			System.out.println("Success");
			return temp;
		} else {
			throw new QueueUnderflowException("Queue is empty.");
		}
	}

	/**
	 * Returns the current size of the queue.
	 */
	@Override
	public int size() {
		return size;
	}

	/**
	 * Enqueues an item into the queue's last last position.
	 */
	@Override
	public boolean enqueue(T e) throws QueueOverflowException {
		MyNode<T> temp = new MyNode<T>(e);
		if(tail == null) {
			tail = temp;
			head = tail;
			size++;
			return true;
		} else if(size < maxSize){
			tail.next = temp; 
			tail = temp;
			size++;
			return true;		
		} else {
			throw new QueueOverflowException("Queue is full.");
		}
	}
	
	/**
	 * Merges all items in queue into a string and returns it.
	 */
	@Override
	public String toString() {
		return toString("");
	}
	
	/**
	 * Merges all items in a queue and returns it with a delimiter between every item. 
	 */
	@Override
	public String toString(String delimiter) {
		String s = "";
		try {
			if(size > 0) {
				MyNode<T> current = head;
				while(current.next != null) {
					s += current.data + delimiter;
					current = current.next;
				}
				s += current.data; 
			}
		} catch(Exception e) {
			e.getMessage();
		}
		return s;		
	}
	
	/**
	 * Fills the queue with an list provided in the parameters.
	 */
	@Override
	public void fill(ArrayList<T> list) {
		try {
			ArrayList<T> listcpy = new ArrayList<T>();
			for(T s:  list) {
				listcpy.add(s);
			}
			
			for(T s: listcpy) {
				enqueue(s);
			}
		} catch(Exception e) {
			e.getMessage();
		}
	}
}
