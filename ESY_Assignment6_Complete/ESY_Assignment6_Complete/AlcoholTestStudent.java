package ESY_Assignment6_Complete;


import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;



public class AlcoholTestStudent {
	Alcohol alcohol;

	@Before
	public void setUp() throws Exception {
		alcohol = new Alcohol("Isopropyl Alcohol 70%", Size.MEDIUM, false);
	}

	@After
	public void tearDown() throws Exception {
		alcohol = null;
	}

	@Test
	public void testGetSize() {
		assertEquals(Size.MEDIUM, alcohol.getSize());
	}
	
	@Test
	public void testCalcPrice() {
		assertEquals(2.5, alcohol.calcPrice(), .01);
	}
}




