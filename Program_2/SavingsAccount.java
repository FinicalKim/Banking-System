package Program_2;
/*CSC 205: 12247 / Asynchronous (no meets)
Program: #2 Inheritance and Polymorphism
Author: Kim Finical & ID# 36283133
Description: This class creates a savings account and manipulates the accounts data.
*/
public class SavingsAccount extends BankAccount{

	public SavingsAccount() {
		super();
	}
	
		// if the debit is greater than the balance then return false otherwise return true and deduct from balance.
	public boolean debit(int amount) {
		if (amount > balance) {
				return false;
		}else {
			balance -= amount;
		return true;}
	}

		// apply the interest rate as a percent
	public void applyInterest() {
		int temp = (int) (balance * interestRate);
		balance = balance + temp;
		
	}

		// return the accounts info as a string
	public String getAccountInfo() {
		
		return "Account type\t: SavingAccount" + "\n" + 
				"Account #\t: " + getAccountNumber() + "\n" + 
				"Balance \t: " + "$" + (String.format( "%.2f", (double) getBalance() / 100.00)) + "\n" +
				"Intereest rate \t: " + (String.format( "%.2f", getinterestRate() * 100.00)) + "%";
	}

}
