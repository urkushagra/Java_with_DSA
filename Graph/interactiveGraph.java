import java.util.*;

// Edge class for representing a connection between nodes
class Edge {
    int destination;
    int weight;

    Edge(int destination, int weight) {
        this.destination = destination;
        this.weight = weight;
    }
}

// Graph class
public class InteractiveGraph {
    private int vertices;
    private boolean isDirected;
    private Map<Integer, List<Edge>> adjList;

    public InteractiveGraph(int vertices, boolean isDirected) {
        this.vertices = vertices;
        this.isDirected = isDirected;
        adjList = new HashMap<>();
        for (int i = 0; i < vertices; i++) {
            adjList.put(i, new ArrayList<>());
        }
    }

    // Add an edge
    public void addEdge(int source, int destination, int weight) {
        adjList.get(source).add(new Edge(destination, weight));
        if (!isDirected) {
            adjList.get(destination).add(new Edge(source, weight));
        }
    }

    // Print adjacency list
    public void printGraph() {
        System.out.println("\nGraph (Adjacency List Representation):");
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

        System.out.print("BFS Traversal: ");
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
        System.out.print("DFS Traversal: ");
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

    // Dijkstra’s Algorithm
    public void dijkstra(int start) {
        int[] distance = new int[vertices];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[start] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.add(new int[]{start, 0});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int node = curr[0];
            int dist = curr[1];

            for (Edge edge : adjList.get(node)) {
                int newDist = dist + edge.weight;
                if (newDist < distance[edge.destination]) {
                    distance[edge.destination] = newDist;
                    pq.add(new int[]{edge.destination, newDist});
                }
            }
        }

        System.out.println("\nDijkstra’s Shortest Path from vertex " + start + ":");
        for (int i = 0; i < vertices; i++) {
            System.out.println("To " + i + " → " + (distance[i] == Integer.MAX_VALUE ? "∞" : distance[i]));
        }
    }

    // Topological Sort (for Directed Acyclic Graphs)
    public void topologicalSort() {
        if (!isDirected) {
            System.out.println("Topological Sort is only for Directed Graphs!");
            return;
        }

        boolean[] visited = new boolean[vertices];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < vertices; i++) {
            if (!visited[i]) topoHelper(i, visited, stack);
        }

        System.out.print("\nTopological Sort: ");
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
        System.out.println();
    }

    private void topoHelper(int v, boolean[] visited, Stack<Integer> stack) {
        visited[v] = true;
        for (Edge edge : adjList.get(v)) {
            if (!visited[edge.destination]) topoHelper(edge.destination, visited, stack);
        }
        stack.push(v);
    }

    // Interactive Menu
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("========= Interactive Graph Program =========");

        System.out.print("Enter number of vertices: ");
        int vertices = sc.nextInt();

        System.out.print("Is the graph directed? (true/false): ");
        boolean isDirected = sc.nextBoolean();

        InteractiveGraph graph = new InteractiveGraph(vertices, isDirected);

        while (true) {
            System.out.println("\n---- Menu ----");
            System.out.println("1. Add Edge");
            System.out.println("2. Show Graph");
            System.out.println("3. BFS Traversal");
            System.out.println("4. DFS Traversal");
            System.out.println("5. Dijkstra’s Shortest Path");
            System.out.println("6. Topological Sort");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter source vertex: ");
                    int src = sc.nextInt();
                    System.out.print("Enter destination vertex: ");
                    int dest = sc.nextInt();
                    System.out.print("Enter weight: ");
                    int weight = sc.nextInt();
                    graph.addEdge(src, dest, weight);
                    System.out.println("✅ Edge added successfully!");
                }

                case 2 -> graph.printGraph();

                case 3 -> {
                    System.out.print("Enter starting vertex for BFS: ");
                    int start = sc.nextInt();
                    graph.bfs(start);
                }

                case 4 -> {
                    System.out.print("Enter starting vertex for DFS: ");
                    int start = sc.nextInt();
                    graph.dfs(start);
                }

                case 5 -> {
                    System.out.print("Enter starting vertex for Dijkstra: ");
                    int start = sc.nextInt();
                    graph.dijkstra(start);
                }

                case 6 -> graph.topologicalSort();

                case 7 -> {
                    System.out.println("Exiting... 👋");
                    sc.close();
                    return;
                }

                default -> System.out.println("❌ Invalid choice! Please try again.");
            }
        }
    }
}
