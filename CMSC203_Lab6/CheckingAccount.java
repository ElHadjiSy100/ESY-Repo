package Lab6;


public class CheckingAccount extends BankAccount {
	private static double FEE = .15; 
	
	public CheckingAccount(String name, double amount) {
		super(name, amount);
		setAccountNumber((getAccountNumber()+"-10"));
	}
	
	@Override
	public boolean withdraw(double amount) {
		double checkClearing = FEE+amount; 
		return super.withdraw(checkClearing);
	}
	
	
}
