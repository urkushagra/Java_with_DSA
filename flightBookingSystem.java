import java.util.*;

class Graph {
    private Map<String, List<String>> adj = new HashMap<>();

    public void addEdge(String u, String v) {
        adj.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
        adj.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
    }

    public void bfs(String start, String dest) {
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        Map<String, String> parent = new HashMap<>();

        queue.add(start); visited.add(start);
        while (!queue.isEmpty()) {
            String curr = queue.poll();
            if (curr.equals(dest)) break;
            for (String neighbor : adj.getOrDefault(curr, new ArrayList<>())) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    parent.put(neighbor, curr);
                    queue.add(neighbor);
                }
            }
        }

        // Reconstruct path
        List<String> path = new ArrayList<>();
        for(String at = dest; at != null; at = parent.get(at)) path.add(at);
        Collections.reverse(path);
        System.out.println("Shortest Path: " + path);
    }

    public static void main(String[] args) {
        Graph g = new Graph();
        g.addEdge("NYC", "LA");
        g.addEdge("NYC", "Chicago");
        g.addEdge("Chicago", "LA");
        g.addEdge("LA", "SF");
        g.bfs("NYC", "SF");
    }
}
