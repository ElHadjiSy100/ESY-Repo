package ESY_Assignment6_Complete;


import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;



public class SmoothieTestStudent {
	Smoothie smoothie;

	@Before
	public void setUp() throws Exception {
		smoothie = new Smoothie("Strawberry Mango Blast", Size.SMALL, 7, true);
	}

	@After
	public void tearDown() throws Exception {
		smoothie = null;
	}

	@Test
	public void testSize() {
		assertEquals(Size.SMALL, smoothie.getSize());
	}
	
	@Test
	public void testCalcPrice() {
		assertEquals(7, smoothie.calcPrice(), .01);
	}
}


