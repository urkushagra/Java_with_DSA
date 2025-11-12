class Student {
    String name;
    int age;

    // Default constructor
    Student() {
        this("Unknown", 18);  // calls parameterized constructor
    }

    // Overloaded constructor with name only
    Student(String n) {
        this(n, 21);  // calls parameterized constructor
    }

    // Parameterized constructor
    Student(String n, int a) {
        name = n;
        age = a;
    }

    void show() {
        System.out.println(name + " - " + age);
    }
}

public class Main {
    public static void main(String[] args) {
        Student s1 = new Student();          // uses default constructor
        Student s2 = new Student("Baby");    // uses single-parameter constructor
        Student s3 = new Student("Kushagra", 22); // uses parameterized constructor

        s1.show();
        s2.show();
        s3.show();
    }
}
