import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
/**
 * Graph class which uses Towns as vertexes and Roads as Edges
 * @author El Hadji Sy
 */

public class Graph implements GraphInterface<Town,Road> {
	private ArrayList<ArrayList<Road>> edges ;
	private ArrayList<Town> towns;
	private ArrayList<ArrayList<Integer>> adjMatrix;
	private int[] previous;
	private int minPath[];
	/**
	 * Constructor which initializes ArrayList fields.
	 */
	public Graph() {
		edges = new ArrayList<ArrayList<Road>>();
		towns = new ArrayList<Town>();
		adjMatrix = new ArrayList<ArrayList<Integer>>();
	}
	
	/**
	 * 
	 */
	@Override
	public Road getEdge(Town sourceVertex, Town destinationVertex) {
		if(sourceVertex == null || destinationVertex == null || sourceVertex .compareTo(destinationVertex) == 0) {
			return null;
		}
		
		int sourceIndex = towns.indexOf(sourceVertex);
		int destinationIndex = towns.indexOf(destinationVertex);
		
		int index = towns.indexOf(
				(edges.get(sourceIndex).size() < edges.get(destinationIndex).size() )? 
						sourceVertex : destinationVertex);
	
		for(Road r: edges.get(index)) {			
			int otherIndex = towns.indexOf(
					(edges.get(sourceIndex).size() < edges.get(destinationIndex).size() )? 
							destinationVertex : sourceVertex);
		
			if(r.getDestination().equals(towns.get(otherIndex)) || r.getSource().equals(towns.get(otherIndex))) {
				return r;
			}
		}
		return null;
	}
		
	/**
	 * 
	 */
	@Override
	public Road addEdge(Town sourceVertex, Town destinationVertex, int weight, String description) {
		if(sourceVertex == null || destinationVertex == null) {
			throw new NullPointerException();
		}
		boolean containsSrc = false;
		boolean containsDest = false;
		for(Town t : towns) {
			if(t.equals(sourceVertex)) {
				containsSrc = true;
			}
			if(t.equals(destinationVertex)) {
				containsDest = true;
			}
		}
		if(!containsSrc || !containsDest) {
			throw new IllegalArgumentException();
		}
		Road road = new Road(sourceVertex,destinationVertex,weight,description);
		int sourceIndex = towns.indexOf(sourceVertex);
		int destinationIndex = towns.indexOf(destinationVertex);
		edges.get(sourceIndex).add(road);
		edges.get(destinationIndex).add(road);

		int currentWeight = adjMatrix.get(destinationIndex).get(sourceIndex);
		if(currentWeight > weight) {
			adjMatrix.get(destinationIndex).set(sourceIndex,weight); 
			adjMatrix.get(sourceIndex).set(destinationIndex,weight); 
		}
		ArrayList<Town> sourceTowns = sourceVertex.getAdjTowns();
		ArrayList<Town> destTowns = destinationVertex.getAdjTowns();
		destTowns.add(sourceVertex);
		sourceTowns.add(destinationVertex);
		destinationVertex.setAdjTowns(destTowns);
		sourceVertex.setAdjTowns(sourceTowns);
		return road;
	}
	
	/**
	 * 
	 */
	@Override
	public boolean addVertex(Town v) {
		if(v == null) {
			throw new NullPointerException();
		}
		for(Town t : towns) {
			if(t.compareTo(v) == 0) {
				return false;
			}
		}
		
		for(int i = 0; i < towns.size(); i++) {
			adjMatrix.get(i).add(Integer.MAX_VALUE);
		}
		towns.add(v);
		adjMatrix.add(new ArrayList<Integer>());
		for(int i = 0; i < towns.size(); i++) {
			adjMatrix.get(towns.size() - 1).add(Integer.MAX_VALUE);
		}
		adjMatrix.get(towns.size()-1).set(towns.size() - 1, 0);
		edges.add(new ArrayList<Road>());
		return true;
	}
	
	/**
	 * 
	 */
	@Override
	public boolean containsEdge(Town sourceVertex, Town destinationVertex) {
		return adjMatrix.get(towns.indexOf(sourceVertex)).get(
				towns.indexOf(destinationVertex)) != Integer.MAX_VALUE;
	}
	
	/**
	 * 
	 */
	@Override
	public boolean containsVertex(Town v) {
		return towns.contains(v);
	}
	
	/**
	 * 
	 */
	@Override
	public Set<Road> edgeSet() {
		HashSet<Road> edgeSet = new HashSet<Road>();
		for(ArrayList<Road> a : edges) {
			edgeSet.addAll(a);
		}
		return edgeSet;
	}
	
	/**
	 * 
	 */
	@Override
	public Set<Road> edgesOf(Town vertex) {
		if(vertex == null) {
			throw new NullPointerException();
		}
		boolean containsSrc = false;
		for(Town t : towns) {
			if(t.equals(vertex)) {
				containsSrc = true;
			}
		}
		if(!containsSrc) {
			throw new IllegalArgumentException();
		}
		return new HashSet<Road>(edges.get(towns.indexOf(vertex)));
	}

