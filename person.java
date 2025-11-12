// this code shows the implementation of super keyword in the parameterized constructore 
// i found that super keyword acess the parent class 

class Person {
    Person() {
        System.out.println("Person created!");
    }
}

class Student extends Person {
    super();
    Student(String n, int a) {
        name=n;
        age=a;
    }
          // calls parent (Person) constructor
        System.out.println("Student created!" + name + age );
           
        }
         void grade(){
            System.out.println("student is passed");
    }
}

public class Main {
    public static void main(String[] args) {
        Student s1 = new Student("kushagra", 22);
        Student s2 = new Student("baby", 21);
        
        
        
    }
}
