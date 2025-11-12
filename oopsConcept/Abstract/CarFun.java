// this is for my fun 
// extends Abstract with different subclasses

// Abstract class
abstract class Car {
    abstract void start(); // abstract method (no body)
    abstract void stop();
}

// Concrete subclass
class Tesla extends Car {
    String model;
    int mileage;

    // Constructor
    Tesla(String model, int mileage){
        this.model = model;
        this.mileage = mileage;
        System.out.println("Tesla model: " + this.model + " is achieving fuel efficiency of: " + this.mileage);
    }

    // Implementation of abstract methods
    
    void start() {
        System.out.println("Car " + model + " starts with a push button");
    }

    
    void stop() {
        System.out.println("Car " + model + " stops with fuel efficiency of: " + mileage);
    }
}

class RangeRover extends Car {
    String name;
    String terrainType;
    float fuelEfficiency;
    int tyrePressure;

    RangeRover(String name, String terrainType, float fuelEfficiency, int tyrePressure) {
        this.name = name;
        this.terrainType = terrainType;
        this.fuelEfficiency = fuelEfficiency;
        this.tyrePressure = tyrePressure;

        System.out.println("The Range Rover " + this.name
                + " adjusts fuel efficiency to " + this.fuelEfficiency
                + " and tyre pressure to " + this.tyrePressure
                + " PS automatically based on the selected " + this.terrainType + " terrain.");
    }

    
    void start() {
        System.out.println("Car " + name + " starts with a push button");
    }

    
    void stop() {
        System.out.println("Car " + name + " stops with fuel efficiency of: " + fuelEfficiency);
    }
}

// Main class
public class Main {
    public static void main(String[] args) {
        Car myCar1 = new Tesla("Y-model", 22);
        Car myCar2 = new Tesla("X-model", 34);
        Car homeCar = new Tesla("CNG-X", 12);
        Car officeCar = new Tesla("Power-Y", 5);

        Car realCar = new RangeRover("Evoque", "Sports", 18.7f, 32);
        Car realCar2 = new RangeRover("Vellar", "Comfort", 12.9f, 34);

        System.out.println("\n--- Car Actions ---");
        myCar1.start();
        myCar1.stop();

        myCar2.start();
        myCar2.stop();

        homeCar.start();
        homeCar.stop();

        officeCar.start();
        officeCar.stop();

        realCar.start();
        realCar2.stop();

        realCar2.start();
        realCar.stop();
    }
}
