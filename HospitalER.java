import java.util.ArrayDeque;
import java.util.Deque;

// A class to represent Patient record
class Patient {
    int id;
    String name;
    String condition;
    boolean isEmergency;

    public Patient(int id, String name, String condition, boolean isEmergency) {
        this.id = id;
        this.name = name;
        this.condition = condition;
        this.isEmergency = isEmergency;
    }

    @Override
    public String toString() {
        return "[PatientID: " + id + ", Name: " + name + 
               ", Condition: " + condition + ", Emergency: " + isEmergency + "]";
    }
}

// Hospital ER Queue Simulation
public class HospitalER {
    private Deque<Patient> erQueue = new ArrayDeque<>();

    // Admit patient (Emergency -> front, Normal -> rear)
    public void admitPatient(Patient p) {
        if (p.isEmergency) {
            erQueue.addFirst(p);
            System.out.println("🚨 Emergency Patient admitted to front: " + p);
        } else {
            erQueue.addLast(p);
            System.out.println("🧑‍⚕️ Normal Patient admitted to rear: " + p);
        }
    }

    // Treat patient (always from front)
    public void treatPatient() {
        if (!erQueue.isEmpty()) {
            Patient p = erQueue.pollFirst();
            System.out.println("✅ Treating Patient: " + p);
        } else {
            System.out.println("⚠️ No patients waiting.");
        }
    }

    // Check who is next
    public void peekNext() {
        Patient next = erQueue.peekFirst();
        if (next != null) {
            System.out.println("⏭ Next Patient: " + next);
        } else {
            System.out.println("⚠️ No patients in queue.");
        }
    }

    // Display all waiting patients
    public void showQueue() {
        System.out.println("📋 Current ER Queue: " + erQueue);
    }

    public static void main(String[] args) {
        HospitalER er = new HospitalER();

        // Simulating patient arrivals
        er.admitPatient(new Patient(1, "John", "Fever", false));
        er.admitPatient(new Patient(2, "Emma", "Accident Injury", true));
        er.admitPatient(new Patient(3, "Liam", "Headache", false));
        er.admitPatient(new Patient(4, "Sophia", "Heart Attack", true));

        // Show queue
        er.showQueue();

        // Treat patients
        er.peekNext();
        er.treatPatient();
        er.treatPatient();
        er.showQueue();
    }
}

/*
1. Concept of ArrayDeque

In Java, ArrayDeque (Array Double Ended Queue) is a resizable array-based implementation of the Deque interface.

It allows insertion and deletion from both ends (addFirst(), addLast(), pollFirst(), pollLast()), making it flexible for priority-based queue systems.

Unlike Stack or LinkedList, it does not allow null values and is faster for queue-like operations.

2. Why ArrayDeque in Real Life?

In real-world systems, not all customers or patients are equal in priority.

Example: In a hospital emergency room (ER), critical patients need immediate treatment, while others wait.

A normal queue (FIFO) cannot handle such priority differences effectively.

By using ArrayDeque, we can:

Add emergency patients to the front of the queue.

Add normal patients to the rear of the queue.

Always treat from the front, ensuring fairness and priority.

3. Program Simulation (Hospital ER System)

Patient Class:
Holds patient details like id, name, condition, and isEmergency.

HospitalER Class:

Deque<Patient> erQueue: Stores all patients.

admitPatient(Patient p): Adds patients to queue (front if emergency, rear if normal).

treatPatient(): Removes and processes patient from the front.

peekNext(): Shows who will be treated next.

showQueue(): Displays the current ER waiting list.

Main Simulation:

Patients arrive with varying urgency.

Emergency patients go to the front.

Doctors always treat patients from the front, simulating real ER workflows.

4. Output Explanation

When you run HospitalER.java, the system:

Admits patients (Normal → Rear, Emergency → Front).

Displays the queue order.

Processes patients (always from the front).

Updates the queue after treatment.

This shows how priority + fairness can be achieved using ArrayDeque.*/

