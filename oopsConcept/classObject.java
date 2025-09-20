class Car {
    String brand;
    int speed;

    // Constructor
    Car(String brand, int speed) {
        this.brand = brand;
        this.speed = speed;
    }

    void display() {
        System.out.println("Brand: " + brand + ", Speed: " + speed);
    }

    public static void main(String[] args) {
        Car c1 = new Car("Tesla", 200);
        Car c2 = new Car("BMW", 180);
        c1.display();
        c2.display();
    }
}
