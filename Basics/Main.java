/*magine you’re Kushagra the Student 👇

You have a parent (Person).

You also have your own properties (Student).

Now when you are created (new Student()):

First your parent (Person) must be created → that’s super().

Then you (Student) get created → that’s your constructor.

If you have two constructors in your own class, and one calls another → that’s this().

✅ So,

super() = “Call my parent.”

this() = “Call my other constructor.” */

class Person {
    Person(String name) {
        System.out.println("Parent: " + name);
    }
}

class Student extends Person {
    Student() {
        this("Kushagra", 21);  // call own constructor
        System.out.println("Default Student created!");
    }

    Student(String name, int age) {
        super(name);  // call parent constructor
        System.out.println("Student age: " + age);
    }
}

public class Main {
    public static void main(String[] args) {
        Student s1 = new Student();
    }
}
