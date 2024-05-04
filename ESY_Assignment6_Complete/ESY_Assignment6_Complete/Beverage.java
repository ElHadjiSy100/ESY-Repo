package ESY_Assignment6_Complete;

public abstract class Beverage {
	private String bevName;
	private Size size; 
	private Type type; 
    private final double BASE_PRICE = 2.0;
    private final double SIZE_PRICE = 0.5;
    
    public Beverage(String bevName, Size size, Type type) {
    	this.bevName = bevName;
    	this.size = size;
    	this.type = type;  
    }
    
    public double addSizePrice() {
    	if(this.size == Size.SMALL) {
    		return BASE_PRICE;
    	}
    	else if(this.size == Size.MEDIUM) {
    		return BASE_PRICE + SIZE_PRICE;
    	}
    	return BASE_PRICE +(2*SIZE_PRICE);
    }
    
    public abstract double calcPrice();
    
    
    public String toString() {
    	return "" + bevName + "" + size + " " + type;
    }
    
    public void getBevName(String bevName) {
    	this.bevName = bevName; 
    }
    
    public String getBevName() {
    	return bevName;
    }
    
    public double getBasePrice() {
    	return BASE_PRICE;
    }
    
    public void setType(Type type) {
    	this.type = type; 
    }
  
    public Type getType() {
    	return type;
    }
    
    public void setSize(Size size) {
    	this.size = size; 
    }
    
    public Size getSize() {
    	return size;
    }
    
    public boolean equals(Object anotherBev) {
    	if(anotherBev instanceof Beverage) {
    		return (((Beverage)anotherBev).bevName.equals(this.bevName) && ((Beverage)anotherBev).size == this.size && ((Beverage)anotherBev).type == this.type);
    	}
    	return false; 
    }
}
