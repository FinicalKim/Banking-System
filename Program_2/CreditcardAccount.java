package Program_2;
/*
Description: This class creates a Credit card account and manipulates the accounts data.
*/
public class CreditcardAccount extends BankAccount{

	private int creditLimit;
	
		// constructor to initialize variables.
	public CreditcardAccount() {
		super();
		creditLimit = 0;
	}
	
		// adds the debit to the balance
	public boolean debit(int amount) {
		if (amount > creditLimit + balance) {
			return false;
		}
		balance -= amount;
		return true;
	}

		// return the accounts credit limit
	public int getCreditLimit() {
		return this.creditLimit;
		
	}
	
		// sets the accounts credit limit
	public void setCreditLimit(int creditLimit) {
		this.creditLimit = creditLimit;
	}
		// Should interest rate be divided by 12, is it monthly??
	public void applyInterest() {
		if (balance < 0) {
			int temp = (int) (balance * interestRate);
			balance = balance + temp;}
		}
		
		// returns the account info as a string
	public String getAccountInfo() {
		return "Account type\t: Creditcard" + "\n" + 
				"Account #\t: " + getAccountNumber() + "\n" + 
				"Balance \t: " + "$" + (String.format( "%.2f", (double) getBalance() / 100.00)) + "\n" +
				"Intereest rate \t: " + (String.format( "%.2f", getinterestRate() * 100.00)) + "%" + "\n" + 
				"Credit limit \t: " + "$" + (String.format( "%.2f", (double) getCreditLimit()));
	}
	
}
