class Student {
    String name;
    int age;

    // Constructor 1
    Student() {
        this.name = "Unknown";
        this.age = 0;
    }

    // Constructor 2
    Student(String name) {
        this.name = name;
        this.age = 18;
    }

    // Constructor 3
    Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    void display() {
        System.out.println("Name: " + name + ", Age: " + age);
    }

    public static void main(String[] args) {
        Student s1 = new Student();
        Student s2 = new Student("John");
        Student s3 = new Student("Alice", 22);
        s1.display();
        s2.display();
        s3.display();
    }
}
