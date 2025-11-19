// This class represents a bank account in a real banking system.
// We apply Encapsulation to protect the balance from unauthorized access.

class BankAccount {

    // -------------------------------
    // 1. PRIVATE DATA (HIDDEN VALUES)
    // -------------------------------
    // No one can directly change balance from outside this class.
    // Prevents hacking, negative balance, or invalid values.
    private double balance;

    private String accountHolderName;
    private String accountNumber;



    // ---------------------------------------------------------
    // 2. PUBLIC GETTERS → to READ DATA in a safe, controlled way
    // ---------------------------------------------------------
    // These methods allow reading sensitive values safely.
    // We do NOT return password or secret details.
    public double getBalance() {
        return balance;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }



    // ---------------------------------------------------------
    // 3. PUBLIC SETTERS → to UPDATE DATA with validation checks
    // ---------------------------------------------------------
    // Setter with validation → No negative or invalid balance allowed.
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;  // safely update balance
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Invalid deposit amount!");
        }
    }

    // Withdraw is also validated — prevents negative balance!
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Invalid withdrawal or insufficient balance!");
        }
    }

    // Setter for account details (with validation)
    public void setAccountHolderName(String name) {
        if (name != null && !name.isEmpty()) {
            this.accountHolderName = name;
        }
    }

    public void setAccountNumber(String number) {
        if (number.length() == 10) {  // simple validation example
            this.accountNumber = number;
        }
    }
}



// ------------------------------------------------------------------------
// MAIN CLASS → Demonstrates how encapsulation protects banking application
// ------------------------------------------------------------------------
public class Main {
    public static void main(String[] args) {

        // Create an account (like creating a user in a real bank app)
        BankAccount account = new BankAccount();

        // Set safe values using encapsulated setter methods
        account.setAccountHolderName("Kushagra");
        account.setAccountNumber("1234567890");

        // -------------------------------
        // TRYING TO ACCESS PRIVATE VALUE
        // -------------------------------
        // ❌ NOT ALLOWED:
        // account.balance = 999999;  // ERROR! balance is private

        // -------------------------------
        // USING SAFE CONTROLLED METHODS
        // -------------------------------
        account.deposit(5000); // ✔ allowed, validated
        account.withdraw(1500); // ✔ allowed
        account.withdraw(10000); // ❌ insufficient balance

        // ------------------------------------
        // ONLY SAFE READ ACCESS IS ALLOWED
        // ------------------------------------
        System.out.println("\n--- Account Details ---");
        System.out.println("Name: " + account.getAccountHolderName());
        System.out.println("Account No: " + account.getAccountNumber());
        System.out.println("Balance: " + account.getBalance());
    }
}
