package ESY_Assignment2_Complete;

public class PatientDriver {
	public static void main(String[] args) {
		Patient patient = new Patient("Jack", "Henry",  "Adams", "1523 King's Court",  "Bethesda", "MD", "20105",  "301-835-3825", "Dr. Smith", "301-665-9000");
		Procedure procedure = new Procedure("Physical Exam", "9/15/2019", "Dr. Knight", "1340.34");
		Procedure procedure2 = new Procedure("Back Surgery", "4/22/2020", "Dr. C", "12450.75");
		Procedure procedure3 = new Procedure("X-Ray", "6/25/2020", "James Knight", "4580.25");
		
		displayPatient(patient);
		displayProcedure(procedure);
		displayProcedure(procedure2);
		displayProcedure(procedure3);
		double totalCharges = calculateCharges(procedure, procedure2, procedure3);
        System.out.printf("\n Total charges: $%,.2f%n", totalCharges);
        
        System.out.println("\n Student Name: El Hadji Sy \n Course: CMSC203 31480 \n Due Date: 3/1/24");
	}
	
	public static void displayPatient(Patient patient) {
        System.out.println(patient);
    }

    public static void displayProcedure(Procedure procedure) {
        System.out.println(procedure);
    }
	
	
	public static double calculateCharges(Procedure procedure, Procedure procedure2, Procedure procedure3) {
		double totalCharges = 0.0; 
		totalCharges += Double.parseDouble(procedure.getProcedureCharges());
		totalCharges += Double.parseDouble(procedure2.getProcedureCharges());
		totalCharges += Double.parseDouble(procedure3.getProcedureCharges());
		return(totalCharges);
	}
}