import java.util.*;

class Solution {
    static final int MOD = 1_000_000_007;

    public int countRestrictedPaths(int n, int[][] edges) {

        // Step 1: Build graph
        List<int[]>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) graph[i] = new ArrayList<>();

        for (int[] e : edges) {
            graph[e[0]].add(new int[]{e[1], e[2]});
            graph[e[1]].add(new int[]{e[0], e[2]});
        }

        // Step 2: Dijkstra from node n
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[n] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[]{n, 0});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int node = curr[0], d = curr[1];

            if (d > dist[node]) continue;

            for (int[] nei : graph[node]) {
                int next = nei[0], w = nei[1];

                if (dist[next] > d + w) {
                    dist[next] = d + w;
                    pq.offer(new int[]{next, dist[next]});
                }
            }
        }

        // Step 3: Sort nodes by distance
        Integer[] nodes = new Integer[n];
        for (int i = 0; i < n; i++) nodes[i] = i + 1;

        Arrays.sort(nodes, (a, b) -> dist[a] - dist[b]);

        // Step 4: DP
        int[] dp = new int[n + 1];
        dp[n] = 1;

        for (int u : nodes) {
            for (int[] nei : graph[u]) {
                int v = nei[0];
                if (dist[v] < dist[u]) {
                    dp[u] = (dp[u] + dp[v]) % MOD;
                }
            }
        }

        return dp[1];
    }
}
