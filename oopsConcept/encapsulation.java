class BankAccount {
    private double balance; // private variable

    public BankAccount(double balance) {
        this.balance = balance;
    }

    // getter
    public double getBalance() {
        return balance;
    }

    // setter
    public void deposit(double amount) {
        if (amount > 0) balance += amount;
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) balance -= amount;
    }

    public static void main(String[] args) {
        BankAccount acc = new BankAccount(1000);
        acc.deposit(500);
        acc.withdraw(200);
        System.out.println("Final Balance: " + acc.getBalance());
    }
}
