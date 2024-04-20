package ESY_Assignment5_Complete;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TwoDimRaggedArrayUtilityTestStudent {
	private double[][] dataSet1 = {{1,2,3},{4,5},{6,7,8,9}};
	private double[][] dataSet2 = {{2, 3, 4}, {5, 6}, {7, 8, 9}};
	private double[][] dataSet3 = {{3, 4, 5}, {6, 7}, {8, 9, 10}};
	private double[][] dataSet4 = {{4, 5, 6}, {7, 8}, {9, 10, 11}};
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test getRowTotal method
	 * Returns the total of all the elements of row 1.
	 * Row 0 refers to the first row in the two dimensional array
	 */
	@Test
	public void testGetRowTotal1() {
		assertEquals(9.0,TwoDimRaggedArrayUtility.getRowTotal(dataSet1,1),.001);
	}
	
	@Test
	public void testGetRowTotal2() {
		assertEquals(11.0,TwoDimRaggedArrayUtility.getRowTotal(dataSet2,1),.001);
	}
	
	@Test
	public void testGetRowTotal3() {
		assertEquals(13.0,TwoDimRaggedArrayUtility.getRowTotal(dataSet3,1),.001);
	}
	
	@Test
	public void testGetRowTotal4() {
		assertEquals(15.0,TwoDimRaggedArrayUtility.getRowTotal(dataSet4,1),.001);
	}
	
	@Test
	public void testGetColumnTotal() {
		assertEquals(14.0,TwoDimRaggedArrayUtility.getColumnTotal(dataSet1,1),.001);
	}
	
	@Test
	public void testGetColumnTotal2() {
		assertEquals(17.0,TwoDimRaggedArrayUtility.getColumnTotal(dataSet2,1),.001);
	}
	
	@Test
	public void testGetColumnTotal3() {
		assertEquals(20.0,TwoDimRaggedArrayUtility.getColumnTotal(dataSet3,1),.001);
	}
	
	@Test
	public void testGetColumnTotal4() {
		assertEquals(23.0,TwoDimRaggedArrayUtility.getColumnTotal(dataSet4,1),.001);
	}
	
	@Test
	public void testGetHighestInRow() {
		assertEquals(5.0,TwoDimRaggedArrayUtility.getHighestInRow(dataSet1,1),.001);
	}
	
	@Test
	public void testGetHighestInRowIndex() {
		assertEquals(1.0,TwoDimRaggedArrayUtility.getHighestInRowIndex(dataSet1,1),.001);
	}
	
	@Test
	public void testGetLowestInRow() {
		assertEquals(4.0,TwoDimRaggedArrayUtility.getLowestInRow(dataSet1,1),.001);
	}
	
	@Test
	public void testGetHighestInColumn() {
		assertEquals(7.0,TwoDimRaggedArrayUtility.getHighestInColumn(dataSet1,1),.001);
	}
	
	@Test
	public void testGetHighestInColumnIndex() {
		assertEquals(2.0,TwoDimRaggedArrayUtility.getHighestInColumnIndex(dataSet1,1),.001);
	}
	
	@Test
	public void testGetLowestInColumn() {
		assertEquals(2.0,TwoDimRaggedArrayUtility.getLowestInColumn(dataSet1,1),.001);
	}
	
	@Test
	public void testGetHighestInArray() {
		assertEquals(9.0,TwoDimRaggedArrayUtility.getHighestInArray(dataSet1),.001);
	}
	
	@Test
	public void testGetLowestInArray() {
		assertEquals(1.0,TwoDimRaggedArrayUtility.getLowestInArray(dataSet1),.001);
	}
	
}
