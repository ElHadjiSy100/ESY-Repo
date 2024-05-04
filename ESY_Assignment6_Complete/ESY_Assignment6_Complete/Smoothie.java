package ESY_Assignment6_Complete;

public class Smoothie extends Beverage{
	private int numOfFruits; 
	private boolean addProtein; 
	
	Smoothie(String bevName, Size size, int numOfFruits, boolean addProtein){
		super(bevName, size, Type.SMOOTHIE); 
		this.numOfFruits = numOfFruits; 
		this.addProtein = addProtein; 
	}
	
	public double calcPrice() {
		double price = addSizePrice();
		for(int i = 0; i < numOfFruits; i++) {
			price += .50;
		}
		if(addProtein == true) {
			price += 1.50;
		}
		return price; 
	}
	
	public void setAddProtein(boolean addProtein) {
		this.addProtein = addProtein; 
	}
	
	public boolean getAddProtein() {
		return addProtein; 
	}
	
	public void setNumOfFruits(int numOfFruits) {
		this.numOfFruits = numOfFruits; 
	}
	
	public int getNumOfFruits() {
		return numOfFruits; 
	}
	
	public String toString() {
		return "" + super.getBevName() + " " + super.getSize() + " " + numOfFruits + " " + addProtein;
	}
	
	public boolean equals(Object anotherSmoothie) {
		if(anotherSmoothie instanceof Smoothie) {
			return (super.equals(anotherSmoothie) && ((Smoothie) anotherSmoothie).getNumOfFruits() == this.numOfFruits && ((Smoothie) anotherSmoothie).getAddProtein() == this.addProtein);

		}
		return false;
	}
		
}
