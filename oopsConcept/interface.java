interface Payment {
    void pay(double amount);
}

class CreditCard implements Payment {
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using Credit Card");
    }
}

class UPI implements Payment {
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using UPI");
    }
}

class InterfaceDemo {
    public static void main(String[] args) {
        Payment p1 = new CreditCard();
        Payment p2 = new UPI();
        p1.pay(500);
        p2.pay(300);
    }
}
