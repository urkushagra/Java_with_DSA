/**
 * Title: Polymorphism Demonstration using Data Structures
 * Author: Kushagra Upadhayay
 * Description:
 * This program demonstrates Runtime Polymorphism in Java
 * by using a common interface `DataStructure` and
 * implementing it with different data structures (Stack, Queue, PriorityQueue).
 *
 * Each class provides its own behavior for insertion and deletion operations.
 */

import java.util.*;

interface DataStructure {
    void insert(int value);
    void remove();
    void display();
}

// -------------------- Stack Implementation --------------------
class StackDS implements DataStructure {
    private Stack<Integer> stack = new Stack<>();

    @Override
    public void insert(int value) {
        stack.push(value);
        System.out.println("Pushed " + value + " into Stack");
    }

    @Override
    public void remove() {
        if (!stack.isEmpty()) {
            System.out.println("Popped " + stack.pop() + " from Stack");
        } else {
            System.out.println("Stack is empty");
        }
    }

    @Override
    public void display() {
        System.out.println("Current Stack: " + stack);
    }
}

// -------------------- Queue Implementation --------------------
class QueueDS implements DataStructure {
    private Queue<Integer> queue = new LinkedList<>();

    @Override
    public void insert(int value) {
        queue.offer(value);
        System.out.println("Enqueued " + value + " into Queue");
    }

    @Override
    public void remove() {
        if (!queue.isEmpty()) {
            System.out.println("Dequeued " + queue.poll() + " from Queue");
        } else {
            System.out.println("Queue is empty");
        }
    }

    @Override
    public void display() {
        System.out.println("Current Queue: " + queue);
    }
}

// -------------------- PriorityQueue Implementation --------------------
class PriorityQueueDS implements DataStructure {
    private PriorityQueue<Integer> pq = new PriorityQueue<>();

    @Override
    public void insert(int value) {
        pq.offer(value);
        System.out.println("Inserted " + value + " into PriorityQueue");
    }

    @Override
    public void remove() {
        if (!pq.isEmpty()) {
            System.out.println("Removed smallest element " + pq.poll());
        } else {
            System.out.println("PriorityQueue is empty");
        }
    }

    @Override
    public void display() {
        System.out.println("Current PriorityQueue: " + pq);
    }
}

// -------------------- Main Class --------------------
public class PolymorphismDemo {
    public static void main(String[] args) {
        // Using polymorphism: same reference, different behaviors
        DataStructure ds;

        System.out.println("=== Stack Operations ===");
        ds = new StackDS();
        ds.insert(10);
        ds.insert(20);
        ds.display();
        ds.remove();
        ds.display();

        System.out.println("\n=== Queue Operations ===");
        ds = new QueueDS();
        ds.insert(5);
        ds.insert(15);
        ds.display();
        ds.remove();
        ds.display();

        System.out.println("\n=== PriorityQueue Operations ===");
        ds = new PriorityQueueDS();
        ds.insert(30);
        ds.insert(10);
        ds.insert(20);
        ds.display();
        ds.remove();
        ds.display();
    }
}
