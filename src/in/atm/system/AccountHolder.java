package in.atm.system;

class AccountHolder {
    private int userId;
    private int userPin;

    public AccountHolder(int userId, int userPin) {
        this.userId = userId;
        this.userPin = userPin;
    }

    public boolean authenticate(int userId, int userPin) {
        return this.userId == userId && this.userPin == userPin;
    }
}