	/**
	 * 
	 */
	@Override
	public Road removeEdge(Town sourceVertex, Town destinationVertex, int weight, String description) {
		if(sourceVertex == null || destinationVertex == null || !containsEdge(sourceVertex,destinationVertex)) {
			return null;
		}
		
		
		int sourceIndex = towns.indexOf(sourceVertex);
		Road ret = null;
		for(Road r : edges.get(sourceIndex)){
			if(r.getDestination().compareTo(destinationVertex) == 0 || r.getSource().compareTo(destinationVertex) == 0 ) {
				ret = r;
				int destinationIndex = towns.indexOf(destinationVertex);
				edges.get(sourceIndex).remove(r);
				edges.get(destinationIndex).remove(r);
				adjMatrix.get(destinationIndex).set(sourceIndex,Integer.MAX_VALUE); 
				adjMatrix.get(sourceIndex).set(destinationIndex,Integer.MAX_VALUE);
				break;
			}
		}
		return ret;
	}

	/**
	 * 
	 */
	@Override
	public boolean removeVertex(Town v) {
		Town copyTown = null;
		int index = -1;
		
		boolean exists = false;
		for(Town t: towns) {
			if(t.compareTo(v) == 0) {
				exists = true;
				index = towns.indexOf(t);
				copyTown = t;
				break;
			}
		}
		

		if(!exists) {
			return false;
		}
		
		ArrayList<Road> edgesCopy = new ArrayList<Road>();
		for(Road oldEdge : edges.get(index)) {
			edgesCopy.add(new Road(oldEdge));
		}

		for(Road r: edgesCopy) {
			removeEdge(r.getSource(),r.getDestination(),r.getWeight(),r.getName());
		}
		towns.remove(copyTown);
		edges.remove(index);
		
		for(ArrayList<Integer> row : adjMatrix) {
			row.remove(index);
		}
		adjMatrix.remove(index);
		return true;
	}
	
	/**
	 * 
	 */
	@Override
	public Set<Town> vertexSet() {
		return new HashSet<Town>(towns);
	}
	
	/**
	 * 
	 */
	public ArrayList<String> shortestPath(Town sourceVertex, Town destinationVertex){
		if(!towns.contains(destinationVertex) || !towns.contains(sourceVertex)) {
			return null;
		}
		dijkstraShortestPath(sourceVertex);
		ArrayList<String> shortest = new ArrayList<String>();
		int destIndex = towns.indexOf(destinationVertex);

		if(minPath != null && minPath[destIndex] == Integer.MAX_VALUE) {
			return null;
		} else {
			int i = destIndex;
			while(previous[i] != -1) {
				String roadName = getEdge(towns.get(previous[i]),towns.get(i)).getName();
				String s = towns.get(previous[i]).getName() + " via " + roadName + " to " + towns.get(i).getName()
						+ " " + (minPath[i] - minPath[previous[i]]) + " mi";
				shortest.add(0, s);
				i = previous[i];
			}
		}

		return shortest;

	}
	
	/**
	 * 
	 */
   @Override
   public void dijkstraShortestPath(Town sourceVertex) {
    int sourceIndex = towns.indexOf(sourceVertex);
	int size = towns.size();
	previous = new int[size];
    boolean[] seen = new boolean[size];
    minPath = new int[size];
    for (int i = 0; i < size; i++) {
      seen[i] = false;
      minPath[i] = Integer.MAX_VALUE;
      previous[i] = -1;
    }
    
    for(int i = 0; i < towns.size(); i++) {
    	minPath[i] = adjMatrix.get(sourceIndex).get(i);
		previous[i] = sourceIndex;
    }
    
    seen[sourceIndex] = true;
    previous[sourceIndex] = -1;
   
    int numSeen = 1;
    int currTown = findMinPath(minPath, seen)[0];
    previous[currTown] = sourceIndex;
    while(numSeen != towns.size()) {
    	if(!seen[currTown]) {
        	seen[currTown] = true;
        	numSeen++;
    	}
    	
    	ArrayList<Integer> townAdjs = new ArrayList<Integer>();
    	for(int i = 0; i < adjMatrix.get(currTown).size(); i++) {
    		if(currTown != i && adjMatrix.get(currTown).get(i) != Integer.MAX_VALUE) {
    			townAdjs.add(i);
    		}
    	}

       	for(int adjTown : townAdjs) {
    		if(!seen[adjTown]) {
    			int proposedWt = getEdge(towns.get(currTown), towns.get(adjTown)).getWeight() + minPath[currTown];
    			if(proposedWt < minPath[adjTown]) {
    				minPath[adjTown] = proposedWt;
    				previous[adjTown] = currTown;
    			}
    		}
    	}
       	
        if(numSeen != towns.size()) {
    	int nextTown = findMinPath(minPath, seen)[0];
    	currTown =nextTown;
        }
    }

  }

   /**
    * Finds the minimum adjacent town and weight from a given town which has been seen.
    * @param weight
    * @param seen
    * @return array of minimum adjacent town and minimum weight.
    */
  public int[] findMinPath(int[] weight, boolean[] seen) {
    int minWeight = Integer.MAX_VALUE;
    int minAdjTown = -1;
    for (int i = 0; i < weight.length; i++) {
      if (!seen[i] && weight[i] < minWeight) {
        minWeight = weight[i];
        minAdjTown = i;
      }
    }
    int[] ret = {minAdjTown, minWeight};
    return ret;
  }
}