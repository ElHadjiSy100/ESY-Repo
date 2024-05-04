package ESY_Assignment6_Complete;


import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;



public class TypeTestStudent {
	Type type;
	
	@Before
	public void setUp() throws Exception {
		type = Type.COFFEE;
	}

	@After
	public void tearDown() throws Exception {
		type = null;
	}

	@Test
	public void testAge() {
		assertEquals(type.COFFEE, type);
	}
}


