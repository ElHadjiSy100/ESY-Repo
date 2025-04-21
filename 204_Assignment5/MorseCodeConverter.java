import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

/**
 * Class that converts Morse code into English.
 * @author El Hadji Sy 
 */
public class MorseCodeConverter {
	private static MorseCodeTree tree = new MorseCodeTree();
	/**
	 * Prints out the entire Morse code tree.
	 * @return String of entire Morse code tree.
	 */
	public static String printTree() { 
		List<String> list = tree.toArrayList();
		String treeString = "";
		for(int i = 0; i < 27; i++) {
			treeString += list.get(i);
			if(i != 26) {
				treeString += " ";
			} 
		}
		return treeString;
	}
	
	/**
	 * Converts a given Morse code string into English.
	 * @param code the Morse code to be converted.
	 * @return The converted English string.
	 */
	public static String convertToEnglish(String code) {
		String[] codeArray = code.split(" ");
		String english = "";
		for(int i = 0; i < codeArray.length; i++) {
			if(codeArray[i].equals("/") ) {
				english += " ";
			} else {
				english += tree.fetch(codeArray[i]);
			}
		}
		return english;
	}
	
	/**
	 * Reads in Morse code from a file and converts it to an English string.
	 * @param codeFile the file to read the Morse code from.
	 * @return The converted English string.
	 * @throws FileNotFoundException
	 */
	public static String convertToEnglish(File codeFile) throws FileNotFoundException{
		Scanner scan; 
		try {
		scan = new Scanner(codeFile);
		String code = scan.nextLine();
		scan.close();
		return convertToEnglish(code); 
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} 
		return null;
	}
}
