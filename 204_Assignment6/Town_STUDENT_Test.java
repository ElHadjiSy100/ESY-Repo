import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Town_STUDENT_Test {

    private Town townA, townB, townC;

    @Before
    public void setUp() throws Exception {
        townA = new Town("Town_A");
        townB = new Town("Town_B");
        townC = new Town("Town_C");

        townA.addAdjTown(townB, 10);
        townA.addAdjTown(townC, 20);
    }

    @After
    public void tearDown() throws Exception {
        townA = null;
        townB = null;
        townC = null;
    }

    @Test
    public void testGetName() {
        assertEquals("Town_A", townA.getName());
        townA.setName("Town_a");
        assertEquals("Town_a", townA.getName());
    }

    @Test
    public void testGetDistanceFrom() {
        assertEquals(Integer.valueOf(10), townA.getDistanceFrom(townB));
        assertEquals(Integer.valueOf(20), townA.getDistanceFrom(townC));
        assertEquals(Integer.valueOf(Integer.MAX_VALUE), townA.getDistanceFrom(new Town("Town_D")));
    }

    @Test
    public void testSetDistanceFrom() {
        townA.setDistanceFrom(townB, 15);
        assertEquals(Integer.valueOf(15), townA.getDistanceFrom(townB));
    }

    @Test
    public void testGetAdjTowns() {
        ArrayList<Town> adj = townA.getAdjTowns();
        assertTrue(adj.contains(townB));
        assertTrue(adj.contains(townC));
    }

    @Test
    public void testSetAdjTowns() {
        ArrayList<Town> newAdjList = new ArrayList<>();
        newAdjList.add(townC);
        townA.setAdjTowns(newAdjList);

        ArrayList<Town> updatedAdj = townA.getAdjTowns();
        assertEquals(1, updatedAdj.size());
        assertTrue(updatedAdj.contains(townC));
    }


    @Test
    public void testToString() {
        String expected = "Town_A Town_B Town_C ";
        assertEquals(expected, townA.toString());
    }

    @Test
    public void testCompareTo() {
        Town dupe = new Town("Town_A");
        assertEquals(0, townA.compareTo(dupe));
        assertTrue(townA.equals(dupe));
    }

}

