package Junit_Lab;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GradebookTester {
	GradeBook gradebook1;
	GradeBook gradebook2;
	
	@BeforeEach
	void setUp() throws Exception {
	    gradebook1 = new GradeBook(5);
		gradebook1.addScore(77.1);
		gradebook1.addScore(60.0);
		gradebook1.addScore(72.2);
		gradebook2 = new GradeBook(5);
		gradebook2.addScore(83.4);
		gradebook2.addScore(94);
		gradebook2.addScore(87.9);
	}

	@AfterEach
	void tearDown() throws Exception {
		gradebook1 = null;
		gradebook2 = null;
		
	}

	@Test
	void testAddScore() {
		assertTrue(gradebook1.toString().equals("77.1 60.0 72.2 "));
		assertTrue(gradebook2.toString().equals("83.4 94.0 87.9 "));
	}

	@Test
	void testSum() {
		assertEquals(gradebook1.sum(), 209.3);
		assertEquals(gradebook2.sum(), 265.3);
	}

	@Test
	void testMinimum() {
		assertEquals(gradebook1.minimum(), 60.0);
		assertEquals(gradebook2.minimum(), 83.4);
	}

	@Test
	void testFinalScore() {
		assertEquals(gradebook1.finalScore(), 149.3);
		assertEquals(gradebook2.finalScore(), 181.9);
	}

	@Test
	void testGetScoreSize() {
		assertEquals(gradebook1.getScoreSize(), 3);
		assertEquals(gradebook2.getScoreSize(), 3);
	}

}
