import java.util.Comparator;
/**
 * Class for a sorted doubly linked list; extends the basic doubly linked list.
 * @param <T>
 * @author El Hadji Sy 
 */
public class SortedDoubleLinkedList<T> extends BasicDoubleLinkedList<T>{
	Comparator<T> comparator;
	/**
	 * Constructor for the sorted doubly linked list.
	 * @param comparableObject
	 */
	public SortedDoubleLinkedList(java.util.Comparator<T> comparableObject) {
		this.comparator = comparableObject;
	}
	
	/**
	 * Add method for the sorted linked list; will add in the order determined by the comparator.
	 * @param data
	 */
	public void add(T data) {
		Node curr = head;
		Node temp = new Node(data);

		if(curr == null) {
			head = tail = temp;
		} else {
			while(curr != null) {
				if(comparator.compare(curr.data, data) > 0) {
					temp.prev = curr.prev;
					if(curr != head) {
						curr.prev.next = temp;
					} else if(curr == head) {
						head = temp;
					}
					curr.prev = temp;
					temp.next = curr;
					size++;

					return;
				}
				curr = curr.next;
			}
			
			tail.next = temp;
			temp.prev = tail;
			tail = temp;	
		}
		size++;
	}
	
	/**
	 * Invalid operation for a sorted doubly linked list.
	 */
	public void addToEnd(T data) throws UnsupportedOperationException {
		throw new UnsupportedOperationException("Invalid operation for sorted list");
	}
	
	/**
	 * Invalid operation for a sorted doubly linked list.
	 */
	public void addToFront(T data) throws UnsupportedOperationException {
		throw new UnsupportedOperationException("Invalid operation for sorted list");
	}
	
	/**
	 * Returns a double linked list iterator.
	 */
	public java.util.ListIterator<T> iterator() {
		return new DoubleLinkedListIterator();
	}
	
	/**
	 * Removes the item specified by the data parameter, and to do that it first finds that item
	 * using the comparator. Calls the super class remove from the basic double linked list.
	 */
	public BasicDoubleLinkedList.Node remove​(T data, java.util.Comparator<T> comparator) {
		return(super.remove​(data, comparator));
	}
}
