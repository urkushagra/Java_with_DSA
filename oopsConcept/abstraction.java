abstract class Vehicle {
    abstract void start();
    void fuel() {
        System.out.println("Fueling...");
    }
}

class Bike extends Vehicle {
    void start() {
        System.out.println("Bike starts with kick");
    }
}

class AbstractionDemo {
    public static void main(String[] args) {
        Vehicle v = new Bike();
        v.start();
        v.fuel();
    }
}
