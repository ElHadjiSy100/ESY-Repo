package ESY_Assignment4_Complete;

public class Property {
	private String propertyName;
	private String city; 
	private double rentalAmount;
	private String owner; 
	private Plot plot; 
	
	public Property(){
		this.propertyName = "";
		this.city = "";
		this.owner = "";
		plot = new Plot(); 
	}
	
	public Property(String propertyName, String city, double rentAmount, String owner) {
		this.propertyName = propertyName;
		this.city = city; 
		rentalAmount = rentAmount; 
		this.owner = owner; 
		plot = new Plot();
	}
	
	public Property(String propertyName, String city, double rentAmount, String owner, int x, int y, int width, int depth) {
		this.propertyName = propertyName;
		this.city = city; 
		this.rentalAmount = rentAmount; 
		this.owner = owner; 
		plot = new Plot(x, y, width, depth);
	}
	
	public Property(Property otherProperty) {
		this(otherProperty.propertyName, otherProperty.city, otherProperty.rentalAmount, otherProperty.owner, 
		     otherProperty.getPlot().getX(), otherProperty.getPlot().getY(), otherProperty.getPlot().getWidth(), 
		     otherProperty.getPlot().getDepth());
	}
	
	public Plot getPlot() {
		return plot; 
	}
	
	public String getPropertyName() {
		return propertyName; 
	}
	
	public String getCity() {
		return city; 
	}
	
	public double getRentAmount() {
		return rentalAmount; 
	}
	
	public String getOwner() {
		return owner; 
	}
	
	public String toString() {
		System.out.println("" + propertyName + "," + city + "," + owner + "," + rentalAmount);
		return "" + propertyName + "," + city + "," + owner + "," + rentalAmount; 
	}
}
