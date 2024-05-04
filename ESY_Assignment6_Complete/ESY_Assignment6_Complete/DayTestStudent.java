package ESY_Assignment6_Complete;


import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;



public class DayTestStudent {
	Day day;
	
	@Before
	public void setUp() throws Exception {
		day = Day.SATURDAY;
	}

	@After
	public void tearDown() throws Exception {
		day = null;
	}

	@Test
	public void testAge() {
		assertEquals(Day.SATURDAY, day);
	}
}


