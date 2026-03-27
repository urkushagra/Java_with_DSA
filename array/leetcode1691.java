import java.util.*;

class Solution {
    public int maxHeight(int[][] cuboids) {
        
        // Step 1: sort each cuboid dimensions
        for (int[] c : cuboids) {
            Arrays.sort(c);
        }
        
        // Step 2: sort all cuboids
        Arrays.sort(cuboids, (a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0];
            if (a[1] != b[1]) return a[1] - b[1];
            return a[2] - b[2];
        });
        
        int n = cuboids.length;
        int[] dp = new int[n];
        
        int maxHeight = 0;
        
        // Step 3: LIS DP
        for (int i = 0; i < n; i++) {
            dp[i] = cuboids[i][2]; // height
            
            for (int j = 0; j < i; j++) {
                if (cuboids[j][0] <= cuboids[i][0] &&
                    cuboids[j][1] <= cuboids[i][1] &&
                    cuboids[j][2] <= cuboids[i][2]) {
                    
                    dp[i] = Math.max(dp[i], dp[j] + cuboids[i][2]);
                }
            }
            
            maxHeight = Math.max(maxHeight, dp[i]);
        }
        
        return maxHeight;
    }
}
