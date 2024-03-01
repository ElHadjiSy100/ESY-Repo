package ESY_Assignment2_Complete;

public class Procedure {
	private String procedureName; 
	private String procedureDate;
	private String practicionerName; 
	private String procedureCharges; 
	
	public Procedure() {
		
	}
	
	public Procedure(String procedureName, String procedureDate) {
		this.procedureName = procedureName; 
		this.procedureDate = procedureDate; 
	}
	
	public Procedure(String procedureName, String procedureDate, String practicionerName, String procedureCharges) {
		this.procedureName = procedureName; 
		this.procedureDate = procedureDate; 
		this.practicionerName = practicionerName; 
		this.procedureCharges = procedureCharges; 
	}
	
	public String getProcedureName() {
		return procedureName; 
	}
	public String getProcedureDate() {
		return procedureDate; 
	}
	public String getPracticionerName() {
		return practicionerName; 
	}
	public String getProcedureCharges() {
		return procedureCharges; 
	}
	
	public void setProcedureName(String procedureName) {
		this.procedureName = procedureName;
	}
	public void setProcedureDate(String procedureDate) {
		this.procedureDate = procedureDate; 
	}
	public void setPracticionerName(String practicionerName) { 
		this.practicionerName = practicionerName; 
	}
	public void setProcedureCharges(String procedureCharges) {
		this.procedureCharges = procedureCharges; 
	}
	
	public String toString() { 
		return("\n\t\t Procedure: " + getProcedureName() + "\n\t\t Procedure Date: " + getProcedureDate() + "\n\t\t Practicioner: " +
				getPracticionerName() + "\n\t\t Charge: " + getProcedureCharges()); 
	}
}
