import java.util.*;

class Solution {
    public int checkWays(int[][] pairs) {

        Map<Integer, Set<Integer>> adj = new HashMap<>();

        // Step 1: Build graph
        for (int[] p : pairs) {
            adj.putIfAbsent(p[0], new HashSet<>());
            adj.putIfAbsent(p[1], new HashSet<>());
            adj.get(p[0]).add(p[1]);
            adj.get(p[1]).add(p[0]);
        }

        int n = adj.size();

        // Step 2: Find root
        int root = -1;
        for (int node : adj.keySet()) {
            if (adj.get(node).size() == n - 1) {
                root = node;
                break;
            }
        }

        if (root == -1) return 0;

        int result = 1;

        // Step 3: Process each node
        for (int node : adj.keySet()) {
            if (node == root) continue;

            int parent = -1;
            int parentDegree = Integer.MAX_VALUE;

            // Find parent
            for (int neighbor : adj.get(node)) {
                if (adj.get(neighbor).size() >= adj.get(node).size()) {
                    if (adj.get(neighbor).size() < parentDegree) {
                        parent = neighbor;
                        parentDegree = adj.get(neighbor).size();
                    }
                }
            }

            if (parent == -1) return 0;

            // Step 4: Validate
            for (int neighbor : adj.get(node)) {
                if (neighbor == parent) continue;
                if (!adj.get(parent).contains(neighbor)) {
                    return 0;
                }
            }

            // Step 5: Check multiple ways
            if (parentDegree == adj.get(node).size()) {
                result = 2;
            }
        }

        return result;
    }
}
