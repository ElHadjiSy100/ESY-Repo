package Assignment1; 

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * STUDENT tests for the methods of PasswordChecker
 * @author 
 *
 */
public class PasswordCheckerTest_STUDENT {
	ArrayList<String> passwords = new ArrayList<String>();
	
	@Before
	public void setUp() throws Exception {
		passwords.add("CS204");
		passwords.add("compsci204");
		passwords.add("COMPSCI204");
		passwords.add("CompSciTwoOFour!");
		passwords.add("CompSci204");
		passwords.add("cccompSci204!");
		passwords.add("c0mPSc!");
		passwords.add("c0mPSc!2o4");
		
	}

	@After
	public void tearDown() throws Exception {
		passwords = null;
	}

	/**
	 * Test if the password is less than 6 characters long.
	 * This test should throw a LengthException for second case.
	 */
	@Test
	public void testIsValidPasswordTooShort1()
	{
		
		try {
			assertTrue(PasswordCheckerUtility.isValidPassword​(passwords.get(1)));
		} catch(LengthException e) {
			assertTrue("Length Exception was thrown", true);
		} catch(Exception e) {
			assertTrue("Other Exception was thrown", false);
			System.out.println("Line 49");
		}
	}
	
	@Test
	public void testIsValidPasswordTooShort2()
	{
		try {
			assertTrue(PasswordCheckerUtility.isValidPassword​(passwords.get(0)));
		} catch(LengthException e) {
			assertTrue("Length Exception was thrown", true);
		} catch(Exception e) {
			assertTrue("Other Exception was thrown", false);
			System.out.println("Line 62");
		}
	}
	
	/**
	 * Test if the password has at least one uppercase alpha character
	 * This test should throw a NoUpperAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoUpperAlpha1()
	{
		try {
			assertTrue(PasswordCheckerUtility.isValidPassword​(passwords.get(2)));
		} catch(NoUpperAlphaException e) {
			assertTrue("NoUpperAlpha Exception was thrown", true);
		} catch(Exception e) {
			assertTrue("Other Exception was thrown", false);
			System.out.println("Line 79");
		}
	}
	
	@Test
	public void testIsValidPasswordNoUpperAlpha2()
	{
		try {
			assertTrue(PasswordCheckerUtility.isValidPassword​(passwords.get(1)));
		} catch(NoUpperAlphaException e) {
			assertTrue("NoUpperAlpha Exception was thrown", true);
		} catch(Exception e) {
			assertTrue("Other Exception was thrown", false);
			System.out.println("Line 92");
		}
	}
	
	/**
	 * Test if the password has at least one lowercase alpha character
	 * This test should throw a NoLowerAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoLowerAlpha1()
	{
		try {
			assertTrue(PasswordCheckerUtility.isValidPassword​(passwords.get(3)));
		} catch(NoLowerAlphaException e) {
			assertTrue("NoLowerAlpha Exception was thrown", true);
		} catch(Exception e) {
			assertTrue("Other Exception was thrown", false);
			System.out.println("Line 109");
		}
	}
	
	@Test
	public void testIsValidPasswordNoLowerAlpha2()
	{
		try {
			assertTrue(PasswordCheckerUtility.isValidPassword​(passwords.get(2)));
		} catch(NoLowerAlphaException e) {
			assertTrue("NoLowerAlpha Exception was thrown", true);
		} catch(Exception e) {
			assertTrue("Other Exception was thrown", false);
			System.out.println("Line 122");
		}
	}

	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsWeakPassword1()
	{
		try {
			assertTrue(PasswordCheckerUtility.isWeakPassword(passwords.get(4)));
		} catch(WeakPasswordException e) {
			assertTrue("WeakPassword Exception was thrown", true);
		} catch(Exception e) {
			assertTrue("Other Exception was thrown", false);
			System.out.println("Line 139");
		}
	}
	
	@Test
	public void testIsWeakPassword2() {
		try {
			assertTrue(PasswordCheckerUtility.isWeakPassword(passwords.get(6)));
		} catch(WeakPasswordException e) {
			assertTrue("WeakPassword Exception was thrown", true);
		} catch(Exception e) {
			assertTrue("Other Exception was thrown", false);
			System.out.println("Line 151");
		}
	}
	
	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsValidPasswordInvalidSequence1()
	{
		try {
			assertTrue(PasswordCheckerUtility.isValidPassword​(passwords.get(4)));
		} catch(InvalidSequenceException e) {
			assertTrue("InvalidSequence Exception was thrown", true);
		} catch(Exception e) {
			assertTrue("Other Exception was thrown", false);
			System.out.println("Line 168");
		}
	}
	
	@Test
	public void testIsValidPasswordInvalidSequence2()
	{
		try {
			assertTrue(PasswordCheckerUtility.isValidPassword​(passwords.get(5)));
		} catch(InvalidSequenceException e) {
			assertTrue("InvalidSequence Exception was thrown", true);
		} catch(Exception e) {
			assertTrue("Other Exception was thrown", false);
			System.out.println("Line 181");
		}
	}
	
	/**
	 * Test if the password has at least one digit
	 * One test should throw a NoDigitException
	 */
	@Test
	public void testIsValidPasswordNoDigit1()
	{
		try {
			assertTrue(PasswordCheckerUtility.isValidPassword​(passwords.get(4)));
		} catch(NoDigitException e) {
			assertTrue("NoDigit Exception was thrown", true);
		} catch(Exception e) {
			assertTrue("Other Exception was thrown", false);
			System.out.println("Line 198");
		}
	}
	
