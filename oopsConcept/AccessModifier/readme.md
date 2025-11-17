# Java Access Modifiers (Simple & Clear Guide)

Access modifiers in Java control **who can access your classes, methods, and variables**.  
They help make your code **secure, organized, and professional**.

---

## 🔰 What Are Access Modifiers?

They decide:
- **Who can see your class**
- **Who can use your method**
- **Who can change your variable**

Java has **4 access levels**:

1. public  
2. protected  
3. default (no keyword)  
4. private  

---

# 1️⃣ public – Accessible From Anywhere

✔ Any class  
✔ Any package  
✔ Entire project

```java
public void start() { }
```

Use when you want **full access**.

---

# 2️⃣ protected – Accessible to Family (Inheritance)

✔ Same package  
✔ Child classes (even in other packages)

```java
protected int speed;
```

Use when:
- You want subclasses to use the method/variable  
- But don’t want outsiders to touch it  

---

# 3️⃣ default – Package Level Access

(No keyword required)

```java
String name;   // default
```

✔ Same package  
❌ Not outside package  
❌ Not in child class outside package  

Use when:
- You want access limited to the **package** only  
- Good for internal project helper classes  

---

# 4️⃣ private – Accessible Only in the Same Class

```java
private int balance;
```

✔ Only inside the class  
❌ Not accessible anywhere else  

Use for:
- Passwords  
- Bank balance  
- Secret logic  
- Sensitive data  

This is the core of **Encapsulation**.

---

# 📌 Comparison Table

| Modifier   | Same Class | Same Package | Child Class | Other Package |
|-----------|------------|--------------|-------------|----------------|
| public    | ✔          | ✔            | ✔           | ✔              |
| protected | ✔          | ✔            | ✔           | ❌ (except child) |
| default   | ✔          | ✔            | ❌          | ❌             |
| private   | ✔          | ❌           | ❌          | ❌             |

---

# 🎯 Where To Use What?

| Use Case | Modifier |
|----------|-----------|
| Everyone should access | **public** |
| Only child class should access | **protected** |
| Only same package can access | **default** |
| Data should be hidden | **private** |

---

# 🏛 Access Modifiers for Classes

Only two are allowed:

| Modifier | Allowed? | Meaning |
|----------|------------|-----------|
| public | ✔ Yes | Class visible everywhere |
| default | ✔ Yes | Class visible in same package |
| private | ❌ No | Not allowed |
| protected | ❌ No | Not allowed |

---

# 🔐 Access Modifiers + Encapsulation

Encapsulation = **private variables + public getters/setters**

```java
class BankAccount {

    private double balance;   // hidden

    public double getBalance() {  // controlled access
        return balance;
    }

    public void deposit(double amount) {
        if(amount > 0) {
            balance += amount;
        }
    }
}
```

Benefits:
- Prevent misuse  
- Validate input  
- Protect important data  

---

# 🏡 Real Life Analogy

| Modifier | Real Life Example |
|----------|------------------------------|
| public | Public park (anyone allowed) |
| protected | Family area (only family allowed) |
| default | Residential colony (neighbors allowed) |
| private | Your room (only you allowed) |

---

# ✅ Final Summary
> Access modifiers protect your data, organize your code, and support encapsulation.  
> They define **who** can access **what** in your program.

