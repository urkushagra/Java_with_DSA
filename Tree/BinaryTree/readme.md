
# 🌳 Binary Search Tree (BST) - Complete Explanation and Java Implementation

A **Binary Search Tree (BST)** is a special type of **Binary Tree** that maintains elements in sorted order, allowing efficient searching, insertion, and deletion.

---

## ⚙️ Definition

A Binary Tree is a **BST** if it satisfies the following properties:

1. The **left subtree** of a node contains only nodes with keys **less than** the node’s key.  
2. The **right subtree** of a node contains only nodes with keys **greater than** the node’s key.  
3. Both left and right subtrees must also be Binary Search Trees.

---

## 🧩 Example of a BST

```
        8
       / \
      3   10
     / \    \
    1   6    14
       / \   /
      4   7 13
```

✅ **BST property check:**  
Left < Root < Right for all nodes.

---

## 🧮 Why BSTs Are Important

| Operation | Average Time | Worst Case (Skewed Tree) |
|------------|---------------|---------------------------|
| Search     | O(log n)      | O(n) |
| Insert     | O(log n)      | O(n) |
| Delete     | O(log n)      | O(n) |
| Traversal  | O(n)          | O(n) |

> To maintain O(log n) consistently, self-balancing BSTs like **AVL Trees** or **Red-Black Trees** are used.

---

## 💻 Java Implementation of a BST

### ✅ Step 1: Node Structure
```java
class Node {
    int key;
    Node left, right;

    public Node(int item) {
        key = item;
        left = right = null;
    }
}
```

### ✅ Step 2: BST Class
```java
class BinarySearchTree {
    Node root;

    BinarySearchTree() {
        root = null;
    }

    // Insert a new key
    void insert(int key) {
        root = insertRec(root, key);
    }

    Node insertRec(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }

        if (key < root.key)
            root.left = insertRec(root.left, key);
        else if (key > root.key)
            root.right = insertRec(root.right, key);

        return root;
    }

    // Search a key
    boolean search(int key) {
        return searchRec(root, key);
    }

    boolean searchRec(Node root, int key) {
        if (root == null) return false;
        if (root.key == key) return true;
        return key < root.key
                ? searchRec(root.left, key)
                : searchRec(root.right, key);
    }

    // Delete a key
    void deleteKey(int key) {
        root = deleteRec(root, key);
    }

    Node deleteRec(Node root, int key) {
        if (root == null)
            return root;

        if (key < root.key)
            root.left = deleteRec(root.left, key);
        else if (key > root.key)
            root.right = deleteRec(root.right, key);
        else {
            // Node with only one child or no child
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            // Node with two children: get inorder successor
            root.key = minValue(root.right);

            // Delete the inorder successor
            root.right = deleteRec(root.right, root.key);
        }
        return root;
    }

    int minValue(Node root) {
        int minv = root.key;
        while (root.left != null) {
            minv = root.left.key;
            root = root.left;
        }
        return minv;
    }

    // Inorder traversal (sorted order)
    void inorder() {
        inorderRec(root);
    }

    void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.key + " ");
            inorderRec(root.right);
        }
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();

        // Insertion
        int[] keys = {8, 3, 10, 1, 6, 14, 4, 7, 13};
        for (int key : keys) {
            tree.insert(key);
        }

        System.out.print("Inorder traversal: ");
        tree.inorder();

        System.out.println("\nSearch 6: " + tree.search(6));
        System.out.println("Search 2: " + tree.search(2));

        tree.deleteKey(10);
        System.out.print("Inorder after deleting 10: ");
        tree.inorder();
    }
}
```

---

### 🧾 Output
```
Inorder traversal: 1 3 4 6 7 8 10 13 14
Search 6: true
Search 2: false
Inorder after deleting 10: 1 3 4 6 7 8 13 14
```

---

## 🌲 Important BST Concepts

### 🧮 Inorder Traversal = Sorted Order
For any BST, performing **inorder traversal** gives a **sorted list** of all elements.

### 🧩 Deletion Cases
When deleting a node:
1. **No child** → Simply remove it.  
2. **One child** → Replace node with its child.  
3. **Two children** → Replace with **inorder successor** (smallest in right subtree).

### ⚡ Optimizations
- Use **iterative** (non-recursive) methods to reduce stack space.  
- Use **Balanced Trees (AVL / Red-Black Tree)** to ensure O(log n) consistently.

---

## 💡 Real-World Applications

| Domain | Use Case |
|--------|-----------|
| Databases | Indexing and searching keys efficiently |
| Compilers | Expression evaluation and syntax trees |
| Networking | Routing tables and IP lookups |
| Machine Learning | Decision Trees |
| Operating Systems | File system hierarchies |

---

## 🧠 Summary

- BSTs provide fast and structured access to sorted data.  
- They are foundational for many advanced data structures like **AVL**, **Red-Black Trees**, and **B-Trees**.  
- Inorder traversal always yields a sorted output.

---

> ✨ *Author: Kushagra Upadhayay*  
> 📘 *Language: Java*  
> 🧩 *Topic: Binary Search Tree (BST)*  
