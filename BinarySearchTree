// Binary Search Tree Implementation in Java
// Covers: Insert, Search, Inorder, Preorder, Postorder Traversals

// Node class → represents each node in the BST
class Node {
    int key;          // value stored in the node
    Node left, right; // left & right child references

    public Node(int item) {
        key = item;
        left = right = null;
    }
}

// Main BST class
class BinarySearchTree {
    Node root; // root node of the tree

    // Constructor → initially tree is empty
    BinarySearchTree() {
        root = null;
    }

    // PUBLIC insert function → adds a new key into the tree
    void insert(int key) {
        root = insertRec(root, key); // call recursive function
    }

    // PRIVATE recursive insert function
    Node insertRec(Node root, int key) {
        // Base case → empty spot found
        if (root == null) {
            root = new Node(key);
            return root;
        }
        // If key is smaller → go left
        if (key < root.key) {
            root.left = insertRec(root.left, key);
        }
        // If key is larger → go right
        else if (key > root.key) {
            root.right = insertRec(root.right, key);
        }
        // Return unchanged root node
        return root;
    }

    // Search function → returns true if key exists
    boolean search(int key) {
        return searchRec(root, key);
    }

    // Recursive search function
    boolean searchRec(Node root, int key) {
        if (root == null) return false;          // not found
        if (root.key == key) return true;        // found
        return key < root.key 
            ? searchRec(root.left, key)          // search left subtree
            : searchRec(root.right, key);        // search right subtree
    }

    // Inorder Traversal → Left → Root → Right (sorted order in BST)
    void inorder() {
        inorderRec(root);
        System.out.println();
    }
    void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.key + " ");
            inorderRec(root.right);
        }
    }

    // Preorder Traversal → Root → Left → Right
    void preorder() {
        preorderRec(root);
        System.out.println();
    }
    void preorderRec(Node root) {
        if (root != null) {
            System.out.print(root.key + " ");
            preorderRec(root.left);
            preorderRec(root.right);
        }
    }

    // Postorder Traversal → Left → Right → Root
    void postorder() {
        postorderRec(root);
        System.out.println();
    }
    void postorderRec(Node root) {
        if (root != null) {
            postorderRec(root.left);
            postorderRec(root.right);
            System.out.print(root.key + " ");
        }
    }
}

// Driver class to test BST
public class Main {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

        // Insert elements into BST
        bst.insert(50);
        bst.insert(30);
        bst.insert(70);
        bst.insert(20);
        bst.insert(40);
        bst.insert(60);
        bst.insert(80);

        // Traversals
        System.out.print("Inorder (Sorted): ");
        bst.inorder();

        System.out.print("Preorder: ");
        bst.preorder();

        System.out.print("Postorder: ");
        bst.postorder();

        // Searching for keys
        int key = 60;
        System.out.println("Searching for " + key + ": " + (bst.search(key) ? "Found" : "Not Found"));

        key = 25;
        System.out.println("Searching for " + key + ": " + (bst.search(key) ? "Found" : "Not Found"));
    }
}
