package ESY_Assignment4_Complete;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * This class represents Student test cases for a Property object.
 *
 * @author El Hadji Sy
 * @version 4/6/2024
 */
class PropertyTestStudent {
	Property propertyOne;

	@BeforeEach
	void setUp() throws Exception {
		propertyOne = new Property("Very Tall Skyscraper", "Dubai", 100000000.0, "World's Richest Man");
	}

	@AfterEach
	void tearDown() throws Exception {
		propertyOne = null;
	}

	@Test
	void testGetPropertyName() {
		assertEquals("Very Tall Skyscraper", propertyOne.getPropertyName());
	}
	
	@Test
	void testGetCity() {
		assertEquals("Dubai", propertyOne.getCity());
	}
	
	@Test
	void testGetRentAmount() {
		assertEquals(100000000.0, propertyOne.getRentAmount());
	}
    
	@Test
	void testGetOnwer() {
		assertEquals("World's Richest Man", propertyOne.getOwner());
	}
		
	@Test
	void testGetPlot() {
		assertEquals(0, propertyOne.getPlot().getX());
		assertEquals(0, propertyOne.getPlot().getY());
		assertEquals(1, propertyOne.getPlot().getWidth());
		assertEquals(1, propertyOne.getPlot().getDepth());
	}

	@Test
	void testToString() {
		assertEquals("Very Tall Skyscraper,Dubai,World's Richest Man,1.0E8",propertyOne.toString());	
	}

}