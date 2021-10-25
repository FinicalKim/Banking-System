package Program_2;
/*CSC 205: 12247 / Asynchronous (no meets)
Program: #2 Inheritance and Polymorphism
Author: Kim Finical & ID# 36283133
Description: This class creates a cheacking account and manipulates the accounts data.
*/
public class CheckingAccount extends BankAccount{

	private int overdraftFee;
	
		// constructor to initialize variables.
	public CheckingAccount() {
		super();
		overdraftFee = 0;
	}
	
		// if the debit is greater than the balance then apply overdraft fee and deduct the balance 
	public boolean debit(int amount) {
		if (amount > balance) {
			balance -= overdraftFee;}
		balance -= amount;
		return true;
	}

		// returns the accounts overdraft fee
	public int getOverdraftFee() {
		return this.overdraftFee ;
		
	}
	
		// sets the accounts overdraft fee
	public void setOverdraftFee(int overdraftFee) {
		this.overdraftFee = overdraftFee;
	}
	
		// apply the interest to the account 
	public void applyInterest() {
		if (balance > 0) {
		int temp = (int) (balance * interestRate);
		balance = balance + temp;}
	}

		// returns the account info as a string
	public String getAccountInfo() {
		
		return "Account type\t: Checking" + "\n" + 
				"Account #\t: " + getAccountNumber() + "\n" + 
				"Balance \t: " + "$" + (String.format( "%.2f", (double) getBalance() / 100.00)) + "\n" +
				"Intereest rate \t: " + (String.format( "%.2f", getinterestRate() * 100.00)) + "%" + "\n" + 
				"Credit limit \t: " + "$" + (String.format( "%.2f", (double) getOverdraftFee()));
		
	}

}