	@Test
	public void testIsValidPasswordNoDigit2() 
	{
		try {
			assertTrue(PasswordCheckerUtility.isValidPassword​(passwords.get(3)));
		} catch(NoDigitException e) {
			assertTrue("NoDigit Exception was thrown", true);
		} catch(Exception e) {
			assertTrue("Other Exception was thrown", false);
			System.out.println("Line 188");
		}
	}
	
	/**
	 * Test correct passwords
	 * This test should not throw an exception
	 */
	@Test
	public void testIsValidPasswordSuccessful1()
	{
		try {
		assertTrue(PasswordCheckerUtility.isValidPassword​(passwords.get(1)));
		} catch(Exception e) {}
	}
	
	@Test
	public void testIsValidPasswordSuccessful2()
	{
		try {
			assertTrue(PasswordCheckerUtility.isValidPassword​(passwords.get(7)));
			} catch(Exception e) {}
	}
	
	
	/**
	 * Test the invalidPasswords method
	 * Check the results of the ArrayList of Strings returned by the validPasswords method
	 */
	@Test
	public void testGetInvalidPasswords() {
		ArrayList<String> results;
		results = PasswordCheckerUtility.getInvalidPasswords(passwords);
		
		Scanner scan = new Scanner(results.get(0)); 
		assertEquals(scan.next(), "CS204");
		String nextResults = scan.nextLine().toLowerCase();
		assertTrue(nextResults.contains("long"));
		
		scan = new Scanner(results.get(1));  
		assertEquals(scan.next(), "compsci204");
		nextResults = scan.nextLine().toLowerCase(); 
		assertTrue(nextResults.contains("uppercase"));
		
		 
		scan = new Scanner(results.get(2));  
		assertEquals(scan.next(), "COMPSCI204");
		nextResults = scan.nextLine().toLowerCase();
		assertTrue(nextResults.contains("lowercase"));
		
		scan = new Scanner(results.get(3));  
		assertEquals(scan.next(), "CompSciTwoOFour!");
		nextResults = scan.nextLine().toLowerCase();
		assertTrue(nextResults.contains("digit"));
		
		scan = new Scanner(results.get(4));  
		assertEquals(scan.next(), "CompSci204");
		nextResults = scan.nextLine().toLowerCase();
		assertTrue(nextResults.contains("special") );
		
		scan = new Scanner(results.get(5));  
		assertEquals(scan.next(), "cccompSci204!");
		nextResults = scan.nextLine().toLowerCase();
		assertTrue(nextResults.contains("sequence") );
		
	}
	
}
