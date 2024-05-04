package ESY_Assignment6_Complete;

import java.util.ArrayList;

/*
 * Class: CMSC203 
 * Instructor: Ashique Tanveer
 * Description: Create a BevShop which can take in orders of coffee, smoothies, and alcohol. 
 * Due: 5/3/24
 * Platform/compiler: Eclipse IDE 
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: El Hadji Sy
*/

public class BevShop implements BevShopInterface {
	ArrayList<Order> orders = new ArrayList<Order>(); 
	
	public BevShop() {
		
	}
	
	public boolean isValidTime(int time) {
		return(time >= 8 && time <= 23); 
	}

	@Override
	public int getMaxNumOfFruits() {
		
		return MAX_FRUIT;
	}

	@Override
	public int getMinAgeForAlcohol() {
		return MIN_AGE_FOR_ALCOHOL;
	}

	@Override
	public boolean isMaxFruit(int numOfFruits) {
		return(numOfFruits > getMaxNumOfFruits());
	}

	@Override
	public int getMaxOrderForAlcohol() {
		return MAX_ORDER_FOR_ALCOHOL;
	}

	@Override
	public boolean isEligibleForMore() {
		Order order = orders.get(orders.size()-1);
		return (order.findNumOfBeveType(Type.ALCOHOL) == MAX_ORDER_FOR_ALCOHOL);
	}

	@Override 
	public int getNumOfAlcoholDrink() {
		return orders.get(orders.size()-1).findNumOfBeveType(Type.ALCOHOL);
	}

	@Override
	public boolean isValidAge(int age) {
		return(age >= MIN_AGE_FOR_ALCOHOL);
	}

	@Override
	public void startNewOrder(int time, Day day, String customerName, int customerAge) {
		orders.add(new Order(time, day, new Customer(customerName, customerAge)));
		
	}

	@Override
	public void processCoffeeOrder(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
		orders.get(orders.size()-1).addNewBeverage(bevName, size, extraShot, extraSyrup);;
		
		
	}

	@Override
	public void processAlcoholOrder(String bevName, Size size) {
		orders.get(orders.size()-1).addNewBeverage(bevName, size);
		
	}

	@Override
	public void processSmoothieOrder(String bevName, Size size, int numOfFruits, boolean addProtein) {
		orders.get(orders.size()-1).addNewBeverage(bevName, size, numOfFruits, addProtein);
		
	}

	@Override
	public int findOrder(int orderNo) {
		for(int i = 0; i < orders.size(); i++) {
			if(orders.get(i).getOrderNo() == orderNo) {
				return i;
			}
		}
		return -1;
	}

	@Override
	public double totalOrderPrice(int orderNo) {
		int index = findOrder(orderNo);
		if(index == -1) {
			return 0.0;
		}
		return orders.get(index).calcOrderTotal();
	}

	@Override
	public double totalMonthlySale() {
		double total = 0.0; 
		for(int i = 0; i < orders.size(); i++) {
			total += orders.get(i).calcOrderTotal();
		}
		return total;
	}

	@Override
	public int totalNumOfMonthlyOrders() {
		return orders.size();
	}

	@Override
	public Order getCurrentOrder() {
		return orders.get(orders.size()-1);
	}

	@Override
	public Order getOrderAtIndex(int index) {
		return orders.get(index);
	}

	@Override
	public void sortOrders() {
		int n = orders.size(); 
        for (int i = 0; i < n - 1; i++) { 
            int min_idx = i; 
            for (int j = i + 1; j < n; j++) { 
                if (orders.get(j).getOrderNo() < orders.get(min_idx).getOrderNo()) {
                    min_idx = j; 
                }
            } 
            Order temp = orders.get(min_idx); 
            orders.set(min_idx, orders.get(i)); 
            orders.set(i, temp);
        } 
	}
}
