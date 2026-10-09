import java.util.ArrayList;
import java.util.List;

public class BankDemo {
    public static void main(String[] args) {
        // Create accounts mix
        List<Account> accounts = new ArrayList<>();
        accounts.add(new SavingsAccount("SA-101", 1000.0, 200.0, 0.05));
        accounts.add(new CurrentAccount("CA-201", 500.0, 300.0, 15.0));

        System.out.println("=== 1. Demonstration of Polymorphism Loop ===");
        for (Account acc : accounts) {
            acc.withdraw(100.0);
            acc.endOfMonth();
            System.out.println("----------------------------------------------");
        }

        System.out.println("\n=== 2. Demonstration of Edge Cases ===");

        // SavingsAccount Edge Case: Withdrawal rejected when taking balance below minimum
        SavingsAccount sa = new SavingsAccount("SA-102", 250.0, 200.0, 0.03);
        System.out.println("[SavingsAccount] Initial Balance: $" + sa.getBalance());
        sa.withdraw(100.0); // Attempting to leave $150, which is below min $200

        System.out.println();

        // CurrentAccount Edge Case: Balance going negative within overdraft limit
        CurrentAccount ca = new CurrentAccount("CA-202", 100.0, 200.0, 10.0);
        System.out.println("[CurrentAccount] Initial Balance: $" + ca.getBalance());
        ca.withdraw(250.0); // Allowed: balance becomes -$150 (within -$200 limit)
    }
}