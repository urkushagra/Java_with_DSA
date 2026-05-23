class Solution {

    public int largestPathValue(String colors, int[][] edges) {

        int n = colors.length();

        List<Integer>[] graph = new ArrayList[n];

        for(int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        int[] indegree = new int[n];

        // Build graph
        for(int[] edge : edges) {

            int u = edge[0];
            int v = edge[1];

            graph[u].add(v);
            indegree[v]++;
        }

        // DP[node][color]
        int[][] dp = new int[n][26];

        Queue<Integer> queue = new LinkedList<>();

        // Start nodes
        for(int i = 0; i < n; i++) {

            if(indegree[i] == 0) {
                queue.offer(i);
            }
        }

        int visited = 0;
        int answer = 0;

        while(!queue.isEmpty()) {

            int node = queue.poll();

            visited++;

            int colorIndex = colors.charAt(node) - 'a';

            dp[node][colorIndex]++;

            answer = Math.max(answer,
                    dp[node][colorIndex]);

            for(int neighbor : graph[node]) {

                // Transfer DP values
                for(int c = 0; c < 26; c++) {

                    dp[neighbor][c] =
                            Math.max(dp[neighbor][c],
                                     dp[node][c]);
                }

                indegree[neighbor]--;

                if(indegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        // Cycle detection
        if(visited < n) {
            return -1;
        }

        return answer;
    }
}
