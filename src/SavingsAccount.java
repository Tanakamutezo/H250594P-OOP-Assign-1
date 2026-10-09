public class SavingsAccount extends Account {
    private double minimumBalance;
    private double interestRate; // e.g., 0.05 for 5%

    public SavingsAccount(String accountNumber, double initialBalance, double minimumBalance, double interestRate) {
        super(accountNumber, initialBalance);
        this.minimumBalance = minimumBalance;
        this.interestRate = interestRate;
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdrawal amount must be positive.");
            return;
        }
        if (balance - amount < minimumBalance) {
            System.out.println("Transaction Rejected for " + accountNumber + ": Withdrawal would bring balance ($"
                    + (balance - amount) + ") below minimum required balance ($" + minimumBalance + ").");
        } else {
            balance -= amount;
            System.out.println("Withdrew $" + amount + " from " + accountNumber + ". Remaining balance: $" + balance);
        }
    }

    @Override
    public void endOfMonth() {
        double interest = balance * interestRate;
        balance += interest;
        System.out.println("End of month for SavingsAccount " + accountNumber + ": Interest added $"
                + interest + ". New balance: $" + balance);
    }
}
