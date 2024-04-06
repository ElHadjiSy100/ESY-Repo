package ESY_Assignment4_Complete;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * This class represents Student test cases for a Plot object.
 * 
 * @author ElHadji Sy
 * @version 4/6/2024
 * 
 */
public class PlotTestStudent {
	private Plot plot1, plot2, plot5, plot10, plot20;

	@Before
	public void setUp() throws Exception {
		plot1 = new Plot(2, 2, 6, 6);
		plot5 = new Plot(3, 4, 4, 3);
	}

	@After
	public void tearDown() throws Exception {
		plot1 = plot5 = null;
	}

	@Test
	public void testOverlaps1() {
		assertTrue(plot1.overlaps(plot5)); // plot5 is entirely inside plot1
	}
	
	@Test
	public void testEncompasses1() {
		assertTrue(plot1.encompasses(plot5)); // plot5 is entirely inside plot1
	}
	
	@Test
	public void testToString() {
		assertEquals("3,4,4,3",plot5.toString());	
	}
	
	@Before
	public void setUp2() throws Exception {
		plot2 = new Plot(3, 7, 3, 2);
		plot10 = new Plot(4, 8, 1, 1);
		plot20 = new Plot(plot10);
	}

	@After
	public void tearDown2() throws Exception {
		plot2 = plot10 = plot20 = null;
	}
	@Test
	public void testOverlaps2() {
		assertTrue(plot2.overlaps(plot10));
	}
	@Test
	public void testEncompasses2() {
		assertTrue(plot2.encompasses(plot10)); // plot5 encompasses plot10
	}
	
	@Test
	public void testCopyPlot() {
		assertTrue(plot20.getX() == (plot10.getX())); // plot5 encompasses plot10
	}
	
	@Test
	public void testToString2() {
		assertEquals("4,8,1,1",plot10.toString());	
	}

}

