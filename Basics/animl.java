// in 12th line of code we see that super keyword but i disscuss earlier that super keyword is added by java compiler by itself but we can see that super.eat(); is added by us 
// we can call any method of parent class of in child class which we want to use .. we don't need to need call every function  from parents class in child classs.
// we will call any particular method by using super keywords
class Animal {
    void eat() {
        System.out.println("Animal eats");
    }
}

class Dog extends Animal {
    void eat() {
        System.out.println("Dog eats biscuits");
        super.eat(); // call parent method
    }
}

public class Main {
    public static void main(String[] args) {
        Dog d = new Dog();
        d.eat();
    }
}
