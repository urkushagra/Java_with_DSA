// Define the Vehicle interface
interface Vehicle {
    void start();
    void stop();
    void sound();
}

// Define the Car class implementing Vehicle
class Car implements Vehicle {
    String name;
    int mileage;
    boolean sound; // represents whether the sound is loud or not

    // Constructor
    Car(String n, int m, boolean x) {
        name = n;
        mileage = m;
        sound = x;
    }

    // Implement start() method
    public void start() {
        System.out.println("Car " + name + " started 🚗");
    }

    // Implement stop() method
    public void stop() {
        System.out.println("Car " + name + " stopped 🛑 with mileage of " + mileage);
    }

    // Implement sound() method
    public void sound() {
        if (sound) {
            System.out.println("Car " + name + " has a loud sound 🔊");
        } else {
            System.out.println("Car " + name + " sound is under limit 🔈");
        }
    }
}

// Main class to test
public class Main {
    public static void main(String[] args) {
        Vehicle v1 = new Car("Kekeye", 34, true);
        Vehicle v2 = new Car("Baby", 15, false);

        v1.start();
        v2.stop();
        v1.sound();
    }
}
