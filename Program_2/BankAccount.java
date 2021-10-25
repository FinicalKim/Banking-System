package Program_2;
/*CSC 205: 12247 / Asynchronous (no meets)
Program: #2 Inheritance and Polymorphism
Author: Kim Finical & ID# 36283133
Description: This abstract class contains all the methods the account types use 
and initializes all the variables.
*/
public abstract class BankAccount {

	protected String accountNumber;
	protected double interestRate;
	protected int balance;
	
		// constructor to initialize variables.
	public BankAccount(){
		accountNumber = "0000-0000-0000-0000";
		interestRate = 0;
		balance = 0;
	}
		// applies a credit to the balance
	public boolean credit(int amount) {
		balance += amount;
		return true;
		
	}
		
	public abstract boolean debit(int amount);
		
		// returns the accounts balance
	public int getBalance() {
		return balance;
		
	}
	
		// returns the accounts account number.
	public String getAccountNumber() {
		return accountNumber;
		
	}
	
		// sets the new accounts, account number
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

		// returns the accounts interest rate
	public double getinterestRate() {
		return interestRate;
		}

		// sets the new accounts interest rate
	public void setInterestRate(double setInterestRate) {
		this.interestRate = setInterestRate;
	}
	
	public abstract void applyInterest();
	
	public abstract String getAccountInfo();
	
	
}
