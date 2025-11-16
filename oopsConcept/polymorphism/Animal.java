//in this i learn that method overriding 
//i think it is same as just for fun example of cars

class Animal {
    void sound() {
        System.out.println("Animal makes sound");
    }
}

class Dog extends Animal {
    void sound() {  // overriding
        System.out.println("Dog barks 🐶");
    }
}

class Cat extends Animal {
    void sound() { // overriding
        System.out.println("Cat meows 🐱");
    }
}

public class Main {
    public static void main(String[] args) {
        Animal a;

        a = new Dog();
        a.sound();  // Dog's sound

        a = new Cat();
        a.sound();  // Cat's sound
    }
}
