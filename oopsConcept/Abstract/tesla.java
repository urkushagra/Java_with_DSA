// by this i understand implementtion through abstrction method

abstract class Car {
    abstract void start(); // abstract method (no body)
    abstract void stop();
}

// Concrete subclass
class Tesla extends Car {
    String model;
    int mileage;

    // Constructor
    Tesla(String m1, int m2) {
        model = m1;
        mileage = m2;
        System.out.println("Tesla model: " + model + " is achieving fuel efficiency of: " + mileage);
    }

    // Implementation of abstract methods
    void start() {
        System.out.println("Car " + model + " starts with a push button ");
    }

    void stop() {
        System.out.println("Car " + model + " stops with fuel efficiency of: " + mileage);
    }
}

// Main class
public class Main {
    public static void main(String[] args) {
        Car myCar1 = new Tesla("Y-model", 22);
        Car myCar2 = new Tesla("X-model", 34);
        Car homeCar = new Tesla("CNG-X", 12);
        Car officeCar = new Tesla("Power-Y", 5);

        System.out.println("\n--- Car Actions ---");
        myCar1.start();
        myCar1.stop();

        myCar2.start();
        myCar2.stop();

        homeCar.start();
        homeCar.stop();

        officeCar.start();
        officeCar.stop();
    }
}
