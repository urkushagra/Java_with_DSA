// this code is extended version of person.java file 
// here I understand completely the super completely


class Admin{
    Admin(){
        System.out.println("Approved by admin!!!");
    }
} 

class Person extends Admin {
    Person() {
        super();
        System.out.println("Person created!");
     
    }
}

class Student extends Person {
    String name;
    int age;

    // Constructor
    Student(String n, int a) {
        super(); 
           
        
        name = n;
        age = a;
        System.out.println(name + "  is interesting");// calls parent (Person) constructor
        System.out.println("Student created! Name: " + name + ", Age: " + age);
    }

    void grade(){
        System.out.println(name + " subject passed");
    }
}





public class Main {
    public static void main(String[] args) {
        Student s1 = new Student("Kushagra", 22);
        s1.grade();
        Student s2 = new Student("Baby", 21);
        s2.grade();

        
    }
}
