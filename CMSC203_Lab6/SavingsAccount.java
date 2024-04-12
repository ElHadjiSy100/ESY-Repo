package Lab6;

public class SavingsAccount extends BankAccount {
	private double rate = .025;
	private int savingsNumber = 0;
	private String accountNumber;
	
	public SavingsAccount(String name, int initialBalance) {
		super(name, initialBalance);
		accountNumber = super.getAccountNumber() + "-" + savingsNumber;
		
	}
	
	public void postInterest() {
		super.deposit((rate/12.0)*super.getBalance());
	}
	
	@Override
	public String getAccountNumber() {
		return accountNumber;
	}
	
	public SavingsAccount(SavingsAccount otherSavingsAccount, int initialBalance) {
		super(otherSavingsAccount, initialBalance);
		savingsNumber++;
		accountNumber = super.getAccountNumber() + "-" + savingsNumber;
	}
}
