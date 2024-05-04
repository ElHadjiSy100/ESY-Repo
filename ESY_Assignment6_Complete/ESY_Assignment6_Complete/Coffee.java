package ESY_Assignment6_Complete;

public class Coffee extends Beverage {
	private boolean extraShot; 
	private boolean extraSyrup;
	
	public Coffee(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
		super(bevName, size, Type.COFFEE);
		this.extraShot = extraShot; 
		this.extraSyrup = extraSyrup; 
	}
	
	public void setExtraShot(boolean extraShot) {
		this.extraShot = extraShot;
	}
	
	public boolean getExtraShot() {
		return extraShot; 
	}
	
	public void setExtraSyrup(boolean extraSyrup) {
		this.extraSyrup = extraSyrup;
	}
	
	public boolean getExtraSyrup() {
		return extraSyrup; 
	}
	
	public String toString() {
		return "" + super.getBevName() + " " + super.getSize() + " " + " " + extraShot + " " + extraSyrup;
	}
	
	public double calcPrice() {
		double price = this.addSizePrice();
		if(extraShot == true) {
			price += .50;
		}
		if(extraSyrup == true) {
			price += .50;
		}
		
		return price; 
	}
	
	public boolean equals(Object anotherCoffee) {
		if(anotherCoffee instanceof Coffee) {
			return (super.equals(anotherCoffee) && ((Coffee) anotherCoffee).getExtraSyrup() == this.extraSyrup && ((Coffee) anotherCoffee).getExtraShot() == this.extraShot);

		}
		return false;
	}
}
