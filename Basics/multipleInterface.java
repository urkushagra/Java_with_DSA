// Define Flyable interface
interface Flyable {
    void fly();
    void flySpeed();
}

// Define Drivable interface
interface Drivable {
    void drive();
    void driveSpeed();
}

// FlyingCar implements both interfaces
class FlyingCar implements Flyable, Drivable {
    String name;
    int speed;

    // Constructor
    FlyingCar(String n, int a) {
        name = n;
        speed = a;
    }

    // Implement Flyable methods
    public void fly() {
        System.out.println("Car " + name + " is flying ✈️");
    }

    public void flySpeed() {
        System.out.println("Flying speed of " + name + " is " + speed + " km/h");
    }

    // Implement Drivable methods
    public void drive() {
        System.out.println("Car " + name + " is driving 🚗");
    }

    public void driveSpeed() {
        System.out.println("Driving speed of " + name + " is " + speed + " km/h");
    }
}

// Main class to test
public class Main {
    public static void main(String[] args) {
        FlyingCar fc1 = new FlyingCar("Tesla", 120);
        FlyingCar fc2 = new FlyingCar("Tata", 89);

        fc1.fly();
        fc1.flySpeed();

        fc2.drive();
        fc2.driveSpeed();
    }
}
