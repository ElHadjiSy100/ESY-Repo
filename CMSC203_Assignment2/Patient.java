package ESY_Assignment2_Complete;

public class Patient {
	private String firstName; 
	private String middleName; 
	private String lastName;
	private String address; 
	private String city; 
	private String state; 
	private String zipCode; 
	private String number; 
	private String emergencyContactName; 
	private String emergencyContactNum;
	
	public Patient() {
		
	}
	
	public Patient(String firstName, String middleName, String lastName) {
		this.firstName = firstName; 
		this.middleName = middleName;
		this.lastName = lastName; 
	}
	
	public Patient(String firstName, String middleName, String lastName, String address, String city, String state, String zipCode, String number, String emergencyContactName, String emergencyContactNum) {
		this.firstName = firstName; 
		this.middleName = middleName;
		this.lastName = lastName; 
		this.address = address; 
		this.city = city; 
		this.state = state;
		this.zipCode = zipCode;
		this.number = number; 
		this.emergencyContactName = emergencyContactName;
		this.emergencyContactNum = emergencyContactNum;
		
	}
	public String getFirstName() {
		return firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getAddress() {
		return address;
	}
	public String getCity() {
		return city;
	}
	public String getState() {
		return state;
	}
	public String getZipCode() {
		return zipCode;
	}
	public String getNumber() {
		return number;
	}
	public String getEmergencyContactName() {
		return emergencyContactName;
	}
	public String getEmergencyContactNum() {
		return emergencyContactNum;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName; 
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName; 
	}
	public void setLastName(String lastName) {
		this.lastName = lastName; 
	}
	public void setAddress(String address) {
		this.address = address; 
	}
	public void setCity(String city) {
		this.city = city; 
	}
	public void setState(String state) {
		this.state = state;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode; 
	}
	public void setNumber(String number) {
		this.number = number; 
	}
	public void setEmergencyContactName(String emergencyContactName) {
		this.emergencyContactName = emergencyContactName; 
	}
	public void emergencyContactNum(String emergencyContactNum) {
		this.emergencyContactNum = emergencyContactNum; 
	}
	
	public String buildFullName(String firstName, String middleName, String lastName) {
		return (firstName + " " + middleName + " " + lastName);
	}
	
	public String buildAddress(String address, String city, String state, String zipCode ) {
		return (address + " " + city + " " + state + " " + zipCode);
	}
	
	public String buildEmergencyContact(String emergencyContactName, String emergencyContactNum) {
		return (emergencyContactName + " " + emergencyContactNum);
	}
	
	public String toString() { 
		return ("Patient info: \n Name: " + buildFullName(firstName, middleName, lastName) + 
				"\n Address: " + buildAddress(address, city, state, zipCode) + "\n Emergency Contact: " + 
				buildEmergencyContact(emergencyContactName, emergencyContactNum)); 
	
	}
}
