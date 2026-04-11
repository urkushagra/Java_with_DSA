import java.util.*;

class Solution {
    public int[] restoreArray(int[][] adjacentPairs) {
        // Step 1: Build graph
        Map<Integer, List<Integer>> graph = new HashMap<>();
        
        for (int[] pair : adjacentPairs) {
            graph.computeIfAbsent(pair[0], k -> new ArrayList<>()).add(pair[1]);
            graph.computeIfAbsent(pair[1], k -> new ArrayList<>()).add(pair[0]);
        }

        int n = adjacentPairs.length + 1;
        int[] result = new int[n];

        // Step 2: Find starting node (degree = 1)
        int start = 0;
        for (int key : graph.keySet()) {
            if (graph.get(key).size() == 1) {
                start = key;
                break;
            }
        }

        // Step 3: Reconstruct array
        result[0] = start;
        result[1] = graph.get(start).get(0);

        for (int i = 2; i < n; i++) {
            List<Integer> neighbors = graph.get(result[i - 1]);

            // Choose the neighbor that is NOT previous element
            if (neighbors.get(0) == result[i - 2]) {
                result[i] = neighbors.get(1);
            } else {
                result[i] = neighbors.get(0);
            }
        }

        return result;
    }
}
