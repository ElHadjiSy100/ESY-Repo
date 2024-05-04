package ESY_Assignment6_Complete;


import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;



public class SizeTestStudent {
	Size size;
	
	@Before
	public void setUp() throws Exception {
		size = size.LARGE;
	}

	@After
	public void tearDown() throws Exception {
		size = null;
	}

	@Test
	public void testAge() {
		assertEquals(Size.LARGE, size);
	}
}


