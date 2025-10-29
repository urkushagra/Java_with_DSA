import java.util.*;

// Edge class to represent connections with weights
class Edge {
    int destination;
    int weight;

    Edge(int destination, int weight) {
        this.destination = destination;
        this.weight = weight;
    }
}

// Main Graph class
public class AdvancedGraph {
    private int vertices;
    private boolean isDirected;
    private Map<Integer, List<Edge>> adjList;

    // Constructor
    public AdvancedGraph(int vertices, boolean isDirected) {
        this.vertices = vertices;
        this.isDirected = isDirected;
        adjList = new HashMap<>();

        for (int i = 0; i < vertices; i++) {
            adjList.put(i, new ArrayList<>());
        }
    }

    // Add edge to the graph
    public void addEdge(int source, int destination, int weight) {
        adjList.get(source).add(new Edge(destination, weight));
        if (!isDirected) {
            adjList.get(destination).add(new Edge(source, weight));
        }
    }

    // Print adjacency list representation
    public void printGraph() {
        System.out.println("Graph (Adjacency List):");
        for (int vertex : adjList.keySet()) {
            System.out.print(vertex + " -> ");
            for (Edge edge : adjList.get(vertex)) {
                System.out.print("(" + edge.destination + ", w=" + edge.weight + ") ");
            }
            System.out.println();
        }
    }

    // Breadth-First Search
    public void bfs(int start) {
        boolean[] visited = new boolean[vertices];
        Queue<Integer> queue = new LinkedList<>();

        visited[start] = true;
        queue.add(start);

        System.out.print("BFS Traversal starting from " + start + ": ");
        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            System.out.print(vertex + " ");

            for (Edge edge : adjList.get(vertex)) {
                if (!visited[edge.destination]) {
                    visited[edge.destination] = true;
                    queue.add(edge.destination);
                }
            }
        }
        System.out.println();
    }

    // Depth-First Search
    public void dfs(int start) {
        boolean[] visited = new boolean[vertices];
        System.out.print("DFS Traversal starting from " + start + ": ");
        dfsHelper(start, visited);
        System.out.println();
    }

    private void dfsHelper(int vertex, boolean[] visited) {
        visited[vertex] = true;
        System.out.print(vertex + " ");

        for (Edge edge : adjList.get(vertex)) {
            if (!visited[edge.destination]) {
                dfsHelper(edge.destination, visited);
            }
        }
    }

    // Dijkstra’s Algorithm (Shortest Path)
    public void dijkstra(int start) {
        int[] distance = new int[vertices];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[start] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.add(new int[]{start, 0});

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int vertex = current[0];
            int dist = current[1];

            for (Edge edge : adjList.get(vertex)) {
                int newDist = dist + edge.weight;
                if (newDist < distance[edge.destination]) {
                    distance[edge.destination] = newDist;
                    pq.add(new int[]{edge.destination, newDist});
                }
            }
        }

        System.out.println("\nDijkstra’s Shortest Paths from vertex " + start + ":");
        for (int i = 0; i < vertices; i++) {
            System.out.println("To " + i + " → " + (distance[i] == Integer.MAX_VALUE ? "∞" : distance[i]));
        }
    }

    // Topological Sort (for Directed Acyclic Graphs)
    public void topologicalSort() {
        if (!isDirected) {
            System.out.println("Topological sort is only valid for directed graphs.");
            return;
        }

        boolean[] visited = new boolean[vertices];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < vertices; i++) {
            if (!visited[i]) {
                topoHelper(i, visited, stack);
            }
        }

        System.out.print("\nTopological Sort: ");
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
        System.out.println();
    }

    private void topoHelper(int vertex, boolean[] visited, Stack<Integer> stack) {
        visited[vertex] = true;

        for (Edge edge : adjList.get(vertex)) {
            if (!visited[edge.destination]) {
                topoHelper(edge.destination, visited, stack);
            }
        }
        stack.push(vertex);
    }

    // Main method
    public static void main(String[] args) {
        // Create a weighted directed graph
        AdvancedGraph graph = new AdvancedGraph(6, true);

        // Add edges (source, destination, weight)
        graph.addEdge(0, 1, 5);
        graph.addEdge(0, 2, 3);
        graph.addEdge(1, 3, 6);
        graph.addEdge(1, 2, 2);
        graph.addEdge(2, 4, 4);
        graph.addEdge(2, 5, 2);
        graph.addEdge(2, 3, 7);
        graph.addEdge(3, 4, -1);
        graph.addEdge(4, 5, -2);

        // Print the graph
        graph.printGraph();

        // Traversals
        graph.bfs(0);
        graph.dfs(0);

        // Shortest Path
        graph.dijkstra(0);

        // Topological Sort
        graph.topologicalSort();
    }
}
