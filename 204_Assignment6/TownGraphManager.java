import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Set;
/**
 * Data Manager the graph data structure
 */
public class TownGraphManager implements TownGraphManagerInterface {
	Graph graph;
	
	/**
	 * Copy constructor which initializes a graph
	 */
	public TownGraphManager() {
		graph = new Graph();
	}
	
	/**
	 * 
	 */
	@Override
	public boolean addRoad(String town1, String town2, int weight, String roadName) {
		Town temp1 = null;
		Town temp2 = null;
		for(Town t : graph.vertexSet()) {
			if(t.getName().equals(town1)) {
				temp1 = new Town(town1);
			} 
			if(t.getName().equals(town2)) {
				temp2 = new Town(town2);
			}
		}
		if(temp1 == null || temp2 == null) {
			return false;
		}
		graph.addEdge(temp1,temp2,weight,roadName);
		return true;
	}
	
	/**
	 * 
	 */
	@Override
	public String getRoad(String town1, String town2) {
		Town temp1 = null;
		Town temp2 = null;
		for(Town t : graph.vertexSet()) {
			if(t.getName().equals(town1)) {
				temp1 = new Town(town1);
			} 
			if(t.getName().equals(town2)) {
				temp2 = new Town(town2);
			}
		}
		if(temp1 == null || temp2 == null) {
			return null;
		}
		
		return graph.getEdge(temp1, temp2).getName();
	}

	/**
	 * 
	 */
	@Override
	public boolean addTown(String v) {
		Town town = new Town(v);
		graph.addVertex(town);
		if(graph.containsVertex(town) == false) {
			return false;
		}
		return true;
	}

	/**
	 * 
	 */
	@Override
	public Town getTown(String name) {
		for(Town t : graph.vertexSet()) {
			if(t.equals(new Town(name)));
			return t;
		}
		return null;
	}

	@Override
	public boolean containsTown(String v) {
		Town town = new Town(v);
		return graph.containsVertex(town);
	}
	
	/**
	 * 
	 */
	@Override
	public boolean containsRoadConnection(String town1, String town2) {
		Town t1 = new Town(town1);
		Town t2 = new Town(town2);
		return graph.containsEdge(t1, t2);
	}

	@Override
	public ArrayList<String> allRoads() {
		ArrayList<String> allRoads = new ArrayList<String>();
		Set<Road> roads = graph.edgeSet();
		if(roads == null) {
			return null;
		}
		for(Road r  : roads) {
			allRoads.add(r.getName());
		}
		Collections.sort(allRoads);
		return allRoads;
	}

	/**
	 * 
	 */
	@Override
	public boolean deleteRoadConnection(String town1, String town2, String road) {
		Town t1 = new Town(town1);
		Town t2 = new Town(town2);
		if(t1 == null || t2 == null) {
			return false;
		}
		Road r = graph.getEdge(t1,t2);
		if(r == null) {
			return false;
		}
		graph.removeEdge(r.getSource(),r.getDestination(),r.getWeight(),r.getName());
		return true;
	}

	/**
	 * 
	 */
	@Override
	public boolean deleteTown(String v) {
		return graph.removeVertex(new Town(v));
	}

	/**
	 * 
	 */
	@Override
	public ArrayList<String> allTowns() {
		ArrayList<Town> townList =  new ArrayList<Town>(graph.vertexSet());
		if(townList.isEmpty()) {
			return null;
		}
		ArrayList<String> townNames = new ArrayList<String>();
		for(Town t : townList) {
			townNames.add(t.getName());
		}
		Collections.sort(townNames);
		return townNames;
	}

	/**
	 * 
	 */
	@Override
	public ArrayList<String> getPath(String town1, String town2) {
		Town t1 = new Town(town1);
		Town t2 = new Town(town2);
		if(graph.edgesOf(t1).isEmpty() || graph.edgesOf(t2).isEmpty()) {
			return new ArrayList<String>();
		}
		return graph.shortestPath(t1, t2);
	}
	
	/**
	 * Populates the graph using town and roads that are given from an input file.
	 * @param sourceFile
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public void populateTownGraph(File sourceFile) throws FileNotFoundException, IOException {
		Scanner scan; 
		scan = new Scanner(sourceFile);
			while(scan.hasNextLine()) {
				String[] arr = scan.nextLine().split(";");
				String[] roadNameAndDist = arr[0].split(",");
				Town t1 = new Town(arr[1]);
				Town t2 = new Town(arr[2]);
				int dist = Integer.parseInt(roadNameAndDist[1]);
				String roadName = roadNameAndDist[0];
				graph.addVertex(t1);
				graph.addVertex(t2);
				graph.addEdge(t1,t2,dist,roadName);
			}
			scan.close();
	}
}
