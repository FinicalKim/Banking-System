package Program_2;

import java.util.ArrayList;
import java.util.Scanner;


public class CSC205_Test_Program2 {
	private static Scanner in = new Scanner(System.in);
	
	public static void main(String[] args) {
		ArrayList<BankAccount> accounts = new ArrayList<BankAccount>();
		int menuChoice = 0;
		
		while (menuChoice != 9)
		{
			displayMainMenu();
			menuChoice = getMenuChoice();
			
			switch (menuChoice)
			{
				case 1: // add account
					addAccount(accounts);
					break;
				case 2: // make a credit
					makeCredit(accounts);
					break;
				case 3: // make a debit
					makeDebit(accounts);
					break;
				case 4: // transfer funds
					transferFunds(accounts);
					break;
				case 5: // view account details
					viewAccountDetails(accounts);
					break;
				case 6: // apply monthly interest
					applyMonthlyInterest(accounts);
					break;
				case 9: // exit program
					exitProgram();
					break;
				default:
					handleMenuError();
					break;
			}
		}

	}
	
	private static void displayMainMenu() {
		System.out.println("----------------------------");
		System.out.println("1) add account");
		System.out.println("2) make a credit");
		System.out.println("3) make a debit");
		System.out.println("4) transfer funds");
		System.out.println("5) view account details");
		System.out.println("6) apply monthly interest");
		System.out.println("9) exit program");
		System.out.println();
	}
	
	private static int getMenuChoice() {
		System.out.print("---> ");
		while(! in.hasNextInt() )
		{
			in.nextLine();
			System.out.print("---> ");
		}
		
		int menuChoice = in.nextInt();
		
		return menuChoice;
	}

	private static void addAccount(ArrayList<BankAccount> accounts) {
		int menuChoice = 0;
		
		while (menuChoice != 9)
		{
			displayAccountTypeMenu();
			menuChoice = getMenuChoice();
			
			switch (menuChoice)
			{
				case 1: // savings account
					addSavingsAccount(accounts);
					return;
				case 2: // checking account
					addCheckingAccount(accounts);
					return;
				case 3: // creditcard account
					addCreditcardAccount(accounts);
					return;
				case 9: // cancel add account
					exitProgram();
					break;
				default:
					handleMenuError();
					break;
			}
		}
	}

	private static void displayAccountTypeMenu() {
		System.out.println("----------------------------");
		System.out.println("1) savings account");
		System.out.println("2) checking account");
		System.out.println("3) creditcard account");
		System.out.println("9) cancel add account");
		System.out.println();
	}
	
	private static void addSavingsAccount(ArrayList<BankAccount> accounts) {
		SavingsAccount newAccount = new SavingsAccount();
		
		setBasicAccountData(newAccount);
		
		accounts.add(newAccount);
	}

	private static void addCheckingAccount(ArrayList<BankAccount> accounts) {
		CheckingAccount newAccount = new CheckingAccount();
		
		setBasicAccountData(newAccount);
		newAccount.setOverdraftFee(getOverdraftFee());
		
		accounts.add(newAccount);
	}

	private static void addCreditcardAccount(ArrayList<BankAccount> accounts) {
		CreditcardAccount newAccount = new CreditcardAccount();
		
		setBasicAccountData(newAccount);
		newAccount.setCreditLimit(getCcreditLimit());
		
		accounts.add(newAccount);
	}

	private static void setBasicAccountData(BankAccount newAccount) {
		newAccount.setAccountNumber(getAccountNumber());
		newAccount.setInterestRate(getInterestRate());
	}

	private static String getAccountNumber() {
		System.out.print("Account number          : ");
		
		String accountNumber = in.next();
		
		return accountNumber;
	}

	private static double getInterestRate() {
		System.out.print("Interest rate           : ");
		
		double interestRate = in.nextDouble();
		
		return interestRate;
	}
	
	private static int getOverdraftFee() {
		System.out.print("Overdraft fee (pennies) : ");
		
		int overdraftFee = in.nextInt();
		
		return overdraftFee;
	}

	private static int getCcreditLimit() {
		System.out.print("Credit Limit (pennies)  : ");
		
		int creditlimit = in.nextInt();
		
		return creditlimit;
	}
	
	private static void makeCredit(ArrayList<BankAccount> accounts) {
		String accountNumber = getAccountNumber();
		int amount = getAmount();
		
		for (BankAccount account : accounts)
			if (account.getAccountNumber().equals(accountNumber))
				account.credit(amount);
	}

	private static void makeDebit(ArrayList<BankAccount> accounts) {
		String accountNumber = getAccountNumber();
		int amount = getAmount();
		
		for (BankAccount account : accounts)
			if (account.getAccountNumber().equals(accountNumber))
			{
				if (! account.debit(amount))
					System.out.println("*** Debit failed - Insuficient funds or credit! ***");
				break;
			}
	}

	private static void transferFunds(ArrayList<BankAccount> accounts) {
		System.out.print("Account to transer funds FROM - ");
		String fromAccountNumber = getAccountNumber();
		
		System.out.print("Account to transer funds TO   - ");
		
		String toAccountNumber = getAccountNumber();
		int amount = getAmount();
		
		BankAccount fromAccount = null, toAccount = null;
		for (BankAccount account : accounts) {
			if (account.getAccountNumber().equals(fromAccountNumber))
				fromAccount = account;
			if (account.getAccountNumber().equals(toAccountNumber))
				toAccount = account;
		}
			
		if (toAccount != null && fromAccount != null && fromAccount.getBalance() >= amount) {
			fromAccount.debit(amount);
			toAccount.credit(amount);
		}
		else
			System.out.println("*** transfer failed - Invalid account number or insufficient funds!");
	}

	private static int getAmount() {
		System.out.print("Amount (in pennies)     : ");
		
		int amount = in.nextInt();
		
		return amount;
	}
	
	private static void viewAccountDetails(ArrayList<BankAccount> accounts) {
		String accountNumber = getAccountNumber();

    System.out.println();
		
		for (BankAccount account : accounts)
			if (account.getAccountNumber().equals(accountNumber))
			{
				System.out.println(account.getAccountInfo());
			}
	}

	private static void applyMonthlyInterest(ArrayList<BankAccount> accounts) {
		for (BankAccount account : accounts)
			account.applyInterest();
	}
	
	private static void exitProgram() {
		System.out.println("*** Exiting program! ***");
	}
	
	private static void handleMenuError() {
		System.out.println("*** Invalid menu choice! ***");		
	}
}
