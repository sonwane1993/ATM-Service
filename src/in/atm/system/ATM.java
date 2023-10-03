package in.atm.system;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* User Id : 12345
 * User PIN : 6789
 * 
 * 2 Account available.......
 * Account id : 1
 * Account id : 2
 * 
 */

class ATM {
    private static final int USER_ID = 12345;
    private static final int USER_PIN = 6789;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Bank bank = new Bank();
        AccountHolder authorizedUser = new AccountHolder(USER_ID, USER_PIN);

        // Sample accounts for demonstration
        
        Account account1 = new Account(1, authorizedUser, 1000);
        Account account2 = new Account(2, authorizedUser, 500);  //new AccountHolder(54321, 9876)
        bank.addAccount(account1);
        bank.addAccount(account2);
        
        System.out.println("WELCOME TO THE BANK ATM");
        
        System.out.println("========================");

        
        
        System.out.print("Enter User ID: ");
        int userId = scanner.nextInt();
        System.out.print("Enter User PIN: ");
        int userPin = scanner.nextInt();

        System.out.println();
        
        if (authorizedUser.authenticate(userId, userPin)) {
        	System.out.println("*************************************");
        	
            System.out.println("Authentication successful.");
            
        	System.out.println("*************************************");

            displayMenu(scanner, bank, authorizedUser);
        }
        
    	System.out.println("*************************************");

        	System.out.println("Invalid Input........");
        	
        System.out.println("*************************************");

        System.out.print("Enter User ID: ");
        int userId1 = scanner.nextInt();
        System.out.print("Enter User PIN: ");
        int userPin1 = scanner.nextInt();

        System.out.println();
        
        if (authorizedUser.authenticate(userId1, userPin1)) {
        	System.out.println("*************************************");
        	
            System.out.println("Authentication successful.");
            
        	System.out.println("*************************************");

            displayMenu(scanner, bank, authorizedUser);
        }
        
        else {
            System.out.println("Authentication failed. Exiting.");
           
        }
    }

    // Display ATM Machine Menu.........
    public static void displayMenu(Scanner scanner, Bank bank, AccountHolder authorizedUser) {
        while (true) {
        	

            System.out.println("\nATM Menu:");
            System.out.println("1. Balance"); 
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Transfer");
            System.out.println("5. Show Transaction History");
            System.out.println("6. Quit");
            System.out.println("Enter your choice: ");


            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                	getBalance(scanner,bank, authorizedUser); //getBalance
                    break;
                case 2:
                    withdraw(scanner, bank, authorizedUser);
                    break;
                case 3:
                    deposit(scanner, bank, authorizedUser);
                    break;
                case 4:
                	transfer(scanner, bank, authorizedUser);
                    // Implement transfer functionality
                    break;
                case 5:
                	showTransactionHistory(bank, authorizedUser);
                    // Implement transfer functionality
                    break;
                case 6:
                	
                    System.out.println("***********************************");
                    
                    
                    	System.out.println("Thank you for using the ATM. Goodbye!");
                    	
                    	
                    System.out.println("***********************************");
	
                    scanner.close();
                    System.exit(0);
                default:
                	
                    System.out.println("***********************************");

                    	System.out.println("Invalid choice. Please try again.");
                    
                    System.out.println("***********************************");

                    break;
            }
        }
    }

    public static void showTransactionHistory(Bank bank, AccountHolder authorizedUser) {
    	
        System.out.println("************************");

        System.out.println("\nTransaction History:");
        
        System.out.println("************************");

        for (Account account : bank.accounts) {
            if (account.getOwner().equals(authorizedUser)) {
                List<BankTransaction> transactions = account.getTransactionHistory();
                for (BankTransaction transaction : transactions) {
                	
                	System.out.println("Transaction Histry.. ");
                    System.out.println("Account ID: " + account.getAccountId());
                    System.out.println("Transaction Type: " + transaction.getTransactionType());
                    System.out.println("Amount: $" + transaction.getAmount());
                    
                    System.out.println("************************");

                }
            }
        }
    }

    public static void withdraw(Scanner scanner, Bank bank, AccountHolder authorizedUser) {
        System.out.print("Enter Account ID: ");
        int accountId = scanner.nextInt();
        Account account = bank.findAccount(accountId);
        double balance1 = account.getBalance();

        if (account != null && account.getOwner().equals(authorizedUser)) {
            System.out.print("Enter withdrawal amount: ");
            double amount = scanner.nextDouble();
            account.withdraw(amount);
            
            // If balance is less in Account....
            
            if(balance1 >= amount) {
            	
	            System.out.println("************************");
	
	            	System.out.println("Withdrawal successful.");
	            
	            System.out.println("*************************");
            }else {
            	System.out.println("***************************");

            	
            		System.out.println("Insufisiant Balance....");
            	
            	System.out.println("***************************");
            	
            }
            
            
        } else {
            System.out.println("***********************************");

            	System.out.println("Invalid account or not authorized.");
            	
            System.out.println("***********************************");
	
        }
    }

    public static void deposit(Scanner scanner, Bank bank, AccountHolder authorizedUser) {
        System.out.print("Enter Account ID: ");
        int accountId = scanner.nextInt();
        Account account = bank.findAccount(accountId);

        if (account != null && account.getOwner().equals(authorizedUser)) {
            System.out.print("Enter deposit amount: ");
            double amount = scanner.nextDouble();
            account.deposit(amount);
            
            System.out.println("************************");
            
            	System.out.println("Deposit successful.");
            
            System.out.println("************************");

        } else {
        	
            System.out.println("***********************************");

            	System.out.println("Invalid account or not authorized.");
            	
            System.out.println("***********************************");
	
        }
    }
    
    public static void transfer(Scanner scanner, Bank bank, AccountHolder authorizedUser) {
    	
    	System.out.println("Enter Account ID: ");
    	int accountId = scanner.nextInt();
    	Account account = bank.findAccount(accountId);
    	
    	double balance2 =  account.getBalance();
    	
    	if(account != null && account.getOwner().equals(authorizedUser)) {
    		
    		System.out.println("Enter Transfer Amount: ");
    		double amount = scanner.nextDouble();
    		account.transfer(amount);
    		if(balance2 >= amount) {
		    		System.out.println("************************");
		            
		        		System.out.println("Transfer successful.");
		        	
		        	System.out.println("************************");
    		}
    		else {
    			
    			System.out.println("************************");
	            
        		System.out.println("Transfer Unsuccessful.");
        	
        	System.out.println("************************");
    		}
    	}else {
        	
            System.out.println("***********************************");

            	System.out.println("Invalid account or not authorized.");
            	
            System.out.println("***********************************");
	
        }
    	
    }
    
    public static void getBalance(Scanner scanner, Bank bank, AccountHolder authorizedUser) {
    	
		System.out.println("************************");

    		System.out.println("Enter Account ID: ");
    	int accountId = scanner.nextInt();
    	Account account = bank.findAccount(accountId);
    	
    	double balance =  account.getBalance();
    	
    		System.out.println("Account Balance : "+balance);
    		
		System.out.println("**************************");

    	

    	
    }
}

