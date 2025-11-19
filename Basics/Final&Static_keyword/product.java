class Product {

    // FINAL → cannot change once assigned
    final String productId;

    String name;
    double price;

    Product(String id, String name, double price) {
        this.productId = id;   // assigned once in constructor
        this.name = name;
        this.price = price;
    }

    void showProduct() {
        System.out.println("Product ID: " + productId);
        System.out.println("Name: " + name);
        System.out.println("Price: ₹" + price);
        System.out.println("----------------------");
    }
}

public class Main {
    public static void main(String[] args) {

        Product p1 = new Product("P1001", "iPhone 14", 70000);
        Product p2 = new Product("P1002", "Samsung S24 FE", 50000);

        p1.showProduct();
        p2.showProduct();

        // p1.productId = "P2000";  // ❌ ERROR → cannot change final variable
    }
}
