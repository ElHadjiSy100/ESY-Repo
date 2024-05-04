package ESY_Assignment6_Complete;


import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;



public class CoffeeTestStudent {
	Coffee coffee;

	@Before
	public void setUp() throws Exception {
		coffee = new Coffee("proteinShake", Size.LARGE, true, true);
	}

	@After
	public void tearDown() throws Exception {
		coffee = null;
	}

	@Test
	public void testGetSize() {
		assertEquals(Size.LARGE, coffee.getSize());
	}
	
	@Test
	public void testCalcPrice() {
		assertEquals(4, coffee.calcPrice(), .01);
	}
}



