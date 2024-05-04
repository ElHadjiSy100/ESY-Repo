package ESY_Assignment6_Complete;

public class Customer {
	private int age; 
	private String name; 
	
	Customer(String name, int age){
		this.name = name; 
		this.age = age; 
	}
	
	Customer(Customer c){
		this.age = c.age; 
	    this.name = c.name;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getAge() {
		return age;
	}
	
	public String getName() {
		return name; 
	}
	
	public String toString() {
		return "" + name + " " + age; 
	}
}
