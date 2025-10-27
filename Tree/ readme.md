# 🌳 Tree Data Structure

A **tree** is a fundamental data structure in computer science that represents hierarchical relationships. Unlike linear structures (like arrays or linked lists), data in a tree is organized in a branching, multi-level structure, similar to a real-world family tree or an organization chart.

At its core, a tree consists of **nodes** (which hold data) connected by **edges** (which represent the relationship between nodes).



---

## Key Terminology

To understand trees, you need to know these common terms:

* **Node**: The basic unit containing data.
* **Root**: The topmost node in the tree. It's the only node with no **parent**.
* **Parent**: A node that has at least one node connected below it.
* **Child**: A node that is connected to a node above it.
* **Edge**: The link or connection between a parent and a child node.
* **Leaf**: A node with no children (also called an external node).
* **Internal Node**: Any node that is not a leaf (i.e., it has at least one child).
* **Subtree**: A tree formed by a node and all of its descendants.
* **Height**: The length of the longest path from a node to a leaf. The height of the *entire tree* is the height of the root node.
* **Depth**: The length of the path from the root to a specific node. The depth of the root is 0.

---

## Common Types of Trees

Trees come in many variations, each optimized for different tasks. Here are some of the most important types.

### 1. Binary Tree
A tree where each node has **at most two children**: a left child and a right child. This is the foundation for many other common tree types.

### 2. Binary Search Tree (BST)
A binary tree with a specific ordering rule:
* For any node, all values in its **left subtree** are **less than** the node's value.
* For any node, all values in its **right subtree** are **greater than** the node's value.

This property makes searching very efficient.
* **Use Case**: Implementing dynamic sets, lookup tables (like dictionaries), or sorting.
* **Performance**: On average, search, insertion, and deletion are fast ($O(\log n)$). However, in the worst case (e.g., inserting items in sorted order), the tree can become unbalanced and "skewed" like a linked list, making these operations slow ($O(n)$).

### 3. AVL Tree (Self-Balancing BST)
An AVL tree is a BST that automatically keeps itself **balanced**. It does this by ensuring that for every node, the heights of its left and right subtrees differ by at most one.
* **Use Case**: Same as a BST, but used when you need to *guarantee* fast performance, even in the worst case. Ideal for lookup-intensive applications.
* **Performance**: Search, insertion, and deletion are *always* $O(\log n)$, even in the worst case. This reliability comes at the cost of more complex insertion and deletion operations, which may require "rotations" to rebalance the tree.

### 4. Heap
A specialized binary tree that satisfies the "heap property." It comes in two forms:
* **Max-Heap**: The value of every parent node is greater than or equal to the values of its children. The largest element is at the root.
* **Min-Heap**: The value of every parent node is less than or equal to the values of its children. The smallest element is at the root.

**Note:** A heap is *not* a search tree. There is no ordering relationship between the left and right children, only between parent and child.
* **Use Case**: Most famously used to implement **priority queues** (where you always need to access the highest- or lowest-priority item quickly). Also the basis for the Heap Sort algorithm.
* **Performance**: Finding the min/max is $O(1)$. Inserting or deleting the min/max is $O(\log n)$.

### 5. B-Tree
A self-balancing search tree that can have **more than two children** per node. Each node can also hold multiple keys (values).
* **Use Case**: Extensively used in **databases and file systems**. Because they are "wide" and "shallow" (low height), they require fewer I/O operations (disk reads/writes) to find data, which is much slower than accessing memory.
* **Performance**: Search, insertion, and deletion are all $O(\log n)$.

---

## Common Operations (Tree Traversal)

"Traversing" a tree means visiting every node exactly once. The order in which you visit them defines the traversal method. There are two main approaches:

### 1. Depth-First Search (DFS)
This approach explores as far as possible down one branch before backtracking. It's often implemented using recursion (or a stack).

* **Pre-order (Node-Left-Right)**:
    1.  Visit the **Node**.
    2.  Traverse the **Left** subtree.
    3.  Traverse the **Right** subtree.
    * *Use*: Good for copying a tree or creating a prefix expression (Polish notation).

* **In-order (Left-Node-Right)**:
    1.  Traverse the **Left** subtree.
    2.  Visit the **Node**.
    3.  Traverse the **Right** subtree.
    * *Use*: On a **Binary Search Tree**, this traversal visits the nodes in **sorted (ascending) order**.

* **Post-order (Left-Right-Node)**:
    1.  Traverse the **Left** subtree.
    2.  Traverse the **Right** subtree.
    3.  Visit the **Node**.
    * *Use*: Good for deleting nodes (you delete the children before the parent) or creating a postfix expression (Reverse Polish notation).



### 2. Breadth-First Search (BFS) / Level-Order
This approach explores all nodes at the current depth (level) before moving on to the next level. It's implemented using a **queue**.

1.  Start at the root, add it to the queue.
2.  While the queue is not empty:
    * Remove the first node from the queue.
    * Visit that node.
    * Add its children (e.g., left, then right) to the back of the queue.
* *Use*: Finding the shortest path between two nodes in terms of edges.

---

## Operations Time Complexity

Here’s a comparison of the "Big O" time complexity for common operations across different tree types ($n$ = number of nodes).

| Tree Type | Operation | Average Case | Worst Case |
| :--- | :--- | :--- | :--- |
| **Binary Search Tree (BST)** | Search | $O(\log n)$ | $O(n)$ |
| | Insert | $O(\log n)$ | $O(n)$ |
| | Delete | $O(\log n)$ | $O(n)$ |
| **AVL Tree (Balanced)** | Search | $O(\log n)$ | $O(\log n)$ |
| | Insert | $O(\log n)$ | $O(\log n)$ |
| | Delete | $O(\log n)$ | $O(\log n)$ |
| **Heap** | Find Min/Max | $O(1)$ | $O(1)$ |
| | Insert | $O(\log n)$ | $O(\log n)$ |
| | Delete Min/Max | $O(\log n)$ | $O(\log n)$ |
| **B-Tree** | Search | $O(\log n)$ | $O(\log n)$ |
| | Insert | $O(\log n)$ | $O(\log n)$ |
| | Delete | $O(\log n)$ | $O(\log n)$ |
