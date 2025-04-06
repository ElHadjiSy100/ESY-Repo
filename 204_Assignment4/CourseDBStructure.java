import java.io.IOException;
import java.util.ArrayList;

/**
 * A class to create a hash table of CDEs.
 */
public class CourseDBStructure extends Node implements CourseDBStructureInterface {
	private Node[] hashTable;
	private int hashTableSize = 0;
	
	/**
	 * Creates a CDS structure (hash table) of CDEs. Hash table size is found by finding 
	 * the first 4k+3 prime greater than the integer which is passed in.
	 * @param n
	 */
	public CourseDBStructure(int n) {
		int nByLoad = (int) (n/1.5);
		boolean isPrime = true; 
		int k = 0;
		hashTableSize = 4*k + 3;
		while(hashTableSize <= nByLoad) {
			hashTableSize = 4*(++k)+3;
		}
		for(int i  = 2; i < Math.sqrt(hashTableSize); i++) {
			if(hashTableSize%i == 0) {
				isPrime = false;
			}
		}
		while(isPrime == false) {
			hashTableSize = 4*(++k)+3;
			isPrime = true;
			for(int i = 2; i < Math.sqrt(hashTableSize); i++) {
				if(hashTableSize%i == 0) {
					isPrime = false;
					break;
				}
			}
			k++;
		}
		hashTable = new Node[hashTableSize];
	}
	
	/**
	 * Creates a CDS structure (hash table) of CDEs for testing. Takes it an int as the hash table
	 * size, and a testing string for testing purposes.
	 * @param testing
	 * @param n
	 */
	public CourseDBStructure(String testing, int n) {
		hashTableSize = n;
		hashTable = new Node[n];
	}
	
	/**
	 * Uses a CDE's CRN to find the key value to add into a hash table of linked lists.
	 * If the table at a given key is empty, a node is created holding the CDE. If the table
	 * contains something, the CDE to be added is added to the tail of the linked list.
	 */
	@Override
	public void add(CourseDBElement element) {
		String crn = "" + element.getCRN();
		int key = crn.hashCode()%hashTableSize;
		if(hashTable[key] == null) {
			Node head = new Node();
			head.data = element;
			hashTable[key] = head;
		} else if(hashTable[key].data.compareTo(element) == 0) {
			return;
		} else { 
			Node curr = hashTable[key];
			if(curr.data.getCRN() == element.getCRN()) {
				curr.data = element;
			} else {
				while(curr.next != null) {
					curr = curr.next;
				}
				curr.next = new Node();
				curr.next.data = element;
				hashTable[key] = curr;
				}
		}
	}
	
	/**
	 * Gets an element from the CDS (hash table) given a specific CRN to search for. 
	 */
	@Override
	public CourseDBElement get(int crn) throws IOException {
		String CRN = "" + crn;
		int key = CRN.hashCode()%hashTableSize;
		if(hashTable[key] == null) {
			throw new IOException();
		} else if(hashTable[key].data.getCRN() == crn) {
			return hashTable[key].data;
		} else {
			Node curr = hashTable[key];
			while(curr.data.getCRN() != crn) {
				if(curr.next == null) {
					throw new IOException();
				}
				curr = curr.next;
			}
			return curr.data;
		}
	}

	/**
	 * Returns an array list that holds all the CDEs inside a given CDS. 
	 */
	@Override
	public ArrayList<String> showAll() {
		ArrayList<String> courses = new ArrayList<String>();
		for(int i = 0; i < hashTableSize; i++) {
			String course1  = "";
			Node curr = hashTable[i];
			if(curr == null && hashTableSize != i) {
				continue;
			} else {
				course1 += "\nCourse:" + curr.data.getID() + " CRN:" + curr.data.getCRN() + " Credits:"
				+ curr.data.getCredits() + " Instructor:" + curr.data.getInstructor() + " Room:" + curr.data.getRoomNum();
				courses.add(course1);
				if(curr.next != null) {
					curr = curr.next;
					while(curr != null) {
						String courseN = "";
						courseN += "\nCourse:" + curr.data.getID() + " CRN:" + curr.data.getCRN() + " Credits:"
						+ curr.data.getCredits() + " Room:" + curr.data.getRoomNum() + " Instructor:" + curr.data.getInstructor();
						courses.add(courseN);
						curr = curr.next;
					}
				}
			}
		}
		return courses;
	}
	
	/**
	 * Returns the hash table size.
	 */
	@Override
	public int getTableSize() {
		return hashTableSize;
	}

}
