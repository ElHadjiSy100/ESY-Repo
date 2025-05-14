import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class TownGraphManager_STUDENT_Test {
	private TownGraphManagerInterface studentGraph;
	private String[] towns;
	  
	@Before
	public void setUp() throws Exception {
		  studentGraph = new TownGraphManager();
		  towns = new String[24];
		  
		  for (int i = 13; i < 24; i++) {
			  towns[i] = "Town_" + i;
			  studentGraph.addTown(towns[i]);
		  }
		  
		  studentGraph.addRoad(towns[13], towns[14], 23, "Road_A");
		  studentGraph.addRoad(towns[13], towns[15], 45, "Road_B");
		  studentGraph.addRoad(towns[13], towns[17], 67, "Road_C");
		  studentGraph.addRoad(towns[15], towns[19], 12, "Road_D");
		  studentGraph.addRoad(towns[15], towns[20], 23, "Road_E");
		  studentGraph.addRoad(towns[16], towns[20], 34, "Road_F");
		  studentGraph.addRoad(towns[18], towns[21], 34, "Road_G");
		  studentGraph.addRoad(towns[21], towns[22], 45, "Road_H");
		  studentGraph.addRoad(towns[20], towns[22], 23, "Road_I");
		  studentGraph.addRoad(towns[17], towns[22], 56, "Road_J");
		  studentGraph.addRoad(towns[22], towns[23], 34, "Road_K");
		  studentGraph.addRoad(towns[14], towns[23], 67, "Road_L");
		 
	}

	@After
	public void tearDown() throws Exception {
		studentGraph = null;
	}

	@Test
	public void testAddRoad() {
		ArrayList<String> roads = studentGraph.allRoads();
		assertEquals("Road_A", roads.get(0));
		assertEquals("Road_J", roads.get(9));
		assertEquals("Road_K", roads.get(10));
		assertEquals("Road_L", roads.get(11));
		studentGraph.addRoad(towns[16], towns[23], 1,"Road_M");
		roads = studentGraph.allRoads();
		assertEquals("Road_A", roads.get(0));
		assertEquals("Road_J", roads.get(9));
		assertEquals("Road_K", roads.get(10));
		assertEquals("Road_L", roads.get(11));
		assertEquals("Road_M", roads.get(12));
		
	}

	@Test
	public void testGetRoad() {
		assertEquals("Road_L", studentGraph.getRoad(towns[14], towns[23]));
		assertEquals("Road_D", studentGraph.getRoad(towns[15], towns[19]));
	}

	@Test
	public void testAddTown() {
		assertEquals(false, studentGraph.containsTown("Town_24"));
		studentGraph.addTown("Town_24");
		assertEquals(true, studentGraph.containsTown("Town_24"));
	}
	
	@Test
	public void testDisjointGraph() {
		assertEquals(false, studentGraph.containsTown("Town_24"));
		studentGraph.addTown("Town_24");
		ArrayList<String> path = studentGraph.getPath(towns[13],"Town_24");
		assertFalse(path.size() > 0);
	}

	@Test
	public void testContainsTown() {
		assertEquals(true, studentGraph.containsTown("Town_14"));
		assertEquals(false, studentGraph.containsTown("Town_24"));
	}

	@Test
	public void testContainsRoadConnection() {
		assertEquals(true, studentGraph.containsRoadConnection(towns[14], towns[23]));
		assertEquals(false, studentGraph.containsRoadConnection(towns[15], towns[17]));
	}

	@Test
	public void testAllRoads() {
		ArrayList<String> roads = studentGraph.allRoads();
		assertEquals("Road_A", roads.get(0));
		assertEquals("Road_J", roads.get(9));
		assertEquals("Road_K", roads.get(10));
		assertEquals("Road_H", roads.get(7));
		assertEquals("Road_I", roads.get(8));
	}

	@Test
	public void testDeleteRoadConnection() {
		assertEquals(true, studentGraph.containsRoadConnection(towns[14], towns[23]));
		studentGraph.deleteRoadConnection(towns[14], towns[23], "Road_L");
		assertEquals(false, studentGraph.containsRoadConnection(towns[14], towns[23]));
	}

	@Test
	public void testDeleteTown() {
		assertEquals(true, studentGraph.containsTown("Town_14"));
		studentGraph.deleteTown(towns[14]);
		assertEquals(false, studentGraph.containsTown("Town_14"));
	}
	
	@Test
	public void testAllTowns() {
		ArrayList<String> roads = studentGraph.allTowns();
		assertEquals("Town_13", roads.get(0));
		assertEquals("Town_22", roads.get(9));
		assertEquals("Town_23", roads.get(10));
		assertEquals("Town_14", roads.get(1));
		assertEquals("Town_20", roads.get(7));
	}

	@Test
	public void testGetPath() {
		ArrayList<String> path = studentGraph.getPath(towns[13],towns[23]);
		  assertNotNull(path);
		  assertTrue(path.size() > 0);
		  assertEquals("Town_13 via Road_A to Town_14 23 mi",path.get(0).trim());
		  assertEquals("Town_14 via Road_L to Town_23 67 mi",path.get(1).trim());

	}
	
	@Test
	public void testGetPathA() {
		ArrayList<String> path = studentGraph.getPath(towns[13],towns[22]);
		  assertNotNull(path);
		  assertTrue(path.size() > 0);
		  assertEquals("Town_13 via Road_B to Town_15 45 mi",path.get(0).trim());
		  assertEquals("Town_15 via Road_E to Town_20 23 mi",path.get(1).trim());
		  assertEquals("Town_20 via Road_I to Town_22 23 mi",path.get(2).trim());
	}
	
	@Test
	public void testGetPathB() {
		ArrayList<String> path = studentGraph.getPath(towns[13],towns[18]);
		  assertNotNull(path);
		  assertTrue(path.size() > 0);
		  assertEquals("Town_13 via Road_B to Town_15 45 mi",path.get(0).trim());
		  assertEquals("Town_15 via Road_E to Town_20 23 mi",path.get(1).trim());
		  assertEquals("Town_20 via Road_I to Town_22 23 mi",path.get(2).trim());
		  assertEquals("Town_22 via Road_H to Town_21 45 mi",path.get(3).trim());
		  assertEquals("Town_21 via Road_G to Town_18 34 mi",path.get(4).trim());

	}

}
