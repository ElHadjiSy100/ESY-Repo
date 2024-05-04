package ESY_Assignment6_Complete;


import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;



public class CustomerTestStudent {
	Customer cust;
	
	@Before
	public void setUp() throws Exception {
		cust = new Customer("Alan", 22);
	}

	@After
	public void tearDown() throws Exception {
		cust = null;
	}

	@Test
	public void testAge() {
		assertEquals(22, cust.getAge());
	}
}


