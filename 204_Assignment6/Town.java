import java.util.ArrayList;
import java.util.HashSet;
import java.util.ArrayList;
/**
 * Data Element (vertex) for Graph.
 */
public class Town implements Comparable<Town>{
	
	private String townName;
	private ArrayList<Town> adjTowns;
	private ArrayList<Integer> adjWeights;
	private int minWt;
	
	/**
	 * Constructor which initializes fields
	 * @param name
	 */
	public Town(String name) {
		this.townName = name;
		adjTowns = new ArrayList<Town>();
		adjTowns = new ArrayList<Town>();
		adjWeights = new ArrayList<Integer>();
	}
	
	/**
	 * Copy Constructor
	 * @param other
	 */
	public Town(Town other) {
		this.townName = other.getName();
		this.adjTowns = other.getAdjTowns();
		this.adjWeights = other.getAdjWeights();

	}
	
//	public Town(String name, ArrayList<Town> adjTowns) {
//		townName = name;
//		this.adjTowns = adjTowns;
//	}
	
	/**
	 * Name of town Getter
	 * @return name
	 */
	public String getName() {
		return townName;
	}
	
	/**
	 * Name of town Setter
	 * @param name
	 */
	public void setName(String name) {
		townName = name;
	}
	
	/**
	 * Adjacent town list Getter
	 * @return adjacent town list
	 */
	public ArrayList<Town> getAdjTowns() {
		return adjTowns;
	}
	
	/**
	 * Adjacent town weight Setter
	 * @return adjacent town weight
	 */
	public ArrayList<Integer> getAdjWeights() {
		return adjWeights;
	}
	
	/**
	 * Adjacent town list Setter
	 * @param adjTowns
	 */
	public void setAdjTowns (ArrayList<Town> adjTowns) {
		this.adjTowns = adjTowns;
	}
	
	/**
	 * Adds an adjacent town and its weight to the corresponding adjacent town and adjacent weight lists respectively.
	 * @param town
	 * @param weight
	 */
	public void addAdjTown(Town town, Integer weight) {
		adjTowns.add(town);
		adjWeights.add( adjTowns.indexOf(town), weight);
	}
	
	/**
	 * Gets distance from an adjacent town
	 * @param adjTown
	 * @return distance from adjacent twown
	 */
	public Integer getDistanceFrom(Town adjTown) {
		if(adjTowns.size() != adjWeights.size()) {
		}

		int index = adjTowns.indexOf(adjTown);
		if(index == -1 ) {  
			return Integer.MAX_VALUE;
		}
		return adjWeights.get(index);
	}
	
	/**
	 * Sets distance from adjacent town using the weight
	 * @param adjTown
	 * @param weight
	 */
	public void setDistanceFrom(Town adjTown, int weight) {
		int index = adjTowns.indexOf(adjTown);
		if(index != -1 ) { 
			adjWeights.set(adjTowns.indexOf(adjTown), weight);
		}
	}
	
	/**
	 * Gets minimum distance
	 * @return minimum distance
	 */
	public int getMinWt() {
		return minWt;
	}
	
	/**
	 * Sets minimum distance
	 * @param minWt
	 */
	public void setMinWt(int minWt) {
		this.minWt = minWt;
	}
	
	/**
	 * 
	 */
	@Override
	public String toString() {
		String s = townName + " ";
		if(adjTowns != null) {
			for(Town t : adjTowns){
				s += t.townName + " ";
			}
		}
		
		return s;
	}
	
	/**
	 * 
	 */
	@Override
	public int compareTo(Town t) {
		if(t.getName().equals(this.townName)){
			return 0;
		}
		return -1;
	}
	
	/**
	 * 
	 */
	@Override
	public boolean equals(Object o) {
		if(o instanceof Town) {
			return this.compareTo((Town)o) == 0;
		}
		return false;
	}
}
