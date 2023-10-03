package in.atm.system;

class BankTransaction {
    private String transactionType;
    private double amount;

    public BankTransaction(String transactionType, double amount) {
        this.transactionType = transactionType;
        this.amount = amount;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public double getAmount() {
        return amount;
    }
}
