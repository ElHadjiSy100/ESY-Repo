package Lab3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GradeBookTest {
	GradeBook g1; 
	GradeBook g2;
	@BeforeAll
		static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	g1 = new GradeBook(5);
	g2 = new GradeBook(5);
	g1.addScore(2);
	g1.addScore(35);
	g1.addScore(22);
	g1.addScore(18);
	g1.addScore(33);
	g2.addScore(44);
	g2.addScore(15);
	g2.addScore(21);
	g2.addScore(22);
	g2.addScore(23);
	}

	@AfterEach
	void tearDown() throws Exception {
		g1 = null; 
		g2 = null;
	}

	@Test
	void test() {
		assertTrue(g1.toString().equals("2.0 35.0 22.0 18.0 33.0 "));
		assertTrue(g2.toString().equals("44.0 15.0 21.0 22.0 23.0 "));
		assertTrue(g1.sum() == 110);
		assertTrue(g2.sum() == 125); 
		assertTrue(g1.minimum() == 2);
		assertTrue(g2.minimum() == 15);
		assertTrue(g1.finalScore() == 108);
		assertTrue(g2.finalScore() == 110);
	}

}
