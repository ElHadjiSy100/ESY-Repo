/**
 * 	This is the class for an element (a course) in the course database
 * @author El Hadji Sy
 */
public class CourseDBElement implements Comparable {
	private String courseID;
	private int crn;
	private int credit;
	private String roomNum;
	private String instructor; 
	
	/**
	 * General constructor which allows CDE fields to be set separately. 
	 */
	public CourseDBElement() {
		
	}
	
	/**
	 * Constructor which builds a CDE based on given parameters.
	 * @param id
	 * @param crn
	 * @param credit
	 * @param roomNum
	 * @param instructor
	 */
	public CourseDBElement(String id, int crn, int credit, String roomNum, String instructor) {
		this.courseID = id;
		this.crn = crn;
		this.credit = credit;
		this.roomNum = roomNum; 
		this.instructor = instructor;
	}
	
	/**
	 * Setter for the course ID.
	 * @param ID
	 */
	public void setID(String ID) {
		this.courseID = ID;
	}
	
	/**
	 * Getter for the course ID.
	 * @return the course ID of a specific CDE.
	 */
	public String getID() {
		return courseID;
	}
	
	
	/**
	 * Setter for the CRN of a specific CDE.
	 * @param crn
	 */
	public void setCRN(int crn) {
		this.crn = crn;
	}
	
	/**
	 * Getter for the CRN of a specific CDE.
	 * @return the CRN of a specific CDE.
	 */
	public int getCRN() {
		return this.crn;
	}
	
	/**
	 * Setter for the amount of credits of a specific CDE.
	 * @param credits
	 */
	public void setCredits(int credits) {
		this.credit = credits;
	}
	
	/**
	 * Getter of the amount of credits for a specific CDE.
	 * @return the amount of credits for a specific CDE.
	 */
	public int getCredits() {
		return credit;
	}
	
	/**
	 * Setter for the room number of a specific CDE.
	 * @param roomNum
	 */
	public void setRoomNum(String roomNum) {
		this.roomNum = roomNum;
	}
	
	/**
	 * Getter of the room number of a specific CDE.
	 * @return the room number of a specific CDE.
	 */
	public String getRoomNum() {
		return roomNum;
	}
	
	/**
	 * Setter for the instructor of a specific CDE.
	 * @param instructor
	 */
	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}
	
	/**
	 * Getter of the instructor of a specific CDE.
	 * @return the instructor of a specific CDE.
	 */
	public String getInstructor() {
		return instructor;
	}
	
	/**
	 * Comparing one course to another course based off of their fields.
	 */
	@Override
	public int compareTo(Object o) {
		if(((CourseDBElement)o).crn == this.crn && ((CourseDBElement)o).credit == this.credit && 
		   ((CourseDBElement)o).roomNum.equals(this.roomNum) && ((CourseDBElement)o).courseID.equals(this.courseID) 
		   && ((CourseDBElement)o).instructor.equals(this.instructor)) {
			return 0;
		} 
		return 1;
	}
}
