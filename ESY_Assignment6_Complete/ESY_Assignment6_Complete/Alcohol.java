package ESY_Assignment6_Complete;

public class Alcohol extends Beverage{
	private boolean isWeekend;  
	
	public Alcohol(String bevName, Size size, boolean isWeekend) {
		 super(bevName, size, Type.ALCOHOL); 
		 this.isWeekend = isWeekend; 
	}
	
	public double calcPrice() {
		double price = addSizePrice(); 
		if(isWeekend == true) {
			price += .60; 
		}
		return price; 
	}
	
	public String toString() {
		return "" + super.getBevName() + " " + super.getSize() + " " + isWeekend;
	}
	
	public void setIsWeekend(boolean isWeekend) {
		this.isWeekend = isWeekend; 
	}
	
	public boolean getIsWeekend() {
		return isWeekend; 
	}
	@Override 
	public boolean equals(Object anotherAlcohol) {
		if(anotherAlcohol instanceof Alcohol) {
			return (super.equals(anotherAlcohol) && ((Alcohol) anotherAlcohol).getIsWeekend() == this.isWeekend);

		}
		return false;
	}
}
