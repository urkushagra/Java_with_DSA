import java.util.*;

class Solution {
    public int minChanges(int[] nums, int k) {
        int MAXX = 1024;
        int n = nums.length;

        int[][] freq = new int[k][MAXX];
        int[] size = new int[k];

        // Step 1: group frequencies
        for (int i = 0; i < n; i++) {
            freq[i % k][nums[i]]++;
            size[i % k]++;
        }

        int[] dp = new int[MAXX];
        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[0] = 0;

        // Step 2: DP
        for (int i = 0; i < k; i++) {
            int[] newDp = new int[MAXX];
            Arrays.fill(newDp, Integer.MAX_VALUE);

            int minDp = Integer.MAX_VALUE;
            for (int x : dp) minDp = Math.min(minDp, x);

            // baseline: change all elements in group
            for (int x = 0; x < MAXX; x++) {
                newDp[x] = minDp + size[i];
            }

            // try keeping values
            for (int val = 0; val < MAXX; val++) {
                if (freq[i][val] == 0) continue;

                for (int x = 0; x < MAXX; x++) {
                    if (dp[x] == Integer.MAX_VALUE) continue;

                    int newXor = x ^ val;
                    newDp[newXor] = Math.min(
                        newDp[newXor],
                        dp[x] + size[i] - freq[i][val]
                    );
                }
            }

            dp = newDp;
        }

        return dp[0];
    }
}
