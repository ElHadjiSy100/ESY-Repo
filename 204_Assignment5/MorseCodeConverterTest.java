 
import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class MorseCodeConverterTest {
	
	@Test
	public void testConvertToEnglishString() {	
		String converter1 = MorseCodeConverter.convertToEnglish("- .... .. ... / -- --- .-. ... . / -.-. --- -.. . / -.-. --- -. ...- . .-. - . .-. / .-- --- .-. -.- ... ");
		assertEquals("this morse code converter works",converter1);
	}
	
	
	@Test
	public void testPrintTree() {	
		
		assertEquals("h s v i f u e l r a p w j  b d x n c k y t z g q m o", MorseCodeConverter.printTree());
	}
	
	
	@Test
	public void testConvertMorseStringToEnglishString() {	
		
		String converter1 = MorseCodeConverter.convertToEnglish(".. / .-.. --- ...- . / -.-. --- -- .--. ..- - . .-. / ... -.-. .. . -. -.-. .");
		assertEquals("i love computer science", converter1);

	}
	
	@Test
	public void testConvertMorseStringToEnglishString2() {	
		
		String converter1 = MorseCodeConverter.convertToEnglish(".-.. --- .-. . -- / .. .--. ... ..- -- / -.. --- .-.. --- .-. / ... .. - / .- -- . -");
		assertEquals("lorem ipsum dolor sit amet", converter1);

	}
	
	@Test
	public void testConvertMorseFileToEnglishString() {	
		
		File file = new File("src/LoveLooksNot.txt"); 
		try {
			assertEquals("love looks not with the eyes but with the mind", MorseCodeConverter.convertToEnglish(file));
		} catch (FileNotFoundException e) {
			assertTrue("An unwanted exception was caught", false);
		}
	}
	

}
