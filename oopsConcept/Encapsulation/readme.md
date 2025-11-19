# Abstraction vs Encapsulation — Clear & Modern Explanation

This README explains **Abstraction** and **Encapsulation** in a clean, modern, and easy-to-read format.  
Both are essential pillars of **Object-Oriented Programming (OOP)**.

---

# 🟦 Abstraction

## 🔍 What is Abstraction?
Abstraction means **hiding internal implementation details** and showing **only the required features**.

It answers the question:  
👉 **“WHAT does the object do?”**

---

## 🛠 How Abstraction Is Achieved in Java
- `abstract` classes  
- `abstract` methods  
- `interfaces`

Developers decide *what features to expose* and *what to hide*.

---

## 💡 Example (Abstraction)

```java
abstract class Animal {
    abstract void sound(); // WHAT to do (no implementation)
}

class Dog extends Animal {
    void sound() {
        System.out.println("Barks"); // HOW to do it
    }
}
```

- `sound()` is declared but not defined → abstraction.  
- Dog gives actual implementation → concrete behavior.

---

## 🚗 Real-Life Analogy
When you press the **Start** button in a car:
- You know it will start the engine (high-level feature)
- You **don't** see fuel injection, spark plugs, sensors working  
→ The complex logic is hidden.

This is **Abstraction**.

---

# 🟩 Encapsulation

## 🔍 What is Encapsulation?
Encapsulation means **hiding data** and providing **controlled access** using methods.

It answers the question:  
👉 **“HOW is the data protected?”**

---

## 🛠 How Encapsulation Is Achieved in Java
- Make variables **private**
- Provide **public getters and setters**
- Use validation inside setters
- Use access modifiers for controlled access

---

## 💡 Example (Encapsulation)

```java
class Student {

    private int age;  // hidden data

    public int getAge() {
        return age; // controlled access
    }

    public void setAge(int age) {
        if (age > 0) { // validation
            this.age = age;
        }
    }
}
```

- Data cannot be accessed directly.  
- Only safe operations are allowed.

---

## 🏦 Real-Life Analogy
Your **ATM balance**:
- You cannot modify bank balance directly  
- You access it only via:
  - ATM PIN  
  - Net banking  
  - Banking app  

This controlled access = **Encapsulation**.

---

# 🆚 Technical Comparison Table

| Feature | Abstraction | Encapsulation |
|---------|-------------|----------------|
| Hides | Implementation | Data |
| Focus | Behavior | Protection |
| Level | Design level | Code level |
| Achieved Using | Interfaces, abstract classes | Private fields, getters/setters |
| Deals With | Methods | Variables |
| Purpose | Reduce complexity | Increase security |

---

# 🧠 Key Difference (Remember This!)

👉 **Abstraction = WHAT to do**  
👉 **Encapsulation = HOW to protect data**

---

# 🖥 Real Tech World Examples

## 🔵 Abstraction in Real World:
- Android’s `onClick()` method → you don’t know how touch events are handled internally.
- Java Collections Framework (`List`, `Set`, `Map`) hide internal algorithms.
- APIs hide their backend logic.

## 🟢 Encapsulation in Real World:
- Bank account details hidden behind getters/setters.
- Android UI components are private internally.
- Spring Boot Entity classes have private fields with public getters/setters.

---

# 🔀 Combined Example

```java
abstract class BankAccount {
    abstract void calculateInterest(); // abstraction
}

class SavingsAccount extends BankAccount {

    private double balance; // encapsulation

    public void deposit(double amt) {
        if (amt > 0) balance += amt;
    }

    public double getBalance() {
        return balance;
    }

    void calculateInterest() {
        System.out.println("Interest: " + balance * 0.05);
    }
}
```

- **Abstraction** → what interest calculation should do  
- **Encapsulation** → balance is protected & validated  

---

# 🏁 Final Summary

| Abstraction | Encapsulation |
|-------------|----------------|
| Hides implementation | Hides internal data |
| Achieved using abstract classes/interfaces | Achieved using private vars + getters/setters |
| Focus: what object does | Focus: how data is protected |
| Example: Car start button | Example: ATM PIN |

---

This README gives a modern, structured, developer-friendly comparison of **Abstraction vs Encapsulation**.

