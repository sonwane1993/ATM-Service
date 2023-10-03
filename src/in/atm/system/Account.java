package in.atm.system;

import java.util.ArrayList;
import java.util.List;

class Account {
    private int accountId;
    private AccountHolder owner;
    private double balance;
    private List<BankTransaction> transactionHistory;

    public Account(int accountId, AccountHolder owner, double initialBalance) {
        this.accountId = accountId;
        this.owner = owner;
        this.balance = initialBalance;
        this.transactionHistory = new ArrayList<>();
    }

    public int getAccountId() {
        return accountId;
    }

    public AccountHolder getOwner() {
        return owner;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactionHistory.add(new BankTransaction("Deposit", amount));
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            transactionHistory.add(new BankTransaction("Withdrawal", amount));
        }
    }
    
    public void transfer(double amount) {
    	
    	if(amount > 0 && balance >= amount) {
    		
    		balance -=amount;
    		transactionHistory.add(new BankTransaction("transfer", amount));
    	}
    }
    
    // class genrick type.......
    public List<BankTransaction> getTransactionHistory() {
        return transactionHistory;
    }
}


