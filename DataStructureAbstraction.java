import java.util.*;

public class DataStructureAbstraction {
    public static void main(String[] args) {
        // Abstraction: Using the List interface
        List<Integer> numbers = new ArrayList<>();

        // We can perform operations without knowing internal implementation
        numbers.add(10);
        numbers.add(20);
        numbers.add(30);
        numbers.remove(1);
        numbers.add(40);

        System.out.println("List elements: " + numbers);

        // We can change the implementation without changing other code
        numbers = new LinkedList<>(numbers);
        numbers.add(50);
        System.out.println("After switching to LinkedList: " + numbers);
    }
}
