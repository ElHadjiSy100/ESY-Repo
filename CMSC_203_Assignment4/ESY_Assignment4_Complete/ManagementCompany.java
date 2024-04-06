package ESY_Assignment4_Complete;

import java.util.*;
/*
 * Class: CMSC203 31480
 * Instructor: Professor Ashique Tanveer
 * Description: Create a management company that oversees properties, and create plots for those properties.
 * Due: 04/05/2024
 * Platform/compiler: Eclipse IDE
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: El Hadji Sy 
*/

public class ManagementCompany {
	private String name; 
	private String taxID;
	private double mgmFee; 
	public static final int MAX_PROPERTY = 5; 
	public static final int MGMT_WIDTH = 10;
	public static final int MGMT_DEPTH = 10; 
	private Property[] properties; 
	private Plot plot;
	private int numberOfProperties; 
	
	public ManagementCompany() { 
		this.name = "";
		this.taxID = "";
		plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
		properties = new Property[MAX_PROPERTY]; 
	}
	
	public ManagementCompany(String name, String taxID, double mgmFee) {
		this.name = name; 
		this.taxID = taxID; 
		this.mgmFee = mgmFee; 
		plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
		properties = new Property[MAX_PROPERTY];
	}
	

	public ManagementCompany(String name, String taxID, double mgmFee, int x, int y, int width, int depth) {
		this.name = name; 
		this.taxID = taxID; 
		this.mgmFee = mgmFee;
		plot = new Plot(x, y, width, depth);
		properties = new Property[MAX_PROPERTY];
	}
	
	public ManagementCompany(ManagementCompany otherManagementCompany) {
		this(otherManagementCompany.name, otherManagementCompany.taxID, otherManagementCompany.mgmFee);
	}

	public int addProperty(String name, String city, double rent, String owner) {
		System.out.println("Top left = (" + plot.getX() + ", " + plot.getY() + "). "
							+ "Ends at (" + ( plot.getX( )+ plot.getWidth() ) + ", " + ( plot.getY() - plot.getDepth() ) + ")." );

		Property property = new Property(name, city, rent, owner);
		if(numberOfProperties == MAX_PROPERTY) {
			return -1;
		} else if(property == null) {
			return -2; 
		} else if(!plot.encompasses(property.getPlot())) {
			System.out.println("thisWasTheResult");
			return -3;
		} else {
			for(int i = 0; i < numberOfProperties; i++) {
				if(properties[i].getPlot().overlaps(property.getPlot())) {
					return -4;
				}
			}
		}
		properties[numberOfProperties] = property;
		return numberOfProperties++; 
		
	}
	
	public int addProperty(String name, String city, double rent, String owner, int x, int y, int width, int depth) {
		Property property = new Property(name, city, rent, owner, x, y, width, depth);
		if(numberOfProperties == MAX_PROPERTY) {
			return -1;
		} else if(property == null) {
			return -2; 
		} else if(!plot.encompasses(property.getPlot())) {
			return -3;
		} else {
			for(int i = 0; i < numberOfProperties; i++) {
				if(properties[i].getPlot().overlaps(property.getPlot())) {
					return -4;
				}
			}
		}
		properties[numberOfProperties] = property;
		return numberOfProperties++;
	}
	
	
	public int addProperty(Property property) {
		Property propertyToAdd = new Property(property);
		if(numberOfProperties == MAX_PROPERTY) {
			return -1;
		} else if(propertyToAdd == null) {
			return -2; 
		} else if(!plot.encompasses(propertyToAdd.getPlot())) {
			return -3;
		} else {
			for(int i = 0; i < numberOfProperties; i++) {
				if(properties[i].getPlot().overlaps(propertyToAdd.getPlot())) {
					return -4;
				}
			}
		}
		properties[numberOfProperties] = propertyToAdd;
		return numberOfProperties++;
	}
	
	public void removeProperty() {
		properties[numberOfProperties] = null;
	}
	
	public boolean isPropertiesFull() {
		return (numberOfProperties == MAX_PROPERTY);
	}
	
	public int getPropertiesCount() {
		return numberOfProperties;
	}
	
	public double getTotalRent() {
		double totalRent = 0.0;
		for(int i = 0; i < numberOfProperties; i++) {
			totalRent += properties[i].getRentAmount();
		}
		return totalRent;
	}
	
	public Property getHighestRentProperty() {
		Property highestProperty = new Property(properties[0]);
		double highestRent = properties[0].getRentAmount();
		for(int i = 0; i < properties.length; i++) {
			if(properties[i].getRentAmount() > highestRent) {
				highestProperty = properties[i];
				highestRent = properties[i].getRentAmount();
			}
		}
		return highestProperty;
	}
	
	public boolean isManagementFeeValid(){
		return (mgmFee > 0 && mgmFee < 100);
	}
	
	public String getName() {
		return name;
	}
	
	public String getTaxID() {
		return taxID;
	}
	
	public Property[] getProperties() {
		return properties;
	}
	
	public double getMgmFeePer() {
		return mgmFee*.01*this.getTotalRent();
		}
	
	public Plot getPlot() {
		return plot;
	}
	
	public String toString() {
	    String str = "List of the properties for " + getName() + ", taxID: " + getTaxID() +"\n" +"______________________________________________________\n";
		for(int i = 0; i < numberOfProperties; i++) {
			str +=  properties[i].getPropertyName() + "," + properties[i].getCity() + "," + properties[i].getOwner() + "," 
		            + properties[i].getRentAmount() + "\n______________________________________________________";
		}
		   str+= "\n\n total management Fee: "  + getMgmFeePer();
		return str;
	}
}