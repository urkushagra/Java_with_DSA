// File: OOPsAnalogyDemo.java

// -----------------------------
// Abstraction: General Idea of Vehicle
// -----------------------------
abstract class Vehicle {
    protected String brand;

    public Vehicle(String brand) {
        this.brand = brand;
    }

    // Abstract: Every vehicle starts differently
    public abstract void start();

    // Common feature: All vehicles have a brand
    public void showBrand() {
        System.out.println("Brand: " + brand);
    }
}

// -----------------------------
// Encapsulation: Engine = "Heart of the Vehicle"
// -----------------------------
class Engine {
    private int horsepower;
    private String type;

    public Engine(int horsepower, String type) {
        this.horsepower = horsepower;
        this.type = type;
    }

    public int getHorsepower() {
        return horsepower;
    }

    public void setHorsepower(int horsepower) {
        if (horsepower > 0) {
            this.horsepower = horsepower;
        } else {
            System.out.println("Horsepower must be positive!");
        }
    }

    public String getType() {
        return type;
    }
}

// -----------------------------
// Inheritance: Car is a type of Vehicle
// -----------------------------
class Car extends Vehicle {
    private Engine engine;

    public Car(String brand, Engine engine) {
        super(brand);
        this.engine = engine;
    }

    @Override
    public void start() {
        System.out.println(brand + " car starts with " +
                           engine.getHorsepower() + " HP " + engine.getType() + " engine.");
    }

    // Compile-time Polymorphism (Overloading)
    public void honk() {
        System.out.println("Car honks: Beep! Beep!");
    }

    public void honk(String mood) {
        System.out.println("Car honks in a " + mood + " mood!");
    }
}

// -----------------------------
// Another Child: Bike is also a Vehicle
// -----------------------------
class Bike extends Vehicle {
    public Bike(String brand) {
        super(brand);
    }

    @Override
    public void start() {
        System.out.println(brand + " bike starts with a kick!");
    }
}

// -----------------------------
// Main Program
// -----------------------------
public class OOPsAnalogyDemo {
    public static void main(String[] args) {
        Engine carEngine = new Engine(200, "Petrol");

        Car car = new Car("BMW", carEngine);
        Bike bike = new Bike("Ducati");

        car.showBrand();
        car.start();
        car.honk();
        car.honk("angry");

        System.out.println();

        bike.showBrand();
        bike.start();

        // Runtime Polymorphism
        Vehicle vehicle = new Car("Audi", new Engine(250, "Diesel"));
        vehicle.start(); // Decides at runtime
    }
}
