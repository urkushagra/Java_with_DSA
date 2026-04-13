import java.util.*;

class Solution {
    List<Integer>[] graph;
    int[] nums;
    int[] ans;

    // stores: value -> {node, depth}
    int[][] lastSeen = new int[51][2];

    List<Integer>[] coprime;

    public int[] getCoprimes(int[] nums, int[][] edges) {
        int n = nums.length;
        this.nums = nums;
        ans = new int[n];

        // Build graph
        graph = new ArrayList[n];
        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();

        for (int[] e : edges) {
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }

        // Precompute coprimes
        coprime = new ArrayList[51];
        for (int i = 1; i <= 50; i++) {
            coprime[i] = new ArrayList<>();
            for (int j = 1; j <= 50; j++) {
                if (gcd(i, j) == 1) {
                    coprime[i].add(j);
                }
            }
        }

        // Initialize
        for (int i = 0; i < 51; i++) {
            lastSeen[i][0] = -1; // node
            lastSeen[i][1] = -1; // depth
        }

        dfs(0, -1, 0);

        return ans;
    }

    private void dfs(int node, int parent, int depth) {
        int val = nums[node];

        int bestNode = -1;
        int maxDepth = -1;

        // Check all coprime values
        for (int v : coprime[val]) {
            if (lastSeen[v][0] != -1) {
                if (lastSeen[v][1] > maxDepth) {
                    maxDepth = lastSeen[v][1];
                    bestNode = lastSeen[v][0];
                }
            }
        }

        ans[node] = bestNode;

        // Save current state
        int prevNode = lastSeen[val][0];
        int prevDepth = lastSeen[val][1];

        lastSeen[val][0] = node;
        lastSeen[val][1] = depth;

        // DFS children
        for (int nei : graph[node]) {
            if (nei != parent) {
                dfs(nei, node, depth + 1);
            }
        }

        // Backtrack
        lastSeen[val][0] = prevNode;
        lastSeen[val][1] = prevDepth;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
