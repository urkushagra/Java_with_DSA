class Solution {
    public int stoneGameVII(int[] stones) {
        int n = stones.length;
        
        // Prefix sum
        int[] prefix = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + stones[i];
        }
        
        int[][] dp = new int[n][n];
        
        // length of subarray
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i + len <= n; i++) {
                int j = i + len - 1;
                
                int leftSum = prefix[j + 1] - prefix[i + 1];
                int rightSum = prefix[j] - prefix[i];
                
                int left = leftSum - dp[i + 1][j];
                int right = rightSum - dp[i][j - 1];
                
                dp[i][j] = Math.max(left, right);
            }
        }
        
        return dp[0][n - 1];
    }
}
