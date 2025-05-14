import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Road_STUDENT_Test {

    private Road road1, road2, road3;
    private Town townA, townB, townC;

    @Before
    public void setUp() throws Exception {
        townA = new Town("Town_A");
        townB = new Town("Town_B");
        townC = new Town("Town_C");

        road1 = new Road(townA, townB, 10, "Road_AB");
        road2 = new Road(townB, townC, 15, "Road_BC");
    }

    @After
    public void tearDown() throws Exception {
        road1 = road2 = null;
        townA = townB = townC = null;
    }

    @Test
    public void testGetNameAndSetName() {
        assertEquals("Road_AB", road1.getName());
        road1.setName("Road_BA");
        assertEquals("Road_BA", road1.getName());
    }

    @Test
    public void testGetWeightAndSetWeight() {
        assertEquals(10, road1.getWeight());
        road1.setWeight(25);
        assertEquals(25, road1.getWeight());
    }

    @Test
    public void testGetAndSetSource() {
        assertEquals(townA, road1.getSource());
        road1.setSource(townC);
        assertEquals(townC, road1.getSource());
    }

    @Test
    public void testGetAndSetDestination() {
        assertEquals(townB, road1.getDestination());
        road1.setDestination(townC);
        assertEquals(townC, road1.getDestination());
    }

    @Test
    public void testToString() {
        String str = road1.toString();
        assertTrue(str.contains("Road_AB"));
        assertTrue(str.contains("10"));
        assertTrue(str.contains("Town_B"));
        assertTrue(str.contains("Town_A"));
    }

    @Test
    public void testContains() {
        assertTrue(road1.contains(townA));
        assertTrue(road1.contains(townB));
        assertFalse(road1.contains(townC));
    }

    @Test
    public void testEquals() {
        assertFalse(road1.equals(road2)); 
    }

    @Test
    public void testCompareTo() {
        assertEquals(-1, road1.compareTo(road2));
    }

    @Test
    public void testdupeConstructor() {
        Road dupe = new Road(road1);
        assertEquals(road1.getName(), dupe.getName());
        assertEquals(road1.getWeight(), dupe.getWeight());
        assertEquals(road1.getSource(), dupe.getSource());
        assertEquals(road1.getDestination(), dupe.getDestination());
    }
}
