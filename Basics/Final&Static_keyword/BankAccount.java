class BankAccount {

    // Shared by ALL customers → static
    static String bankName = "State Bank of India";

    // Unique for each object
    String accountHolder;
    int balance;

    BankAccount(String name, int bal) {
        this.accountHolder = name;
        this.balance = bal;
    }

    void showDetails() {
        System.out.println("Bank: " + bankName);
        System.out.println("Customer: " + accountHolder);
        System.out.println("Balance: " + balance);
        System.out.println("----------------------");
    }
}

public class Main {
    public static void main(String[] args) {

        BankAccount a1 = new BankAccount("Kushagra", 5000);
        BankAccount a2 = new BankAccount("Aman", 8000);

        a1.showDetails();
        a2.showDetails();

        // Updating static variable
        BankAccount.bankName = "HDFC Bank";  // affects all accounts

        a1.showDetails();
        a2.showDetails();
    }
}
