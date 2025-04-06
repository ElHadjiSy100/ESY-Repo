import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * This is the test file for the CourseDBManager
 * which is implemented from the CourseDBManagerInterface
 * 
 */
public class CourseDBManager_STUDENT_Test {
	private CourseDBManagerInterface dataMgrStudent = new CourseDBManager();

	/**
	 * Create an instance of CourseDBManager
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		dataMgrStudent = new CourseDBManager();
	}

	/**
	 * Set dataMgrStudent reference to null
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
		dataMgrStudent = null;
	}

	/**
	 * Test for the add method
	 */
	@Test
	public void testAddToDB() {
		try {
			dataMgrStudent.add("CMSC204",12345,4,"SW217","James Adam Smith");
		}
		catch(Exception e) {
			fail("This should not have caused an Exception");
		}
	}
	
	/**
	 * Test for the showAll method
	 */
	@Test
	public void testShowAll() {
		dataMgrStudent.add("CMSC204",12346,4,"SW217","George Washington");
		dataMgrStudent.add("CMSC204",12347,4,"SW217","John Carmack");
		dataMgrStudent.add("CMSC204",12348,4,"SW217","Uncle Bob");
		ArrayList<String> list = dataMgrStudent.showAll();
		assertEquals(list.get(0),"\nCourse:CMSC204 CRN:12346 Credits:4 Instructor:George Washington Room:SW217");
	 	assertEquals(list.get(1),"\nCourse:CMSC204 CRN:12347 Credits:4 Instructor:John Carmack Room:SW217");
		assertEquals(list.get(2),"\nCourse:CMSC204 CRN:12348 Credits:4 Instructor:Uncle Bob Room:SW217");
	}
	
	/**
	 * Test for the read method
	 */
	@Test
	public void testRead() {
		try {
			File inputFile = new File("Test1.txt");
			PrintWriter inFile = new PrintWriter(inputFile);
			inFile.println("CMSC204 12347 4 SW217 John Carmack");
			inFile.print("CMSC204 12348 4 SW217 Uncle Bob");
			
			inFile.close();
			dataMgrStudent.readFile(inputFile);
			assertEquals("CMSC204",dataMgrStudent.get(12347).getID());
			assertEquals("CMSC204",dataMgrStudent.get(12348).getID());
			assertEquals("SW217",dataMgrStudent.get(12348).getRoomNum());
		} catch (Exception e) {
			fail("Should not have thrown an exception");
		}
	}
}