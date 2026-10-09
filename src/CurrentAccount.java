public class CurrentAccount extends Account {
    private double overdraftLimit;
    private double monthlyMaintenanceFee;

    public CurrentAccount(String accountNumber, double initialBalance, double overdraftLimit, double monthlyMaintenanceFee) {
        super(accountNumber, initialBalance);
        this.overdraftLimit = overdraftLimit;
        this.monthlyMaintenanceFee = monthlyMaintenanceFee;
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdrawal amount must be positive.");
            return;
        }
        if (balance - amount < -overdraftLimit) {
            System.out.println("Transaction Rejected for " + accountNumber + ": Exceeds overdraft limit of $" + overdraftLimit);
        } else {
            balance -= amount;
            System.out.println("Withdrew $" + amount + " from " + accountNumber + ". Remaining balance: $" + balance);
        }
    }

    @Override
    public void endOfMonth() {
        balance -= monthlyMaintenanceFee;
        System.out.println("End of month for CurrentAccount " + accountNumber + ": Maintenance fee deducted $"
                + monthlyMaintenanceFee + ". New balance: $" + balance);
    }
}
