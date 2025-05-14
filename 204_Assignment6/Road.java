import java.util.ArrayList;

/**
 * Road Data Element (edge) for graph 
 */
public class Road implements Comparable<Road> {
	private String roadName;
	private int distance;
	private Town start;
	private Town end;
		
	/**
	 * Constructor; sets fields.
	 * @param start
	 * @param end
	 * @param distance
	 * @param roadName
	 */
	public Road(Town start, Town end,int distance, String roadName ) {
		this.roadName = roadName;
		this.distance = distance;
		this.start = start;
		this.end = end;
	}
	
	/**
	 * Copy constructor
	 * @param other
	 */
	public Road(Road other) {
		this.roadName = other.roadName;
		this.distance = other.distance;
		this.start = other.start;
		this.end = other.end;
	}
	
	/**
	 * Road name setter
	 * @param roadName
	 */
	public void setName(String roadName){
		this.roadName = roadName;
	}
	
	/**
	 * Road name getter
	 * @return
	 */
	public String getName() {
		return roadName;
	}
	
	/**
	 * Road weight setter
	 * @param distance
	 */
	public void setWeight(int distance){
		this.distance = distance;
	}
	
	/**
	 * Road weight getter
	 * @return
	 */
	public int getWeight() {
		return distance;
	}

	/**
	 * Road source setter
	 * @param start
	 */
	public void setSource(Town start){
		this.start = start;
	}
	
	/**
	 * Road source getter
	 * @return
	 */
	public Town getSource() {
		return start;
	}
	
	/**
	 * Road destination setter
	 * @param end
	 */
	public void setDestination(Town end){
		this.end = end;
	}
	
	/**
	 * Road destination getter
	 * @return
	 */
	public Town getDestination() {
		return end;
	}
	
	/**
	 * 
	 */
	@Override
	public String toString() {
		String s = roadName + " " + distance + " " + end  + " " + start; 
		return s;
	}

	/**
	 * Checks if a road contains a town as its source or destination
	 * @param town
	 * @return true if the road contains the town; false otherwise
	 */
	public boolean contains(Town town) {
		return(this.end.compareTo(town) == 0 || this.start.compareTo(town) == 0);
	}
	
	
	/**
	 * 
	 */
	@Override
	public int compareTo(Road r) {
		if((r.getName().equals(this.roadName))) {
			return 0;
		}
		return -1;
	}
	
	/**
	 * 
	 */
	@Override
	public boolean equals(Object o) {
		if(o instanceof Road) {
			return this.compareTo((Road)o) == 0;
		}
		return false;
	}
	
	
}
