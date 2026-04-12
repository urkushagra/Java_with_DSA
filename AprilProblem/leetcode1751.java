import java.util.*;

class Solution {
    public int maxValue(int[][] events, int k) {
        Arrays.sort(events, (a, b) -> a[0] - b[0]);

        int n = events.length;
        int[][] dp = new int[n][k + 1];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return dfs(events, 0, k, dp);
    }

    private int dfs(int[][] events, int i, int k, int[][] dp) {
        if (i == events.length || k == 0) return 0;

        if (dp[i][k] != -1) return dp[i][k];

        // Option 1: skip event
        int skip = dfs(events, i + 1, k, dp);

        // Option 2: take event
        int nextIndex = findNext(events, events[i][1]);
        int take = events[i][2] + dfs(events, nextIndex, k - 1, dp);

        return dp[i][k] = Math.max(skip, take);
    }

    private int findNext(int[][] events, int endDay) {
        int left = 0, right = events.length;

        while (left < right) {
            int mid = (left + right) / 2;
            if (events[mid][0] <= endDay) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }
}
