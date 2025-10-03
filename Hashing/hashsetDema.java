import java.util.*;

class HashSetDemo {
    public static void main(String[] args) {
        HashSet<String> set = new HashSet<>();
        
        set.add("Apple");
        set.add("Banana");
        set.add("Mango");
        set.add("Apple"); // Duplicate, won’t be added
        set.add(null);    // null allowed
        
        System.out.println(set); 
        // Output could be: [Banana, Apple, Mango, null]
        // (order not guaranteed)
        
        System.out.println(set.contains("Mango")); // true
        set.remove("Banana");
        System.out.println(set); // [Apple, Mango, null]
    }
}
