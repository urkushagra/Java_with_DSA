# 🧩 Graph Data Structure

## 📘 Introduction
A **Graph** is a non-linear data structure that represents a collection of **nodes (vertices)** connected by **edges (links)**.  
It is widely used to model real-world systems such as social networks, transportation routes, computer networks, and web page linking.

Graphs help solve complex problems like finding the shortest path, detecting cycles, or modeling relationships among entities.

---

## 🧠 Key Concepts

### 1. **Basic Terminology**
- **Vertex (Node):** A point that represents an entity.
- **Edge:** A connection between two vertices.
- **Degree:** Number of edges incident to a vertex.
- **Path:** Sequence of vertices connected by edges.
- **Cycle:** A path that starts and ends at the same vertex.

---

## 🧮 Types of Graphs

### ➤ Based on Direction
- **Undirected Graph:** Edges have no direction.  
  Example: Friendship in a social network.
- **Directed Graph (Digraph):** Edges have a specific direction.  
  Example: Following on Twitter.

### ➤ Based on Weight
- **Weighted Graph:** Edges have weights/costs (like distances).
- **Unweighted Graph:** All edges have equal weight.

### ➤ Based on Cycles
- **Cyclic Graph:** Contains at least one cycle.
- **Acyclic Graph:** Has no cycles (e.g., Trees and DAGs).

### ➤ Special Types
- **Connected Graph:** A path exists between every pair of vertices.
- **Disconnected Graph:** Some vertices are isolated.
- **Complete Graph:** Every vertex is connected to all other vertices.

---

## 🏗️ Graph Representations

### 1. **Adjacency Matrix**
A 2D array `matrix[V][V]` where `matrix[i][j] = 1` (or weight) if an edge exists, otherwise `0`.

```java
int[][] graph = {
    {0, 1, 0, 1},
    {1, 0, 1, 1},
    {0, 1, 0, 1},
    {1, 1, 1, 0}
};
```

### 2. **Adjacency List**
An array/list of lists where each vertex stores a list of its adjacent vertices.

```java
import java.util.*;

class Graph {
    private Map<Integer, List<Integer>> adjList = new HashMap<>();

    public void addEdge(int u, int v) {
        adjList.putIfAbsent(u, new ArrayList<>());
        adjList.putIfAbsent(v, new ArrayList<>());
        adjList.get(u).add(v);
        adjList.get(v).add(u); // For undirected graph
    }

    public void printGraph() {
        for (int node : adjList.keySet()) {
            System.out.println(node + " -> " + adjList.get(node));
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph();
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.printGraph();
    }
}
```

---

## 🔍 Graph Traversal Algorithms

### 1. **Depth-First Search (DFS)**
- Explores as far as possible along one branch before backtracking.
- Implemented using recursion or a stack.

### 2. **Breadth-First Search (BFS)**
- Explores all neighbors level by level.
- Implemented using a queue.

---

## ⚙️ Applications of Graphs
- 🌐 **Social Networks:** Representing users and connections.
- 🚗 **Google Maps:** Finding shortest paths using Dijkstra’s Algorithm.
- 🔒 **Network Security:** Detecting vulnerabilities and communication paths.
- 🧬 **Biology:** Modeling gene/protein interactions.
- 💻 **Compiler Design:** Control Flow and Dependency Graphs.
- 🕸️ **Web Crawling:** Representing pages and links.

---

## 📊 Common Graph Algorithms
| Algorithm | Purpose |
|------------|----------|
| **BFS (Breadth-First Search)** | Shortest path in unweighted graphs |
| **DFS (Depth-First Search)** | Traversal and cycle detection |
| **Dijkstra’s Algorithm** | Shortest path in weighted graphs |
| **Bellman-Ford Algorithm** | Shortest path (handles negative weights) |
| **Floyd-Warshall Algorithm** | All-pairs shortest paths |
| **Kruskal’s / Prim’s Algorithm** | Minimum Spanning Tree |
| **Topological Sort** | Task ordering in Directed Acyclic Graphs |

---

## 🧩 Example: BFS Traversal (Java)
```java
import java.util.*;

class BFSExample {
    private Map<Integer, List<Integer>> adjList = new HashMap<>();

    public void addEdge(int u, int v) {
        adjList.putIfAbsent(u, new ArrayList<>());
        adjList.putIfAbsent(v, new ArrayList<>());
        adjList.get(u).add(v);
        adjList.get(v).add(u);
    }

    public void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        queue.add(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.print(node + " ");

            for (int neighbor : adjList.get(node)) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
    }

    public static void main(String[] args) {
        BFSExample g = new BFSExample();
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 3);
        g.addEdge(3, 4);

        System.out.println("BFS Traversal starting from node 0:");
        g.bfs(0);
    }
}
```

---

## 🧠 Complexity Analysis

| Representation | Space Complexity | Edge Check | Traversal Complexity |
|----------------|------------------|-------------|----------------------|
| **Adjacency Matrix** | O(V²) | O(1) | O(V²) |
| **Adjacency List** | O(V + E) | O(V) | O(V + E) |

---

## 🏁 Conclusion
Graphs are powerful tools for representing and solving real-world problems involving relationships and connectivity.  
Understanding how to implement and traverse graphs efficiently is essential for mastering data structures and algorithms.

---

## 🧾 References
- [GeeksforGeeks - Graph Data Structure](https://www.geeksforgeeks.org/graph-data-structure-and-algorithms/)
- [LeetCode Graph Problems](https://leetcode.com/tag/graph/)
- [Visualgo - Graph Visualization](https://visualgo.net/en/graphds)
