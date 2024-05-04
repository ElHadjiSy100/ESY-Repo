package ESY_Assignment6_Complete;

import java.util.*;

public class Order implements OrderInterface, Comparable {
	private int orderNo;
	private int orderTime;
	private Day orderDay;
	private Customer cust; 
	private ArrayList<Beverage> beverages = new ArrayList<Beverage>();
	
	public Order(int orderTime, Day orderDay, Customer cust) {
		this.orderTime = orderTime; 
		this.orderDay = orderDay; 
		this.cust = cust; 
	}
	 public int generateOrder() {
	        Random rand = new Random();
	        orderNo = rand.nextInt(10000, 90000);
	        return orderNo; 
	    }

	    public int getOrderNo() {
	        return orderNo;
	    }

	    public void setOrderTime(int orderTime) {
	        this.orderTime = orderTime; 
	    }

	    public int getOrderTime() {
	        return orderTime;
	    }

	    public void setOrderDay(Day orderDay) {
	        this.orderDay = orderDay; 
	    }

	    public Day getOrderDay() {
	        return orderDay;
	    }

	    public void setCustomer(Customer cust) {
	        this.cust = cust; 
	    }

	    public Customer getCustomer() {
	        return cust;
	    }

	    public Day getDay() {
	        return orderDay;
	    }
	    
	@Override
	public int compareTo(Object anotherOrder) {
        int num = this.orderNo - ((Order)anotherOrder).orderNo; 
        if(num > 0) {
            return 1;
        } else if(num < 0){
            return -1;
        } else {
            return 0;
        }

	}
	
	@Override
	public boolean isWeekend() {
		 return(orderDay == Day.SATURDAY || orderDay == Day.SUNDAY);
	}
	
    public void setBeverage(Beverage beverage) {
        beverages.add(beverage);
    }
    
	@Override
	public Beverage getBeverage(int orderNo) {
		return beverages.get(orderNo);
	}
	
    public int getTotalItems() {
        return beverages.size();
    }
    
	@Override
	public void addNewBeverage(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
		 Beverage beverage = new Coffee(bevName, size, extraShot, extraSyrup); 
	        beverages.add(beverage);	
	}
	
	@Override
	public void addNewBeverage(String bevName, Size size) {
	    Beverage beverage = new Alcohol(bevName, size, isWeekend()); 
        beverages.add(beverage);
	}
	
	@Override
	public void addNewBeverage(String bevName, Size size, int numOfFruits, boolean addProtein) {
		 Beverage beverage = new Smoothie(bevName, size, numOfFruits, addProtein); 
	        beverages.add(beverage);	
	}
	
	@Override
    public String toString() {
        return "" + orderNo + " " + orderTime + " " + orderDay + " " + cust.getName() + " " + cust.getAge();
    }
    
	@Override
	public double calcOrderTotal() {
	     double total = 0.0; 
	        for(int i = 0; i < beverages.size(); i++) {
	            if(beverages.get(i) instanceof Coffee) {
	                Coffee coffee = (Coffee) beverages.get(i);
	                total += coffee.calcPrice();
	            }else if(beverages.get(i) instanceof Smoothie) {
	                Smoothie smoothie = (Smoothie) beverages.get(i);
	                total += smoothie.calcPrice();
	            }else if(beverages.get(i) instanceof Alcohol) {
	                Alcohol alcohol = (Alcohol) beverages.get(i);
	                total += alcohol.calcPrice();
	            }
	        }
	        System.out.println(total);
	        return total;
	}
	@Override
	public int findNumOfBeveType(Type type) {
	       int count = 0;
	        if(type == Type.COFFEE) {
	            for(int i = 0; i < beverages.size(); i++) {
	                if(beverages.get(i) instanceof Coffee) {
	                    count++;
	                }
	            }
	        } else if(type == Type.SMOOTHIE) {
	            for(int i = 0; i < beverages.size(); i++) {
	                if(beverages.get(i) instanceof Smoothie) {
	                    count++;
	                }
	            }
	        } else if(type == Type.ALCOHOL) {
	            for(int i = 0; i < beverages.size(); i++) {
	                if(beverages.get(i) instanceof Alcohol) {
	                    count++; 
	                }
	            }
	        }
	        return count; 
	}
	
	
	
}
		