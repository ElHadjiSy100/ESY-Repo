
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class Graph_STUDENT_Test {
	private GraphInterface<Town,Road> studentGraph;
	private Town[] towns;

	@Before
	public void setUp() throws Exception {
		 studentGraph = new Graph();
		  towns = new Town[24];
		  
		  for (int i = 13; i < 24; i++) {
			  towns[i] = new Town("Town_" + i);
			  studentGraph.addVertex(towns[i]);
		  }
		  
		  studentGraph.addEdge(towns[13], towns[14], 23, "Road_A");
		  studentGraph.addEdge(towns[13], towns[15], 45, "Road_B");
		  studentGraph.addEdge(towns[13], towns[17], 67, "Road_C");
		  studentGraph.addEdge(towns[15], towns[19], 12, "Road_D");
		  studentGraph.addEdge(towns[15], towns[20], 23, "Road_E");
		  studentGraph.addEdge(towns[16], towns[20], 34, "Road_F");
		  studentGraph.addEdge(towns[18], towns[21], 34, "Road_G");
		  studentGraph.addEdge(towns[21], towns[22], 45, "Road_H");
		  studentGraph.addEdge(towns[20], towns[22], 23, "Road_I");
		  studentGraph.addEdge(towns[17], towns[22], 56, "Road_J");
		  studentGraph.addEdge(towns[22], towns[23], 34, "Road_K");
		  studentGraph.addEdge(towns[14], towns[23], 67, "Road_L");
		 
	}

	@After
	public void tearDown() throws Exception {
		studentGraph = null;
	}

	@Test
	public void testGetEdge() {
		assertEquals(new Road(towns[16], towns[20],34, "Road_F"), studentGraph.getEdge(towns[16], towns[20]));
	}

	@Test
	public void testAddEdge() {
		assertEquals(false, studentGraph.containsEdge(towns[16], towns[18]));
		studentGraph.addEdge(towns[16], towns[18], 12, "Road_M");
		assertEquals(true, studentGraph.containsEdge(towns[16], towns[18]));
	}

	@Test
	public void testAddVertex() {
		Town newTown = new Town("Town_24");
		assertEquals(false, studentGraph.containsVertex(newTown));
		studentGraph.addVertex(newTown);
		assertEquals(true, studentGraph.containsVertex(newTown));
	}

	@Test
	public void testContainsEdge() {
		assertEquals(true, studentGraph.containsEdge(towns[15], towns[20]));
		assertEquals(false, studentGraph.containsEdge(towns[16], towns[18]));
	}

	@Test
	public void testContainsVertex() {
		assertEquals(true, studentGraph.containsVertex(new Town("Town_14")));
		assertEquals(false, studentGraph.containsVertex(new Town("Town_24")));
	}

	@Test
	public void testEdgeSet() {
		Set<Road> roads = studentGraph.edgeSet();
		ArrayList<String> roadArrayList = new ArrayList<String>();
		for(Road road : roads)
			roadArrayList.add(road.getName());
		Collections.sort(roadArrayList);
		assertEquals("Road_A", roadArrayList.get(0));
		assertEquals("Road_B", roadArrayList.get(1));
		assertEquals("Road_C", roadArrayList.get(2));
		assertEquals("Road_D", roadArrayList.get(3));
		assertEquals("Road_E", roadArrayList.get(4));
		assertEquals("Road_K", roadArrayList.get(10));
	}

	@Test
	public void testEdgesOf() {
		Set<Road> roads = studentGraph.edgesOf(towns[14]);
		ArrayList<String> roadArrayList = new ArrayList<String>();
		for(Road road : roads)
			roadArrayList.add(road.getName());
		Collections.sort(roadArrayList);
		assertEquals("Road_A", roadArrayList.get(0));
		assertEquals("Road_L", roadArrayList.get(1));
	}
	
	@Test
	public void testRemoveEdge() {
		assertEquals(true, studentGraph.containsEdge(towns[16], towns[20]));
		studentGraph.removeEdge(towns[16], towns[20], 34, "Road_F");
		assertEquals(false, studentGraph.containsEdge(towns[16], towns[20]));
	}
	
	@Test
	public void testRemoveVertex() {
		assertEquals(true, studentGraph.containsVertex(towns[15]));
		studentGraph.removeVertex(towns[15]);
		assertEquals(false, studentGraph.containsVertex(towns[15]));
	}

	@Test
	public void testVertexSet() {
		Set<Town> roads = studentGraph.vertexSet();
		assertEquals(true,roads.contains(towns[14]));
		assertEquals(true, roads.contains(towns[22]));
		assertEquals(true, roads.contains(towns[23]));
		assertEquals(true, roads.contains(towns[15]));
		assertEquals(true, roads.contains(towns[16]));
	}

	 @Test
	  public void testTown_1ToTown_11() {
		  String beginTown = "Town_13", endTown = "Town_23";
		  Town beginIndex=null, endIndex=null;
		  Set<Town> towns = studentGraph.vertexSet();
		  Iterator<Town> iterator = towns.iterator();
		  while(iterator.hasNext())
		  {    	
			  Town town = iterator.next();
			  if(town.getName().equals(beginTown))
				  beginIndex = town;
			  if(town.getName().equals(endTown))
				  endIndex = town;		
		  }
		  if(beginIndex != null && endIndex != null)
		  {

			  ArrayList<String> path = studentGraph.shortestPath(beginIndex,endIndex);
			  assertNotNull(path);
			  assertTrue(path.size() > 0);
			  assertEquals("Town_13 via Road_A to Town_14 23 mi",path.get(0).trim());
			  assertEquals("Town_14 via Road_L to Town_23 67 mi",path.get(1).trim());
		  }
		  else
			  fail("Town names are not valid");

	  }
	  
	  
	  @Test
	  public void testTown1ToTown_10() {
		  String beginTown = "Town_13", endTown = "Town_23";
		  Town beginIndex=null, endIndex=null;
		  Set<Town> towns = studentGraph.vertexSet();
		  Iterator<Town> iterator = towns.iterator();
		  while(iterator.hasNext())
		  {    	
			  Town town = iterator.next();
			  if(town.getName().equals(beginTown))
				  beginIndex = town;
			  if(town.getName().equals(endTown))
				  endIndex = town;		
		  }
		  if(beginIndex != null && endIndex != null)
		  {
			  ArrayList<String> path = studentGraph.shortestPath(beginIndex,endIndex);
			  assertNotNull(path);
			  assertTrue(path.size() > 0);
			  assertEquals("Town_13 via Road_A to Town_14 23 mi",path.get(0).trim());
			  assertEquals("Town_14 via Road_L to Town_23 67 mi",path.get(1).trim());
		  }
		  else
			  fail("Town names are not valid");

	  }
	  
	  @Test
	  public void testTown_4ToTown_11() {
		  String beginTown = "Town_17", endTown = "Town_23";
		  Town beginIndex=null, endIndex=null;
		  Set<Town> towns = studentGraph.vertexSet();
		  Iterator<Town> iterator = towns.iterator();
		  while(iterator.hasNext())
		  {    	
			  Town town = iterator.next();
			  if(town.getName().equals(beginTown))
				  beginIndex = town;
			  if(town.getName().equals(endTown))
				  endIndex = town;		
		  }
		
		  if(beginIndex != null && endIndex != null)
		  {
			  ArrayList<String> path = studentGraph.shortestPath(beginIndex,endIndex);
			  assertNotNull(path);
			  assertTrue(path.size() > 0);
			  assertEquals("Town_17 via Road_J to Town_22 56 mi",path.get(0).trim());
			  assertEquals("Town_22 via Road_K to Town_23 34 mi",path.get(1).trim());
		  }
		  else
			  fail("Town names are not valid");

	  }
}