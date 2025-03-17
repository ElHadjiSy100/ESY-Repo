import java.util.ListIterator;
import java.util.NoSuchElementException;
/**
 * Class for a basic doubly linked list, which implements the iterable interface. The class contains a 
 * nested iterator and node class within it.
 * @author El Hadji Sy
 * @param <T>
 */
public class BasicDoubleLinkedList<T> implements Iterable<T>{
	protected Node head;
	protected Node tail;
	protected int size = 0;
	
	/**
	 * Inner node class for the double linked list
	 * @author El Hadji Sy
	 */
	public class Node {
		protected T data;
		protected Node prev;
		protected Node next; 
	/**
	 * Constructor for a node; sets data passed in as the data attribute of the node.
	 * @param dataNode
	 */
		public Node(T dataNode) {
			this.next = null;
			this.prev = null;
			this.data = dataNode;
		}
	}	
	
	/**
	 * Basic constructor.
	 */
	public BasicDoubleLinkedList() {
	
	}
	
	/**
	 * Returns size of the linked list.
	 * @return size of list.
	 */
	public int getSize() {
		return size;
	}
	
	/**
	 * Adds to the end of the linked list.
	 * @param data
	 */
	public void addToEnd(T data) {
		Node temp = new Node(data);
		if(head == tail) {
			if(tail == null) {
				tail = head = temp;
			} else if(tail != null) {
				head.next = temp;
				temp.prev = tail;
				tail = temp;
			}
		} else {
			tail.next = temp;
			temp.prev = tail;
			tail = temp;
		}

		size++;
	}
	
	/**
	 * Adds to the beginning of the linked list.
	 * @param data
	 */
	public void addToFront(T data) {
		Node temp = new Node(data);
		if(head == tail) {
			if(head == null) {
				head = tail = temp;
			} else if(head != null) {
				temp.next = head;
				head.prev = temp;
				head = temp;
			} else {
				head = tail = temp;
			}
		} else {
			temp.next = head;
			head.prev = temp;
			head = temp;
		}
		size++;
	}
	
	/**
	 * Gets the first element of the linked list without removing it.
	 * @return the first element of the linked list.
	 */
	public T getFirst() {
		if(head != null) {
			return head.data;
		} 
		return null;
	}
	
	/**
	 * Gets the last element of the linked list without removing it.
	 * @return the last element of the linked list.
	 */
	public T getLast() {
		if(tail != null) {
			return tail.data;
		}
		return null;
	}
	
	/**
	 * Creates a new object of the doubly linked list iterator class.
	 */
	public ListIterator<T> iterator() {
		return new DoubleLinkedListIterator();
	}
	
	/**
	 * Removes a target from the linked list by comparing it to a comparator which is passed in.
	 * @param targetData
	 * @param comparator
	 * @return target if found in list, null if not found.
	 * 
	 */
	public BasicDoubleLinkedList.Node remove​(T targetData, java.util.Comparator<T> comparator) {
		Node curr = head;
		while(curr != null) {
			if(comparator.compare(targetData, curr.data) == 0) {
				if(curr.next != null && curr.prev != null) {
					curr.prev.next = curr.next;
					curr.next.prev = curr.prev;
				} else if(curr.next != null && curr.prev == null) {
					curr.next.prev = null;
					head = curr.next;
				} else if(curr.prev != null && curr.next == null) {
					curr.prev.next = null;
					tail = curr.prev;
				}
				size--;
				return curr;
			}
			curr = curr.next;
		}
		size--;
		return null;
	}
	/**
	 * Gets and removes the first element in the list.
	 * @return the first element in the list.
	 */
	public T retrieveFirstElement() {
		T first = getFirst();
		if(head != null) {
			if(head.next != null) {
				head.next.prev = null;
			}
			head = head.next;
		}
		size--;
		return first;
	}
	
	/**
	 * Gets and removes the last element in the list.
	 * @return the last element in the list.
	 */
	public T retrieveLastElement() {
		T last = getLast();
		if(tail != null) {
			if(tail.prev != null) {
				tail.prev.next = null;
			}
			tail = tail.prev;
		}
		size--;
		return last;
	}
	
	/**
	 * Returns an array list of all the items in the linked list.
	 * @return an array list of the linked list items.
	 */
	public java.util.ArrayList<T> toArrayList() {
		java.util.ArrayList<T> list = new java.util.ArrayList<T>();
		ListIterator<T> iterator = iterator();
		while(iterator.hasNext()) {
			list.add(iterator.next());
		}
		return list;
	}
	
	/**
	 * Inner class for the doubly linked list iterator.
	 * @author El Hadji Sy 
	 */
	public class DoubleLinkedListIterator implements ListIterator<T> {
		protected Node nextNode;
		protected Node prevNode;
		/**
		 * Creates a new iterator object.
		 */
		public DoubleLinkedListIterator() {
			this.nextNode = head;
		}
		
		/**
		 * Checks if there is a next node in the list.
		 */
		public boolean hasNext() {
			return nextNode != null;	
		}
		
		/**
		 * Jumps to the next position in the iteration, passing over an item in the list. Returns 
		 * the item it jumped over without removing it.
		 */
		public T next() throws NoSuchElementException { 
			T result; 
			if(hasNext()) {
				result = nextNode.data; 
				prevNode = nextNode;
				nextNode = nextNode.next;
			} else {
				throw new NoSuchElementException("Cannot call next()." + "Iterator is at end of list");
			}
			return result;
		}
		
		/**
		 * Unsupported operation of this iterator.
		 */
		public int nextIndex() throws UnsupportedOperationException {
			throw new UnsupportedOperationException("This operation is unsupported in this iterator");
		}

		/**
		 * Checks if the there is a previous node in the list.
		 */
		public boolean hasPrevious() {
			return prevNode != null;
		}
		
		/**
		 * Jumps back to the last position of iteration, passing over an item in the list. Returns 
		 * the item it jumped over without removing it.
		 */
		public T previous() throws NoSuchElementException{
			T result;
			if(hasPrevious()) {
				result = prevNode.data;
				nextNode = prevNode;
				prevNode = prevNode.prev;
			} else {
				throw new NoSuchElementException("Cannot call previous();" + "Iterator is at start of list");
			}
			return result;
		}
		
		/**
		 * Unsupported operation in this iterator.
		 */
		public int previousIndex() throws UnsupportedOperationException {
			throw new UnsupportedOperationException();
		}

		/**
		 * Unsupported operation in this iterator.
		 */
		public void add(T arg0) throws UnsupportedOperationException {
			throw new UnsupportedOperationException();
		}
		
		/**
		 * Unsupported operation in this iterator.
		 */
		public void remove() throws UnsupportedOperationException {
			throw new UnsupportedOperationException();
		}

		/**
		 * Unsupported operation in this iterator.
		 */
		public void set(T arg0) throws UnsupportedOperationException {
			throw new UnsupportedOperationException();
		}
	}

}
