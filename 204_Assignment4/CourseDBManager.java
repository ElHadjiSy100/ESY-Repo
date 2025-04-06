import java.io.File; 	
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * Course database manager which externally adds, retrieves, and shows courses from a given course databse.
 * @author El Hadji Sy
 */
public class CourseDBManager implements CourseDBManagerInterface {
	CourseDBStructure cds = new CourseDBStructure(500);
	
	/**
	 * Creates and adds a course element to a CDS.
	 */
	@Override
	public void add(String id, int crn, int credits, String roomNum, String instructor) {
		CourseDBElement element = new CourseDBElement(id,crn,credits,roomNum,instructor);
		cds.add(element);
	}

	/**
	 * Retrieves a CDE from a CDS based on the given CRN.
	 */
	@Override
	public CourseDBElement get(int crn) {
		try {
			return cds.get(crn);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Reads in CDEs from a given file, and adds all CDEs from the file into a CDS. 
	 */
	@Override
	public void readFile(File input) throws FileNotFoundException {
		Scanner scan;
		try {
			scan = new Scanner(input);
			while(scan.hasNextLine()) {
				String data = scan.nextLine();
				String[] elementArray = data.split(" ");
				String ID = elementArray[0];
				int crn = Integer.parseInt(elementArray[1]);
				int credit = Integer.parseInt(elementArray[2]);
				String room = elementArray[3];
				String instructor = elementArray[4];
				for(int i = 5; i < elementArray.length; i++) {
					instructor += " " + elementArray[i];
				}
				add(ID,crn,credit,room,instructor);
			}
			scan.close();
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Creates an array list of all courses in a given CDS.
	 */
	@Override
	public ArrayList<String> showAll() {
		return cds.showAll();
	}
	
}
