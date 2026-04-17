import java.util.*;

class Solution {
    public int[] countPairs(int n, int[][] edges, int[] queries) {
        int[] degree = new int[n + 1];
        Map<Long, Integer> map = new HashMap<>();

        // Step 1: Build degree + edge count
        for (int[] e : edges) {
            int u = e[0], v = e[1];
            degree[u]++;
            degree[v]++;

            if (u > v) {
                int temp = u; u = v; v = temp;
            }

            long key = (long)u * 100000 + v;
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        // Step 2: Sort degrees
        int[] sorted = new int[n];
        for (int i = 1; i <= n; i++) {
            sorted[i - 1] = degree[i];
        }
        Arrays.sort(sorted);

        int[] ans = new int[queries.length];

        // Step 3: Process each query
        for (int q = 0; q < queries.length; q++) {
            int k = queries[q];

            int left = 0, right = n - 1;
            int count = 0;

            // count pairs using two pointers
            while (left < right) {
                if (sorted[left] + sorted[right] > k) {
                    count += (right - left);
                    right--;
                } else {
                    left++;
                }
            }

            // Step 4: remove invalid pairs
            for (long key : map.keySet()) {
                int u = (int)(key / 100000);
                int v = (int)(key % 100000);
                int common = map.get(key);

                if (degree[u] + degree[v] > k &&
                    degree[u] + degree[v] - common <= k) {
                    count--;
                }
            }

            ans[q] = count;
        }

        return ans;
    }
}
